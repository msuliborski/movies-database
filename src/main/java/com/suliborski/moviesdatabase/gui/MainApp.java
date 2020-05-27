package com.suliborski.moviesdatabase.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.net.URL;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL location = getClass().getResource("/com/suliborski/moviesdatabase/MainView.fxml"); ///src/main/resources/com/almasb/test/
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent/*, 600, 100*/);
        stage.setTitle("Airport");
        stage.setScene(scene);
        Screen controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}