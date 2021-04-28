package edu.upc.dsa.Classes;

import java.util.*;

public class Laboratorio{

    private String id;
    private String name;
    private Queue<Muestra> muestraQueue = new LinkedList<>();

    public Laboratorio (){
        this.id = UUID.randomUUID().toString();
    }

    public Laboratorio (String name){
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public void sendMuestra(Muestra muestra){
        muestraQueue.add(muestra);
    }

    public Muestra removeMuestra(){
        return muestraQueue.remove();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue<Muestra> getMuestraQueue() {
        return muestraQueue;
    }

    public void setMuestraQueue(Queue<Muestra> muestraQueue) {
        this.muestraQueue = muestraQueue;
    }
    public String toString() {
        return "Lab [id= "+ id+"name= "+name+"Cola de muestras= "+muestraQueue+"]";
    }



}
