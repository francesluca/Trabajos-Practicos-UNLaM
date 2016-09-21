package tests;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import polinomio.Polinomio;

public class TestTiempoDeEvaluacion {

	private Calendar tiempoInicio;
	private Calendar tiempoFin;
	private Polinomio polinomio;

	public TestTiempoDeEvaluacion(String Path) throws FileNotFoundException {
		polinomio = new Polinomio(Path);
	}

	public long tiempoMultiplicacionesSucesivas(double x) {

		tiempoInicio = new GregorianCalendar();

		polinomio.evaluarMultiplicacionesSucesivas(x);

		tiempoFin = new GregorianCalendar();

		return (long)(tiempoFin.getTimeInMillis() - tiempoInicio.getTimeInMillis());
	}
	
	public long tiempoRecursiva(double x) {

		tiempoInicio = new GregorianCalendar();

		polinomio.evaluarRecursiva(x);

		tiempoFin = new GregorianCalendar();

		return (long)(tiempoFin.getTimeInMillis() - tiempoInicio.getTimeInMillis());
	}
	
	public long tiempoRecursivaMejorada(double x) {

		tiempoInicio = new GregorianCalendar();

		polinomio.evaluarRecursivaMejorada(x);

		tiempoFin = new GregorianCalendar();

		return (long)(tiempoFin.getTimeInMillis() - tiempoInicio.getTimeInMillis());
	}
	
	public long tiempoProgramacionDinamica(double x) {

		tiempoInicio = new GregorianCalendar();

		polinomio.evaluarProgramacionDinamica(x);

		tiempoFin = new GregorianCalendar();

		return (long)(tiempoFin.getTimeInMillis() - tiempoInicio.getTimeInMillis());
	}
	
	public long tiempoMathPow(double x) {

		tiempoInicio = new GregorianCalendar();

		polinomio.evaluarMathPow(x);

		tiempoFin = new GregorianCalendar();

		return (long)(tiempoFin.getTimeInMillis() - tiempoInicio.getTimeInMillis());
	}
	
	public long tiempoHorner(double x) {

		tiempoInicio = new GregorianCalendar();

		polinomio.evaluarHorner(x);

		tiempoFin = new GregorianCalendar();

		return (long)(tiempoFin.getTimeInMillis() - tiempoInicio.getTimeInMillis());
	}
}
