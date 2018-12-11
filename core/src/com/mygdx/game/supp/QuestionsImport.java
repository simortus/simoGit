package com.mygdx.game.supp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class QuestionsImport {

    public String question;
    public String rightAns;
    public String wrongAns1;
    public String wrongAns2;
    public String wrongAns3;

    public QuestionsImport(String question, String rightAns, String wrongAns1, String wrongAns2, String wrongAns3) {

        this.question = question;
        this.rightAns = rightAns;
        this.wrongAns1 = wrongAns1;
        this.wrongAns2 = wrongAns2;
        this.wrongAns3 = wrongAns3;

    }


    public static void filler(Stack<QuestionsImport> stack, File questions) {
        String question, rightAns, wrongAns1, wrongAns2, wrongAns3;
        question = rightAns = wrongAns1 = wrongAns2 = wrongAns3 = null;

        int i = 0 ;
        Scanner dataReader = null;

        try{
            dataReader = new Scanner(questions);
            while(dataReader.hasNextLine()){
                if(i == 0){
                    question = dataReader.nextLine();
                    i++;
                } else if(i == 1){
                    rightAns = dataReader.nextLine();
                    i++;
                } else if(i == 2){
                    wrongAns1 = dataReader.nextLine();
                    i++;
                } else if(i == 3) {
                    wrongAns2 = dataReader.nextLine();
                    i++;
                } else if(i == 4){
                    wrongAns3 = dataReader.nextLine();
                    i++;
                } else if(i == 5){
                    stack.push(new QuestionsImport(question,rightAns,wrongAns1,wrongAns2,wrongAns3));
                    i = 0;
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("File is missing");

        }
        finally {
        if(dataReader != null){
            dataReader.close();
        }
        }
    }
}