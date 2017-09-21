package testBatallas;

import org.junit.Assert;
import org.junit.Test;

import item.Capa;
import item.Escudo;
import item.Puñal;

import unidad.Arquero;
import unidad.Caballero;
import unidad.Soldado;

public class TestItem {
	
	@Test
	public void equiparCapaSoldado(){
		Soldado ryan = new Soldado();
		Capa capita = new Capa();
		ryan.equiparCon(capita);
		Assert.assertEquals(200, ryan.getEnergía());
	}
	
	@Test
	public void equiparPuñal(){
		Arquero legolas = new Arquero();
		Puñal puñalsito = new Puñal();
		legolas.equiparCon(puñalsito);
		
		Assert.assertEquals(8, legolas.getDaño());
		Assert.assertEquals(-3, legolas.getDefensa());
		
	}
	
	@Test
	public void equiparMismoItem(){
		Soldado ryan = new Soldado();
		Puñal puñal1 = new Puñal();
		Puñal puñal2 = new Puñal();
		
		Assert.assertTrue(ryan.equiparCon(puñal1));
		
		// NO DEJA EQUIPAR UN MISMO OBJETO, RETORNA FALSE
		Assert.assertFalse(ryan.equiparCon(puñal2));
	}
	
	@Test
	public void equiparseTodo(){
		Caballero aragon = new Caballero();
		Puñal puñal = new Puñal();
		Escudo shell = new Escudo();
		Capa capita = new Capa();
		
		Assert.assertTrue(aragon.equiparCon(puñal));
		Assert.assertTrue(aragon.equiparCon(shell));
		Assert.assertTrue(aragon.equiparCon(capita));
	}
	
	@Test
	public void tomarPocion(){
		Soldado ryan = new Soldado();
		Soldado cabo = new Soldado();
		
		ryan.atacarA(cabo);
		Assert.assertEquals(ryan.getEnergía(), 90);
		
		ryan.beberPoción();
		Assert.assertEquals(ryan.getEnergía(), 100);
	}
	
	
	
}
