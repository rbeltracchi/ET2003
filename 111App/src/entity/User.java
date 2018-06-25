/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dataBase.MySQLConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class User {
//armaria el objeto en el frame de log in y pasaria la instancia a la referencia del frame principal.
    private int idUser;
    private int progress;
    private String name;
    private String surname;
    private String eMail;
    private String telephoneNumber;
    private ArrayList<Integer> completedPractices;//necesito solamente los ids.
    private boolean is111Student;
    private MySQLConnection connection; //la conexion con la cual voy a hacer la consulta.

    public User(MySQLConnection connection) {
        this.connection=connection;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public ArrayList<Integer> getCompletedPractices() {
        return completedPractices;
    }

    public void setCompletedPractices(ArrayList<Integer> completedPractices) {
        this.completedPractices = completedPractices;
    }

    public boolean isIs111Student() {
        return is111Student;
    }

    public void setIs111Student(boolean is111Student) {
        this.is111Student = is111Student;
    }
    
    public void updateProgress(int score, int id) throws SQLException {
    /*Este metodo es llamado desde la clase panel Activity, y se ejecuta una vez que
    el usuario realizo la actividad correctamente y por primera vez.*/    
        //Se ejecuta la instruccion para actualizar el campo progreso del usuario en la base de datos:
        String instruction01="update usuario set progreso=progreso + "+score+" where pk_id_usuario="+this.getIdUser();
        connection.executeInstruction(instruction01);
        //Se pide el dato ya actualizado mediante una consulta para setearlo en la instancia de usuario:
        String query01="select progreso from usuario where pk_id_usuario="+this.getIdUser();
        connection.executeQuery(query01);
        ResultSet res01=connection.getResultSet();
        this.setProgress(res01.getInt("progreso"));
        //Se inserta el registro correspondiente en la tabla de ejercicios realizados:
        String instruction02="insert into ejercicio_realizado (fk_id_usuario,fk_id_ejercicio) select pk_id_usuario from usuario"
                + "where pk_id_usuario="+this.getIdUser()+", "
                + "select pk_id_ejercicio from ejercicio where pk_id_ejercicio="+id;//(chequear que esta query este bien)
        connection.executeInstruction(instruction02);
        //Se incorpora al arraylist el nuevo id del ejercicio realizado.
        completedPractices.add(id);
        
    }

    @Override
    public String toString() {

        return "Nombre: " + name + "\nApellido: " + surname + "\nProgreso: " + progress + "\nActividades Realizadas: " + completedPractices.toString();

    }
}
