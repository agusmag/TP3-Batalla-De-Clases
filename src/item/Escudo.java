package item;

public class Escudo extends Item {

	public Escudo(){
		super.tipo = "Escudo";
	}
	
	@Override
	public void descripcion(){
		System.out.println("+40% Defensa");
	}

}
