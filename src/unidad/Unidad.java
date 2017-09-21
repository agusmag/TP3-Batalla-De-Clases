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

	public boolean equiparCon(Item item)		//equipa con un item
	{
		if (objetos.size() < 3)
		{
			for (Item itemEqui : objetos)		//comprobar si ya lo tenia equipado
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
		case "escudo":
			this.defensa = 40;
			break;
		}
	}

	protected boolean infomarEstado()
	{ // Informa si la Unidad esta viva o muerta; 1 esta VIVA
		return this.salud != 0;
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

	public final void atacarA(Unidad objetivo)
	{
		if (puedoAtacar(objetivo))
			atacar(objetivo);
	}
	
	void da�ar (Unidad objetivo)
	{
		int da�oRecib = (objetivo.tieneEscudo()) ? (this.da�o*objetivo.defensa/100) : this.da�o;
		if (objetivo.salud > da�oRecib) 	
			objetivo.salud -= da�oRecib;
		if (objetivo.salud <0)				// evita tener vida negativa
			objetivo.salud =0;
			
		//se reduce la cantidad del ataque al 40%
		// si el da�o es igual o menor que la defensa directamente no hace nada
		// el if est� porque si pasa eso, va a quedar un n�m negativo y le va a subir la vida al objetivo
	}
	
	
	private boolean tieneEscudo() {
		for (Item itemEqui : objetos)		//comprobar si ya lo tenia equipado
		{
			if (itemEqui.getName() == "Escudo")
				return true;
		}
		return false;
	}
}
