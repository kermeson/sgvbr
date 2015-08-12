package br.com.kermeson.sgvbr.ui.controller;

import javafx.scene.Node;

public abstract class AbstractController implements Controller {
	private Node view;

	@Override
	public Node getView() {
		return view;
	}

	@Override
	public void setView(Node view) {
		this.view = view;
	}
}
