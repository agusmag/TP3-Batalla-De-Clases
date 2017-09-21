package item;

public abstract class Item {
	String tipo;

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	abstract void descripcion();

}
