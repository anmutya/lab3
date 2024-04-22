/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an_mutya.lab3;


import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**
 *
 * @author annamutovkina
 */
public class YamlReader implements FileReader{

    @Override
    public ArrayList<Reactor> readFile(String path) {
        ArrayList<Reactor> reactors = new ArrayList<>();
        try {
            Yaml yaml = new Yaml(new Constructor(Reactor.class));
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);

            if (inputStream != null) {
                yaml.loadAll(inputStream).forEach(reactor -> reactors.add((Reactor) reactor));
            } else {
                System.out.println("File not found: " + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reactors;
    }

    @Override
    public DefaultMutableTreeNode buildTree() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
