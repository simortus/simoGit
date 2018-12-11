package com.mygdx.game.supp;

import static com.badlogic.gdx.math.MathUtils.random;

public class PBLQuestions{
    static String[] pblQues = {
            "One of the following is not a part of PBL terminology?",
            "What comes first?",
            "What does SWOT stands for?"
    };

    static String[][] pblAns = {
            {"1.Problem formula", "2.Introduction", "3.Methodolody", "4.Conclusion"},
            {"1.Problem formulation", "2.Introduction", "3.Product concept", "4.SWOT analysis"},
            {"1.Strategy, Work, Obstacle and Threats ","2.Strength, Wage, Opportunity and Task","3.Strategy, Weakness, Opportunity and Threats","4.Strength, Weakness, Opportunities and Threats"}
    };
    static int[] pblRightAns = {1,2,3};

//    QAStorage pbl = new QAStorage(ques[Dice.quesRandom],ans[Dice.quesRandom],ans[Dice.quesRandom][rightAns[Dice.quesRandom]]);
//    String PBLquestion = test.getQuestion();
//    String[] PBLanswers = test.getAnswers();
//    String PBLrightAnswer = test.getRightAnswer();

}
