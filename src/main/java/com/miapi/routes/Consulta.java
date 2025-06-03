package com.miapi.routes;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.miapi.database.Conexion;

import java.sql.*;
import java.util.*;

public class Consulta {

    public static void configurarRutas() {
        get("/consulta1", (req, res) -> {
            Connection conn = Conexion.conectar();
            List<Map<String, Object>> resultados = new ArrayList<>();
            String sql = "SELECT ep.idEspecie, ep.nombre, ta.nombre_comun AS tipo_arbol " +
                    "FROM EspecieProtegida ep " +
                    "JOIN Arbol a ON a.especie = ep.nombre " +
                    "JOIN TipoArbol ta ON ta.idTipo = a.tipo_id";

            try (PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> fila = new HashMap<>();
                    fila.put("idEspecie", rs.getInt("idEspecie"));
                    fila.put("nombre", rs.getString("nombre"));
                    fila.put("tipo_arbol", rs.getString("tipo_arbol"));
                    resultados.add(fila);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            res.type("application/json");
            return new Gson().toJson(resultados);
        });
    }
}
