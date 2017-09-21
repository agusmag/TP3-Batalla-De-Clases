package unidad;

import java.util.ArrayList;
import java.util.List;
import item.Item;

// CLASE PADRE DE LAS UNIDADES
public abstract class Unidad
{
	int salud, daño, defensa, energía;
	double distanciaAtaqueMax, distanciaAtaqueMin;
	Vector2 pos;
	protected List<Item> objetos;

	abstract void atacar (Unidad objetivo);
	abstract boolean puedoAtacar (Unidad objetivo);
	public abstract void mostrarStats();

	public Unidad(int salud, int daño, double distanciaAtaqueMin, double distanciaAtaqueMax, Vector2 pos)
	{
		objetos = new ArrayList<Item>();
		this.salud = salud;
		this.daño = daño;
		this.distanciaAtaqueMax = distanciaAtaqueMax;
		this.distanciaAtaqueMin = distanciaAtaqueMin;
		this.pos = pos;

		// defensa no está en el constructor ya que todas las unidades empiezan
		// con 0 defensa aparentemente
		// this.defensa = defensa;
	}

	protected boolean equiparCon(Item item)
	{
		if (objetos.size() < 3)
		{
			for (Item itemEqui : objetos)
			{
				if (itemEqui.getName() == item.getName())
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
		switch (item.getName())
		{
		case "capa":
			this.energía *= 2;
			this.daño *= 0.9;
			break;
		case "puñal":
			this.defensa -= 3;
			this.daño += 3;
			break;
		// EN EL CASO DE ESCUDOS SE AUMENTA LA DEFENSA EN LOS ATAQUES
		}
	}

	protected boolean infomarEstado()
	{ // Informa si la Unidad esta viva o muerta.
		return this.salud <= 0;
	}

	protected void moverA(Vector2 pos)
	{
		this.pos = pos;
	}

	protected void mostrarStatsBásicos()
	{
		System.out.println("Mi daño actual es: " + this.daño);
		System.out.println("Mi salud actual es: " + this.salud);
		System.out.println("Mi defensa actual es: " + this.defensa);
	}

	boolean estáEnRango(Unidad objetivo)
	{
		double dist = this.pos.distancia(objetivo.pos);

		return dist >= distanciaAtaqueMin && dist <= distanciaAtaqueMax;
	}

	protected Vector2 getPos()
	{
		return this.pos;
	}

	protected int getDaño()
	{
		return this.daño;
	}

	final void atacarA(Unidad objetivo)
	{
		if (puedoAtacar(objetivo))
			atacar(objetivo);
	}
	
	void dañar (Unidad objetivo)
	{
		if (this.daño > objetivo.defensa)
			objetivo.salud -= (this.daño - objetivo.defensa);
		
		// si el daño es igual o menor que la defensa directamente no hace nada
		// el if está porque si pasa eso, va a quedar un núm negativo y le va a subir la vida al objetivo
	}
}
