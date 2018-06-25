/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pablo
 */
public class MySQLConnection {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    //Constructor donde armo la cadena de conexion, pasando tambien el usuario y la contraseña:
    public MySQLConnection(String cadenaConexion, String usuario, String pass) {
        try {
            connection = DriverManager.getConnection(cadenaConexion, usuario, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Metodos get:
    public Connection getConexion() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    //Metodos para cerrar la conexion y objetos que acompañan:
    public void closeResult() {
        try {
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void closeStatement() {
        try {
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void closeConexion() {
        try {
            if (resultSet != null) {
                closeResult();
            }
            if (statement != null) {
                closeStatement();
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //METODOS PARA LAS CONSULTAS/INSERCIONES/UPDATES...
    public void executeQuery(String query) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    //Método para hacer delete, update o insert. Devuelve el numero de registros afectados:
    public int executeInstruction(String instruction) {

        int rows = 0;

        try {
            statement = connection.createStatement();
            rows = statement.executeUpdate(instruction);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rows;
    }

    //Método para validar log in y registro:
    public boolean checkExistingValue(String data, String column, String table) {

        boolean exists = false;

        Statement statementAux;
        try {
            statementAux = connection.createStatement();

            ResultSet aux = statementAux.executeQuery("select count(*) from " + table + " where upper(" + column + ")='" + data.toUpperCase() + "'");

            aux.next();

            if (aux.getInt(1) >= 1) {
                exists = true;
            }

            aux.close();
            statementAux.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return exists;
    }
}
