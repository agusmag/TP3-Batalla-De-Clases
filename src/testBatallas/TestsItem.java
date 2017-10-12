package testBatallas;

import org.junit.Assert;
import org.junit.Test;

import item.Capa;
import item.Escudo;
import item.Pu�al;

import unidad.Arquero;
import unidad.Caballero;
import unidad.Punto;
import unidad.Soldado;
import unidad.Unidad;

public class TestsItem 
{
	@Test
	public void equiparPu�al() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Pu�al(legolas);
		
		Assert.assertEquals(8, legolas.getDa�o());
		Assert.assertEquals(-3, legolas.getDefensa());
	}
	
	@Test
	public void equiparCapa() throws Exception
	{
		Unidad leonidas = new Soldado();
		leonidas = new Capa(leonidas);
		
		Assert.assertEquals(200, leonidas.getEnergia());
	}
	
	@Test
	public void equiparEscudo () throws Exception
	{
		Caballero knight = new Caballero(new Punto(0, 1));	//ataque de 50 ps

		Unidad soldier = new Soldado();
		soldier = new Escudo(soldier);
		knight.atacarA(soldier);		//da�o recibido 20 (40%)
		
		Assert.assertEquals(180, soldier.getSalud());
	}
	
	@Test
	public void equiparCapaEscudo () throws Exception
	{
		Caballero knight = new Caballero(new Punto(0, 1));

		Unidad soldier = new Soldado();
		soldier = new Capa(soldier);
		soldier = new Escudo(soldier);
		knight.atacarA(soldier);
		
		Assert.assertEquals(180, soldier.getSalud());
		Assert.assertEquals(200, soldier.getEnergia());
	}
	
	@Test
	public void equiparPu�alEscudo () throws Exception
	{
		Caballero knight = new Caballero(new Punto(0, 1));

		Unidad soldier = new Soldado();
		soldier = new Pu�al(soldier);
		soldier = new Escudo(soldier);
		knight.atacarA(soldier);
		
		Assert.assertEquals(179, soldier.getSalud());
	}
	
	@Test
	public void equiparPu�alCapa () throws Exception
	{
		Caballero knight = new Caballero(new Punto(0, 1));

		Unidad soldier = new Soldado();
		soldier = new Pu�al(soldier);
		soldier = new Capa(soldier);
		soldier.atacarA(knight);
		
		Assert.assertEquals(11, soldier.getDa�o());
		Assert.assertEquals(190, soldier.getEnergia());
		Assert.assertEquals(189, knight.getSalud());
	}
	
	@Test
	public void equiparPu�alCapaEscudo() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Pu�al(legolas);
		legolas = new Capa(legolas);
		legolas = new Escudo(legolas);
		
		Assert.assertEquals(7, legolas.getDa�o());
		Assert.assertEquals(-3, legolas.getDefensa());
		
		Caballero knight = new Caballero(new Punto(0, 1));
		knight.atacarA(legolas);
		Assert.assertEquals(29, legolas.getSalud());
	}
	
	@Test
	public void equiparCaballero() throws Exception
	{
		Unidad aragorn = new Caballero();
		
		aragorn = new Pu�al(aragorn);
		aragorn = new Capa(aragorn);
		
		Assert.assertEquals(47, aragorn.getDa�o());
	}
	
	@Test
	public void equiparSoldado() throws Exception
	{
		Unidad leonidas = new Soldado();
		leonidas = new Pu�al(leonidas);		
		Assert.assertEquals(13, leonidas.getDa�o());
	}
}
