package com.example.dotsandlinesgame;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class gameController {

    @FXML
    private Button button;
    @FXML
    private Label Player1Name, Player2Name;
    @FXML
    private Label playerScore1, playerScore2;
    @FXML
    private GridPane grid;
    @FXML
    private Label nowPlaying1,NowPlaying2;

    Line line = new Line();

    public void Player1Name(String user1) {
        Player1Name.setText(user1);
    }

    public void Player2Name(String user2) {
        Player2Name.setText(user2);
    }

    public void selectDot (MouseEvent event){
        System.out.println("dot selected");
        line.setOpacity(1.0);
        line.setStrokeWidth(6.0);
        line.setStroke(Color.RED);
        line.setStartX(event.getX());
        line.setStartY(event.getY());
    }

    public void endDot (MouseEvent event){
        System.out.println("dot completed");
        line.setEndX(event.getX());
        line.setEndY(event.getY());
        System.out.println(line);
    }


}
