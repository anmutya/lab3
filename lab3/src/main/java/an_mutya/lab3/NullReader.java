/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an_mutya.lab3;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author annamutovkina
 */
public class NullReader implements FileReader{

    @Override
    public ArrayList<Reactor> readFile(String path) {
        System.out.println("Unknown file format!");
        return null;
    }

    @Override
    public DefaultMutableTreeNode buildTree() {
        return null;
    }
    
}
