package com.suliborski.moviesdatabase;

import com.suliborski.moviesdatabase.data.Movie;
import com.suliborski.moviesdatabase.utils.*;
import com.suliborski.moviesdatabase.utils.XSLT.*;
import com.suliborski.moviesdatabase.utils.XPath.*;

import java.util.ArrayList;
import java.util.List;

interface IA { String getA(); }
interface IB extends IA { int getB(); }
interface IC { int getC(); }

abstract class D implements IB, IC {

    private String a;
    private int b, c;

    public D(String a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getA(){ return a; }
    public int getB(){ return b; }
    public int getC(){ return c; }

    public void setA(String a){ this.a = a; }
    public void setB(int b) { this.b = b; }
    public void setC(int c) { this.c = c; }

    public boolean equals(Object o){
        if(o == null || !(o instanceof D)){
            return false;
        }

        return a.equalsIgnoreCase(((D) o).getA());
    }
}

class E extends D{
    public E(String a, int b, int c){
        super(a, b, c);
        setA(a); setB(b); setC(c);
    }
}

class F extends E{

    private double d;

    public F(String a, int b, int c, double d){
        super(a, b, c);
        setA(a); setB(b); setC(c);
        this.d = d;
    }

    public double getD(){ return d; }

    public boolean equals(Object o){
        if(o == null || !(o instanceof F)){
            return false;
        }



        return this.getA().equalsIgnoreCase(((F) o).getA()) && this.getB() == ((F) o).getB() && this.getC() == ((F) o).getC();
    }
}


class Main {
    public static void main(String args[]) {
        IB a = new E("abc", 1, 1);
        D b = new F("abc", 1, 1, 2.2);
        IA c = new E("abc", 3, 3);
        //IB d = new IB();
        IC e = new F("ddd", 4, 4, 4.4);

        IA r1[] = new D[5];
        IA r2[] = new IB[5];
        ///IB r3[] = new IA[5];
        IC r4[] = new IC[5];

        System.out.println(a);
        System.out.println(b);
        System.out.println(a.equals(b));// f
        System.out.println(b.equals(a));// t
        System.out.println(c.equals(b));// f
        System.out.println(c.getA());
        //System.out.println(e.getA());
    }
}
//
//public class Main {
//    public static void main(String[] args) {
//
//        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//        // Prepare XML files with desired movies
//        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////        Mapper.generateSampleXML();
//
//
//
//
//
//        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//        // Test data manipulation (add, edit, remove)
//        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////        System.out.println(Mapper.getMovieFromXMLFile("Toy Story", "movies.xml"));
////        Mapper.addMovieToXMLFile(Mapper.stringToMovie(HttpRequest.httpRequest(link, "Good Will Hunting", "output.txt")), "movies.xml");
////        System.out.println(Mapper.getMovieFromXMLFile("Good Will Hunting", "movies.xml"));
////        Mapper.deleteMovieFromXMLFile("Toy Story", "movies.xml");
//
//
//        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//        // Validate .xml file with DTD and XML (throwing exception means that validation failed)
//        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////        Validator.validateWithDTD("movies.xml");
////        Validator.validateWithXSD("movies.xml");
//
//
//
//
//
//
//
//        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//        // Test if xPath functions work correctly
//        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////        System.out.println(XPathExercise1("Blade Runner")); //ok
////
////        System.out.println(XPathExercise2("Ridley Scott")); //ok
////
////        List<String> actors = new ArrayList<>();
////        actors.add("Eddie Murphy");
////        actors.add("Ossie Davis");
////        actors.add("Oliver Platt");
////        System.out.println(XPathExercise3(actors)); //ok
////
////        System.out.println(XPathExercise4(70, 91)); //ok
////
////        System.out.println(XPathExercise5("United States")); //ok
////
////        System.out.println(XPathExercise6(1990, 1995)); //ok
////
////        System.out.println(XPathExercise7(50, 200)); //ok
////
////        System.out.println(XPathExercise8("English")); //ok
//
//
//        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//        // Generate outputs with XSLT
//        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////        System.out.println(XSLT.XSLTExercise1());
////        System.out.println(XSLT.XSLTExercise2());
////        System.out.println(XSLT.XSLTExercise3());
//
//    }
//}

