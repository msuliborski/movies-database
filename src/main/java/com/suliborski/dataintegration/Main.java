package com.suliborski.dataintegration;

import com.suliborski.dataintegration.data.Movie;
import com.suliborski.dataintegration.utils.HttpRequest;
import com.suliborski.dataintegration.utils.Wrapper;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        List<String> movieStrings = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();

        movieStrings.add("Toy Story");
        movieStrings.add("Dr. Dolittle (1998 film)");
//        movieStrings.add("Pulp Fiction");
//        movieStrings.add("Thelma & Louise");
//        movieStrings.add("Blade Runner");
//        movieStrings.add("Prometheus (2012 film)");
//        movieStrings.add("Back to the Future");
//        movieStrings.add("Good Will Hunting");
//        movieStrings.add("The Talented Mr. Ripley (film)");
//        movieStrings.add("The Accidental Tourist");
//        movieStrings.add("Match Point");
//        movieStrings.add("Vicky Cristina Barcelona");
//        movieStrings.add("Larry Crowne");
//        movieStrings.add("Annie Hall");
//        movieStrings.add("The Village (2004 film)");
//        movieStrings.add("Quills");
//        movieStrings.add("Walk the Line");
//        movieStrings.add("Pretty Woman");
//        movieStrings.add("Ocean's Eleven");
//        movieStrings.add("Avengers: Endgame");
//        movieStrings.add("Schindler's List");
//        movieStrings.add("A Quiet Place (film)");

        String link = "https://en.wikipedia.org/wiki/";

        for (String movieString : movieStrings) {
            String wikiSourceCode = HttpRequest.httpRequest(link, movieString, "output.txt");
            movies.add(Wrapper.stringToMovie(wikiSourceCode));

        }

        System.out.println("");
//        System.out.println(movies);

        Wrapper.moviesToNewXMLFile(movies, "movies.xml");
    }


}

