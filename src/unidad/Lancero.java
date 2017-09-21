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
		da�ar(objetivo);
	}
	
	@Override
	boolean puedoAtacar (Unidad objetivo)
	{
		return est�EnRango(objetivo);
	}

	@Override
	public void mostrarStats()
	{
		mostrarStatsB�sicos();
	}

}
