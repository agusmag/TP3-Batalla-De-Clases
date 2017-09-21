package unidad;

import java.util.List;
import item.Item;

// CLASE PADRE DE LAS UNIDADES
public abstract class Unidad {
	protected int daño;
	protected int salud;
	protected int defensa;

	protected int energia;
	protected int posicion;
	protected List<Item> objetos;

	public abstract boolean puedoAtacar(Unidad atacado);
	public abstract void mostrarStats();

	protected Unidad (){
		
	}
	
	protected boolean equiparCon(Item item) {
		if (objetos.size() < 3) {
			for (Item itemEqui : objetos) {
				if (itemEqui.getName() == item.getName())
					return false;
			}
			objetos.add(item);
			actualizarStat(item);
			return true;
		}
		return false;
	}

	protected void actualizarStat(Item item) {

		switch (item.getName()) {
		case "capa":
			this.energia *= 2;
			this.daño *= 0.9;
			break;
		case "puñal":
			this.defensa -= 3;
			this.daño += 3;
			break;
		// EN EL CASO DE ESCUDOS SE AUMENTA LA DEFENSA EN LOS ATAQUES
		}
	}
	
	protected boolean infomarEstado(Unidad esa){ //Informa si la Unidad esta viva o muerta.
		if (esa.salud == 0){
			return false;
		}
		
		return true;
	}
	
	protected void moverA(int pos){
		this.posicion = pos;
	}
	
	protected void mostrarStatsBasicos(){
		System.out.println("Mi vida daño actual es: " + this.daño);
		System.out.println("Mi vida salud actual es: " + this.salud);
		System.out.println("Mi vida defensa actual es: " + this.defensa);
	}
	
	protected boolean estarEnRango(){
		
	}
	
	protected int getPosicion(){
		return this.posicion;
	}
	
	protected int getDaño(){
		return this.daño;
	}
	
	protected void atacarA(Unidad esa){
		if(this.puedoAtacar(esa)){
			
		}
	}
}
