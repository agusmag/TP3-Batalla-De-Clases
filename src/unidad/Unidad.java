package unidad;

import item.Item;

public abstract class Unidad {
	protected int daño;
	protected int salud;
	protected int defensa;
	protected int distancia;
	protected Item[] objetos;
	
	
	abstract void atacarA(Unidad esa);
	abstract void equiparCon(Item objeto);
	
}

