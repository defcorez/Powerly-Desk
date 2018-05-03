package ru.mrsnuff.powerly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Powerly extends Application {

    private static Powerly instance;
    public static Powerly getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initStage();
        instance = this;
    }

    private void initStage() throws IOException {
        primaryStage.setTitle("Powerly");
        showLoader();
    }

    public void showLoader() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Loader.fxml"));

        Scene scene = new Scene(root);

        primaryStage.close();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showMain() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));

        Scene scene = new Scene(root);

        primaryStage.close();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showAdder() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Adder.fxml"));

        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }
}
