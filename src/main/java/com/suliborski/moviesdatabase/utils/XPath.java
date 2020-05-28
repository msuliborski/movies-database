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
        return "nope";
    }

    public static String XPathExercise1(String title){
        System.out.println("Search for a movie title and show relevant information");
        String xp="//movies/movie[title='" + title + "']";
        return XPath.execute(xp, "movies.xml");
    }

    public static String XPathExercise2(String director){ System.out.println("Search for films by a given director");
        String xp="//movies/movie[director='" + director + "']/title";
        return XPath.execute(xp, "movies.xml");
    }

    public static String XPathExercise3(List<String> actors){
        System.out.println("Search for films with the participation of a given actor / actors");
        String actorsString = "actor='" + String.join("' and actor='", actors) + "'";
        String xp="//movies/movie/cast[" + actorsString + "]/../title";
        return XPath.execute(xp, "movies.xml");
    }

    public static String XPathExercise4(int min, int max){
        System.out.println("Search for movies with a duration between a given interval");
        String xp="/movies/movie[duration>=" + min + " and duration<=" + max + "]/title";
        return XPath.execute(xp, "movies.xml");
    }

    public static String XPathExercise5(String country){
        System.out.println("Search for films from a given country");
        String xp="/movies/movie[country='" + country + "']/title";
        return XPath.execute(xp, "movies.xml");
    }


    public static String XPathExercise6(int min, int max){
        System.out.println("Search for movies with a year between a given interval");
        String xp="/movies/movie[year>=" + min + " and year<=" + max + "]/title";
        return XPath.execute(xp, "movies.xml");
    }


    public static String XPathExercise7(int min, int max){
        System.out.println("Search for movies with a box office between a given interval");
        String xp="/movies/movie[box-office>=" + min + " and box-office<=" + max + "]/title";
        return XPath.execute(xp, "movies.xml");
    }

    public static String XPathExercise8(String language){
        System.out.println("Search for films in a given language");
        String xp="/movies/movie[original-language='" + language + "']/title";
        return XPath.execute(xp, "movies.xml");
    }
}
