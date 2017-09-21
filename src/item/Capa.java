package item;

public class Capa extends Item {

	public Capa(){
		super.tipo = "Capa";
	}
	
	@Override
	public void descripcion(){
		System.out.println("Energia x 2 \n -10% Daño");
	}

}
