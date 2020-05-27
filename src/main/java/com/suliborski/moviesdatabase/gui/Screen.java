package com.suliborski.moviesdatabase.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen implements Initializable {

    private Stage stage;


    public Button wojtekButton;
    public Button module1Button;
    public Button module2Button;

    private static Screen instance;

    public Screen() {
        if (instance == null) {
            instance = this;
        } else {
            throw new RuntimeException("MainView already created!");
        }
    }

    public static Screen getInstance() {
        return instance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    void wojtek(){
        wojtekButton.setText("WOJTEK");
    }
    @FXML
    void module1Button(){
        module1Button.setText("chuj");
    }
    @FXML
    void module2Button(){
        module1Button.setText("chuj2");
    }

}
