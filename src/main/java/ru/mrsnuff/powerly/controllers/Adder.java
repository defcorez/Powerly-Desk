package ru.mrsnuff.powerly.controllers;

import javafx.fxml.FXML;
import ru.mrsnuff.powerly.Powerly;

public class Adder {

    @FXML
    public void add() {

    }

    @FXML
    public void closeButton() {
        Powerly.getInstance().getSecondaryStage().close();
    }
}
