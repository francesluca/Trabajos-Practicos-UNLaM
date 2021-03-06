package polinomio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import tests.TestTiempoDeEvaluacion;

public class Polinomio {

	private int grado;
	private double[] coeficientes;

	public Polinomio(String Path) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(Path));
		scan.useLocale(Locale.ENGLISH);

		grado = scan.nextInt();
		coeficientes = new double[grado + 1];

		for (int i = 0; i <= grado; i++) {
			coeficientes[i] = scan.nextDouble();
		}

		scan.close();
	}

	@Override
	public String toString() {
		String coeficientesString = "[";

		for (int i = 0; i < coeficientes.length; i++) {
			coeficientesString += coeficientes[i];

			if (i < coeficientes.length - 1)
				coeficientesString += "; ";
		}

		coeficientesString += "]";
		return coeficientesString;
	}

	public double evaluarMultiplicacionesSucesivas(double x) {
		double resultado = 0;
		double potencia = 1;

		for (int i = 0; i < coeficientes.length; i++) {
			for (int j = 0; j < grado - i; j++) {
				potencia *= x;
			}

			resultado += potencia * coeficientes[i];
			potencia = 1;
		}

		return resultado;
	}

	public double evaluarRecursiva(double x) {
		double resultado = 0;

		for (int i = 0; i < coeficientes.length; i++) {
			resultado += potencia(x, grado - i) * coeficientes[i];
		}

		return resultado;
	}

	public double potencia(double x, int grado) {
		if (grado == 0) {
			return 1;
		}

		return x * potencia(x, grado - 1);
	}

	public double evaluarRecursivaMejorada(double x) {
		double resultado = 0;

		for (int i = 0; i < coeficientes.length; i++) {
			resultado += potenciaMejorada(x, grado - i) * coeficientes[i];
		}

		return resultado;
	}

	public double potenciaMejorada(double x, int grado) {
		if (grado == 0) {
			return 1;
		}

		if (grado % 2 == 0)
			return potenciaMejorada(x * x, grado / 2);

		return x * potenciaMejorada(x, grado - 1);
	}

	public double evaluarProgramacionDinamica(double x) {
		double resultado = 0;
		double potencia = 1;

		for (int i = 0; i < coeficientes.length; i++) {
			resultado += coeficientes[grado - i] * potencia;
			potencia *= x;
		}

		return resultado;
	}

	public double evaluarMathPow(double x) {
		double resultado = 0;

		for (int i = 0; i < coeficientes.length; i++) {
			resultado += Math.pow(x, grado - i) * coeficientes[i];
		}

		return resultado;
	}
	
	public double evaluarHorner(double x) {
		double resultado = 0;

		for (int i = 0; i <= coeficientes.length - 1; i++) {
			resultado =  coeficientes[i] + (resultado * x);
		}

		return resultado;
	}

	public static void generarArchivoPolinomioAleatorio(String path, int grado) throws IOException {
		PrintWriter writer = new PrintWriter(new File(path));
		double minimo = -5;
		double maximo = 5;

		writer.print(grado + "\n");

		for (int i = 0; i <= grado; i++) {
			writer.print((int) ((maximo - minimo) * Math.random() + minimo) + "\n");
		}

		writer.close();
	}

	public static void main(String[] args) throws IOException {
		double x = 1.01;
		int grado = 15000;
		String path = "archivos/polinomioGrado" + grado + ".in";
		//Polinomio.generarArchivoPolinomioAleatorio(path, grado);
		//System.out.println(p.evaluarMathPow(x));
		
		Polinomio polinomio = new Polinomio(path);
		TestTiempoDeEvaluacion test = new TestTiempoDeEvaluacion(path);

		System.out.println("\n------------Evaluaciones (x = 2, grado = " + grado + ")------------");

		if (grado <= 5000) {
			System.out.println("Recursiva, tiempo: " + test.tiempoRecursiva(x) + " miliseg" + " ,evaluacion: " + polinomio.evaluarRecursiva(x));
		}

		if (grado <= 50000) {
			System.out.println("Multipl. sucesivas, tiempo: " + test.tiempoMultiplicacionesSucesivas(x) + " miliseg" + " ,evaluacion: " + polinomio.evaluarMultiplicacionesSucesivas(x));
		}
		
		if(grado <= 10000000) {
			System.out.println("Recursiva Mejorada, tiempo: " + test.tiempoRecursivaMejorada(x) + " miliseg" + " ,evaluacion: " + polinomio.evaluarRecursivaMejorada(x));
			System.out.println("Math.Pow(), tiempo: " + test.tiempoMathPow(x) + " miliseg" + " ,evaluacion: " + polinomio.evaluarMathPow(x));
		}
		
		System.out.println("Programacion Dinamica, tiempo: " + test.tiempoProgramacionDinamica(x) + " miliseg" + " ,evaluacion: " + polinomio.evaluarProgramacionDinamica(x));
		System.out.println("Polinomio Horner, tiempo: " + test.tiempoHorner(x) + " miliseg" + " ,evaluacion: " + polinomio.evaluarHorner(x));
	}
}
