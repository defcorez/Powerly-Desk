package ru.mrsnuff.powerly.controllers;

import ru.mrsnuff.powerly.Powerly;

import java.io.IOException;

public class Loader {

    public void next() throws IOException {
        Powerly.getInstance().showMain();
    }
}
