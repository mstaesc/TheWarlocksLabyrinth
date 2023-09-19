package edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game;

public class Question {
    //Stores the question
    private int questionID;

    //Stores the correct answer for the question
    private boolean answerTrue;

    public Question (int questionID, boolean answerTrue) {
        //set values through arguments passed in constructor
        this.questionID = questionID;
        this.answerTrue = answerTrue;
    }

    //gets the question
    public int getQuestionID() {
        return questionID;
    }

    //set the question
    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    //get correct answer to question
    public boolean getAnswerTrue() {
        return answerTrue;
    }

    //set correct answer to question
    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
