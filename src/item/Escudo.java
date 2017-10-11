package item;

import unidad.Unidad;

/**
 * La unidad que posea este item recibir� solamente el 40 % del da�o enemigo.
 */

public class Escudo extends Item 
{
	private static final int ID_ITEM_ESCUDO = 2;
	
	public Escudo(Unidad unidad) throws Exception 
	{
		super(unidad);
		
		// verifico que no tenga equipado el mismo item
		if ((unidad.getItemsEquipados() & ID_ITEM_ESCUDO) != 0)
			throw new Exception("Ya tiene un pu�al equipado!");
	}

	@Override
	public int getDefensa ()
	{
		// trunca la defensa luego de multiplicarla si qued� con decimales
		return (int) (this.unidad.getDefensa() * 1.4);
	}
	
	@Override
	public int getItemsEquipados ()
	{
		return this.unidad.getItemsEquipados() + ID_ITEM_ESCUDO;
	}

	@Override
	public void descripcion() {
		System.out.println("+40% Defensa");
	}

}
