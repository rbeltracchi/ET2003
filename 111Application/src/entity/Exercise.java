/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;

/**
 *
 * @author Automata
 */
public class Exercise {

    private long id;
    private String task;
    private String image;
    private int correctAnswer;
    private int score;
    private String option1;
    private String option2;
    private String option3;
    private int userAnswer;
    private Topic topicBelong;
    private Set userDo = new HashSet<User>();

    public Exercise() {
    }
    
//    Sin ID
    public Exercise(String task, String image, int correctAnswer, int score, String option1, String option2, String option3, int userAnswer, Topic topicBelong) {
        this.task = task;
        this.image = image;
        this.correctAnswer = correctAnswer;
        this.score = score;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.userAnswer = userAnswer;
        this.topicBelong = topicBelong;
    }
    
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    public Topic getTopicBelong() {
        return topicBelong;
    }

    public void setTopicBelong(Topic topicBelong) {
        this.topicBelong = topicBelong;
    }

    public Set getUserDo() {
        return userDo;
    }

    public void setUserDo(Set userDo) {
        this.userDo = userDo;
    }
    
    @Override
    public String toString(){
        return "Enunciado: " + task ;
    }
    
}
