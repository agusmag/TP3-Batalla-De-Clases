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
	
}
