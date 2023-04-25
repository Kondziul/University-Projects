package com.example.server;

import answer.Answer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HelloController {

    private static final Integer PORT = 4999;

    private static final Path PATH = Path.of("Pytanka.txt");
    private ServerSocket serverSocket;

    private Socket clientSocket;
    private BlockingQueue<Answer> queue;

    private Pair<String,String> stringPair(String[] s){
        return new Pair<>(s[0], s[1]);
    }
    private List<Pair<String,String>> stringPairList = new ArrayList<>();

    @FXML
    public TextArea textArea;


    @FXML
    public void initialize()  throws IOException{


        serverSocket = new ServerSocket(PORT);
        clientSocket = serverSocket.accept();

        readQuestionsFromFile();

        System.out.println("ServerSocket awaiting connections...");


        queue = new ArrayBlockingQueue<>(10);
        AnswerAnalyzer answerAnalyzer = new AnswerAnalyzer(queue, stringPairList, this);
        AnswerListener answerListener = new AnswerListener(clientSocket,queue);

        new Thread(answerAnalyzer).start();
        new Thread(answerListener).start();
        System.out.println("AnswerAnalyzer i answerListener uruchomieni");


    }

    private void readQuestionsFromFile() throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(PATH);
        bufferedReader.lines().forEach(str->stringPairList.add(stringPair(str.split("\\*",2))));

    }
}
