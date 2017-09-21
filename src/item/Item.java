package item;

public abstract class Item {
	String tipo;

	public String getName() {
		return this.tipo;
	}
	
	abstract void descripcion();

}
