package com.example.dotsandlinesgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
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
    private Line line0,line1,line2,line3,line4,line5,line6,line7,line8,line9,line10,line11,line12,line13,
            line14,line15,line16,line17,line18,line19,line20,line21,line22,line23,line24,line25,line26,line27,
            line28,line29,line30,line31,line32,line33,line34,line35,line36,line37,line38,line39;
    @FXML
    private Button endGame;


    private Parent newroot;
    private Stage stage;
    private Scene newscene;

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

    public int winnerBlue = 0 ;
    public int winnerRed = 0 ;

    public void changeColor(MouseEvent event){
        String eventlogger = event.getPickResult().getIntersectedNode().getId();
        String selectedLineId = eventlogger.replaceAll("[\\D]", "");
        int idx = Integer.parseInt(selectedLineId);
        Line[] lines = {line0,line1,line2,line3,line4,line5,line6,line7,line8,line9,line10,line11,line12,line13,
                line14,line15,line16,line17,line18,line19,line20,line21,line22,line23,line24,line25,line26,line27,
                line28,line29,line30,line31,line32,line33,line34,line35,line36,line37,line38,line39};
        for(int i=0; i<=lines.length; i = i+1){
            if(lines[idx]==lines[i]){
                if (Objects.equals(nowPlaying1.getText(), s) && !Objects.equals(lines[i].getStyle(),"-fx-stroke: #1e90ff")){
                    lines[i].setStyle("-fx-stroke: #1e90ff;");
                    lines[i].setOpacity(1.0);
                    break;
                }else if (Objects.equals(nowPlaying2.getText(), s) && !Objects.equals(lines[i].getStyle(),"-fx-stroke: #ff3916")){
                    lines[i].setStyle("-fx-stroke: #ff3916;");
                    lines[i].setOpacity(1.0);
                    break;
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("cannot take this line");
                    alert.setHeaderText("line already taken by the other player");
                    alert.showAndWait();
                    break;
                }
            }
        }
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
                        if (Objects.equals(nowPlaying1.getText(), s) && !Objects.equals(buttons[i].getText(), String.valueOf(Player2Name.getText().charAt(0)).toUpperCase())) {
                            buttons[i].setText(String.valueOf(Player1Name.getText().charAt(0)).toUpperCase().trim());
                            buttons[i].setFont(Font.font(15));
                            score1 = score1 + 1;
                            scorePlayer1.setText(String.valueOf(score1));
                            buttons[i].setStyle("-fx-Background-color: #1e90ff;");
                            winnerBlue=winnerBlue+1;
                            break;
                        } else if (Objects.equals(nowPlaying2.getText(), s) && !Objects.equals(buttons[i].getText(), String.valueOf(Player1Name.getText().charAt(0)).toUpperCase())) {
                            buttons[i].setText(String.valueOf(Player2Name.getText().charAt(0)).toUpperCase().trim());
                            buttons[i].setFont(Font.font(15));
                            score2 = score2 + 1;
                            scorePlayer2.setText(String.valueOf(score2));
                            buttons[i].setStyle("-fx-Background-color: #ff3916;");
                            winnerRed=winnerRed+1;
                            break;
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("cannot take this box");
                            alert.setHeaderText("box already taken by the other player");
                            alert.showAndWait();
                            break;
                        }
                    }
            }
    }

    public void endGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("winner.fxml"));
        newroot = loader.load();
        winnerController controllerForWinner = loader.getController();
        newscene = new Scene(newroot);
        if(winnerBlue>winnerRed){
            String c = "-fx-Background-color: #1e90ff;";
            controllerForWinner.announcewinner(Player1Name.getText(),c);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(newscene);
            stage.show();
        } else if (winnerRed>winnerBlue) {
            String c = "-fx-Background-color: #ff3916";
            controllerForWinner.announcewinner(Player2Name.getText(),c);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newscene);
            stage.show();
        }else if (winnerRed==winnerBlue)
            controllerForWinner.draw();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newscene);
            stage.show();
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
