/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.HashSet;
import java.util.*;
import java.util.List;

/**
 *
 * @author Automata
 */
public class Module {

    private long id;
    private String name;
    private String description;
    private Set topics = new HashSet<Topic>();


    public Module() {
    }
//    Sin ID
    public Module(String name, String description) {
        this.name = name;
        this.description = description;
    }
//    Con ID
    public Module(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public Set getTopics() {
        return topics;
    }

    public void setTopics(Set topics) {
        this.topics = topics;
    }
    
    @Override
    public String toString() {

        return name;

    }
}
