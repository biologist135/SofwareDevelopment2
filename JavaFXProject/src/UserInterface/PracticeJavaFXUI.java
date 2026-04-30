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
	MenuItem 