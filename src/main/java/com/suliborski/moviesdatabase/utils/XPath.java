package com.suliborski.moviesdatabase.utils;

import net.sf.saxon.s9api.*;

import java.io.File;
import java.util.List;

public class XPath {

    public static String execute(String xp, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                Processor processor = new Processor(false);
                XPathCompiler xPathCompiler = processor.newXPathCompiler();

                DocumentBuilder documentBuilder = processor.newDocumentBuilder();

                XdmNode xml = documentBuilder.build(new File(fileName));
                XPathSelector xPathSelector = xPathCompiler.compile(xp).load();

                xPathSelector.setContextItem(xml);
                XdmValue xdmValue = xPathSelector.evaluate();


                StringBuilder stringBuilder = new StringBuilder();
                for (XdmItem xdmItem : xdmValue) {
                    stringBuilder.append(xdmItem.getStringValue()).append("\n");
                }
                return stringBuilder.toString();

            } catch (SaxonApiException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static void XPathExercise1(String title){
        System.out.println("Search for a movie title and show relevant information");
        String xp="//movies/movie[title='" + title + "']";
        String result = XPath.execute(xp, "movies.xml");
        System.out.println(result);
    }

    public static void XPathExercise2(String director){ System.out.println("Search for films by a given director");
        String xp="//movies/movie[director='" + director + "']/title";
        String result = XPath.execute(xp, "movies.xml");
        System.out.println(result);
    }

    public static void XPathExercise3(List<String> actors){
        System.out.println("Search for films with the participation of a given actor / actors");
        String actorsString = "actor='" + String.join("' and actor='", actors) + "'";
        String xp="//movies/movie/cast[" + actorsString + "]/../title";
        String result = XPath.execute(xp, "movies.xml");
        System.out.println(result);
    }

    public static void XPathExercise4(int min, int max){
        System.out.println("Search for movies with a duration between a given interval");
        String xp="/movies/movie[duration>=" + min + " and duration<=" + max + "]/title";
        String result = XPath.execute(xp, "movies.xml");
        System.out.println(result);
    }

    public static void XPathExercise5(String country){
        System.out.println("Search for films from a given country");
        String xp="/movies/movie[country='" + country + "']/title";
        String result = XPath.execute(xp, "movies.xml");
        System.out.println(result);
    }


    public static void XPathExercise6(int min, int max){
        System.out.println("Search for movies with a year between a given interval");
        String xp="/movies/movie[year>=" + min + " and year<=" + max + "]/title";
        String result = XPath.execute(xp, "movies.xml");
        System.out.println(result);
    }


    public static void XPathExercise7(int min, int max){
        System.out.println("Search for movies with a box office between a given interval");
        String xp="/movies/movie[box-office>=" + min + " and box-office<=" + max + "]/title";
        String result = XPath.execute(xp, "movies.xml");
        System.out.println(result);
    }

    public static void XPathExercise8(String language){
        System.out.println("Search for films in a given language");
        String xp="/movies/movie[original-language='" + language + "']/title";
        String result = XPath.execute(xp, "movies.xml");
        System.out.println(result);
    }
}
