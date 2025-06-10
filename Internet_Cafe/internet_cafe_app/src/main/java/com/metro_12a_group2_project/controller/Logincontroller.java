package com.metro_12a_group2_project.controller;

import java.io.IOException;

import com.metro_12a_group2_project.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Logincontroller {

    @FXML
    private Button btnlogin;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtpassword;

    @FXML
    private TextField txtphoneno;


    @FXML
    public void initialize(){
        
    }
    @FXML
    void loginaction(ActionEvent event) throws IOException {
        App.setRoot("Primary");
    }

}
