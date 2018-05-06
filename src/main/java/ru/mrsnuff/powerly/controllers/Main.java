package ru.mrsnuff.powerly.controllers;

import javafx.fxml.FXML;
import ru.mrsnuff.powerly.Powerly;

import java.io.IOException;

public class Main {

    @FXML
    public void addComputer() throws IOException {
        Powerly.getInstance().showAdder();
    }

    @FXML
    public void removeComputer() {

    }
}
