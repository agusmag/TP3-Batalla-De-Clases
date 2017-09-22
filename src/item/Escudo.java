package item;

/**
 * La unidad que posea este item recibira solamente el 40 % del daño
 */

public class Escudo extends Item {

	public Escudo() {
		super.tipo = "Escudo";
	}

	@Override
	public void descripcion() {
		System.out.println("+40% Defensa");
	}

}
