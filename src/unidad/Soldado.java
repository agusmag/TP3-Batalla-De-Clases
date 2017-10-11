package unidad;

/**
*
* 
* Limitación de ataque -ENERGIA. 
* Realizar un ataque consume 10 puntos de energia.

*/

public class Soldado extends Unidad implements BebenPoción {
	public Soldado() {
		super(200, 10, 0, 1, new Punto());
		this.energia = 100;
	}

	public Soldado(Punto pos) {
		super(200, 10, 0, 1, pos);
		this.energia = 100;
	}

	@Override
	public void mostrarStats() {
		System.out.println("Soldado:");
		System.out.println("---------------");
		super.mostrarStats();
		System.out.println("Energía: " + this.energia);
		System.out.println("---------------");
	}

	@Override
	public void beberPoción() {
		this.energia = 100;
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