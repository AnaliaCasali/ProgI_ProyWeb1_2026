package org.ies63.progi.entities;

public class Empleado {


    private int id;
    private String nombre;
    private String apellido;
    private double salarioBase;

     //CONSTRUCTORES
    public Empleado(){
     }
    public Empleado(String nombre, String apellido, double salarioBase){
         this.nombre=nombre;
        this.apellido=apellido;
        this.salarioBase=salarioBase;
    }

    // ATAJO-> BTN DERECHO -> GENERATE GETTER & SETTER


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }



    public  void mostrarInformacion(){
        System.out.print("Empleado:" + this.id + " - " + this.apellido + " " + this.nombre
                            + "\n Salario: " + this.salarioBase + "\n" );
    }

    public double calcularSalario(){
        return this.salarioBase;
    }
    // los metodos final no pueden ser sobreescritos por las clases hijas
    public final void mostrarMsg(String msg){
        System.out.print("Bienvenido " + this.apellido + " " + this.nombre + " " + msg);
    }

    @Override
    public String toString(){
        return "Empleado:" + this.id + " - " + this.apellido + " " + this.nombre
                + "\n Salario: " + this.salarioBase + "\n" ;
    }


}
