package testBatallas;

import org.junit.Assert;
import org.junit.Test;

import item.Capa;
import item.Escudo;
import item.Puñal;

import unidad.Arquero;
import unidad.Caballero;
import unidad.Punto;
import unidad.Soldado;
import unidad.Unidad;

public class TestsItem 
{
	@Test
	public void equiparPuñal() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Puñal(legolas);
		
		Assert.assertEquals(8, legolas.getDaño());
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
		knight.atacarA(soldier);		//daño recibido 20 (40%)
		
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
	public void equiparPuñalEscudo () throws Exception
	{
		Caballero knight = new Caballero(new Punto(0, 1));

		Unidad soldier = new Soldado();
		soldier = new Puñal(soldier);
		soldier = new Escudo(soldier);
		knight.atacarA(soldier);
		
		Assert.assertEquals(179, soldier.getSalud());
	}
	
	@Test
	public void equiparPuñalCapa () throws Exception
	{
		Caballero knight = new Caballero(new Punto(0, 1));

		Unidad soldier = new Soldado();
		soldier = new Puñal(soldier);
		soldier = new Capa(soldier);
		soldier.atacarA(knight);
		
		Assert.assertEquals(11, soldier.getDaño());
		Assert.assertEquals(190, soldier.getEnergia());
		Assert.assertEquals(189, knight.getSalud());
	}
	
	@Test
	public void equiparPuñalCapaEscudo() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Puñal(legolas);
		legolas = new Capa(legolas);
		legolas = new Escudo(legolas);
		
		Assert.assertEquals(7, legolas.getDaño());
		Assert.assertEquals(-3, legolas.getDefensa());
		
		Caballero knight = new Caballero(new Punto(0, 1));
		knight.atacarA(legolas);
		Assert.assertEquals(29, legolas.getSalud());
	}
	
	@Test
	public void equiparCaballero() throws Exception
	{
		Unidad aragorn = new Caballero();
		
		aragorn = new Puñal(aragorn);
		aragorn = new Capa(aragorn);
		
		Assert.assertEquals(47, aragorn.getDaño());
	}
	
	@Test
	public void equiparSoldado() throws Exception
	{
		Unidad leonidas = new Soldado();
		leonidas = new Puñal(leonidas);		
		Assert.assertEquals(13, leonidas.getDaño());
	}
}
