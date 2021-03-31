package com.example.appclientes.Pojos;

public class Compañia {
    private String NombreEmpresa;
    private String ID;
    private String correo;
    private String empleados;
    private String proyectos;
    private int numeroEmpleados;
    private String Imagen;

    public Compañia() {

    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        NombreEmpresa = nombreEmpresa;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmpleados() {
        return empleados;
    }

    public void setEmpleados(String empleados) {
        this.empleados = empleados;
    }

    public String getProyectos() {
        return proyectos;
    }

    public void setProyectos(String proyectos) {
        this.proyectos = proyectos;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    @Override
    public String toString() {
        return "Compañia{" +
                "NombreEmpresa='" + NombreEmpresa + '\'' +
                ", ID='" + ID + '\'' +
                ", correo='" + correo + '\'' +
                ", empleados='" + empleados + '\'' +
                ", proyectos='" + proyectos + '\'' +
                ", numeroEmpleados=" + numeroEmpleados +
                ", Imagen='" + Imagen + '\'' +
                '}';
    }
}
