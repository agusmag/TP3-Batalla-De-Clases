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
			throw new Exception("Ya tiene un escudo equipado!");
	}

	@Override
	public void serDa�ado(int da�oRecibido)
	{
		int da�oFinal = da�oRecibido <= this.getDefensa() ? 0 : da�oRecibido - this.getDefensa();
		da�oFinal = (int) (da�oFinal * 0.4);
		
		this.setSalud(this.getSalud() - da�oFinal);
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
	
	@Override
	public void recargarFlechas () 
	{
		this.unidad.recargarFlechas();
	}
	
	@Override
	public int getFlechas () 
	{
		return this.unidad.getFlechas();
	}
	
	@Override
	public void setFlechas (int flechas) 
	{
		this.unidad.setFlechas(flechas);
	}

}
