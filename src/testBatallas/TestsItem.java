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
	
}
