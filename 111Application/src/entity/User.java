/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Automata
 */
public class User implements Serializable{

    private long id;
    @Size(min = 3, max = 50, message= "El nombre debe tener entre 3 y 50 caracteres")
   // @NotNull (message="Debes ingresar un nombre")
    private String name;
    @Size(min = 3, max = 50, message="El apellido debe tener entre 3 y 50 caracteres")
   // @NotNull (message="Debes ingresar un apellido")
    private String surname;
    @Email(message="El Email no es una dirección de correo válida")
    @Size(min=3,max=50,message="Debes ingresar un eMail entre 3 y 50 caracteres")
    private String eMail;
    @NotNull(message="Debes ingresar una contraseña")
    @Size(min = 5, max = 30, message="La contraseña debe tener entre 5 y 30 caracteres")
    private String password;
    @Pattern(regexp="([0-9]{7,15})", message="El telefono no es valido")
    private String telephoneNumber;
    private int progress;
    private boolean is111Student;
    private Set completedExercises = new HashSet<Exercise>();

    public User() {
    }
    
//    Sin ID
    public User(String name, String surname, String eMail, String password, String telephoneNumber, int progress, boolean is111Student) {
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.progress = progress;
        this.is111Student = is111Student;
    }
    
//    Con ID
    public User(long id, String name, String surname, String eMail, String password, String telephoneNumber, int progress, boolean is111Student) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.progress = progress;
        this.is111Student = is111Student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isIs111Student() {
        return is111Student;
    }

    public void setIs111Student(boolean is111Student) {
        this.is111Student = is111Student;
    }
    
    public void setExercise(Exercise ex){
        completedExercises.add(ex);
    }

    public Set getCompletedExercises() {
        return completedExercises;
    }

    public void setCompletedExercises(Set completedExercises) {
        this.completedExercises = completedExercises;
    }
    
    @Override
    public String toString() {
        return "Id: " + id + " Nombre: " + name + " Apellido: " + surname
                + " Progreso: " + progress + " Email: " + eMail + " Telefono: "
                + telephoneNumber + " Es alumno: " + is111Student;
    }

}
