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
public class Module {

    private int idModule;
    private String name;
    private ArrayList<Topic> topics;
    private String description;//este dato si bien lo cargo, dentro del planteo que me hice no
                               //encontre alguna parte en la que se justifique/sea necesario mostrarlo ((*)abierto a sugerencias)
    private int order;//((*)me pasa lo mismo)-->creo que el orden se justificaba mas en las actividades.
                      //En la base de datos la tabla ejercicio no tenia campo orden, igual le encontre una vuelta en una de las clases
                      //de tipo panel (si mal no recuerdo).

    public Module(int idModule, String name, ArrayList<Topic> topics, String description, int order) {
        this.idModule = idModule;
        this.name = name;
        this.topics = topics;
        this.description = description;
        this.order = order;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
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

    @Override
    public String toString() {

        return "Nombre: " + name + "\nDescripción: " + description;

    }
}
