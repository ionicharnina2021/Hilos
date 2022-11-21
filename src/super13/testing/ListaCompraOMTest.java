package super13.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import super13.Comentador;
import super13.modelo.Cart;
import super13.repos.ArticulosEnStockRepositorio;
import super13.repos.ListaCompraOM;

class ListaCompraOMTest {
	ListaCompraOM listaOM;
	ArticulosEnStockRepositorio articulosEnStockRepositorio;
	@BeforeEach
	void before() {
		articulosEnStockRepositorio=new ArticulosEnStockRepositorio(10);
		listaOM =new ListaCompraOM(articulosEnStockRepositorio);
	}

	@Test
	void testGetListaCompraRandom() {
		Comentador.mensaje("comienza la prueba");
		int elementosMaximo = 3;
		int cantidadMaxima = 5;
		Cart listaCompraRandom = listaOM.getListaCompraRandom(elementosMaximo, cantidadMaxima);
		int size = listaCompraRandom.size();
		assertTrue(size<=elementosMaximo);
		assertTrue(size>0);
		Comentador.mensaje("termina la prueba");
		listaCompraRandom.getArticulos().entrySet().stream().forEach((entry)->{
			assertTrue(entry.getValue()>0&&entry.getValue()<=cantidadMaxima);
		});
	}

}
