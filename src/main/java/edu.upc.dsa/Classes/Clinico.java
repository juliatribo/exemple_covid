package edu.upc.dsa.Classes;

import java.util.UUID;

public class Clinico {

    private String id;
    private String name;

    public Clinico(){
        this.id = UUID.randomUUID().toString();
    }

    public Clinico(String name){
        this.name = name;
        this.id = UUID.randomUUID().toString();
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
    public String toString() {
        return "Clinico [id= "+ id+"name= "+name+"]";
    }
}