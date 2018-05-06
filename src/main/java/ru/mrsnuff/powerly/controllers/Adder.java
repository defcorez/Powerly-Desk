package ru.mrsnuff.powerly.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.mrsnuff.powerly.Powerly;
import ru.mrsnuff.powerly.model.Computer;
import ru.mrsnuff.powerly.utils.SQL;

public class Adder {

    @FXML private TextField nameField;
    @FXML private TextField ipField;
    @FXML private TextField userField;
    @FXML private PasswordField passwordField;

    @FXML
    public void addComputer() {
        Main.getInstance().getComputersData().add(new Computer(nameField.getText(), ipField.getText(), userField.getText(), passwordField.getText()));
        SQL.exec("INSERT INTO computers (name, ip, user, password) VALUES (" + nameField.getText() + ", " + ipField.getText() + ", " + userField.getText() + ", " + passwordField.getText() + ");");
        Powerly.getInstance().getSecondaryStage().close();
    }

    @FXML
    public void closeButton() {
        Powerly.getInstance().getSecondaryStage().close();
    }
}
