package model;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;


public class Formula {
	
	// Formel wird als DoubleUnaryOperator übergeben, damit nicht eine Klasse pro Funktion erstellt werden muss
	private DoubleUnaryOperator func;
	private double[] xVals;
	private double[] yVals;
	
	// Konstruktor
	public Formula(DoubleUnaryOperator func) {
		this.func = func;
		this.xVals = calculateXValsSmooth();
		this.yVals = calculateYVals();
		
	}
	
	// Array mit X-Werten erstellen ("geglättet")
	private double[] calculateXValsSmooth() {
		double[] xVals = new double[2000];
		double val = -1000;
		for (int i=0; i<2000; i ++) {
			xVals[i] = val/100;
			val++;
		}
		return xVals;
	}
	
	// Array mit X-Werten erstellen (einfach; -10 bis 10 einschl.)
		private double[] calculateXVals() {
			double[] xVals = new double[21];
			double val = -10;
			for (int i=0; i<=20; i++) {
				xVals[i] = val;
				val++;
			}
			return xVals;
		}
	
	// Y Werte werden mit Hilfe der Formel per Stream erzeugt
	private double[] calculateYVals() {
		double[] yVals = DoubleStream.of(this.xVals).map(func).toArray();
		return yVals;
	}
	
	// Getter
	public double[] getxVals() {
		return xVals;
	}

	public double[] getyVals() {
		return yVals;
	}
	
	
	
}
