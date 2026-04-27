package main;

import view.LoginView;
import view.ReporteView;
import dao.Conexion;

public class Main {
    public static void main(String[] args) {
        Conexion.getConnection();
        Conexion.crearTablas(); 
        new LoginView().setVisible(true);
    }
}