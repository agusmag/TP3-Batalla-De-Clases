package item;

/**
 * Aumenta 3 puntos de ataque, pero reduce 3 ps de defensa
 */

public class Puñal extends Item {

	public Puñal() {
		super.tipo = "Puñal";
	}

	@Override
	public void descripcion() {
		System.out.println("+3 Daño \n -3 Defensa");
	}

}
