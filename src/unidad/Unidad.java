package unidad;

import java.util.List;
import item.Item;

// CLASE PADRE DE LAS UNIDADES
public abstract class Unidad {
	protected int daño;
	protected int salud;
	protected int energia;
	protected int defensa;
	protected int posicion;
	protected List<Item> objetos;

	public abstract void atacarA(Unidad esa);
	public abstract void mostrarStats();

	protected boolean equiparCon(Item item) {
		if (objetos.size() < 3) {
			for (Item itemEqui : objetos) {
				if (itemEqui.getName() == item.getName())
					return false;
			}
			objetos.add(item);
			actualizarStat(item);
			return true;
		}
		return false;
	}

	protected void actualizarStat(Item item) {

		switch (item.getName()) {
		case "capa":
			this.energia *= 2;
			this.daño *= 0.9;
			break;
		case "puñal":
			this.defensa -= 3;
			this.daño += 3;
			break;
		// EN EL CASO DE ESCUDOS SE AUMENTA LA DEFENSA EN LOS ATAQUES
		}
	}
	
	protected boolean infomarEstado(Unidad esa){ //Informa si la Unidad esta viva o muerta.
		if (esa.salud == 0){
			return false;
		}
		
		return true;
	}
}
