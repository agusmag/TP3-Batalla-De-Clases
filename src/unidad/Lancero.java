package unidad;


/** 

 * �nica limiaci�n de ataque -DISTANCIA

 */
public class Lancero extends Unidad
{
	private final static int DISTANCIA_LANCERO_MIN = 1;
	private final static int DISTANCIA_LANCERO_MAX = 3;

	public Lancero ()
	{
		super(150, 25, DISTANCIA_LANCERO_MIN, DISTANCIA_LANCERO_MAX, new Punto());
	}
	
	public Lancero (Punto pos)
	{
		super(150, 25, DISTANCIA_LANCERO_MIN, DISTANCIA_LANCERO_MAX, pos);
	}


	@Override
	public boolean puedoAtacar (Unidad objetivo)
	{
		return estaEnRango(objetivo);
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
