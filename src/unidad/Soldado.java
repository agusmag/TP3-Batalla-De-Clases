package unidad;

/**
*
* Limitaci�n de ataque -ENERGIA. 
* Realizar un ataque consume 10 puntos de energia.
*/

public class Soldado extends Unidad implements BebenPoci�n {
	private final static int DISTANCIA_LANCERO_MIN = 0;
	private final static int DISTANCIA_LANCERO_MAX = 1;
	private static final int SALUD= 200;
	private static final int DA�O=10;
	private static final int ENERGIAMAX=100;
	
	public Soldado() {
		super(SALUD, DA�O, DISTANCIA_LANCERO_MIN, DISTANCIA_LANCERO_MAX, new Punto());
		this.energia = ENERGIAMAX;
	}

	public Soldado(Punto pos) {
		super(SALUD, DA�O, DISTANCIA_LANCERO_MIN, DISTANCIA_LANCERO_MAX, pos);
		this.energia = ENERGIAMAX;
	}

	@Override
	public void mostrarStats() {
		System.out.println("Soldado:");
		System.out.println("---------------");
		super.mostrarStats();
		System.out.println("Energ�a: " + this.energia);
		System.out.println("---------------");
	}

	@Override
	public void beberPoci�n() {
		this.energia = ENERGIAMAX;
	}

	@Override
	public boolean puedoAtacar(Unidad objetivo) {
		if (estaEnRango(objetivo) && this.energia >= 10) {
			this.energia -= 10;
			return true;
		}
		return false;
	}

}