package testBatallas;

import org.junit.Test;

import unidad.Arquero;
import unidad.Caballero;
import unidad.Lancero;
import unidad.Soldado;
import unidad.Unidad;

public class BatallasDePrueba {

	@Test
	public void generarClase(){ //Este test comprueba que las diferentes clases esten bien instanciadas (Se comprueba Herencia).
		Unidad soldier = new Soldado();
		Unidad archer = new Arquero();
		Unidad lancer = new Lancero();
		Unidad knight = new Caballero();
		
		soldier.mostrarStats();
		archer.mostrarStats();
		lancer.mostrarStats();
		knight.mostrarStats();
		
	}
	
}
