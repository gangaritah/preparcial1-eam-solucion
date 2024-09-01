package main.java.com.miempresa.miapp;

public class ServicioVeterinario {
	private Veterinario veterinario;
	private String horariosAtencion;
	
    public ServicioVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
        this.horariosAtencion = "Domingo a domingo 24 horas";
    }

    public double calcularEdadPromedioMascotas() {
    	int totalEdad = 0;
        int numeroDeMascotas = veterinario.obtenerMascotas().size();
        
        for (int i = 0; i < numeroDeMascotas; i++) {
            Mascota mascota = veterinario.obtenerMascotas().get(i);
            totalEdad += mascota.getEdad();
        }
        
        if (numeroDeMascotas > 0) {
            return (double) totalEdad / numeroDeMascotas;
        }
        
        return 0.0;
    }

    public boolean esMascotaRegistrada(String nombre) {
    	if (nombre == null) {
    		throw new IllegalArgumentException("No se admiten nombres nulos");
    	}
        return veterinario.buscarMascotaPorNombre(nombre) != null;
    }

    public void registrarMascota(Mascota mascota) {
        veterinario.agregarMascota(mascota);
    }
    
    public String horariosAtencion( ) {
        return this.horariosAtencion;
    }
    
}
