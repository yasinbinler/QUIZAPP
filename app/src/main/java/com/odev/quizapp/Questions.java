package com.odev.quizapp;

import java.util.ArrayList;

public class Questions {
    private String question, sika, sikb, sikc, sikd;
    private boolean isQuestionImaged, isAnswerImaged;
    private int dogruCvp, puan;


    public Questions(String question, String sika, String sikb, String sikc, String sikd, boolean isQuestionImaged, boolean isAnswerImaged, int dogruCvp, int puan) {
        this.question = question;
        this.sika = sika;
        this.sikb = sikb;
        this.sikc = sikc;
        this.sikd = sikd;
        this.isQuestionImaged = isQuestionImaged;
        this.isAnswerImaged = isAnswerImaged;
        this.dogruCvp = dogruCvp;
        this.puan = puan;
    }
    public Questions(String question, String sika, String sikb, String sikc, String sikd, boolean isQuestionImaged, boolean isAnswerImaged, int dogruCvp) {
        this.question = question;
        this.sika = sika;
        this.sikb = sikb;
        this.sikc = sikc;
        this.sikd = sikd;
        this.isQuestionImaged = isQuestionImaged;
        this.isAnswerImaged = isAnswerImaged;
        this.dogruCvp = dogruCvp;
    }
    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getDogruCvp() {
        return dogruCvp;
    }

    public void setDogruCvp(int dogruCvp) {
        this.dogruCvp = dogruCvp;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSika() {
        return sika;
    }

    public void setSika(String sika) {
        this.sika = sika;
    }

    public String getSikb() {
        return sikb;
    }

    public void setSikb(String sikb) {
        this.sikb = sikb;
    }

    public String getSikc() {
        return sikc;
    }

    public void setSikc(String sikc) {
        this.sikc = sikc;
    }

    public String getSikd() {
        return sikd;
    }

    public void setSikd(String sikd) {
        this.sikd = sikd;
    }


    public boolean isQuestionImaged() {
        return isQuestionImaged;
    }

    public void setQuestionImaged(boolean questionImaged) {
        isQuestionImaged = questionImaged;
    }

    public boolean isAnswerImaged() {
        return isAnswerImaged;
    }

    public void setAnswerImaged(boolean answerImaged) {
        isAnswerImaged = answerImaged;
    }
}
