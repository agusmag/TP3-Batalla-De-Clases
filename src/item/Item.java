package item;

import unidad.Punto;
import unidad.Unidad;

/**
 * Clase padre de los items. 
 * Todos los m�todos tienen complejidad computacional O(1).
 */
public abstract class Item extends Unidad
{
	protected Unidad unidad;

	/**
	 * Descripci�n del item.
	 */
	abstract void descripcion();
	
	/**
	 * Constructor que necesita la referencia de la unidad a la que se le equipar� el item.
	 */
	public Item (Unidad unidad)
	{
		this.unidad = unidad;
	}
	
	public boolean puedoAtacar(Unidad objetivo)
	{
		return this.unidad.puedoAtacar(objetivo);
	}
	
	public boolean muerta ()
	{
		return this.unidad.muerta();
	}
	
	/**
	 * Retorna la salud de la unidad que tiene equipado este item.
	 */
	public int getSalud() 
	{
		return this.unidad.getSalud();
	}
	
	/**
	 * Cambia la salud de la unidad que tiene equipado este item.
	 * @param salud n�mero de salud a asignarle a la unidad
	 */
	public void setSalud(int salud) 
	{
		this.unidad.setSalud(salud);
	}

	/**
	 * Retorna la defensa de la unidad que tiene equipado este item.
	 */
	public int getDefensa() 
	{
		return this.unidad.getDefensa();
	}

	/**
	 * Cambia la defensa de la unidad que tiene equipado este item.
	 * @param defensa n�mero de defensa a asignarle a la unidad
	 */
	public void setDefensa(int defensa) 
	{
		this.unidad.setDefensa(defensa);;
	}

	/**
	 * Retorna la energ�a de la unidad que tiene equipado este item.
	 */
	public int getEnergia() 
	{
		return this.unidad.getEnergia();
	}

	/**
	 * Cambia la energ�a de la unidad que tiene equipado este item.
	 * @param energ�a n�mero de energ�a a asignarle a la unidad
	 */
	public void setEnergia(int energia) 
	{
		this.unidad.setEnergia(energia);;
	}

	/**
	 * Retorna la posici�n de la unidad que tiene equipado este item.
	 */
	public Punto getPos() 
	{
		return this.unidad.getPos();
	}
	
	/**
	 * Cambia la posici�n de la unidad que tiene equipado este item.
	 * @param posici�n Punto de la posici�n a la que se mover� la unidad
	 */
	public void moverA(Punto pos) 
	{
		this.unidad.moverA(pos);;
	}

	/**
	 * Retorna el da�o de la unidad que tiene equipado este item.
	 */
	public int getDa�o() 
	{
		return this.unidad.getDa�o();
	}
	
}
