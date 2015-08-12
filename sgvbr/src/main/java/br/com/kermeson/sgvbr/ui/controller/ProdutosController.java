package br.com.kermeson.sgvbr.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.kermeson.sgvbr.entity.Produto;
import br.com.kermeson.sgvbr.service.ProdutoService;
import br.com.kermeson.sgvbr.util.SpringFXMLLoader;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

@Component
public class ProdutosController extends AbstractController implements Initializable {

	@FXML
	private TableView<Produto> tbProdutos;
	@FXML
	private TableColumn<Produto, Long> colId;
	@FXML
	private TableColumn<Produto, String> colNome;
	@FXML
	private Button btnAdicionar;

	@Autowired
	private ProdutoService produtoService;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colId.setCellValueFactory(new PropertyValueFactory<Produto, Long>("id"));
		colNome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));

	}

	@FXML
	private void adicionarProdutoAction(ActionEvent event) throws IOException {
		ProdutoController produtoController = (ProdutoController) SpringFXMLLoader.load("fxml/Produto.fxml");
		final Stage stage = new Stage();
		stage.setScene(new Scene((Parent) produtoController.getView()));
		stage.setTitle("Cadastrar Produto");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(btnAdicionar.getScene().getWindow());
		stage.showAndWait();
	}

	public TableView<Produto> getTbProdutos() {
		return tbProdutos;
	}

	public void setTbProdutos(TableView<Produto> tbProdutos) {
		this.tbProdutos = tbProdutos;
	}

	public void atualizarProdutos() {
		tbProdutos.setItems(FXCollections.observableArrayList(produtoService.buscarTodos()));
	}

}
