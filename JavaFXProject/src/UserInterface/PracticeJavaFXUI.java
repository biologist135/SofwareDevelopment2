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

//Class that extends the application class.
public class PracticeJavaFXUI extends Application{
//Overridden start method Polymorphism. implements the stage, border pane, and menu bar.
	@Override
	public void start(Stage primaryStage) {
	primaryStage.setTitle("User Interface Project");
	BorderPane root = new BorderPane();
	MenuBar menuBar = new MenuBar();
	
	//Creates the menu, and menu items.
	Menu menu = new Menu("options");
	MenuItem dateTimeItem = new MenuItem("Show Date and Time");
	MenuItem saveItem = new MenuItem("Save Date and Time");
	MenuItem greenItem = new MenuItem("Green Background");
	MenuItem exitItem = new MenuItem("Exit");
	
	//Adds all of the menu items to menu and adds menu to menu bar.
	menu.getItems().addAll(dateTimeItem, saveItem, greenItem, exitItem);
	menuBar.getMenus().add(menu);
	//Creates text area, and a VBox. Provides a location for the VBox that is center of the window.
	TextArea text = new TextArea();
	VBox centerBox = new VBox();
	centerBox.setAlignment(Pos.CENTER);
	
	//Provides demensions of the text box, and puts the text box in the VBox, to control its location.
	text.setPrefWidth(300);
	text.setPrefHeight(100);
	text.setMaxWidth(300);
	text.setMaxHeight(100);
	centerBox.getChildren().add(text);
	
	//Allocates the menu bar to the top of the border pane, and add the VBox to the center of the border pane.
	root.setTop(menuBar);
	root.setCenter(centerBox);
	//Introduces random object.
	Random random = new Random();
	
	//Sets action event for the dateTimeItem menu item. Pulls current date and time, and formats it, and then allocates 
	//It as a string to text box.
	dateTimeItem.setOnAction(event-> {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		text.setText(now.format(formatter));
		
	});
	
	/*Sets action even for the saveItem menu item. Implements a file writer, writes what is in the text box to the file. it then closes file
	Includes try catch for the IO.
	When the file is saved, it posts that in the text file.*/
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
	//Action event for greenItem menu item. Uses RGB values and the random object to get random numbers within a specific value.
	//Increased the green value to ensure it was a "green hue"
	greenItem.setOnAction(event->{
		int redValue = random.nextInt(80);
		int greenValue = random.nextInt(156) +100;
		int blueValue = random.nextInt(80);
		
		//Takes the rgb colors and formats it so that the set style method will accept values. Sets the style for the background
		String rgbColor = String.format("rgb(%d, %d, %d)", redValue, greenValue, blueValue);
		root.setStyle("-fx-background-color: " + rgbColor + ";");
		
		//Changes the menu items text to reflect the RGB Values that were selected for the current background color.
		greenItem.setText("Green Hue: RGB(" + redValue+ "," + greenValue + "," + blueValue+ ")");
		
	});
	//Allows the application to close when using the exitItem menu item.
	exitItem.setOnAction(event -> {
        Platform.exit();
    });
	
	//Creates a scene with dimensions and the border pane
	Scene scene = new Scene(root, 500, 350);
		//Adds the scene to the stage
        primaryStage.setScene(scene);
        //Makes the stage visible
        primaryStage.show();
}
	//Launch(args) in main.
	public static void main(String[] args) {
		launch(args);
	}
	
}

