package com.suliborski.dataintegration.utils;

import com.suliborski.dataintegration.data.Movie;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wrapper {

    private enum Mode {
        skip, title, imageURL, releaseDateUSA, country, director, cast, duration, distributedBy, originalLanguage, musicAuthors, boxOffice, producers, budget
    }

    //TODO
    //correct numbers
    //fix dates
    public static Movie stringToMovie(String sourceCode) {
        Mode mode = Mode.title;
        Movie movie = new Movie();
        StringBuilder wikiTable = new StringBuilder();

        Scanner scanner = new Scanner(sourceCode);
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() <= 0) continue;  // skip empty rows

            Matcher matcher;
            if (mode == Mode.title) {
                matcher = Pattern.compile("<h1 id=\"firstHeading\" class=\"firstHeading\" lang=\"en\"><i>(.*?)</i>").matcher(line);
                if (matcher.find()) {
                    movie.setTitle(matcher.group(1));
                    mode = Mode.imageURL;
                }
            }

            if (mode == Mode.imageURL) {
                matcher = Pattern.compile("<table .*?<img alt=\".*?\" src=\"(.*?)\"").matcher(line);
                if (matcher.find()) {
                    movie.setImageURL(matcher.group(1));
                    mode = Mode.director;
                }
            }


            matcher = Pattern.compile("(?<![a-z]=)[\"|>]([ a-zA-Z0-9$&#;.,]+?)[\"|<]").matcher(line);
            while (matcher.find()) {
                wikiTable.append(matcher.group(1)).append("=");
            }
        }

        List<String> wikiTableData = List.of(wikiTable.toString().split("="));

        for (String cell : wikiTableData) {
            if (cell.equals("Directed by")) { mode = Mode.director; continue;}
            else if (cell.equals("Release date")) { mode = Mode.releaseDateUSA; continue;}
            else if (cell.equals("Country")) { mode = Mode.country; continue;}
            else if (cell.equals("Produced by")) { mode = Mode.producers; continue;}
            else if (cell.equals("Starring")) { mode = Mode.cast; continue;}
            else if (cell.equals("Running time")) { mode = Mode.duration; continue;}
            else if (cell.equals("Distributed by")) { mode = Mode.distributedBy; continue;}
            else if (cell.equals("Language")) { mode = Mode.originalLanguage; continue;}
            else if (cell.equals("Music by")) { mode = Mode.musicAuthors; continue;}
            else if (cell.equals("Budget")) { mode = Mode.budget; continue;}
            else if (cell.equals("Box office")) { mode = Mode.boxOffice; continue;}
            else if (cell.equals("Screenplay by")) { mode = Mode.skip; continue;}
            else if (cell.equals("Story by")) { mode = Mode.skip; continue;}
            else if (cell.equals("Edited by")) { mode = Mode.skip; continue;}
            else if (cell.equals("Written by")) { mode = Mode.skip; continue;}
            else if (cell.equals("Production")) { mode = Mode.skip; continue;}
            else if (cell.equals("Cinematography")) { mode = Mode.skip; continue;}
            else if (cell.equals("Based on")) { mode = Mode.skip; continue;}
            else if (cell.equals("company")) { mode = Mode.skip; continue;}

            if (mode == Mode.director) { movie.setDirector(cell); mode = Mode.skip; }
            else if (mode == Mode.releaseDateUSA) { movie.setReleaseDateUSA(cell); movie.setYear(cell.substring(cell.length() - 4));mode = Mode.skip; }
            else if (mode == Mode.country) { movie.setCountry(cell); mode = Mode.skip; }
            else if (mode == Mode.producers) movie.getProducers().add(cell);
            else if (mode == Mode.cast) movie.getCast().add(cell);
            else if (mode == Mode.duration) { movie.setDuration(cell); mode = Mode.skip; }
            else if (mode == Mode.distributedBy) { movie.setDistributedBy(cell); mode = Mode.skip; }
            else if (mode == Mode.originalLanguage) { movie.setOriginalLanguage(cell); mode = Mode.skip; }
            else if (mode == Mode.musicAuthors) movie.getMusicAuthors().add(cell);
            else if (mode == Mode.budget) { movie.setBudget(cell); }
            else if (mode == Mode.boxOffice) { movie.setBoxOffice(cell); break; }
        }
        scanner.close();
        return movie;
    }

    public static Element getRootElementFromXMLFile(String fileName) {
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(fileName);

            Document document = builder.build(xmlFile);
            return document.getRootElement().detach();
        } catch (JDOMException | IOException ignore) { }
        return null;
    }

    public static Movie elementToMovie(Element movieElement) {
        Movie movie = new Movie();

        movie.setTitle(movieElement.getChild("title").getText());
        movie.setImageURL(movieElement.getChild("image-URL").getText());
        movie.setReleaseDateUSA(movieElement.getChild("release-date-USA").getText());
        movie.setCountry(movieElement.getChild("country").getText());
        movie.setDirector(movieElement.getChild("director").getText());

        Element producersElement = movieElement.getChild("producers");
        for (Element producerElement : producersElement.getChildren())
            movie.getProducers().add(producerElement.getValue());

        Element castElement = movieElement.getChild("cast");
        for (Element actorElement : castElement.getChildren())
            movie.getCast().add(actorElement.getValue());

        movie.setDuration(movieElement.getChild("duration").getText());
        movie.setDistributedBy(movieElement.getChild("distributed-by").getText());
        movie.setOriginalLanguage(movieElement.getChild("original-language").getText());

        Element musicElement = movieElement.getChild("music");
        for (Element musicianElement : musicElement.getChildren())
            movie.getMusicAuthors().add(musicianElement.getValue());

        movie.setBudget(movieElement.getChild("budget").getText());
        movie.setBoxOffice(movieElement.getChild("box-office").getText());

        return movie;
    }

    public static Element movieToElement(Movie movie) {
        Element movieElement = new Element("movie");
        movieElement.addContent(new Element("title").setText(movie.getTitle()));
        movieElement.addContent(new Element("image-URL").setText(movie.getImageURL()));
        movieElement.addContent(new Element("release-date-USA").setText(movie.getReleaseDateUSA()));
        movieElement.addContent(new Element("country").setText(movie.getCountry()));
        movieElement.addContent(new Element("director").setText(movie.getDirector()));

        Element producersElement = new Element("producers");
        for (String producer : movie.getProducers())
            producersElement.addContent(new Element("producer").setText(producer));
        movieElement.addContent(producersElement);

        Element castElement = new Element("cast");
        for (String actor : movie.getCast())
            castElement.addContent(new Element("actor").setText(actor));
        movieElement.addContent(castElement);

        movieElement.addContent(new Element("duration").setText(movie.getDuration()));
        movieElement.addContent(new Element("distributed-by").setText(movie.getDistributedBy()));
        movieElement.addContent(new Element("original-language").setText(movie.getOriginalLanguage()));

        Element musiciansElement = new Element("music");
        for (String musician : movie.getMusicAuthors())
            musiciansElement.addContent(new Element("author").setText(musician));
        movieElement.addContent(musiciansElement);

        movieElement.addContent(new Element("budget").setText(movie.getBudget()));
        movieElement.addContent(new Element("box-office").setText(movie.getBoxOffice()));

        return movieElement;
    }

    public static void saveRootElementInXMLFile(Element rootElement, String fileName) {
        Document document = new Document();
        document.setRootElement(rootElement);
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        try {
            xmlOutputter.output(document, new FileOutputStream(fileName));
        } catch (IOException ignore) { }
    }

    public static void moviesToNewXMLFile(List<Movie> movies, String fileName) {
        Document document = new Document();
        document.setRootElement(new Element("movies", Namespace.getNamespace("https://www.suliborski.com/movies")));
        for(Movie movie : movies)
            document.getRootElement().addContent(movieToElement(movie));

        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        try {
            xmlOutputter.output(document, new FileOutputStream(fileName));
        } catch (IOException ignore) { }

    }

    public static Movie getMovieFromXMLFile(String title, String fileName) {

            Element rootElement = getRootElementFromXMLFile(fileName);

            List<Element> movieElements = rootElement.getChildren("movie");

            for (Element movieElement : movieElements)
                if (movieElement.getChild("title").getText().equals(title)) {
                    return elementToMovie(movieElement);
                }

            return null;
    }

    public static void addMovieToXMLFile(Movie movie, String fileName) {
        File file = new File(fileName);
        if (file.exists() && !file.isDirectory()) {
            saveRootElementInXMLFile(getRootElementFromXMLFile(fileName).addContent(movieToElement(movie)), fileName);
        } else {
            List<Movie> movieList = new ArrayList<>();
            movieList.add(movie);
            moviesToNewXMLFile(movieList, fileName);
        }
    }

    public static void deleteMovieFromXMLFile(String title, String fileName) {
        Element rootElement = getRootElementFromXMLFile(fileName);
        Element movieToDelete = null;
        List<Element> movieElements = rootElement.getChildren("movie");

        for (Element movieElement : movieElements)
            if (movieElement.getChild("title").getText().equals(title)){
                movieToDelete = movieElement;
            }
        rootElement.removeContent(movieToDelete);
        saveRootElementInXMLFile(rootElement, fileName);
    }

    public static void editMovieInXMLFile(String title, String fileName, Movie newMovieData) {
        Movie movie = getMovieFromXMLFile(title, fileName);

        Element rootElement = getRootElementFromXMLFile(fileName);
        Element movieElement = null;

        List<Element> movieElements = rootElement.getChildren("movie");

        for (Element e : movieElements)
            if (e.getChild("title").getText().equals(title)) {
                movieElement = e;
            }

        movieElement.getChild("title").setText(movie.getTitle());
        movieElement.getChild("image-URL").setText(movie.getImageURL());
        movieElement.getChild("release-date-USA").setText(movie.getReleaseDateUSA());
        movieElement.getChild("country").setText(movie.getCountry());
        movieElement.getChild("director").setText(movie.getDirector());

        Element producersElement = new Element("producers");
        for (String producer : movie.getProducers())
            producersElement.getChild("producer").setText(producer);
        movieElement.removeContent(movieElement.getChild("producers"));
        movieElement.addContent(producersElement);

        Element castElement = new Element("cast");
        for (String actor : movie.getCast())
            castElement.getChild("actor").setText(actor);
        movieElement.removeContent(movieElement.getChild("cast"));
        movieElement.addContent(castElement);

        movieElement.getChild("duration").setText(movie.getDuration());
        movieElement.getChild("distributed-by").setText(movie.getDistributedBy());
        movieElement.getChild("original-language").setText(movie.getOriginalLanguage());

        Element musiciansElement = new Element("music");
        for (String musician : movie.getMusicAuthors())
            musiciansElement.getChild("author").setText(musician);
        movieElement.removeContent(movieElement.getChild("music"));
        movieElement.addContent(musiciansElement);

        movieElement.getChild("budget").setText(movie.getBudget());
        movieElement.getChild("box-office").setText(movie.getBoxOffice());

        saveRootElementInXMLFile(rootElement, fileName);
    }

}





