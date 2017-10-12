package testBatallas;

import org.junit.Assert;
import org.junit.Test;

import item.Capa;
import item.Escudo;
import item.Puñal;

import unidad.Arquero;
import unidad.Caballero;
import unidad.Soldado;
import unidad.Unidad;

public class TestsItem {
	
	// Hay que hacer los tests de los items de vuelta
	
	@Test
	public void equiparPuñal() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Puñal(legolas);
		
		Assert.assertEquals(8, legolas.getDaño());
		legolas.mostrarStats();
		Assert.assertEquals(0, legolas.getDefensa());
		
	}
	
	@Test
	public void equiparPuñalyCapa() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Puñal(legolas);
		legolas = new Capa(legolas);
		
		Assert.assertEquals(7, legolas.getDaño());
		legolas.mostrarStats();
		Assert.assertEquals(0, legolas.getDefensa());
		
	}
	
	@Test
	public void equiparPuñal_Capa_Escudo() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Puñal(legolas);
		legolas = new Capa(legolas);
		legolas = new Escudo(legolas);
		
		Assert.assertEquals(7, legolas.getDaño());
		legolas.mostrarStats();
		Assert.assertEquals(0, legolas.getDefensa());
		
	}
	
	@Test
	public void equiparCaballero() throws Exception
	{
		Unidad aragorn = new Caballero();
		aragorn = new Puñal(aragorn);
		Assert.assertEquals(53, aragorn.getDaño());
		
		aragorn = new Capa(aragorn);
		Assert.assertEquals(47, aragorn.getDaño());
		
		//aragorn.mostrarStats();
	}
	
	@Test
	public void equiparSoldado() throws Exception
	{
		Unidad leonidas = new Soldado();
		leonidas = new Puñal(leonidas);		
		Assert.assertEquals(13, leonidas.getDaño());

		
	}
}
