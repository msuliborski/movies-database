package com.suliborski.moviesdatabase.utils;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HttpRequest {
    
     public static String httpRequest(String link, String search, String outFile) {
         try {
             URL url = new URL(link + URLEncoder.encode(search, StandardCharsets.UTF_8).replace("+", "_"));
             System.out.println(link + URLEncoder.encode(search, StandardCharsets.UTF_8).replace("+", "_"));

             URLConnection urlConnection = url.openConnection();

             urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en-US; rv:1.9.2.16) Gecko/20110319 Firefox/3.6.16");

             try (BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
                  BufferedWriter out = new BufferedWriter(new FileWriter(outFile));) {
                 StringBuilder stringBuilder = new StringBuilder();
                 String line;

                 while ((line = in.readLine()) != null)
                     stringBuilder.append(line).append(System.getProperty("line.separator"));

                 out.write(stringBuilder.toString());
                 return stringBuilder.toString();
             }
         } catch (MalformedURLException ex) {
             System.out.println("Error in URL!");

         } catch (IOException ex) {
             System.out.println("Error while writing to the file!");
         }
         return null;
     }
}
