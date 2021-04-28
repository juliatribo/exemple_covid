package edu.upc.dsa.Classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Persona {
    public Persona() {
    }

    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private String salud;
    private List<String> muestrasPersona;

    public Persona(String id, String nombre,String apellido,int edad,String salud){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salud = salud;
        muestrasPersona =  new LinkedList<>();

    }

    public void addMuestra(String idMuestra){

        muestrasPersona.add(idMuestra);
    }


    public  String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    public List<String> getMuestrasPersona() {
        return muestrasPersona;
    }

    public void setMuestrasPersona(List<String> muestrasPersona) {
        this.muestrasPersona = muestrasPersona;
    }

    public String toString() {
        return "Persona [id"+id+"nombre= "+nombre+"apellido= "+apellido+"edad= "+edad+"salud= "+salud+  "]";
    }


}
