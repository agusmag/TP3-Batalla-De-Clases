package unidad;

import item.Item;

public class Caballero extends Unidad{
	
	private char Caballo;; // C = Combate , N = No Combate, esto es por si el caballo esta o no dominado.

	public Caballero(){
		super.daño = 50;
		super.defensa = 0;
		super.salud = 200;
		super.distancia = 2;
		this.Caballo = 'C';
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