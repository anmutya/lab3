/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package an_mutya.lab3;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author annamutovkina
 */
public interface FileReader {

    public ArrayList<Reactor> readFile(String path);

    public DefaultMutableTreeNode buildTree();
}
