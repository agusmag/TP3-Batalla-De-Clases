package item;

/**
 * La unidad que posea este item recibirá solamente el 40 % del daño enemigo.
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
