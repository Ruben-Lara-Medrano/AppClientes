package com.example.appclientes.Pojos;

public class Proyecto {
    private String nombreProyecto;
    private String personal;

    public Proyecto() {
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombreProyecto='" + nombreProyecto + '\'' +
                ", personal='" + personal + '\'' +
                '}';
    }
}
