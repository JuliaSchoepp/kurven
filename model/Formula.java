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
		this.xVals = calculateXVals();
		this.yVals = calculateYVals();
		
	}
	
	// Array mit X-Werten erstellen (-100 bis 100, um etwas zu glätten)
	private double[] calculateXVals() {
		double[] xVals = new double[200];
		double val = -100;
		for (int i=0; i<200; i++) {
			xVals[i] = val;
			val++;
		}
		return xVals;
	}
	
	// Y Werte werden mit Hilfe der Formel erzeugt
	private double[] calculateYVals() {
		double[] yVals = DoubleStream.of(this.xVals).map(func).toArray();
		return yVals;
	}
	
	// Getter, just in Case
	public DoubleUnaryOperator getFunc() {
		return func;
	}

	public double[] getxVals() {
		return xVals;
	}

	public double[] getyVals() {
		return yVals;
	}
	
	
	
}
