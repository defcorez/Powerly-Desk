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
    private Parent root;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initStage();
        instance = this;
    }

    private void initStage() throws IOException {
        primaryStage.setTitle("Powerly");
        primaryStage.setResizable(false);

        showLoader();
    }

    private void showLoader() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/Loader.fxml"));

        scene = new Scene(root);

        setScene(scene);
    }

    public void showMain() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));

        scene = new Scene(root);

        setScene(scene);
    }

    public void showAdder() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/Adder.fxml"));

        scene = new Scene(root);

        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    private void setScene(Scene scene) {
        primaryStage.close();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
