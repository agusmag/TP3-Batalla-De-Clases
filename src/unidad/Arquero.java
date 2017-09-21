package unidad;

public class Arquero extends Unidad
{
	private final static int DISTANCIA_ARQUERO_MIN = 2;
	private final static int DISTANCIA_ARQUERO_MAX = 5;
	int flechas;

	public Arquero()
	{
		super(50, 5, DISTANCIA_ARQUERO_MIN, DISTANCIA_ARQUERO_MAX, new Vector2());
		this.flechas = 20;
	}
	
	public Arquero(Vector2 pos)
	{
		super(50, 5, DISTANCIA_ARQUERO_MIN, DISTANCIA_ARQUERO_MAX, pos);
		this.flechas = 20;
	}

	public int getFlechas()
	{
		return flechas;
	}

	public void setFlechas(int flechas)
	{
		this.flechas = flechas;
	}

	@Override
	public void mostrarStats()
	{
		System.out.println("Caballero:");
		System.out.println("---------------");
		super.mostrarStats();
		System.out.println("Flechas: " + this.flechas);
		System.out.println("---------------");
	}
	
	@Override
	void atacar(Unidad objetivo)
	{
		dañar(objetivo);
		this.flechas--;
	}
	
	@Override
	boolean puedoAtacar (Unidad objetivo)
	{
		return estáEnRango(objetivo) && this.flechas > 0;
	}

}