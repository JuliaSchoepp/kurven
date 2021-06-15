package view;

import control.CanvasController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private Canvas canvas;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Formeln");

        initRoot();
	}
	
	
	public void initRoot() {
		// Rahmen
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10,10,10,10));
		Label header = new Label("Darstellung einiger mathematischer Formeln:");
		header.setFont(new Font(20));
		header.setAlignment(Pos.CENTER);
		pane.setTop(header);
		
		// Canvas
		Canvas canvas = new Canvas(500,500);
		this.canvas = canvas;
		CanvasController control = new CanvasController(canvas);
		control.drawEmpty();
		pane.setCenter(canvas);
		
		// Button-Bereich
		GridPane buttonPane = new GridPane();
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(10,10,10,10));
		pane.setBottom(buttonPane);
		
		// Buttons: create, arrange, set on action
		Button halbX = new Button("y = 0,5x");
		halbX.setPrefWidth(150);
		halbX.setOnAction(e -> control.drawHalbX());
		Button x = new Button("y = x");
		x.setPrefWidth(150);
		x.setOnAction(e -> control.drawX());
		Button zweiX = new Button("y = 2x");
		zweiX.setPrefWidth(150);
		zweiX.setOnAction(e -> control.draw2X());
		Button quadKlein = new Button("y = 0,1 x^2");
		quadKlein.setPrefWidth(150);
		quadKlein.setOnAction(e -> control.drawquadkl());
		Button quad = new Button("y = x^2");
		quad.setOnAction(e -> control.drawQuad());
		quad.setPrefWidth(150);
		Button quadGroß = new Button("y = 10x^2");
		quadGroß.setOnAction(e -> control.drawQuadGr());
		quadGroß.setPrefWidth(150);
		Button sin1 = new Button("y = 3sin(xpi/10)");
		sin1.setPrefWidth(150);
		sin1.setOnAction(e -> control.drawSin1());
		Button sin2 = new Button("y = 6sin(xpi/10)");
		sin2.setOnAction(e -> control.drawSin2());
		sin2.setPrefWidth(150);
		Button sin3 = new Button("y = 6sin(xpi/5)");
		sin3.setPrefWidth(150);
		sin3.setOnAction(e -> control.drawSin3());
		Button four = new Button("y = 5sin(x*pi/10) + (5/3)sin(3x*pi/10) + sin(x*pi/2) + (5/7)sin(7x*pi/10)");
		four.setPrefWidth(450);
		four.setOnAction(e -> control.drawFour());
		
		buttonPane.add(halbX, 0, 0);
		buttonPane.add(x, 1, 0);
		buttonPane.add(zweiX, 2, 0);
		buttonPane.add(quadKlein, 0, 1);
		buttonPane.add(quad, 1, 1);
		buttonPane.add(quadGroß, 2, 1);
		buttonPane.add(sin1, 0, 2);
		buttonPane.add(sin2, 1, 2);
		buttonPane.add(sin3, 2, 2);
		buttonPane.add(four, 0,3,3,1);
		
		// Zeigen
		Scene scene = new Scene(pane);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
