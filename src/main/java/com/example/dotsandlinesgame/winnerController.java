package com.example.dotsandlinesgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class winnerController {

    @FXML
    private Label winner;
    @FXML
    private Button playAgain;
    @FXML
    private AnchorPane anchornew;

    public void announcewinner(String s,String c){
        winner.setText(s+" wins");
        anchornew.setStyle(c);
    }

    public void draw(){
        winner.setText("draw");
        anchornew.setStyle("-fx-Background-color: GREY");
    }

}
