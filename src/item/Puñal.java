package item;

/**
 * Aumenta 3 puntos de ataque, pero reduce 3 ps de defensa
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
