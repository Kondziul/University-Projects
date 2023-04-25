package com.example.klient1;

import answer.Answer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HelloController{

    private Socket socket;
    private ObjectOutputStream objectOutputStream;

    @FXML
    private TextField answer;

    @FXML
    private TextField nick;

    @FXML
    private Button connectButton;


    @FXML
    private Button sendButton;

    @FXML
    void onConnect(ActionEvent event) throws IOException{
        socket = new Socket("localhost", 4999);
        System.out.println("Connected!");

        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        connectButton.setDisable(true);
        sendButton.setDisable(false);


    }

    @FXML
    void onSend(ActionEvent event) throws IOException{

        Answer answer1 = new Answer(nick.getText(),answer.getText());
        objectOutputStream.writeObject(answer1);

    }

    @FXML
    public void initialize() throws IOException{

        connectButton.setDisable(false);
        sendButton.setDisable(true);





    }
}