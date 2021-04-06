package com.example.appclientes.Conexion;

public class ConexionCAD
{
    private static final String URL="http://IP serviodor:80/PhpAPPClientes/";
    public String cogerUsuario(){
        return URL+"sacar_usuario.php?id=";
    }
    public String actualizarUsuario(){
        return URL+"actualizar_usuario.php";
    }
    public String insertarUsuario(){
        return URL+"insertar.php";
    }
    public String mostarDatosPerfil(){
        return URL+"datosPerfil.php";
    }
    public String insertarFichajes(){
        return URL+"insertarPartesHoras.php";
    }
    public String mostrarFichajes(){
        return URL+"mostarFichajes.php";
    }
    public String insertarPartesHoras(){
        return URL+"insertarFichajes.php";
    }
    public String mostarPartesHoras(){
        return URL+"mostrarPartesHoras.php";
    }
    public String insertarProyecto(){
        return URL+"insertarProyecto.php";
    }
    public String mostrarProyecto(){
        return URL+"mostarProyecto.php";
    }
    public String mostarVentas(){
        return URL+"mostarVentas.php";
    }
    public String mostarCompras(){
        return URL+"mostarCompras.php";
    }

}
