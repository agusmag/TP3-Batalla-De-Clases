package item;

/**
 * Aumenta en 3 los puntos de ataque, pero reduce en 3 los puntos de defensa.
 */

public class Pu�al extends Item {

	public Pu�al() {
		super.tipo = "Pu�al";
	}

	@Override
	public void descripcion() {
		System.out.println("+3 Da�o \n -3 Defensa");
	}

}
