package br.com.kermeson.sgvbr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox) FXMLLoader
					.load(Thread.currentThread().getContextClassLoader().getResource("fxml/Sample.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(
					Thread.currentThread().getContextClassLoader().getResource("css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
