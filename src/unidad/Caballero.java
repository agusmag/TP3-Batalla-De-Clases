package unidad;

public class Caballero extends Unidad{
	
	private char caballo; // C = Combate , N = No Combate, esto es por si el caballo esta o no dominado.
	private int numAtaques;
	
	public Caballero(){
		super.daño = 50;
		super.salud = 200;
		super.energia = 0;
		super.defensa = 0;
		super.posicion = 2;
		this.caballo = 'C';
		this.numAtaques = 0;
	}
	
	@Override
	public void atacarA(Unidad esa) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mostrarStats() {
		System.out.println("Mi vida daño actual es: " + this.daño);
		System.out.println("Mi vida salud actual es: " + this.salud);
		System.out.println("El estado de mi caballo es: " + this.caballo + " con " + this.numAtaques + " Ataques Realizados");
		System.out.println("Mi vida defensa actual es: " + this.defensa); // Podria sacarse REVISAR
	}
			
}