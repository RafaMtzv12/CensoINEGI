package dao;

import java.sql.*;
import model.Vivienda;

public class ViviendaDAO {

    public void insertar(Vivienda v) {
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO vivienda(tipo_id, municipio_id, localidad_id)"
            );

            ps.setInt(1, v.getTipoId());
            ps.setInt(2, v.getMunicipioId());
            ps.setInt(3, v.getLocalidadId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listar() {
    try {
        Connection conn = Conexion.getConnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM vivienda");

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("tipo") + " | " +
                rs.getString("municipio") + " | " +
                rs.getString("localidad")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    public void limpiarTabla() {
    try {
        Connection conn = Conexion.getConnection();
        Statement stmt = conn.createStatement();

        stmt.executeUpdate("DELETE FROM vivienda");

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}