package unidad;

import java.util.ArrayList;
import java.util.List;
import item.Item;

/**
*CLASE PADRE DE LAS UNIDADES
*
*/
public abstract class Unidad
{
	int salud, da�o, defensa, energia, itemsEquipados;
	int distanciaAtaqueMax, distanciaAtaqueMin;
	Punto pos;
	protected List<Item> objetos;

	public abstract boolean puedoAtacar(Unidad objetivo);

	/**
	 * Constructor vac�o para poder usar Decorator con los items.
	 */
	protected Unidad()
	{
		
	}
	
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
	public Unidad(int salud, int da�o, int distanciaAtaqueMin, int distanciaAtaqueMax, Punto pos) 
	{
		objetos = new ArrayList<Item>();
		this.salud = salud;
		this.da�o = da�o;
		this.distanciaAtaqueMax = distanciaAtaqueMax;
		this.distanciaAtaqueMin = distanciaAtaqueMin;
		this.pos = pos;
		this.defensa = 0;
	}

	/*
	 * M�todo de testeo.
	 * Muestra los stats de la unidad.
	 */
	
	public void mostrarStats() 
	{
		System.out.println("Da�o: " + this.getDa�o());
		System.out.println("Salud: " + this.getSalud());
		System.out.println("Defensa: " + this.getDefensa());
	}

	/**
	 * Informa si la unidad est� muerta.
	 * @return Retorna TRUE si la unidad est� muerta
	 */
	public boolean muerta() {
		return this.salud == 0;
	}

	/**
	 * Mueve a la unidad a una determinada posici�n.
	 * @param pos posici�n a la cual se mover� la unidad.
	 */
	public void moverA(Punto pos) {
		this.pos = pos;
	}
	
	/**
	 * Se comprueba si est� dentro del alcance permitido para atacar.
	 */
	protected boolean estaEnRango(Unidad objetivo) {
		double dist = this.pos.distancia(objetivo.pos);
		return dist >= distanciaAtaqueMin && dist <= distanciaAtaqueMax;
	}

	/**
	 * Se evalua primero si puede realizar una ataque, si el enemigo no est� muerto
	 * y que el enemigo no sea �l mismo. Si todo lo anterior se cumple procede a
	 * realizar un ataque.
	 * 
	 * @param objetivo unidad que ser� afectada por los ataques
	 */
	public final void atacarA(Unidad objetivo) {
		if (puedoAtacar(objetivo) && objetivo.muerta() == false && !objetivo.equals(this))
			this.da�ar(objetivo);
	}

	/**
	 * Ejecuta el ataque, llamando al m�todo serDa�ado del objetivo
	 * @param objetivo
	 */
	private void da�ar(Unidad objetivo) 
	{
		objetivo.serDa�ado(this.getDa�o());
	}

	private void serDa�ado(int da�oRecibido)
	{
		int da�oFinal = da�oRecibido <= this.getDefensa() ? 0 : da�oRecibido - this.getDefensa();
		this.setSalud(this.getSalud() - da�oFinal);
	}
	
	/**
	 * Comprueba la exixtencia de un Item en concreto.
	 * @param idItem n�mero de id del item
	 * @return true si tiene el item equipado
	 */
	public boolean tieneItem(int idItem) 
	{
		return (this.getItemsEquipados() & idItem) != 0;
	}

	// -----------------------------------------------------------------------------
	// M�todos de uso secundario
	// -----------------------------------------------------------------------------
	public int getSalud() {
		return salud;
	}

	/**
	 * Cambia la salud de la Unidad. De ser negativa le asigna un 0.
	 * @param salud n�mero de salud a asignarle a la unidad
	 */
	
	public void setSalud(int salud) {
		this.salud = salud < 0 ? 0 : salud;
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

	public void setPos(Punto pos) {
		this.pos = pos;
	}

	public Punto getPos() {
		return this.pos;
	}

	public int getDa�o() {
		return this.da�o;
	}
	
	public int getItemsEquipados()
	{
		return this.itemsEquipados;
	}
}
