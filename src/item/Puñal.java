package item;

/**
 * Aumenta en 3 los puntos de ataque, pero reduce en 3 los puntos de defensa.
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
