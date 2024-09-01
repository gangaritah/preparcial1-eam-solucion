package main.test.com.miempresa.miapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import main.java.com.miempresa.miapp.Mascota;
import main.java.com.miempresa.miapp.ServicioVeterinario;
import main.java.com.miempresa.miapp.Veterinario;

class ServicioTest {
	
	Veterinario mockVterinario;
	ServicioVeterinario servicio;
	
	@BeforeEach
	void antes() {
		mockVterinario = Mockito.mock(Veterinario.class);
		servicio = new ServicioVeterinario(mockVterinario);
	}
	
	@DisplayName("Probando CalcularEdadPromedioMascotas cuando el promedio es diferente de 0")
	@Test
	void testCalcularEdadPromedioMascotasConPromedioDiferente0() {
		ArrayList<Mascota> mascotas = new ArrayList<>();
		mascotas.add(new Mascota("Peep", "perro", 5));
		mascotas.add(new Mascota("Tom", "gato",5));
		
		Mockito.when(mockVterinario.obtenerMascotas()).thenReturn(mascotas);
		double promedio = servicio.calcularEdadPromedioMascotas();
		assertEquals(promedio, 5);
	}
	
	@DisplayName("Probando CalcularEdadPromedioMascotas cuando el promedio es 0")
	@Test
	void testCalcularEdadPromedioMascotasConPromedio0() {
		ArrayList<Mascota> mascotas = new ArrayList<>();
		
		Mockito.when(mockVterinario.obtenerMascotas()).thenReturn(mascotas);
		double promedio = servicio.calcularEdadPromedioMascotas();
		assertEquals(promedio, 0.0);
	}
	
	@DisplayName("Probando EsMascotaRegistrada cuando lanza excepción")
	@Test
	void testEsMascotaRegistradaExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {
			servicio.esMascotaRegistrada(null);
		});
	}
	
	@DisplayName("Probando EsMascotaRegistrada cuando la mascota está registrada")
	@Test
	void testEsMascotaRegistradaTrue() {
		Mascota conocido = new Mascota("Tom", "gato", 7);
		
		Mockito.when(mockVterinario.buscarMascotaPorNombre("Tom")).thenReturn(conocido);
		boolean esRegistrada = servicio.esMascotaRegistrada("Tom");
		assertTrue(esRegistrada);
	}
	
	@DisplayName("Probando EsMascotaRegistrada cuando la mascota no está registrada")
	@Test
	void testEsMascotaRegistradaFalse() {

		Mockito.when(mockVterinario.buscarMascotaPorNombre("Tom")).thenReturn(null);
		boolean esRegistrada = servicio.esMascotaRegistrada("Tom");
		assertFalse(esRegistrada);
	}
	
	@DisplayName("Probando horariosAtencion")
	@Test
	void testHorariosAtencion() {
		String horariosDeAtencion = servicio.horariosAtencion();
		assertNotNull(horariosDeAtencion);
		assertEquals(horariosDeAtencion, "Domingo a domingo 24 horas");
	}
	

}
