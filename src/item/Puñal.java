package item;

public class Pu�al extends Item {

	public Pu�al(){
		super.tipo = "Pu�al";
	}
	
	@Override
	public void descripcion(){
		System.out.println("+3 Da�o \n -3 Defensa");
	}

}
