package item;

/**
 * Este item duplica la energia, pero reduce el daño 10%
 */

public class Capa extends Item {

	public Capa(){
		super.tipo = "Capa";
	}
	
	@Override
	public void descripcion(){
		System.out.println("Energia x 2 \n -10% Daño");
	}

}
