package unidad;

import java.util.List;
import item.Item;

// CLASE PADRE DE LAS UNIDADES
public abstract class Unidad {
	protected int da�o;
	protected int salud;
	protected int energia;
	protected int defensa;
	protected int posicion;
	protected List<Item> objetos;

	abstract void atacarA(Unidad esa);

	boolean equiparCon(Item item) {
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

	void actualizarStat(Item item) {

		switch (item.getName()) {
		case "capa":
			this.energia *= 2;
			this.da�o *= 0.9;
			break;
		case "pu�al":
			this.defensa -= 3;
			this.da�o += 3;
			break;
		// EN EL CASO DE ESCUDOS SE AUMENTA LA DEFENSA EN LOS ATAQUES
		}
	}
}
