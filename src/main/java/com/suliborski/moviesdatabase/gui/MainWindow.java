package com.suliborski.moviesdatabase.gui;

import com.suliborski.moviesdatabase.data.Movie;
import com.suliborski.moviesdatabase.utils.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {

    private Stage stage;

    public Button showXMLFileButton;
    public Button showDTDButton;
    public Button showXSDButton;

    public Button addMovieButton;
    public Button deleteMovieButton;
    public Button editYearButton;
    public Button editDirectorButton;
    public Button editCountryButton;
    public Button validateDTDButton;
    public Button validateXSDButton;
    public Button xPathButton1;
    public Button xPathButton2;
    public Button xPathButton3;
    public Button xPathButton4;
    public Button xPathButton5;
    public Button xPathButton6;
    public Button xPathButton7;
    public Button xPathButton8;
    public Button xsltButton1;
    public Button xsltButton2;
    public Button xsltButton3;
    public Button xsltButton4;
    public Button xsltButton5;
    public Button xsltButton6;

    public TextArea xmlFileContent;

    public TextField addMovieF1;
    public TextField deleteMovieF1;
    public TextField editYearF1;
    public TextField editYearF2;
    public TextField editCountryF1;
    public TextField editCountryF2;
    public TextField editDirectorF1;
    public TextField editDirectorF2;
    public TextField xPath1F1;
    public TextField xPath2F1;
    public TextField xPath3F1;
    public TextField xPath4F1;
    public TextField xPath4F2;
    public TextField xPath5F1;
    public TextField xPath6F1;
    public TextField xPath6F2;
    public TextField xPath7F1;
    public TextField xPath7F2;
    public TextField xPath8F1;

    private static MainWindow instance;

    public MainWindow() {
        if (instance == null) {
            instance = this;
        } else {
            throw new RuntimeException("MainView already created!");
        }
    }

    public static MainWindow getInstance() {
        return instance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        getSampleMoviesToXML();

        showXMLFile();
    }

    private void getSampleMoviesToXML(){
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

    }



    @FXML
    void validateDTD(){
        if (Validator.validateWithDTD("movies.xml"))
            validateDTDButton.setStyle("-fx-text-fill: #00FF00");
        else
            validateDTDButton.setStyle("-fx-text-fill: #FF0000");
    }
    @FXML
    void validateXSD(){
        if (Validator.validateWithXSD("movies.xml"))
            validateXSDButton.setStyle("-fx-text-fill: #00FF00");
        else
            validateXSDButton.setStyle("-fx-text-fill: #FF0000");
    }



    @FXML
    void showXMLFile(){
//        xmlFileContent.setText(XSLT.readDocumentToString(XSLT.readDocumentXML("movies.xml")));
        xmlFileContent.setText(Mapper.fileToString("movies.xml"));
    }

    @FXML
    void showDTD(){
        xmlFileContent.setText(Mapper.fileToString("movies.dtd"));
    }

    @FXML
    void showXSD(){
        xmlFileContent.setText(Mapper.fileToString("movies.xsd"));
    }



    @FXML
    void addMovie(){
        Mapper.addNewMovieToXMLFile(addMovieF1.getText(), "movies.xml");
        showXMLFile();
        addMovieF1.clear();
    }
    @FXML
    void deleteMovie(){
        Mapper.deleteMovieFromXMLFile(deleteMovieF1.getText(), "movies.xml");
        showXMLFile();
        deleteMovieF1.clear();
    }
    @FXML
    void editYear(){
        Mapper.editYearInXMLFile(editYearF1.getText(), "movies.xml", Integer.parseInt(editYearF2.getText()));
        showXMLFile();
        editYearF1.clear();
        editYearF2.clear();
    }
    @FXML
    void editDirector(){
        Mapper.editDirectorInXMLFile(editDirectorF1.getText(), "movies.xml", editDirectorF2.getText());
        showXMLFile();
        editDirectorF1.clear();
        editDirectorF2.clear();
    }
    @FXML
    void editCountry(){
        Mapper.editCountryInXMLFile(editCountryF1.getText(), "movies.xml", editCountryF2.getText());
        showXMLFile();
        editCountryF1.clear();
        editCountryF2.clear();
    }

    @FXML
    void executeXPath1(){
        System.out.println(xPath1F1.getText());
        System.out.println(XPath.XPathExercise1(xPath1F1.getText()));
        xmlFileContent.setText(XPath.XPathExercise1(xPath1F1.getText()));
    }
    @FXML
    void executeXPath2(){
        xmlFileContent.setText(XPath.XPathExercise2(xPath2F1.getText()));
    }
    @FXML
    void executeXPath3(){
        xmlFileContent.setText(XPath.XPathExercise3(new ArrayList<>(Arrays.asList(xPath3F1.getText().split(";")))));
    }
    @FXML
    void executeXPath4(){
        xmlFileContent.setText(XPath.XPathExercise4(Integer.parseInt(xPath4F1.getText()), Integer.parseInt(xPath4F2.getText())));
    }
    @FXML
    void executeXPath5(){
        xmlFileContent.setText(XPath.XPathExercise5(xPath5F1.getText()));
    }
    @FXML
    void executeXPath6(){
        xmlFileContent.setText(XPath.XPathExercise6(Integer.parseInt(xPath6F1.getText()), Integer.parseInt(xPath6F2.getText())));
    }
    @FXML
    void executeXPath7(){
        xmlFileContent.setText(XPath.XPathExercise7(Integer.parseInt(xPath7F1.getText()), Integer.parseInt(xPath7F2.getText())));
    }
    @FXML
    void executeXPath8(){
        xmlFileContent.setText(XPath.XPathExercise8(xPath8F1.getText()));
    }

    @FXML
    void executeXSLT1(){
        xmlFileContent.setText(XSLT.XSLTExercise1());
    }
    @FXML
    void executeXSLT2(){
        xmlFileContent.setText(XSLT.XSLTExercise2());
    }
    @FXML
    void executeXSLT3(){
        xmlFileContent.setText(XSLT.XSLTExercise3());
    }

}
