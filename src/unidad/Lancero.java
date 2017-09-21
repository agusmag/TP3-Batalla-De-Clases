package unidad;

public class Lancero extends Unidad{
	private static int DISTANCIA_LANCERO_MIN = 1;
	private static int DISTANCIA_LANCERO_MAX = 3;
	public Lancero(){
		super.daño = 25;
		super.salud = 150;
		super.energia = 0;
		super.defensa = 0;
		super.posicion = 3;	
	}
	

	@Override
	public void mostrarStats() {
		super.mostrarStatsBasicos();
	}


	@Override
	public boolean puedoAtacar(Unidad atacado) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
