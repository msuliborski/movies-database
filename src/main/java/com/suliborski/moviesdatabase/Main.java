package com.suliborski.moviesdatabase;

import com.suliborski.moviesdatabase.data.Movie;
import com.suliborski.moviesdatabase.utils.*;
import com.suliborski.moviesdatabase.utils.XSLT.*;
import com.suliborski.moviesdatabase.utils.XPath.*;

import java.util.ArrayList;
import java.util.List;

import static com.suliborski.moviesdatabase.utils.XPath.*;

public class Main {



    public static void main(String[] args) {

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // Prepare XML files with desired movies
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        List<String> movieStrings = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();

        movieStrings.add("Toy Story");
        movieStrings.add("Dr. Dolittle (1998 film)");
        movieStrings.add("Pulp Fiction");
        movieStrings.add("Thelma & Louise");
        movieStrings.add("Blade Runner");
        movieStrings.add("Prometheus (2012 film)");
        movieStrings.add("Back to the Future");
        movieStrings.add("Good Will Hunting");
        movieStrings.add("The Talented Mr. Ripley (film)");
        movieStrings.add("The Accidental Tourist");
        movieStrings.add("Match Point");
        movieStrings.add("Vicky Cristina Barcelona");
        movieStrings.add("Larry Crowne");
        movieStrings.add("Annie Hall");
        movieStrings.add("The Village (2004 film)");
        movieStrings.add("Quills");
        movieStrings.add("Walk the Line");
        movieStrings.add("Pretty Woman");
        movieStrings.add("Ocean's Eleven");
        movieStrings.add("Avengers: Endgame");
        movieStrings.add("Schindler's List");
        movieStrings.add("A Quiet Place (film)");

        String link = "https://en.wikipedia.org/wiki/";

        for (String movieString : movieStrings) {
            String wikiSourceCode = HttpRequest.httpRequest(link, movieString, "output.txt");
            movies.add(Mapper.stringToMovie(wikiSourceCode));
        }

        Mapper.moviesToNewXMLFile(movies, "movies.xml");







        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // Test data manipulation (add, edit, remove)
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//        System.out.println(Mapper.getMovieFromXMLFile("Toy Story", "movies.xml"));
//        Mapper.addMovieToXMLFile(Mapper.stringToMovie(HttpRequest.httpRequest(link, "Good Will Hunting", "output.txt")), "movies.xml");
//        System.out.println(Mapper.getMovieFromXMLFile("Good Will Hunting", "movies.xml"));
//        Mapper.deleteMovieFromXMLFile("Toy Story", "movies.xml");


        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // Validate .xml file with DTD and XML (throwing exception means that validation failed)
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//        try {
//            SAXBuilder builder = new SAXBuilder(XMLReaders.DTDVALIDATING);
//            Document jdomDocValidatedFalse = builder.build(new File("movies.xml"));
//        } catch (JDOMException | IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            SAXBuilder builder = new SAXBuilder(XMLReaders.XSDVALIDATING);
//            Document jdomDocValidatedFalse = builder.build(new File("movies.xml"));
//        } catch (JDOMException | IOException e) {
//            e.printStackTrace();
//        }







        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // Test if xPath functions work correctly
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        XPathExercise1("Toy Story"); //ok

        XPathExercise2("Ridley Scott"); //ok

        List<String> actors = new ArrayList<>();
        actors.add("Eddie Murphy");
        actors.add("Ossie Davis");
        actors.add("Oliver Platt");
        XPathExercise3(actors); //ok

        XPathExercise4(70, 91); //ok

        XPathExercise5("United States"); //ok

        XPathExercise6(1990, 1995); //ok

        XPathExercise7(50, 200); //ok

        XPathExercise8("English"); //ok


        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // Generate coś tam
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        XSLT.createNewHtml("movies.xml", "movies-to-image-urls-html.xsl", "movies-image-urls.html");
        XSLT.createNewXml("movies.xml", "movies-to-directors-movies-xml.xsl", "movies-directors-movies.xml");
        XSLT.createNewTxt("movies.xml", "movies-to-movies-of-country-txt.xsl", "movies-of-country.txt");

//


    }



}

