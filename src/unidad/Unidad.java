package unidad;

import java.util.ArrayList;
import java.util.List;
import item.Item;

/**
*CLASE PADRE DE LAS UNIDADES
*
*/
public abstract class Unidad {
	int salud, daño, defensa, energia;
	int distanciaAtaqueMax, distanciaAtaqueMin;
	Vector2 pos;
	protected List<Item> objetos;

	abstract boolean puedoAtacar(Unidad objetivo);

	/**
	 * Constructos de unidades
	 * Todas las unidades comienzan con defensa 0
	 * 
	 * @param salud Salud de la unidad
	 * @param daño Daño que puede efectuar
	 * @param distanciaAtaqueMin distancia de ataque efectivo minimo
	 * @param distanciaAtaqueMax distancia de ataque efectivo maximo
	 * @param pos posicion del la unidad [x,y]
	 */
	public Unidad(int salud, int daño, int distanciaAtaqueMin, int distanciaAtaqueMax, Vector2 pos) {
		objetos = new ArrayList<Item>();
		this.salud = salud;
		this.daño = daño;
		this.distanciaAtaqueMax = distanciaAtaqueMax;
		this.distanciaAtaqueMin = distanciaAtaqueMin;
		this.pos = pos;
		this.defensa = 0;
	}

	/*
	 * Método de testeo.
	 * Muestra los stats de la unidad.
	 */
	
	public void mostrarStats() {
		System.out.println("Daño: " + this.daño);
		System.out.println("Salud: " + this.salud);
		System.out.println("Defensa: " + this.defensa);
	}
	/**
	 * Equipamiento de item, se impide que tenga dos item del mismo tipo
	 * @param item 		tipo de item a aceptar[capa, puñal, escudo]
	 * @return Retorna True si se logró equipar correctamente
	 */
	public boolean equiparCon(Item item) {
		if (objetos.size() < 3) {
			for (Item itemEqui : objetos) // comprobar si ya lo tenia equipado
			{
				if (itemEqui.getTipo() == item.getTipo())
					return false;
			}
			objetos.add(item);
			actualizarStat(item);
			return true;
		}
		return false;
	}

	/**
	 * Modifica el estado de la unidad dependiendo de los item que posee.
	 */
	protected void actualizarStat(Item item) {
		switch (item.getTipo()) {
		case "Capa":
			this.energia *= 2;
			this.daño *= 0.9;
			break;
		case "Puñal":
			this.defensa -= 3;
			this.daño += 3;
			break;
		case "escudo":
			this.defensa = 40;
			break;
		}
	}

	/**
	 * Informa si la unidad está muerta.
	 * @return Retorna TRUE si la unidad está muerta
	 */
	public boolean muerta() {
		return this.salud == 0;
	}

	/**
	 * Mueve a la unidad a una determinada posición.
	 * @param pos posición a la cual se moverá la unidad.
	 */
	public void moverA(Vector2 pos) {
		this.pos = pos;
	}
	/**
	 * Se comprueba si está dentro del alcance permitido para atacar.
	 */
	protected boolean estaEnRango(Unidad objetivo) {
		double dist = this.pos.distancia(objetivo.pos);
		return dist >= distanciaAtaqueMin && dist <= distanciaAtaqueMax;
	}

	/**
	 * Se evalua primero si puede realizar una ataque, si el enemigo no está muerto
	 * y que el enemigo no sea él mismo. Si todo lo anterior se cumple procede a
	 * realizar un ataque.
	 * 
	 * @param objetivo unidad que será afectada por los ataques
	 */
	public final void atacarA(Unidad objetivo) {
		if (puedoAtacar(objetivo) && objetivo.muerta() == false && !objetivo.equals(this))
			this.dañar(objetivo);
	}

	/**
	 * Ejecuta el artaque, reduce el ataque en 40% si el enemigo posee escudo
	 * Se evita tambien tener vida negativa
	 * @param objetivo
	 */
	private void dañar(Unidad objetivo) {
		int dañoRecib = (objetivo.tieneItem( "Escudo")) ? (this.daño * objetivo.defensa / 100) : this.daño;
		if (objetivo.tieneItem( "Puñal"))
			dañoRecib += 3;
		objetivo.salud -= dañoRecib;
		if (objetivo.salud < 0) 
			objetivo.salud = 0;
	}

	
	/**
	 * Comprueba la exixtencia de un Item en concreto.
	 * @param item
	 * @return
	 */
	private boolean tieneItem(String item) {
		for (Item itemEqui : objetos) 
		{
			if (itemEqui.getTipo() == item)
				return true;
		}
		return false;
	}

	// -----------------------------------------------------------------------------
	// Métodos de uso secundario
	// -----------------------------------------------------------------------------
	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}

	protected Vector2 getPos() {
		return this.pos;
	}

	public int getDaño() {
		return this.daño;
	}
}
