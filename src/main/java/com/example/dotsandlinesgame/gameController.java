package com.example.dotsandlinesgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

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
    public Button button1,button2,button3,button4,button5,button6,
            button7,button8,button9,button10,button11,button12;


    @FXML
    Line line = new Line();

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

    public double selectDot (MouseEvent event){
        System.out.println("dot selected");
        line.setOpacity(1.0);
        line.setStrokeWidth(6.0);
        line.setStroke(Color.RED);
        line.setStartX(event.getX());
        line.setStartY(event.getY());
        line.setEndX(endDot(event));
        return 0;
    }

    public double endDot (MouseEvent event) {
        System.out.println("dot completed");
        line.setEndX(event.getX());
        line.setEndY(event.getY());
        System.out.println(line);
        return 0;
    }
    public void scoreUp(ActionEvent event){
        Integer score1 = Integer.valueOf(scorePlayer1.getText());
        Integer score2= Integer.valueOf(scorePlayer2.getText());
        button1.setText(String.valueOf(Player1Name.getText().charAt(0)));
        button1.setFont(Font.font(13));
        if (nowPlaying1.getText()==s){
            score1=score1+1;
            scorePlayer1.setText(String.valueOf(score1));
        }else if(nowPlaying2.getText()==s){
           score2=score2+1;
           scorePlayer2.setText(String.valueOf(score2));
        }
    }
    public void switchTurns(ActionEvent event) {
        if (nowPlaying1.getText()==s){
            nowPlaying2.setText(s);
            nowPlaying1.setText("");
        }else if(nowPlaying2.getText()==s) {
            nowPlaying1.setText(s);
            nowPlaying2.setText("");
        }
    }
}
