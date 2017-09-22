package unidad;

import java.util.ArrayList;
import java.util.List;
import item.Item;

/**
*CLASE PADRE DE LAS UNIDADES
*
*/
public abstract class Unidad {
	int salud, da�o, defensa, energia;
	int distanciaAtaqueMax, distanciaAtaqueMin;
	Vector2 pos;
	protected List<Item> objetos;

	abstract boolean puedoAtacar(Unidad objetivo);

	/**
	 * Constructos de unidades
	 * Todas las unidades comienzan con defensa 0
	 * 
	 * @param salud Salud de la unidad
	 * @param da�o Da�o que puede efectuar
	 * @param distanciaAtaqueMin distancia de ataque efectivo minimo
	 * @param distanciaAtaqueMax distancia de ataque efectivo maximo
	 * @param pos posicion del la unidad [x,y]
	 */
	public Unidad(int salud, int da�o, int distanciaAtaqueMin, int distanciaAtaqueMax, Vector2 pos) {
		objetos = new ArrayList<Item>();
		this.salud = salud;
		this.da�o = da�o;
		this.distanciaAtaqueMax = distanciaAtaqueMax;
		this.distanciaAtaqueMin = distanciaAtaqueMin;
		this.pos = pos;
		this.defensa = 0;
	}

	public void mostrarStats() {
		System.out.println("Da�o: " + this.da�o);
		System.out.println("Salud: " + this.salud);
		System.out.println("Defensa: " + this.defensa);
	}
/**
 * Equipamiento de item	, se impide que tenga dos item del mismo tipo
 * @param item 		tipo de item a aceptar[capa, pu�al, escudo]
 * @return Retorna True si se logro equipar correctamente
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
	 * Modifica el estado de la unidad dependiendo de los item que poseea
	 */
	protected void actualizarStat(Item item) {
		switch (item.getTipo()) {
		case "Capa":
			this.energia *= 2;
			this.da�o *= 0.9;
			break;
		case "Pu�al":
			this.defensa -= 3;
			this.da�o += 3;
			break;
		case "escudo":
			this.defensa = 40;
			break;
		}
	}

	/**
	 * Informa si la Unidad esta muerta.
	 * @return Retorna TRUE si la unidad esta muerta
	 */
	public boolean muerta() {
		return this.salud == 0;
	}

	public void moverA(Vector2 pos) {
		this.pos = pos;
	}
/**
 * Se comprueba si esta dentro del alcance permitido para atacar
 */
	protected boolean estaEnRango(Unidad objetivo) {
		double dist = this.pos.distancia(objetivo.pos);
		return dist >= distanciaAtaqueMin && dist <= distanciaAtaqueMax;
	}

	/**
	 * Se evalua primero si puede realizar una ataque, si el enemigo no esta muerto
	 * y que el enemigo no sea �l mismo. Si todo lo anterior acurio procede a
	 * realizar un ataque
	 * 
	 * @param objetivo unidad que sera afectada por los ataques
	 */
	public final void atacarA(Unidad objetivo) {
		if (puedoAtacar(objetivo) && objetivo.muerta() == false && !objetivo.equals(this))
			this.da�ar(objetivo);
	}

	/**
	 * Ejecuta el artaque, reduce el ataque en 40% si el enemigo posee escudo
	 * Se evita tambien tener vida negativa
	 * @param objetivo
	 */
	private void da�ar(Unidad objetivo) {
		int da�oRecib = (objetivo.tieneItem( "Escudo")) ? (this.da�o * objetivo.defensa / 100) : this.da�o;
		if (objetivo.tieneItem( "Pu�al"))
			da�oRecib += 3;
		objetivo.salud -= da�oRecib;
		if (objetivo.salud < 0) 
			objetivo.salud = 0;
	}

	
	/**
	 * Coptrueba la exixtencia de un Item en concreto
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
	// Metodos de uso secundario
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

	public int getDa�o() {
		return this.da�o;
	}
}
