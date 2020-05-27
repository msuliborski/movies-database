package com.suliborski.moviesdatabase.utils;

import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.transform.XSLTransformException;
import org.jdom2.transform.XSLTransformer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class XSLT {


    public static String createNewXml(String xml, String xslt, String output) {
        Document doc = readDocumentXML(xml);
        if (doc != null) {
            Document x = transformDocument(doc, xml, xslt);
            writeDocumentToFile(x, output);


            doc = readDocumentXML(output);
            String t = readDocumentToString(doc);
            return t;
        }
        return "No such file";
    }

    public static void createNewHtml(String xml, String xslt, String output){
        Document doc = readDocumentXML(xml);
        if (doc != null) {
            Document x = transformDocument(doc, xml, xslt);
            writeDocumentToFile(x, output);


            String url = output;
            File htmlFile = new File(url);
            //                Desktop.getDesktop().browse(htmlFile.toURI());
            System.out.println(htmlFile.toURI());
        }
    }

    public static String createNewTxt(String xml, String xslt, String output){
        Document doc = readDocumentXML(xml);
        if (doc != null) {
            transformDocument2(xml, xslt, output);

            try {
                FileReader reader = new FileReader(output);
                BufferedReader bufferedReader = new BufferedReader(reader);

                StringBuilder builder = new StringBuilder();
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    builder.append(line + "\n");
                }
                return builder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "No such file";
    }

    public static Document transformDocument(Document XMLdoc, String xmlFile, String xslFile) {

        try {
            DocType d = XMLdoc.getDocType();
            if (d != null) {
                XMLdoc.setDocType(null);
                writeDocumentToFile(XMLdoc, xmlFile);
                XMLdoc = readDocumentXML(xmlFile);
            }
            XSLTransformer transformer = new XSLTransformer(xslFile);
            Document doc2 = transformer.transform(XMLdoc);
            if (doc2 == null) System.out.println("Null");
            return doc2;
        } catch (XSLTransformException ex) {
        }
        return null;
    }
  
  
    /* Também perimte Transformações para TXT method="text"
       Não cria objeto DOM Document
       Cria diretamente em disco o ficheiro da transformação*/
    public static void transformDocument2(String xmlFile, String xslFile, String sOutFile)
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader(xmlFile));
            String sLine;
            StringBuilder sBuffer = new StringBuilder();
            while ( (sLine = br.readLine()) != null ) 
                sBuffer.append(sLine).append("\n");
            String sXML = sBuffer.toString();
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new StreamSource(xslFile));
            transformer.transform(new StreamSource(new StringReader(sXML)),
                                  new StreamResult(new FileOutputStream(sOutFile)));
        }
        catch(IOException | TransformerException ex){
        }
    
  }
    public static Document readDocumentXML(String filename) {
        try {
            File file = new File(filename);
            InputStreamReader stream = new InputStreamReader(new FileInputStream(file), "utf-8");
            Reader reader = new BufferedReader(stream);
            SAXBuilder builder = new SAXBuilder();
            Document anotherDocument = builder.build(reader);
            return anotherDocument;
        } catch (JDOMException | IOException ex) {
            System.out.println("File XML not found");
            return null;
        }
    }

    public static void writeDocumentToFile(Document doc, String filename) {
        OutputStreamWriter writer = null;
        try {

            Format outputFormat = Format.getPrettyFormat();
            outputFormat.setIndent("    ");
            outputFormat.setEncoding("utf-8");

            XMLOutputter outputter = new XMLOutputter(outputFormat);
            writer = new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8);
            outputter.output(doc, writer);
            writer.close();
        } catch (IOException ignored) {
        } finally {
            try {
                writer.close();
            } catch (IOException ignored) {
            }
        }

    }

    /*Read a Document XML to a String*/
    public static String readDocumentToString(Document doc) {


        Format outputFormat = Format.getPrettyFormat();
        outputFormat.setIndent("     ");

        XMLOutputter outputter = new XMLOutputter(outputFormat);
        String txt = outputter.outputString(doc);
        return txt;
    }


}
