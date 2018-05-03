package ru.mrsnuff.powerly.controllers;

import javafx.fxml.FXML;
import ru.mrsnuff.powerly.Powerly;

import java.io.IOException;

public class Loader {

    public void next() throws IOException {
        Powerly.getInstanse().showMain();
    }
}
