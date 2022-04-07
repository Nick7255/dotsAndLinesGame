package com.example.dotsandlinesgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.util.Arrays;
import java.util.Objects;


public class gameController{
    @FXML
    private Label scorePlayer1,scorePlayer2;
    @FXML
    private Button switcher;
    @FXML
    private Label Player1Name, Player2Name;
    @FXML
    private Label nowPlaying1,nowPlaying2;
    @FXML
    private Button button0,button1,button2,button3,button4,button5,button6,
            button7,button8,button9,button10,button11,button12, button13, button14, button15;

    @FXML
    private Line redLine;

    public String s = "Now Playing...";


    public void initializeTurn(String s){
        nowPlaying1.setText(s);
    }

    public void Player1Name(String user1) {
        Player1Name.setText(user1);
    }

    public void Player2Name(String user2) {
        Player2Name.setText(user2);
    }

    public void selectDot (MouseEvent event){

    }

    public void endDot (MouseEvent event) {
    }

    public void scoreUp(MouseEvent event){
            String eventlogger = event.getPickResult().getIntersectedNode().getId();
            String selectedButtonId = eventlogger.replaceAll("[\\D]", "");
            int idx = Integer.parseInt(selectedButtonId);
            Integer score1 = Integer.valueOf(scorePlayer1.getText());
            Integer score2 = Integer.valueOf(scorePlayer2.getText());
            Button[] buttons = {button0, button1, button2, button3, button4, button5, button6,
                    button7, button8, button9, button10,
                    button11, button12, button13, button14, button15};
            for (int i = 0; i <= buttons.length; i = i + 1) {
                if (buttons[idx] == buttons[i]) {
                    if (nowPlaying1.getText() == s) {
                        buttons[i].setText(String.valueOf(Player1Name.getText().charAt(0)).toUpperCase());
                        buttons[i].setFont(Font.font(15));
                        score1 = score1 + 1;
                        scorePlayer1.setText(String.valueOf(score1));
                    } else if (nowPlaying2.getText() == s) {
                        buttons[i].setText(String.valueOf(Player2Name.getText().charAt(0)).toUpperCase());
                        buttons[i].setFont(Font.font(15));
                        score2 = score2 + 1;
                        scorePlayer2.setText(String.valueOf(score2));
                    }
                    buttons[i].isDisabled();
                    break;
                }
            }
    }

    public void switchTurns (ActionEvent event) {
        if (nowPlaying1.getText()==s){
            nowPlaying2.setText(s);
            nowPlaying1.setText("");
        }else if(nowPlaying2.getText()==s) {
            nowPlaying1.setText(s);
            nowPlaying2.setText("");
        }
    }
}
