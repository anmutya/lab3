/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlerAndManager;

import reader.JsonReader;

/**
 *
 * @author annamutovkina
 */
public class JSONhandler extends Handler{
    private JsonReader json = new JsonReader();
    @Override
    public void handleRequest(String path) {
        if(path.endsWith(".json")){
           storage.setReactors("json", json.readFile(path));
        }
        else{
            next.handleRequest(path);
        }
    } 
}
