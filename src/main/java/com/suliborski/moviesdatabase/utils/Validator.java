package com.suliborski.moviesdatabase.utils;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

import java.io.File;
import java.io.IOException;

public class Validator {

    public static boolean validateWithDTD(String fileName){
        try {
            SAXBuilder builder = new SAXBuilder(XMLReaders.DTDVALIDATING);
            Document jdomDocValidatedFalse = builder.build(new File(fileName));
            return true;
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean validateWithXSD(String fileName){
        try {
            SAXBuilder builder = new SAXBuilder(XMLReaders.XSDVALIDATING);
            Document jdomDocValidatedFalse = builder.build(new File(fileName));
            return true;
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
