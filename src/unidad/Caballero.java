package unidad;

public class Caballero extends Unidad implements BebenPosion{
	private static int DISTANCIA_CABALLERO_MIN = 1;
	private static int DISTANCIA_CABALLERO_MAX = 2;
	
	private int numAtaques;
	
	public Caballero(){
		super.daño = 50;
		super.salud = 200;
		super.energia = 0;
		super.defensa = 0;
		super.posicion = 2;
		this.numAtaques = 0;
	}

	
	@Override
	public void mostrarStats() {
	
		super.mostrarStatsBasicos();
		System.out.println("Mi numero de ataques realizados es: " + this.numAtaques);
	}

	@Override
	public void beberPosion() {
		this.numAtaques = 0;
	}


	@Override
	public boolean puedoAtacar(Unidad atacado) {
		// TODO Auto-generated method stub
		return false;
	}
			
}