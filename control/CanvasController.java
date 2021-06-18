package control;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.Formula;

public class CanvasController {
	
	private Canvas canvas;
	private GraphicsContext gc;
	
	public CanvasController(Canvas canvas) {
		this.canvas = canvas;
		this.gc = this.canvas.getGraphicsContext2D();
	}
	
	// Canvas wird geleert und Achsen gezeichnet und beschriftet
	public void drawEmpty() {
		gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
		gc.strokeLine(0,250,500,250);
		gc.strokeLine(250, 0, 250, 500);
		gc.strokeText("-10", 0, 265);
		gc.strokeText("-5", 125, 265);
		gc.strokeText("5", 375, 265);
		gc.strokeText("10", 485, 265);
		gc.strokeText("-10", 230, 495);
		gc.strokeText("-5", 230, 375);
		gc.strokeText("5", 230, 125);
		gc.strokeText("10", 230, 10);
		
	}
	
	public void draw(DoubleUnaryOperator op) {
		// Values aus Model errechnen
		Formula formula = new Formula(op);
		double[] xVals = formula.getxVals();
		double[] yVals = formula.getyVals();
		// Transform from cartesian to computer system
		double[] xtransf = DoubleStream.of(xVals).map(x -> x*25 + 250).toArray();
		double[] ytransf = DoubleStream.of(yVals).map(x -> x*(-25) + 250).toArray();
		// draw line
		gc.beginPath();
		gc.moveTo(xtransf[0], ytransf[0]);
		for (int i =1; i<xtransf.length; i++) {
			gc.lineTo(xtransf[i], ytransf[i]);
		}
		gc.closePath(); // wahrscheinlich Falsch, da Form geschlossen wird -> Linie zurück
		gc.stroke();
	}
	
	
	public void drawHalbX() {
		drawEmpty();
		DoubleUnaryOperator halbX = x -> 0.5*x;
		draw(halbX);
	}
	
	public void drawX() {
		drawEmpty();
		DoubleUnaryOperator xnorm = x -> x;
		draw(xnorm);
	}

	public void draw2X() {
		drawEmpty();
		DoubleUnaryOperator zweiX = x -> 2*x;
		draw(zweiX);
	}

	public void drawquadkl() {
		drawEmpty();
		DoubleUnaryOperator quadKl = x -> 0.1*x*x;
		draw(quadKl);
	}
	
	public void drawQuad() {
		drawEmpty();
		DoubleUnaryOperator quad = x -> x*x;
		draw(quad);
	}
	
	public void drawQuadGr() {
		drawEmpty();
		DoubleUnaryOperator quadGr = x -> 10*x*x;
		draw(quadGr);
	}

	public void drawSin1() {
		drawEmpty();
		DoubleUnaryOperator sin1 = x -> 3*Math.sin(x*Math.PI/10);
		draw(sin1);
	}

	public void drawSin2() {
		drawEmpty();
		DoubleUnaryOperator sin2 = x -> 6*Math.sin(x*Math.PI/10);
		draw(sin2);
	}

	public void drawSin3() {
		drawEmpty();
		DoubleUnaryOperator sin3 = x -> 6*Math.sin(x*Math.PI/5);
		draw(sin3);
	}

	public void drawFour() {
		drawEmpty();
		DoubleUnaryOperator four = x -> 5*Math.sin(x*Math.PI/10)+(5/3)*Math.sin(3*x*Math.PI/10)+
				Math.sin(x*Math.PI/2)+5*(5/7)*Math.sin(7*x*Math.PI/10);
		draw(four);
	}
	
	
	
}
