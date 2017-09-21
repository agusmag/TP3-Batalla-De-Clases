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

//	abstract void atacar (Unidad objetivo);
	abstract boolean puedoAtacar (Unidad objetivo);
	
	public void mostrarStats()
	{
		System.out.println("Da�o: " + this.da�o);
		System.out.println("Salud: " + this.salud);
		System.out.println("Defensa: " + this.defensa);
	}
	
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
			this.energ�a *= 2;
			this.da�o *= 0.9;
			break;
		case "Pu�al":
			this.defensa -= 3;
			this.da�o += 3;
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

	protected void moverA(Vector2 pos)
	{
		this.pos = pos;
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

	public int getDa�o()
	{
		return this.da�o;
	}

	public final void atacarA(Unidad objetivo)
	{
		if (puedoAtacar(objetivo) && objetivo.muerta() == false && !objetivo.equals(this))
			this.da�ar(objetivo);
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
	public int getEnerg�a()
	{
		return energ�a;
	}
	public void setEnerg�a(int energ�a)
	{
		this.energ�a = energ�a;
	}
	public void setPos(Vector2 pos)
	{
		this.pos = pos;
	}
	
}
