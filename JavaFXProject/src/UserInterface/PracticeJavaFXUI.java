package UserInterface;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class PracticeJavaFXUI extends Application{
@Override
	public void start(Stage primaryStage) {
	primaryStage.setTitle("User Interface Project");
	BorderPane root = new BorderPane();
	MenuBar menuBar = new MenuBar();
	
	Menu menu = new Menu("options");
	MenuItem dateTimeItem = new MenuItem("Show Date and Time");
	MenuItem saveItem = new MenuItem("Save Date and Time");
	MenuItem greenItem = new MenuItem("Green Background");
	MenuItem exitItem = new MenuItem("Exit");
	
	menu.getItems().addAll(dateTimeItem, saveItem, greenItem, exitItem);
	menuBar.getMenus().add(menu);
	
	TextArea text = new TextArea();
	VBox centerBox = new VBox();
	centerBox.setAlignment(Pos.CENTER);
	
	text.setPrefWidth(300);
	text.setPrefHeight(100);
	text.setMaxWidth(300);
	text.setMaxHeight(100);
	centerBox.getChildren().add(text);
	
	root.setTop(menuBar);
	root.setCenter(centerBox);
	Random random = new Random();
	
	dateTimeItem.setOnAction(event-> {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		text.setText(now.format(formatter));
		
	});
	saveItem.setOnAction(event-> {
		try{
			FileWriter writer = new FileWriter("log.txt");
			writer.write(text.getText());
			writer.close();
			
			text.appendText("\nsaved to log.txt");
		}catch(IOException e) {
			text.appendText("\nError saving to file");
		}
	});
	
	greenItem.setOnAction(event->{
		int redValue = random.nextInt(80);
		int greenValue = random.nextInt(156) +100;
		int blueValue = random.nextInt(80);
		
		String rgbColor = String.format("rgb(%d, %d, %d)", redValue, greenValue, blueValue);
		root.setStyle("-fx-background-color: " + rgbColor + ";");
		
		greenItem.setText("Green Hue: RGB(" + redValue+ "," + greenValue + "," + blueValue+ ")");
		
	});
	exitItem.setOnAction(event -> {
        Platform.exit();
    });
	
	Scene scene = new Scene(root, 500, 350);

        primaryStage.setScene(scene);

        primaryStage.show();
}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

