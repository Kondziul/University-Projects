package com.example.server;

import answer.Answer;
import javafx.util.Pair;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class AnswerAnalyzer implements Runnable{

    private BlockingQueue<Answer> queue;

    private List<Pair<String,String>> stringPairList;
    private Answer answer;
    private int currentQuestionIndex;
    private String writeOnApp;

    private HelloController helloController;


    public AnswerAnalyzer(BlockingQueue<Answer> queue, List<Pair<String,String>> stringPairList, HelloController helloController) {
        this.queue = queue;
        this.stringPairList = stringPairList;
        this.helloController = helloController;
        this.writeOnApp = stringPairList.get(currentQuestionIndex).getKey() + "\n";
        helloController.textArea.setText(writeOnApp);
    }

    @Override
    public void run() {
        while(true){
            if(queue.size()>0) {
                try {
                    answer = queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                writeOnApp += answer.getNick() + " odpowiedział: " + answer.getAnswer() + "\n";
                if (checkAnswer(answer)){
                    writeOnApp += "Dobra odpowiedź \n";
                    helloController.textArea.setText(writeOnApp);
                    currentQuestionIndex++;
                    nextQuestion();

                }
                else{
                    writeOnApp+="Zła odpowiedź \n";
                    helloController.textArea.setText(writeOnApp);
                }



            }
        }


    }

    private void nextQuestion() {
        if(currentQuestionIndex >= stringPairList.size()){
            writeOnApp+="Koniec gry! \n";
            helloController.textArea.setText(writeOnApp);
        }
        else{
            writeOnApp+=stringPairList.get(currentQuestionIndex).getKey() + "\n";
            helloController.textArea.setText(writeOnApp);
        }

    }

    private boolean checkAnswer(Answer answer) {
        return answer.getAnswer().equalsIgnoreCase(stringPairList.get(currentQuestionIndex).getValue());
    }



}
