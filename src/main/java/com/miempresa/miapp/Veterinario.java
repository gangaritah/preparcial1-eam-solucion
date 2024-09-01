package main.java.com.miempresa.miapp;

import java.util.ArrayList;
import java.util.List;

public class Veterinario {
	private List<Mascota> mascotas;

    public Veterinario() {
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public List<Mascota> obtenerMascotas() {
        return mascotas;
    }

    public Mascota buscarMascotaPorNombre(String nombre) {
        for (int i = 0; i < mascotas.size(); i++) {
            Mascota mascota = mascotas.get(i);
            if (mascota.getNombre().equalsIgnoreCase(nombre)) {
                return mascota;
            }
        }
        return null;
    }
}
