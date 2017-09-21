package unidad;

public class Arquero extends Unidad{
	private static int DISTANCIA_ARQUERO;
	
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
	
	
	public void atacarA(Unidad esa) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mostrarStats() {
		System.out.println("Mi vida daño actual es: " + this.daño);
		System.out.println("Mi vida salud actual es: " + this.salud);
		System.out.println("Mi vida defensa actual es: " + this.defensa); // Podria sacarse REVISAR
		System.out.println("Mi cantidad de flechas actual es: " + this.flechas);
	}

	
}