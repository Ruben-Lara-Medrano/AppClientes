package com.example.appclientes.Pojos;

public class Compañia {
    private String NombreCompañia;
    private int numeroEmplados;
    private String email;
    private String Telefono;
    private String UID;

    public Compañia() {
    }

    public Compañia(String nombreCompañia, int numeroEmplados, String email, String telefono, String UID) {
        NombreCompañia = nombreCompañia;
        this.numeroEmplados = numeroEmplados;
        this.email = email;
        Telefono = telefono;
        this.UID = UID;
    }

    public String getNombreCompañia() {
        return NombreCompañia;
    }

    public void setNombreCompañia(String nombreCompañia) {
        NombreCompañia = nombreCompañia;
    }

    public int getNumeroEmplados() {
        return numeroEmplados;
    }

    public void setNumeroEmplados(int numeroEmplados) {
        this.numeroEmplados = numeroEmplados;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
