package unidad;

import item.Item;

public class Arquero extends Unidad{
	private static int DISTANCIA_ARQUERO;
	
	private int flechas;
	
	
	public Arquero(){
		super.daño = 5;
		super.defensa = 0;
		super.salud = 50;
		super.posicion = 5;
		this.flechas = 20;
		//Falta inicializar el vector con 3 posiciones.
	}
	
	@Override
	
	
	protected void atacarA(Unidad esa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean equiparCon(Item objeto) {
		// TODO Auto-generated method stub
		
	}
	
}