package ru.mrsnuff.powerly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
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
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private Stage secondaryStage;
    public Stage getSecondaryStage() {
        return secondaryStage;
    }

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
        setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/Loader.fxml"))));
    }

    public void showMain() throws IOException {
        setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"))));
    }

    public void showAdder() throws IOException {
        secondaryStage = new Stage();

        secondaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/Adder.fxml"))));
        secondaryStage.setResizable(false);
        secondaryStage.setTitle("Добавить компьютер");
        secondaryStage.initOwner(primaryStage);
        secondaryStage.initModality(Modality.WINDOW_MODAL);
        secondaryStage.showAndWait();
    }

    private void setScene(Scene scene) {
        primaryStage.close();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
