/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an_mutya.lab3;

/**
 *
 * @author annamutovkina
 */
public class Manager {
    ReactorStorage storage = new ReactorStorage();
    public void readFileXML(String path){
        storage.setReactors(xml.readFile(path));
        storage.setSource("xml");
    }
    public void readFileJSON(String path){
        storage.setReactors(json.readFile(path));
        storage.setSource("json");
    }
}
