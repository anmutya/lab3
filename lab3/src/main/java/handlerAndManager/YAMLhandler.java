/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlerAndManager;


/**
 *
 * @author annamutovkina
 */
public class YAMLhandler extends Handler{

    @Override
    public void handleRequest(String path) {
        if(path.endsWith(".yaml")){
          storage.setReactors("yaml", yaml.readFile(path));
        }
        else{
            next.handleRequest(path);
        }
    }
}
