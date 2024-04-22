/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an_mutya.lab3;

/**
 *
 * @author annamutovkina
 */
public class JSONhandler extends Handler{

    @Override
    public void handleRequest(String path) {
        if(path.endsWith(".json")){
            yaml.readFile(path);
        }
        else{
            next.handleRequest(path);
        }
    }
    
}
