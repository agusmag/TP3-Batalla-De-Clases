package unidad;

public class Soldado extends Unidad implements BebenPoción
{
	public Soldado()
	{
		super(200, 10, 0, 1, new Vector2());
		this.energía = 100;
	}
	
	public Soldado(Vector2 pos)
	{
		super(200, 10, 0, 1, pos);
		this.energía = 100;
	}

	@Override
	public void mostrarStats()
	{
		System.out.println("Soldado:");
		System.out.println("---------------");
		super.mostrarStats();
		System.out.println("Energía: " + this.energía);
		System.out.println("---------------");
	}

	@Override
	public void beberPoción()
	{
		this.energía = 100;
	}

//	@Override
//	public void atacar(Unidad objetivo)
//	{
//		dañar(objetivo);
//		this.energía -= 10;
//	}

	@Override
	boolean puedoAtacar(Unidad objetivo)
	{
		if(estáEnRango(objetivo) && this.energía >= 10)
		{
			this.energía -= 10;
			return true;
		}
		return false;
	}

}