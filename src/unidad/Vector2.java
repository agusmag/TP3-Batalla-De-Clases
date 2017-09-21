package unidad;

public class Vector2
{
	double x, y;
	
	public Vector2 ()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2 (double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double distancia (Vector2 punto)
	{
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}
}
