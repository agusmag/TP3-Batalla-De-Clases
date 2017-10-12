package testBatallas;

import org.junit.Assert;
import org.junit.Test;

import item.Capa;
import item.Escudo;
import item.Pu�al;

import unidad.Arquero;
import unidad.Caballero;
import unidad.Soldado;
import unidad.Unidad;

public class TestsItem {
	
	// Hay que hacer los tests de los items de vuelta
	
	@Test
	public void equiparPu�al() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Pu�al(legolas);
		
		Assert.assertEquals(8, legolas.getDa�o());
		legolas.mostrarStats();
		Assert.assertEquals(0, legolas.getDefensa());
		
	}
	
	@Test
	public void equiparPu�alyCapa() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Pu�al(legolas);
		legolas = new Capa(legolas);
		
		Assert.assertEquals(7, legolas.getDa�o());
		legolas.mostrarStats();
		Assert.assertEquals(0, legolas.getDefensa());
		
	}
	
	@Test
	public void equiparPu�al_Capa_Escudo() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Pu�al(legolas);
		legolas = new Capa(legolas);
		legolas = new Escudo(legolas);
		
		Assert.assertEquals(7, legolas.getDa�o());
		legolas.mostrarStats();
		Assert.assertEquals(0, legolas.getDefensa());
		
	}
	
	@Test
	public void equiparCaballero() throws Exception
	{
		Unidad aragorn = new Caballero();
		aragorn = new Pu�al(aragorn);
		Assert.assertEquals(53, aragorn.getDa�o());
		
		aragorn = new Capa(aragorn);
		Assert.assertEquals(47, aragorn.getDa�o());
		
		//aragorn.mostrarStats();
	}
	
	@Test
	public void equiparSoldado() throws Exception
	{
		Unidad leonidas = new Soldado();
		leonidas = new Pu�al(leonidas);		
		Assert.assertEquals(13, leonidas.getDa�o());

		
	}
}
