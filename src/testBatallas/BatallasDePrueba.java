package testBatallas;

import org.junit.Test;

import item.Item;
import unidad.Arquero;
import unidad.Caballero;
import unidad.Lancero;
import unidad.Soldado;
import unidad.Unidad;
import unidad.Vector2;

public class BatallasDePrueba
{

	@Test
	public void generarClase()
	{ 	// Este test comprueba que las diferentes clases esten bien instanciadas
		// (Se comprueba Herencia).
		Unidad soldier = new Soldado(new Vector2(0,2));		//soldado repocicionado
		Unidad lancer = new Lancero();
		

		soldier.mostrarStats();
		System.out.println();
		
		
		//soldier.equiparCon("Escudo");		//equipar escudo
		lancer.atacarA(soldier);				//ataque realizado
		soldier.mostrarStats();
		


		
		
		
		/*
		Unidad archer = new Arquero();
		Unidad knight = new Caballero();
		
		archer.mostrarStats();		
		knight.mostrarStats();*/
		

	}

}
