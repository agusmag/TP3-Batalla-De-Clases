package unidad;


/** 
 * �nica limiaci�n de ataque -DISTANCIA
 */
public class Lancero extends Unidad
{
	private final static int DISTANCIA_LANCERO_MIN = 1;
	private final static int DISTANCIA_LANCERO_MAX = 3;
	private static final int SALUD= 150;
	private static final int DA�O=25;
	
	public Lancero ()
	{
		super(SALUD, DA�O, DISTANCIA_LANCERO_MIN, DISTANCIA_LANCERO_MAX, new Punto());
	}
	
	public Lancero (Punto pos)
	{
		super(SALUD, DA�O, DISTANCIA_LANCERO_MIN, DISTANCIA_LANCERO_MAX, pos);
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
