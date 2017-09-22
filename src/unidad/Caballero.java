package unidad;

/**
 * Constructor de la unidad Caballero

 * 
 * Esta unidad no puede realizar mas de tres ataque seguidos
 * Necesita tomar pocion para volver a atacar
 * 

 */
public class Caballero extends Unidad implements BebenPoción {
	private static final int DISTANCIA_CABALLERO_MIN = 1;
	private static final int DISTANCIA_CABALLERO_MAX = 2;
	int contadorAtaques;

	public Caballero() {
		super(200, 50, DISTANCIA_CABALLERO_MIN, DISTANCIA_CABALLERO_MAX, new Vector2());
	}

	public Caballero(Vector2 pos) {
		super(200, 50, DISTANCIA_CABALLERO_MIN, DISTANCIA_CABALLERO_MAX, pos);
	}

	@Override
	boolean puedoAtacar(Unidad objetivo) {
		if (estaEnRango(objetivo) && contadorAtaques < 3) {
			contadorAtaques++;
			return true;
		}
		return false;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see unidad.Unidad#mostrarStats()
	 */
	@Override
	public void mostrarStats() {
		System.out.println("Caballero:");
		System.out.println("---------------");
		super.mostrarStats();
		System.out.println("Ataques realizados: " + this.contadorAtaques);
		System.out.println("---------------");
	}

	/**
	 * Reinicia el contador de ataques (non-Javadoc)
	 * 
	 * @see unidad.BebenPoción#beberPoción()
	 */
	@Override
	public void beberPoción() {
		this.contadorAtaques = 0;
	}

}