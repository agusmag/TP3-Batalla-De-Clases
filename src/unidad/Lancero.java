package unidad;

public class Lancero extends Unidad{

	public Lancero(){
		super.daño = 25;
		super.salud = 150;
		super.energia = 0;
		super.defensa = 0;
		super.posicion = 3;	
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
	}
	
}
