/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Clase05_Actividad;

import lombok.Data;

/**
 *
 * @author aZ3Dx
 */
@Data
public class Curso {
    public String nombre;
    public char modalidad;
    public String[] carxci;
    
    /**/
    Curso(String nombre, char modalidad, String[] carxci) {
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.carxci = carxci;
    }

    Curso() {
        
    }
}
