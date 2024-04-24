/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlerAndManager;

/**
 *
 * @author annamutovkina
 */
public class XMLhandler extends Handler{
    @Override
    public void handleRequest(String path) {
        if(path.endsWith(".xml")){
           storage.setReactors("xml", xml.readFile(path));
        }
        else{
            next.handleRequest(path);
        }
    }
}
