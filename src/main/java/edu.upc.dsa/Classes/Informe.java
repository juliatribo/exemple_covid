package edu.upc.dsa.Classes;


public class Informe {

    public Informe(){
    }

    private boolean positivo;
    private String comentario;

    public Informe(boolean positivo, String comentario){
        this.positivo = positivo;
        this.comentario = comentario;
    }


    public boolean isPositivo() {
        return positivo;
    }

    public void setPositivo(boolean positivo) {
        this.positivo = positivo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String toString() {
        return "Informe [positivo= "+ positivo+"comentario= "+comentario+"]";
    }
}
