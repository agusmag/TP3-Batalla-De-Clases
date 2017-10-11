package item;

import unidad.Unidad;

/**
 * Aumenta en 3 los puntos de ataque, pero reduce en 3 los puntos de defensa.
 */

public class Pu�al extends Item 
{
	private static final int ID_ITEM_PU�AL = 1;
	
	public Pu�al(Unidad unidad) throws Exception 
	{
		super(unidad);
		
		// verifico que no tenga equipado el mismo item
		if ((unidad.getItemsEquipados() & ID_ITEM_PU�AL) != 0)
			throw new Exception("Ya tiene un pu�al equipado!");
	}

	@Override
	public int getDa�o ()
	{
		return this.unidad.getDa�o() + 3;
	}
	
	@Override
	public int getDefensa ()
	{
		return this.unidad.getDefensa() <= 3 ? 0 : this.unidad.getDefensa() - 3;
	}
	
	@Override
	public int getItemsEquipados ()
	{
		return this.unidad.getItemsEquipados() + ID_ITEM_PU�AL;
	}
	
	@Override
	public void descripcion() {
		System.out.println("+3 Da�o \n -3 Defensa");
	}

}
