package unidad;

import item.Item;

public class Arquero extends Unidad{
	private int flechas;

	
	public Arquero(){
		super.daño = 5;
		super.defensa = 0;
		super.salud = 50;
		super.distancia = 5;
		this.flechas = 20;
		//Falta inicializar el vector con 3 posiciones.
	}
	
	@Override
	
	
	protected void atacarA(Unidad esa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void equiparCon(Item objeto) {
		// TODO Auto-generated method stub
		
	}
	
}