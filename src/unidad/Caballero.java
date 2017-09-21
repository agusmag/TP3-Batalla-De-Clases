package unidad;

public class Caballero extends Unidad implements BebenPoción
{
	private static final int DISTANCIA_CABALLERO_MIN = 1;
	private static final int DISTANCIA_CABALLERO_MAX = 2;
	int contadorAtaques;
	
	public Caballero ()
	{
		super(200, 50, DISTANCIA_CABALLERO_MIN, DISTANCIA_CABALLERO_MAX, new Vector2());
	}
	
	public Caballero (Vector2 pos)
	{
		super(200, 50, DISTANCIA_CABALLERO_MIN, DISTANCIA_CABALLERO_MAX, pos);
	}

	@Override
	void atacar(Unidad objetivo)
	{
		dañar(objetivo);
		contadorAtaques++;
	}

	@Override
	boolean puedoAtacar(Unidad objetivo)
	{
		return estáEnRango(objetivo) && contadorAtaques < 3;
	}

	@Override
	public void mostrarStats() {
	
		super.mostrarStatsBásicos();
		System.out.println("Mi numero de ataques realizados es: " + this.contadorAtaques);
	}

	@Override
	public void beberPoción() 
	{
		this.contadorAtaques = 0;
	}
			
}