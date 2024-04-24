/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlerAndManager;

import reader.JsonReader;
import reactor.ReactorStorage;
import reader.XmlReader;
import reader.YamlReader;

/**
 *
 * @author annamutovkina
 */
public abstract class Handler {
    protected YamlReader yaml = new YamlReader();
    protected JsonReader json = new JsonReader();
    protected XmlReader xml = new XmlReader();
    protected ReactorStorage storage = ReactorStorage.INSTANCE;
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }
    public abstract void handleRequest(String path);
}
