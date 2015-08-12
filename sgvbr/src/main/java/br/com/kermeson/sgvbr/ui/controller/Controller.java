package br.com.kermeson.sgvbr.ui.controller;

import javafx.scene.Node;

public interface Controller {
	Node getView();

	void setView(Node view);
}