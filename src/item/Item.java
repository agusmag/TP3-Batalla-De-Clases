package item;

import unidad.Punto;
import unidad.Unidad;

/**
 * Clase padre de los item
 */
public abstract class Item extends Unidad
{
	protected Unidad unidad;
	
	String tipo;

	abstract void descripcion();
	
	public Item (Unidad unidad)
	{
		this.unidad = unidad;
	}
	
	public boolean puedoAtacar(Unidad objetivo)
	{
		return this.unidad.puedoAtacar(objetivo);
	}
	/*public String getTipo() 
	{
		return this.tipo;
	}

	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}*/

	public int getSalud() 
	{
		return this.unidad.getSalud();
	}
	
	public void setSalud(int salud) 
	{
		this.unidad.setSalud(salud);
	}

	public int getDefensa() 
	{
		return this.unidad.getDefensa();
	}

	public void setDefensa(int defensa) 
	{
		this.unidad.setDefensa(defensa);;
	}

	public int getEnergia() 
	{
		return this.unidad.getEnergia();
	}

	public void setEnergia(int energia) 
	{
		this.unidad.setEnergia(energia);;
	}

	public void setPos(Punto pos) 
	{
		this.unidad.setPos(pos);;
	}

	public Punto getPos() 
	{
		return this.unidad.getPos();
	}

	public int getDaño() 
	{
		return this.unidad.getDaño();
	}
	
}
