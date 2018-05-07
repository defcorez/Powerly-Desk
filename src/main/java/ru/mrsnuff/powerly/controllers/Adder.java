package ru.mrsnuff.powerly.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.mrsnuff.powerly.Powerly;
import ru.mrsnuff.powerly.model.Computer;
import ru.mrsnuff.powerly.utils.H2DB;

public class Adder {

    @FXML private TextField nameField;
    @FXML private TextField ipField;
    @FXML private TextField userField;
    @FXML private PasswordField passwordField;

    @FXML
    public void addComputer() {

        for (Computer c : Main.getInstance().getComputersData()) {
            if (c.getName().equalsIgnoreCase(nameField.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(Powerly.getInstance().getSecondaryStage());
                alert.setTitle("Ошибка");
                alert.setHeaderText("Недопустимое имя");
                alert.setContentText("Компьютер с таким именем уже существует");
                alert.showAndWait();
                return;
            }
        }

        //TODO: сделать нормальную проверку на символы и их отсутсвие

        if (nameField.getText().equals("") || ipField.getText().equals("") || userField.getText().equals("") || passwordField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Powerly.getInstance().getSecondaryStage());
            alert.setTitle("Внимание");
            alert.setHeaderText("Все поля должны быть заполнены");
            alert.setContentText("Перед продолжением заполните все поля");
            alert.showAndWait();
            return;
        }

        H2DB.addComputer(nameField.getText(), ipField.getText(), userField.getText(), passwordField.getText());
        Main.getInstance().getComputersData().add(new Computer(nameField.getText(), ipField.getText(), userField.getText(), passwordField.getText()));

        Powerly.getInstance().getSecondaryStage().close();
    }

    @FXML
    public void closeButton() {
        Powerly.getInstance().getSecondaryStage().close();
    }
}
