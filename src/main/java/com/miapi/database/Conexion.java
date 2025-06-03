package com.miapi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/DB_arboles", "root", "130808");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }
}
