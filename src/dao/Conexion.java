package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 

public class Conexion {

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:censo.db");
                System.out.println("Conectado a la BD");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    
    public static void crearTablas() {
    try {
        Connection conn = getConnection();

        Statement stmt = conn.createStatement();
        String sqlTipo = "CREATE TABLE IF NOT EXISTS tipo_vivienda ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "nombre TEXT"
        + ");";

        stmt.execute(sqlTipo);
        
        stmt.executeUpdate("INSERT INTO tipo_vivienda(nombre) SELECT 'Concreto' WHERE NOT EXISTS (SELECT 1 FROM tipo_vivienda WHERE nombre='Concreto')");
        stmt.executeUpdate("INSERT INTO tipo_vivienda(nombre) SELECT 'Adobe' WHERE NOT EXISTS (SELECT 1 FROM tipo_vivienda WHERE nombre='Adobe')");
        stmt.executeUpdate("INSERT INTO tipo_vivienda(nombre) SELECT 'Ladrillo' WHERE NOT EXISTS (SELECT 1 FROM tipo_vivienda WHERE nombre='Ladrillo')");
        stmt.executeUpdate("INSERT INTO tipo_vivienda(nombre) SELECT 'Madera' WHERE NOT EXISTS (SELECT 1 FROM tipo_vivienda WHERE nombre='Madera')");
        stmt.executeUpdate("INSERT INTO tipo_vivienda(nombre) SELECT 'Cartón' WHERE NOT EXISTS (SELECT 1 FROM tipo_vivienda WHERE nombre='Cartón')");
        
        String sqlMunicipio = "CREATE TABLE IF NOT EXISTS municipio ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "nombre TEXT"
        + ");";

        stmt.execute(sqlMunicipio);
        
        String sqlLocalidad = "CREATE TABLE IF NOT EXISTS localidad ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "nombre TEXT, "
        + "municipio_id INTEGER, "
        + "FOREIGN KEY(municipio_id) REFERENCES municipio(id)"
        + ");";

        stmt.execute(sqlLocalidad);
        
        stmt.executeUpdate("INSERT INTO municipio(nombre) SELECT 'Saltillo' WHERE NOT EXISTS (SELECT 1 FROM municipio WHERE nombre='Saltillo')");
        stmt.executeUpdate("INSERT INTO municipio(nombre) SELECT 'Torreón' WHERE NOT EXISTS (SELECT 1 FROM municipio WHERE nombre='Torreón')");

        stmt.executeUpdate("INSERT INTO localidad(nombre, municipio_id) SELECT 'Centro', 1 WHERE NOT EXISTS (SELECT 1 FROM localidad WHERE nombre='Centro')");
        stmt.executeUpdate("INSERT INTO localidad(nombre, municipio_id) SELECT 'Norte', 2 WHERE NOT EXISTS (SELECT 1 FROM localidad WHERE nombre='Norte')");
        
        String sqlVivienda = "CREATE TABLE IF NOT EXISTS vivienda ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "tipo_id INTEGER, "
                + "municipio_id INTEGER, "
                + "localidad_id INTEGER,"
                + "FOREIGN KEY(tipo_id) REFERENCES tipo_vivienda(id),"
                + "FOREIGN KEY(municipio_id) REFERENCES municipio(id),"
                + "FOREIGN KEY(localidad_id) REFERENCES localidad(id)"
                + ");";

        stmt.execute(sqlVivienda);
        
        String sqlHabitante = "CREATE TABLE IF NOT EXISTS habitante ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "nombre TEXT, "
        + "edad INTEGER, "
        + "sexo TEXT, "
        + "vivienda_id INTEGER, "
        + "FOREIGN KEY(vivienda_id) REFERENCES vivienda(id)"
        + ");";

        stmt.execute(sqlHabitante);
        
        stmt.execute("CREATE TABLE IF NOT EXISTS actividad ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "nombre TEXT)");

        stmt.execute("CREATE TABLE IF NOT EXISTS vivienda_actividad ("
        + "vivienda_id INTEGER, "
        + "actividad_id INTEGER)");
        
        stmt.executeUpdate("INSERT INTO actividad(nombre) SELECT 'Comercio' WHERE NOT EXISTS (SELECT 1 FROM actividad WHERE nombre='Comercio')");
        stmt.executeUpdate("INSERT INTO actividad(nombre) SELECT 'Agricultura' WHERE NOT EXISTS (SELECT 1 FROM actividad WHERE nombre='Agricultura')");
        stmt.executeUpdate("INSERT INTO actividad(nombre) SELECT 'Servicios' WHERE NOT EXISTS (SELECT 1 FROM actividad WHERE nombre='Servicios')");

            System.out.println("Tabla vivienda creada o ya existente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    
            