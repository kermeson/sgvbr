package br.com.kermeson.sgvbr.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.kermeson.sgvbr.entity.Produto;
import br.com.kermeson.sgvbr.service.ProdutoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class ProdutoController extends AbstractController implements Initializable {

	@FXML
	private Button btnSalvar;

	@FXML
	private TextField txtFieldNome;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutosController produtosController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	private void salvarProdutoAction(ActionEvent event) throws IOException {
		Produto produto = new Produto();
		produto.setNome(txtFieldNome.getText());
		produtoService.incluir(produto);

		Stage stage = (Stage) getView().getScene().getWindow();
		stage.close();
		produtosController.atualizarProdutos();
	}

}
