package unidad;

public class Soldado extends Unidad implements BebenPoci�n
{
	public Soldado()
	{
		super(200, 10, 0, 1, new Vector2());
		this.energ�a = 100;
	}
	
	public Soldado(Vector2 pos)
	{
		super(200, 10, 0, 1, pos);
		this.energ�a = 100;
	}

	@Override
	public void mostrarStats()
	{
		System.out.println("Soldado:");
		System.out.println("---------------");
		super.mostrarStats();
		System.out.println("Energ�a: " + this.energ�a);
		System.out.println("---------------");
	}

	@Override
	public void beberPoci�n()
	{
		this.energ�a = 100;
	}

	@Override
	public void atacar(Unidad objetivo)
	{
		da�ar(objetivo);
		this.energ�a -= 10;
	}

	@Override
	boolean puedoAtacar(Unidad objetivo)
	{
		return est�EnRango(objetivo) && this.energ�a >= 10;
	}

}