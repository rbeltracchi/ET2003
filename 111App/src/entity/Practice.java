/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dataBase.MySQLConnection;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class Practice {

    private int idPractice;
    private int idTopic;
    private String task;
    private Image image;//ver el seteo de este atributo.
    private int correctAnswer;
    private int score;
    private String option1;
    private String option2;
    private String option3;
    private int userAnswer;
    private User user;

    public Practice(int idPractice, int idTopic, String task, Image image, int correctAnswer, int score, String option1,
            String option2, String option3, User user) {
        this.idPractice = idPractice;
        this.idTopic = idTopic;
        this.task = task;
        this.image = image;
        this.correctAnswer = correctAnswer;
        this.score = score;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.userAnswer = 0;
        this.user = user;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public int getIdPractice() {
        return idPractice;
    }

    public void setIdPractice(int idPractice) {
        this.idPractice = idPractice;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public String toString() {

        System.out.println("Id tema: " + idTopic + " - Enunciado: " + task);

        return "";

    }

}
