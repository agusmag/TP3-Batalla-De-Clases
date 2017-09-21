package unidad;

public class Soldado extends Unidad implements BebenPosion{
 	
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
	public void mostrarStats() {
		super.mostrarStatsBasicos();
		System.out.println("Mi vida energia actual es: " + this.energia);
	}

	@Override
	public void beberPosion() {
		this.energia = 100;
	}


	@Override
	public boolean puedoAtacar(Unidad atacado) {
		// TODO Auto-generated method stub
		return false;
	}

}