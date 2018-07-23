/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Automata
 */
public class Topic {

    private long id;
    private String name;
    private String description;
    private String theory;
    private Set exercises = new HashSet<Exercise>();
    
    public Topic() {
        
    }
//    Sin ID
    public Topic(String name, String description, String theory) {
        this.name = name;
        this.description = description;
        this.theory = theory;
    }
    
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public Set getExercises() {
        return exercises;
    }

    public void setExercises(Set exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString(){
        return name;
    }
    
}