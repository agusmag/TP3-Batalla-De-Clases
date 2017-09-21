package unidad;

import item.Item;

public class Lancero extends Unidad{

	public Lancero(){
		super.daño = 25;
		super.defensa = 0;
		super.salud = 150;
		super.distancia = 3;	
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
