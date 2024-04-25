/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlerAndManager;

import reactor.ReactorStorage;

/**
 *
 * @author annamutovkina
 */
public abstract class Handler {
    protected ReactorStorage storage = ReactorStorage.INSTANCE;
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }
    public abstract void handleRequest(String path);
}
