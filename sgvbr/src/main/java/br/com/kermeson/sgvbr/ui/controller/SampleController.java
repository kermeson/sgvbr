package br.com.kermeson.sgvbr.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import br.com.kermeson.sgvbr.util.SpringFXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

@Component
public class SampleController extends AbstractController implements Initializable {
	@FXML
	private Button btnProdutos;

	@FXML
	private void visualizarProdutosAction(ActionEvent event) throws IOException {

		ProdutosController produtosController = (ProdutosController) SpringFXMLLoader.load("fxml/Produtos.fxml");
		final Stage stage = new Stage();
		stage.setScene(new Scene((Parent) produtosController.getView()));
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
