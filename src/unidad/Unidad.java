package unidad;

import java.util.ArrayList;
import java.util.List;
import item.Item;

// CLASE PADRE DE LAS UNIDADES
public abstract class Unidad
{
	int salud, daño, defensa, energia;
	double distanciaAtaqueMax, distanciaAtaqueMin;
	Vector2 pos;
	protected List<Item> objetos;

//	abstract void atacar (Unidad objetivo);
	abstract boolean puedoAtacar (Unidad objetivo);
	
	public void mostrarStats()
	{
		System.out.println("Daño: " + this.daño);
		System.out.println("Salud: " + this.salud);
		System.out.println("Defensa: " + this.defensa);
	}
	
	public Unidad(int salud, int daño, double distanciaAtaqueMin, double distanciaAtaqueMax, Vector2 pos)
	{
		objetos = new ArrayList<Item>();
		this.salud = salud;
		this.daño = daño;
		this.distanciaAtaqueMax = distanciaAtaqueMax;
		this.distanciaAtaqueMin = distanciaAtaqueMin;
		this.pos = pos;

		// defensa no estï¿½ en el constructor ya que todas las unidades empiezan
		// con 0 defensa aparentemente
		// this.defensa = defensa;
	}
	
	public boolean equiparCon(Item item)
	{
		if (objetos.size() < 3)
		{
			for (Item itemEqui : objetos)		//comprobar si ya lo tenia equipado
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

	protected void actualizarStat(Item item)
	{
		switch (item.getTipo())
		{
		case "Capa":
			this.energia *= 2;
			this.daño *= 0.9;
			break;
		case "Puñal":
			this.defensa -= 3;
			this.daño += 3;
			break;
		// EN EL CASO DE ESCUDOS SE AUMENTA LA DEFENSA EN LOS ATAQUES
		case "escudo":
			this.defensa = 40;
			break;
		}
	}

	public boolean muerta ()
	{ // Informa si la Unidad esta viva o muerta.
		return this.salud <= 0;
	}

	public void moverA(Vector2 pos)
	{
		this.pos = pos;
	}

	protected boolean estaEnRango(Unidad objetivo)
	{
		double dist = this.pos.distancia(objetivo.pos);

		return dist >= distanciaAtaqueMin && dist <= distanciaAtaqueMax;
	}

	protected Vector2 getPos()
	{
		return this.pos;
	}

	public int getDaño()
	{
		return this.daño;
	}

	public final void atacarA(Unidad objetivo)
	{
		if (puedoAtacar(objetivo) && objetivo.muerta() == false && !objetivo.equals(this))
			this.dañar(objetivo);
	}
	
	private void dañar (Unidad objetivo)
	{
		int dañoRecib = (objetivo.tieneEscudo()) ? (this.daño*objetivo.defensa/100) : this.daño;
		if (objetivo.salud >= dañoRecib) 	
			objetivo.salud -= dañoRecib;
		if (objetivo.salud <0)				// evita tener vida negativa
			objetivo.salud =0;
			
		//se reduce la cantidad del ataque al 40%
		// si el daño es igual o menor que la defensa directamente no hace nada
		// el if esta porque si pasa eso, va a quedar un daño negativo y le va a subir la vida al objetivo
	}
	private boolean tieneEscudo() {
		for (Item itemEqui : objetos)		//comprobar si ya lo tenia equipado
		{
			if (itemEqui.getTipo() == "Escudo")
				return true;
		}
		return false;
	}
	
	public int getSalud()
	{
		return salud;
	}
	public void setSalud(int salud)
	{
		this.salud = salud;
	}
	public int getDefensa()
	{
		return defensa;
	}
	public void setDefensa(int defensa)
	{
		this.defensa = defensa;
	}
	public int getEnergia()
	{
		return energia;
	}
	public void setEnergia(int energia)
	{
		this.energia = energia;
	}
	public void setPos(Vector2 pos)
	{
		this.pos = pos;
	}
	
}
