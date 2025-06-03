package com.miapi;

import static spark.Spark.*;
import com.miapi.routes.Consulta;

public class App {
    public static void main(String[] args) {
        port(4567); // Puerto de Spark
        Consulta.configurarRutas(); // Cargar las rutas
        System.out.println("Servidor escuchando en el puerto 4567");
    }
}
