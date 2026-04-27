package dao;

import java.sql.*;
import model.Vivienda;

public class ViviendaDAO {

    public int insertar(Vivienda v) {
        int idGenerado = 0;

        try {
            Connection conn = Conexion.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO vivienda(tipo_id, municipio_id, localidad_id) VALUES(?,?,?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, v.getTipoId());
            ps.setInt(2, v.getMunicipioId());
            ps.setInt(3, v.getLocalidadId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return idGenerado;
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