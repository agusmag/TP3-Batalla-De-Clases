package item;

public class Puñal extends Item {

	public Puñal(){
		super.tipo = "Puñal";
	}
	
	@Override
	public void descripcion(){
		System.out.println("+3 Daño \n -3 Defensa");
	}

}
