package unidad;

import java.util.ArrayList;
import java.util.List;
import item.Item;

// CLASE PADRE DE LAS UNIDADES
public abstract class Unidad
{
	int salud, da�o, defensa, energ�a;
	double distanciaAtaqueMax, distanciaAtaqueMin;
	Vector2 pos;
	protected List<Item> objetos;

	abstract void atacar (Unidad objetivo);
	abstract boolean puedoAtacar (Unidad objetivo);
	public abstract void mostrarStats();

	public Unidad(int salud, int da�o, double distanciaAtaqueMin, double distanciaAtaqueMax, Vector2 pos)
	{
		objetos = new ArrayList<Item>();
		this.salud = salud;
		this.da�o = da�o;
		this.distanciaAtaqueMax = distanciaAtaqueMax;
		this.distanciaAtaqueMin = distanciaAtaqueMin;
		this.pos = pos;

		// defensa no est� en el constructor ya que todas las unidades empiezan
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
			this.energ�a *= 2;
			this.da�o *= 0.9;
			break;
		case "pu�al":
			this.defensa -= 3;
			this.da�o += 3;
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

	protected void mostrarStatsB�sicos()
	{
		System.out.println("Mi da�o actual es: " + this.da�o);
		System.out.println("Mi salud actual es: " + this.salud);
		System.out.println("Mi defensa actual es: " + this.defensa);
	}

	boolean est�EnRango(Unidad objetivo)
	{
		double dist = this.pos.distancia(objetivo.pos);

		return dist >= distanciaAtaqueMin && dist <= distanciaAtaqueMax;
	}

	protected Vector2 getPos()
	{
		return this.pos;
	}

	protected int getDa�o()
	{
		return this.da�o;
	}

	final void atacarA(Unidad objetivo)
	{
		if (puedoAtacar(objetivo))
			atacar(objetivo);
	}
	
	void da�ar (Unidad objetivo)
	{
		if (this.da�o > objetivo.defensa)
			objetivo.salud -= (this.da�o - objetivo.defensa);
		
		// si el da�o es igual o menor que la defensa directamente no hace nada
		// el if est� porque si pasa eso, va a quedar un n�m negativo y le va a subir la vida al objetivo
	}
}
