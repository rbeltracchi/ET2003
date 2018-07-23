package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import control.HibernateUtil;
import control.Manager;
import entity.User;
import frame.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Automata
 */
public class Main {

    public static void main(String[] args) {
        try {
            LoginFrame mf = new LoginFrame();
            HibernateUtil.closeSession();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
