package com.metro_12a_group2_project.controller;

import java.io.IOException;

import com.metro_12a_group2_project.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button primaryButton;

    @FXML
    public void initialize(){
        
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
