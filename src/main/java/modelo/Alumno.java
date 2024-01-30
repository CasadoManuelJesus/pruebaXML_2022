package modelo;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private String apellido;
    private int edad;
    private float notaMedia;

    public Alumno(){}
    public Alumno(String nombre, String apellido, int edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public int getEdad(){
        return this.edad;
    }
    public float getNotaMedia(){
        return this.notaMedia;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public void setEdad(int edad){
        this.edad=edad;
    }

    public void calculaNotaMedia(ArrayList<Integer> notas){
        int sumaNota = 0;
        for (int nota:
             notas) {
            sumaNota+=nota;
        }
        this.notaMedia= (float) sumaNota /notas.size();
    }



}
