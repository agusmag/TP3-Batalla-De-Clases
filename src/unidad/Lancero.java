package unidad;

public class Lancero extends Unidad
{
	private final static int DISTANCIA_LANCERO_MIN = 1;
	private final static int DISTANCIA_LANCERO_MAX = 3;

	public Lancero ()
	{
		super(150, 25, DISTANCIA_LANCERO_MIN, DISTANCIA_LANCERO_MAX, new Vector2());
	}
	
	public Lancero (Vector2 pos)
	{
		super(150, 25, DISTANCIA_LANCERO_MIN, DISTANCIA_LANCERO_MAX, pos);
	}

	@Override
	void atacar (Unidad objetivo)
	{
		dañar(objetivo);
	}
	
	@Override
	boolean puedoAtacar (Unidad objetivo)
	{
		return estáEnRango(objetivo);
	}

	@Override
	public void mostrarStats()
	{
		System.out.println("Lancero:");
		System.out.println("---------------");
		super.mostrarStats();
		System.out.println("---------------");
	}

}
