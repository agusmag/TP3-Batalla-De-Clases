package unidad;

public class Arquero extends Unidad{
	private static int DISTANCIA_ARQUERO_MIN = 2;
	private static int DISTANCIA_ARQUERO_MAX = 5;
	private int flechas;
	
	
	public Arquero(){
		super.daño = 5;
		super.defensa = 0;
		super.salud = 50;
		super.energia = 0;
		super.posicion = 5;
		this.flechas = 20;
		//Falta inicializar el vector con 3 posiciones.
	}
	
	
	@Override
	public void mostrarStats() {
		super.mostrarStatsBasicos();
		System.out.println("Mi cantidad de flechas actual es: " + this.flechas);
	}


	@Override
	public boolean puedoAtacar(Unidad atacado) {
		if(atacado.getPosicion() <= DISTANCIA_ARQUERO_MAX && atacado.getPosicion() >= DISTANCIA_ARQUERO_MIN
				&& this.flechas > 0)
			return true;
		return false;
	}

	
}