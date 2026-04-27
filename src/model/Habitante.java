/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author RJMV
 */
public class Habitante {
    private int id;
    private String nombre;
    private int edad;
    private String sexo;
    private int vivienda_id;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public int getVivienda_id() { return vivienda_id; }
    public void setVivienda_id(int vivienda_id) { this.vivienda_id = vivienda_id; }
}
