/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlerAndManager;

import an_mutya.lab3.TreeBuilder;
import javax.swing.tree.DefaultMutableTreeNode;
import reactor.ReactorStorage;
import reader.JsonReader;
import reader.XmlReader;
import reader.YamlReader;

/**
 *
 * @author annamutovkina
 */
public class Manager {
    public void loadFile(String path){
        YAMLhandler yAMLhandler = new YAMLhandler(new YamlReader());
        JSONhandler jSONhandler = new JSONhandler(new JsonReader());
        XMLhandler xMLhandler = new XMLhandler(new XmlReader());
        yAMLhandler.setNext(jSONhandler);
        jSONhandler.setNext(xMLhandler);
        yAMLhandler.handleRequest(path);
        
    }
    public DefaultMutableTreeNode buildTree(){
        TreeBuilder treeBuilder = new TreeBuilder();
        return treeBuilder.buildTreeData();
    }
    public void deleteFiles(){
        ReactorStorage.INSTANCE.clearReactors();
    }
}
