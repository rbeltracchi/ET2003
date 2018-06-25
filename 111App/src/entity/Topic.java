/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class Topic {

    private int idTopic;
    private String name;
    private int idModule;
    private String description;
    private int order;
    private String theory;
    private ArrayList<Practice> practices;

    public Topic(int idTopic, String name, int idModule, String description, int order, String theory, ArrayList<Practice> practices) {
        this.idTopic = idTopic;
        this.name = name;
        this.idModule=idModule;
        this.description = description;
        this.order = order;
        this.theory = theory;
        this.practices = practices;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setModuleName(int idModule) {
        this.idModule = idModule;
    }

    
    
    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public ArrayList<Practice> getPractices() {
        return practices;
    }

    public void setPractices(ArrayList<Practice> practices) {
        this.practices = practices;
    }

    @Override
    public String toString() {//este metodo deberia ser llamado en el JComboBox del TopicPanel cuando 
                              //mostraria las opciones (temas).

        System.out.println(name);

        return "";

    }

}
