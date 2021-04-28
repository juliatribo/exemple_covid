package edu.upc.dsa.Classes;
import java.util.Date;

public class Muestra {
    public Muestra(){
    }

    private String id;
    private String idClinico;
    private String nombrePersona;
    private Date fecha;
    private String idLab;
    private Informe informe = null;

    public Muestra(String id, String idClinico, String nombrePersona, Date fecha, String idLab){
        this.idClinico = idClinico;
        this.nombrePersona = nombrePersona;
        this.fecha = fecha;
        this.idLab = idLab;
        this.id = id;
    }



    public String getIdClinico() {
        return idClinico;
    }

    public void setIdClinico(String idClinico) {
        this.idClinico = idClinico;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public String toString() {
        return "Muestra [id= "+ id+"idClinico= "+idClinico+"idPersona= "+ nombrePersona +"fecha= "+fecha+"idLab= "+idLab+ "informe = "+informe+ "]";
    }

}
