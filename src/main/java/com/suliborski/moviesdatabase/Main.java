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
//        Mapper.generateSampleXML();





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
//        Validator.validateWithDTD("movies.xml");
//        Validator.validateWithXSD("movies.xml");







        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // Test if xPath functions work correctly
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//        System.out.println(XPathExercise1("Blade Runner")); //ok
//
//        System.out.println(XPathExercise2("Ridley Scott")); //ok
//
//        List<String> actors = new ArrayList<>();
//        actors.add("Eddie Murphy");
//        actors.add("Ossie Davis");
//        actors.add("Oliver Platt");
//        System.out.println(XPathExercise3(actors)); //ok
//
//        System.out.println(XPathExercise4(70, 91)); //ok
//
//        System.out.println(XPathExercise5("United States")); //ok
//
//        System.out.println(XPathExercise6(1990, 1995)); //ok
//
//        System.out.println(XPathExercise7(50, 200)); //ok
//
//        System.out.println(XPathExercise8("English")); //ok


        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // Generate outputs with XSLT
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//        System.out.println(XSLT.XSLTExercise1());
//        System.out.println(XSLT.XSLTExercise2());
//        System.out.println(XSLT.XSLTExercise3());

    }
}

