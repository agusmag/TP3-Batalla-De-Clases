package testBatallas;

import org.junit.Assert;
import org.junit.Test;

import item.Capa;
import item.Escudo;
import item.Pu�al;

import unidad.Arquero;
import unidad.Caballero;
import unidad.Soldado;

public class TestItem {
	
	@Test
	public void equiparCapaSoldado(){
		Soldado ryan = new Soldado();
		Capa capita = new Capa();
		ryan.equiparCon(capita);
		Assert.assertEquals(200, ryan.getEnerg�a());
	}
	
	@Test
	public void equiparPu�al(){
		Arquero legolas = new Arquero();
		Pu�al pu�alsito = new Pu�al();
		legolas.equiparCon(pu�alsito);
		
		Assert.assertEquals(8, legolas.getDa�o());
		Assert.assertEquals(-3, legolas.getDefensa());
		
	}
	
	@Test
	public void equiparMismoItem(){
		Soldado ryan = new Soldado();
		Pu�al pu�al1 = new Pu�al();
		Pu�al pu�al2 = new Pu�al();
		
		Assert.assertTrue(ryan.equiparCon(pu�al1));
		
		// NO DEJA EQUIPAR UN MISMO OBJETO, RETORNA FALSE
		Assert.assertFalse(ryan.equiparCon(pu�al2));
	}
	
	@Test
	public void equiparseTodo(){
		Caballero aragon = new Caballero();
		Pu�al pu�al = new Pu�al();
		Escudo shell = new Escudo();
		Capa capita = new Capa();
		
		Assert.assertTrue(aragon.equiparCon(pu�al));
		Assert.assertTrue(aragon.equiparCon(shell));
		Assert.assertTrue(aragon.equiparCon(capita));
	}
	
	@Test
	public void tomarPocion(){
		Soldado ryan = new Soldado();
		Soldado cabo = new Soldado();
		
		ryan.atacarA(cabo);
		Assert.assertEquals(ryan.getEnerg�a(), 90);
		
		ryan.beberPoci�n();
		Assert.assertEquals(ryan.getEnerg�a(), 100);
	}
	
	
	
}
