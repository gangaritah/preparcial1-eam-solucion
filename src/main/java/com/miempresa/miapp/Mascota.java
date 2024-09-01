package main.java.com.miempresa.miapp;

public class Mascota {
	
	private String nombre;
    private String tipo;
    private int edad;

    public Mascota(String nombre, String tipo, int edad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEdad() {
        return edad;
    }

}
