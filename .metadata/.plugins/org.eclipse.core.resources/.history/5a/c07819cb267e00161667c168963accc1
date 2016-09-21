package tests;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import polinomio.Polinomio;

public class TestPolinomio {

	@Test
	public void testEvaluarMultiplicacionesSucesivas() throws FileNotFoundException {
		Polinomio polinomio = new Polinomio("archivos/polinomioGrado3.in");
		double x = 2;
		double resultado = 48;
		
		Assert.assertEquals(resultado, polinomio.evaluarMultiplicacionesSucesivas(x), 0);
	}
	
	@Test
	public void testEvaluarRecursiva() throws FileNotFoundException {
		Polinomio polinomio = new Polinomio("archivos/polinomioGrado3.in");
		double x = 2;
		double resultado = 48;
		
		Assert.assertEquals(resultado, polinomio.evaluarRecursiva(x), 0);
	}
	
	@Test
	public void testEvaluarRecursivaMejorada() throws FileNotFoundException {
		Polinomio polinomio = new Polinomio("archivos/polinomioGrado3.in");
		double x = 2;
		double resultado = 48;
		
		Assert.assertEquals(resultado, polinomio.evaluarRecursivaMejorada(x), 0);
	}
	
	@Test
	public void testEvaluarProgramacionDinamica() throws FileNotFoundException {
		Polinomio polinomio = new Polinomio("archivos/polinomioGrado3.in");
		double x = 2;
		double resultado = 48;
		
		Assert.assertEquals(resultado, polinomio.evaluarProgramacionDinamica(x), 0);
	}
	
	@Test
	public void testEvaluarMathPow() throws FileNotFoundException {
		Polinomio polinomio = new Polinomio("archivos/polinomioGrado3.in");
		double x = 2;
		double resultado = 48;
		
		Assert.assertEquals(resultado, polinomio.evaluarMathPow(x), 0);
	}
	
	@Test
	public void testEvaluarMejorada() throws FileNotFoundException {
		Polinomio polinomio = new Polinomio("archivos/polinomioGrado3.in");
		double x = 2;
		double resultado = 48;
		
		Assert.assertEquals(resultado, polinomio.evaluarMejorada(x), 0);
	}
}
