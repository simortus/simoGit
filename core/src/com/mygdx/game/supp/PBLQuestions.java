package com.mygdx.game.supp;

import static com.badlogic.gdx.math.MathUtils.random;

public class PBLQuestions{

    /** HERE YOU ADD QUESTIONS SEPARATED BY A COMMA */
    static String[] pblQues = {
            "One of the following is not a part of PBL terminology?",
            "What comes first?",
            "What does SWOT stands for?",
            " QUESTION ?"
    };

    /** HERE THE SET OF ANSWERS
     * THE FIRST SET OF ANSWERS CORESPONDS TO THE FIRST QUESTION, THE SECOND SET FOR THE SECOND QUESTION AND SO ON.. */
    static String[][] pblAns = {
            {"Problem formula", "Introduction", "Methodolody", "Conclusion"},
            {"Problem formulation", "Introduction", "Product concept", "SWOT analysis"},
            {"Strategy, Work, Obstacle and Threats ","Strength, Wage, Opportunity and Task","Strategy, Weakness, Opportunity and Threats","Strength, Weakness, Opportunities and Threats"},
            {"ANSWER1","ANSWER2","ANSWER3","ANSWER4"}
    };

    /** HERE RIGHT ANSWER' INDEX
     * CORRECT ANSWER TO QUESTION 1 IS THE FIRST ELEMENT IN THIS ARRAY(1 IN THIS CASE)
     * WHICH CORRESPONDS TO THE POSITION OF THE RIGHT ANSWER IN THE SET OF ANSWERS CORRESPONDING TO THAT QUESTION
     * (THEY CAN BE 1 , 2 , 3 , 4 SINCE WE CAN CHOSE FROM 4 OPTIONS )*/
    static int[] pblRightAns = {1,2,3};

//    QAStorage pbl = new QAStorage(ques[Dice.quesRandom],ans[Dice.quesRandom],ans[Dice.quesRandom][rightAns[Dice.quesRandom]]);
//    String PBLquestion = test.getQuestion();
//    String[] PBLanswers = test.getAnswers();
//    String PBLrightAnswer = test.getRightAnswer();

}
