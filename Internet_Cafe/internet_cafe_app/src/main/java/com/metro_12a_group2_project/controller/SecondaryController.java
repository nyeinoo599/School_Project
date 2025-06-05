package com.metro_12a_group2_project.controller;

import java.io.IOException;

import com.metro_12a_group2_project.App;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}