package unidad;

public class Soldado extends Unidad {
	private int energia;

	public Soldado() {
		super.daño = 10;
		super.salud = 200;
		this.energia = 100;
		super.defensa = 0;
		super.posicion = 0;
		// Falta inicializar el vector con 3 posiciones.
	}

	@Override
	public void atacarA(Unidad esa) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarStats() {
		System.out.println("Mi vida daño actual es: " + this.daño);
		System.out.println("Mi vida salud actual es: " + this.salud);
		System.out.println("Mi vida energia actual es: " + this.energia);
		System.out.println("Mi vida defensa actual es: " + this.defensa); // Podria sacarse REVISAR
	}

}