/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Clase05_Actividad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author aZ3Dx
 */
@SpringBootApplication
@Controller
public class Controlador {
    @GetMapping("/")
    public String inicio(Model model){
        
        var c1 = new Carrera();
        c1.setNombre("Ingeniería Civil");
        c1.setFacultad("Ingeniería");
        var c2 = new Carrera();
        c2.setNombre("Ingeniería de Sistemas Computacionales");
        c2.setFacultad("Ingeniería");
        var c3 = new Carrera();
        c3.setNombre("Ingeniería Industrial");
        c3.setFacultad("Ingeniería");
        var c4 = new Carrera();
        c4.setNombre("Ingeniería Agroindustrial");
        c4.setFacultad("Ingeniería");
        var c5 = new Carrera();
        c5.setNombre("Ingeniería Ambiental");
        c5.setFacultad("Ingeniería");
        var c6 = new Carrera();
        c6.setNombre("Ingeniería de Minas");
        c6.setFacultad("Ingeniería");
        var c7 = new Carrera();
        c7.setNombre("Ingeniería Electrónica");
        c7.setFacultad("Ingeniería");
        var c8 = new Carrera();
        c8.setNombre("Ingeniería en Logística y Transporte");
        c8.setFacultad("Ingeniería");
        var c9 = new Carrera();
        c9.setNombre("Ingeniería Geológica");
        c9.setFacultad("Ingeniería");
        var c10 = new Carrera();
        c10.setNombre("Ingeniería Mecatrónica");
        c10.setFacultad("Ingeniería");
        var c11 = new Carrera();
        c11.setNombre("Ingeniería Empresarial");
        c11.setFacultad("Ingeniería");
        
        var arcarreras = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11);
        
        model.addAttribute("acarreras", arcarreras);
        
        return "index";
    }
    @GetMapping("/ciclos")
    public String ciclos(Carrera carrera, Model model){
        
        byte[] numeros = new byte[]{1,2,3,4,5,6,7,8,9,10};
        
        model.addAttribute("numeros", numeros);
        model.addAttribute("carrer", carrera);
        
        return "ciclos";
    }
    @GetMapping("/cursos")
    public String cursos(Carrera carrera,byte ciclo, Model model){
        
        carrera.nombre = carrera.nombre + Integer.toString(ciclo);
        
        //var acursos = Arrays.asList(c1,c2,c3);   
        BufferedReader bufferLectura = null;
        List<Curso> acursos = new ArrayList<>();
        
        try {
            bufferLectura = new BufferedReader(new FileReader("Carreras.csv"));
            String linea = bufferLectura.readLine();
            
            while(linea != null){
                Curso c = new Curso();
                String[] campos = linea.split(",");
                String cur = "";
                int i;
                for(i = 0; i < campos.length; i++){
                    cur = cur + campos[i];
                    if(campos[i + 1].equals("P") || campos[i + 1].equals("V")){
                        cur = cur.replaceAll("\"", "");
                        break;
                    }else {
                        cur = cur + ",";
                    }
                }
                /**/
                c.nombre = cur;
                c.modalidad = campos[i+1].charAt(0);
                List<String> listcarxci = new ArrayList<>();
                for(i = i + 2; i < campos.length; i++){
                    listcarxci.add(campos[i]);
                }
                c.carxci = listcarxci.toArray(String[]::new);
                acursos.add(c);
                linea = bufferLectura.readLine();
            }
        }
        catch(IOException e){
            e.getMessage();
        }
        finally{
            if(bufferLectura != null){
                try{
                    bufferLectura.close();
                }
                catch(IOException e){
                    e.getMessage();
                }
            }
        }
        
        model.addAttribute("cicl", ciclo);
        model.addAttribute("acur", acursos);
        model.addAttribute("carrer", carrera);
        
        
        return "cursos";
    }
}
