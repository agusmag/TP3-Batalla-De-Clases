package unidad;

/**
 * 
 * Posee un numero limitado de ataques (flechas).
 * Al acabarse, necesitar� recargarlas.
 */

public class Arquero extends Unidad
{
	private final static int DISTANCIA_ARQUERO_MIN = 2;
	private final static int DISTANCIA_ARQUERO_MAX = 5;
	private static final int SALUD= 50;
	private static final int DA�O=5;
	private static final int FLECHAS_INI=20;
	int flechas;

	public Arquero()
	{
		super(SALUD, DA�O, DISTANCIA_ARQUERO_MIN, DISTANCIA_ARQUERO_MAX, new Punto());
		this.flechas = FLECHAS_INI;
	}
	
	public Arquero(Punto pos)
	{
		super(SALUD, DA�O, DISTANCIA_ARQUERO_MIN, DISTANCIA_ARQUERO_MAX, pos);
		this.flechas = FLECHAS_INI;
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
		System.out.println("Arquero:");
		System.out.println("---------------");
		super.mostrarStats();
		System.out.println("Flechas: " + this.flechas);
		System.out.println("---------------");
	}
	

	@Override
	public boolean puedoAtacar (Unidad objetivo)
	{
		if(estaEnRango(objetivo) && this.flechas > 0){
			this.flechas --;
			return true;
		}
		return false;
	}
	
	/**
	 * Agrega 6 flechas al carcaj del arquero.
	 */
	public void recargarFlechas ()
	{
		this.flechas += 6;
	}

}