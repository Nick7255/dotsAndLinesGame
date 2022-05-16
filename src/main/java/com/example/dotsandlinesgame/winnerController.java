package com.example.dotsandlinesgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class winnerController {

    @FXML
    private Label winner;
    @FXML
    private Button playagain,newplayers;
    @FXML
    private AnchorPane anchornew;

    public void announcewinner(String s,String c){
        winner.setText(s.trim()+" wins");
        anchornew.setStyle(c);
    }

    public void draw(){
        winner.setText("draw");
        anchornew.setStyle("-fx-Background-color: GREY");
    }

    public void backtostart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene.fxml"));
        Parent newroot = loader.load();
        Controller restartcontroller = loader.getController();
        Scene newscene = new Scene(newroot);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(newscene);
        stage.show();
    }

}
