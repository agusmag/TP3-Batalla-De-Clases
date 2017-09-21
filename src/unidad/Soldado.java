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
		super.mostrarStatsBásicos();
		System.out.println("Mi energia actual es: " + this.energía);
	}

	@Override
	public void beberPoción()
	{
		this.energía = 100;
	}

	@Override
	void atacar(Unidad objetivo)
	{
		dañar(objetivo);
		this.energía -= 10;
	}

	@Override
	boolean puedoAtacar(Unidad objetivo)
	{
		return estáEnRango(objetivo) && this.energía >= 10;
	}

}