package item;

import unidad.Unidad;

/**
 * Este item duplica la energ�a, pero reduce el da�o 10%
 */

public class Capa extends Item 
{

private static final int ID_ITEM_CAPA = 4;
	
	public Capa(Unidad unidad) throws Exception 
	{
		super(unidad);
		
		// verifico que no tenga equipado el mismo item
		if ((unidad.getItemsEquipados() & ID_ITEM_CAPA) != 0)
			throw new Exception("Ya tiene un pu�al equipado!");
		
		// duplica la energ�a al equiparse
		unidad.setEnergia(unidad.getEnergia() * 2);
	}
	
	@Override
	public int getDa�o ()
	{
		// trunca el da�o si es que qued� con decimales
		return (int) (this.unidad.getDa�o() * 0.9);
	}
	
	@Override
	public int getItemsEquipados ()
	{
		return this.unidad.getItemsEquipados() + ID_ITEM_CAPA;
	}
	
	@Override
	public void descripcion(){
		System.out.println("Energia x 2 \n -10% Da�o");
	}

}
