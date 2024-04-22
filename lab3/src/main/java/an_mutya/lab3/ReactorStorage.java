/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an_mutya.lab3;

import java.util.ArrayList;

/**
 *
 * @author annamutovkina
 */
public class ReactorStorage {
    private String source;
    private ArrayList<Reactor> reactors = new ArrayList<>();

    public String getSource() {
        return source;
    }
    public ArrayList<Reactor> getReactors() {
        return reactors;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setReactors(ArrayList<Reactor> reactors) {
        this.reactors = reactors;
    }
}
