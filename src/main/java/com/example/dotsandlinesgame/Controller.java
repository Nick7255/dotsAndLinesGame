package com.example.dotsandlinesgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private Button StartButton;
    @FXML
    private Button player1Submit,player2Submit;
    @FXML
    private TextField player1TextField,player2TextField;
    @FXML
    private Label player1Name,player2Name;

    private String user1,user2;

    private Parent root;
    private Stage stage;
    private Scene scene;

    String s = "Now Playing...";


    public void submit1(ActionEvent event) {
        String username1 = player1TextField.getText();
        player1Name.setText(username1);
        user1=username1;
    }


    public void submit2(ActionEvent event) {
        String username2 = player2TextField.getText();
        player2Name.setText(username2);
        user2=username2;
    }

    public void start(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        root = loader.load();
        gameController controllerForGame = loader.getController();
        controllerForGame.Player1Name(user1);
        controllerForGame.Player2Name(user2);
        controllerForGame.initializeTurn(s);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}