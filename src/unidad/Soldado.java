package unidad;

import item.Item;

public class Soldado extends Unidad {
	private int energia;
	
	public Soldado(){
		super.daño = 10;
		super.defensa = 0;
		super.salud = 200;
		super.distancia = 0;
		this.energia = 100;
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