package unidad;

/**
*   Constructor de la unidad Soldado
* 
* Limitaci�n de ataque -ENERGIA. 
* Realizar un ataque consume 10 ps de energia

*/

public class Soldado extends Unidad implements BebenPoci�n {
	public Soldado() {
		super(200, 10, 0, 1, new Vector2());
		this.energia = 100;
	}

	public Soldado(Vector2 pos) {
		super(200, 10, 0, 1, pos);
		this.energia = 100;
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
		this.energia = 100;
	}

	@Override
	protected boolean puedoAtacar(Unidad objetivo) {
		if (estaEnRango(objetivo) && this.energia >= 10) {
			this.energia -= 10;
			return true;
		}
		return false;
	}

}