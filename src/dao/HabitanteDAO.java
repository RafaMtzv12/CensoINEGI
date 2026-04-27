/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author RJMV
 */

import java.sql.*;
import model.Habitante;

public class HabitanteDAO {
     public void insertar(Habitante h) {
        try {
            Connection conn = Conexion.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO habitante(nombre, edad, sexo, vivienda_id) VALUES(?,?,?,?)"
            );

            ps.setString(1, h.getNombre());
            ps.setInt(2, h.getEdad());
            ps.setString(3, h.getSexo());
            ps.setInt(4, h.getVivienda_id());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void contarPorVivienda() {
        try {
           Connection conn = Conexion.getConnection();
           Statement stmt = conn.createStatement();

           ResultSet rs = stmt.executeQuery(
               "SELECT v.tipo, COUNT(h.id) as total " +
               "FROM vivienda v " +
               "LEFT JOIN habitante h ON v.id = h.vivienda_id " +
               "GROUP BY v.tipo"
           );

           while (rs.next()) {
               System.out.println(
                   rs.getString("tipo") + " → " +
                   rs.getInt("total") + " habitantes"
               );
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
