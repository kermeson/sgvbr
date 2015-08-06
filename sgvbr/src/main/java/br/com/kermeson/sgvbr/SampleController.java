package br.com.kermeson.sgvbr;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SampleController implements Initializable {
	@FXML
	private Button btnProdutos;

	@FXML
	private void visualizarProdutosAction(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		stage = new Stage();
		root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("fxml/Produtos.fxml"));
		stage.setScene(new Scene(root));
		stage.setTitle("Produtos");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(btnProdutos.getScene().getWindow());
		stage.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
