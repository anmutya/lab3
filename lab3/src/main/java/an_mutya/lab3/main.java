package an_mutya.lab3;

import managers.Manager;
import managers.SessionManager;
import org.hibernate.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author annamutovkina
 */
public class main {
    public static void main(String[] args) {
        Manager manager = new Manager();
//        manager.exportToDB();
        manager.agregationByCountry();
        manager.agregationByRegion();
        manager.closeSession();

    }
}
