/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaxml_2022;

import java.util.ArrayList;

import modelo.Alumno;
import modelo.Profesor;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author enrique
 */
public class ProfesorHandlerXML extends DefaultHandler{
    
    private StringBuilder cadena;
    private Profesor profesor;
    private ArrayList<Integer> notas;

    private Alumno alumno;
    private ArrayList<Profesor> profesores;
    private ArrayList<Alumno> alumnos;
   
    //Parte que recoge los objetos creados para ser enviados fuera de la clase
    
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }
    public ArrayList<Alumno> getAlumnos(){
        return this.alumnos;
    }

    //parte que mapea el documento e introduce los datos en objetos
          
    @Override
    public void startDocument() throws SAXException {
        cadena=new StringBuilder();
        profesores=new ArrayList<Profesor>();
        alumnos=new ArrayList<Alumno>();
        System.out.println("startDocument");
    }
    
    @Override
    public void startElement(String uri, String nombreLocal, String nombreCualif, Attributes atrbts) throws SAXException {
        cadena.setLength(0);
        if (nombreCualif.equals("profesor")){
            profesor=new Profesor();
            profesor.setCp(atrbts.getValue("cp"));
            profesor.setDni(atrbts.getValue("dni"));
        } else if (nombreCualif.equals("alumno")){
            notas= new ArrayList<>();
            alumno = new Alumno();
            alumno.setNombre(atrbts.getValue("nombre"));
            alumno.setApellido(atrbts.getValue("apellido"));
            alumno.setEdad(Integer.parseInt(atrbts.getValue("edad")));
        }
         System.out.println("startElement: "+nombreLocal+ " "+nombreCualif);
     }

    @Override
    public void characters(char[] chars, int inicio, int lon) throws SAXException {
        cadena.append(chars, inicio, lon);
        System.out.println("dato final: "+cadena);
    }
    
    @Override
    public void endElement(String uri, String nombreLocal, String nombreCualif) throws SAXException {
        if(nombreCualif.equals("nombre")){
            profesor.setNombre(cadena.toString());
        } else if (nombreCualif.equals("horasLectivas")){
            profesor.setHorasLectivas(Integer.parseInt(cadena.toString()));
        } else if (nombreCualif.equals("mayor55")){
            profesor.setMayor55(Boolean.parseBoolean(cadena.toString()));
        }else if (nombreCualif.equals("profesor")){
            profesores.add(profesor);
        } else if (nombreCualif.equals("notaHLC")){
            notas.add(Integer.parseInt(cadena.toString()));
        }else if (nombreCualif.equals("notaSGE")) {
            notas.add(Integer.parseInt(cadena.toString()));
        } else if (nombreCualif.equals("notaPMSM")) {
            notas.add(Integer.parseInt(cadena.toString()));
        } else if (nombreCualif.equals("notaADAT")) {
            notas.add(Integer.parseInt(cadena.toString()));
        }else if (nombreCualif.equals("notaEIE")) {
            notas.add(Integer.parseInt(cadena.toString()));
        } else if (nombreCualif.equals("notaPSP")) {
            notas.add(Integer.parseInt(cadena.toString()));
        } else if (nombreCualif.equals("notaDI")){
            notas.add(Integer.parseInt(cadena.toString()));
        } else if (nombreCualif.equals("alumno")){
            alumno.calculaNotaMedia(this.notas);
            alumnos.add(alumno);
        }
        System.out.println("endtElement: "+nombreLocal+ " "+nombreCualif);
    }
    
    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");
    }
}
