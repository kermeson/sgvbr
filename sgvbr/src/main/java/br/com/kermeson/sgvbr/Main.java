package br.com.kermeson.sgvbr;

import br.com.kermeson.sgvbr.ui.controller.SampleController;
import br.com.kermeson.sgvbr.util.SpringFXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			SampleController produtosController = (SampleController) SpringFXMLLoader.load("fxml/Sample.fxml");
			Scene scene = new Scene((Parent) produtosController.getView(), 400, 400);
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
