package com.example.server;

import answer.Answer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class AnswerListener implements Runnable {


    private BlockingQueue<Answer> queue;

    private ObjectInputStream objectInputStream;

    public AnswerListener(Socket clientSocket, BlockingQueue<Answer> queue) throws IOException {
        this.queue = queue;
        this.objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("czekanie na odpowiedź\n");
                Answer answer = (Answer) objectInputStream.readObject();
                System.out.println("otrzymano odpowiedź od " + answer.getNick() + "\n" + answer.getAnswer());
                queue.add(answer);
            } catch (IOException ex) {
                System.err.println("I/O error: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.err.println("Class Not Found error: " + ex.getMessage());
            }

        }

    }
}
