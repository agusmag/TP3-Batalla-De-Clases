package item;

public abstract class Item {
	String tipo;

	protected Item(String tipo) {
		this.tipo = tipo;
	}

	public String getName() {
		return this.tipo;
	}

}
