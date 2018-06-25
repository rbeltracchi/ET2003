/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import frame.MainFrameApp;

/**
 *
 * @author Pablo
 */
public class App {

    public static void main(String[] args) {
        try {
            MainFrameApp mainFrame = new MainFrameApp();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
