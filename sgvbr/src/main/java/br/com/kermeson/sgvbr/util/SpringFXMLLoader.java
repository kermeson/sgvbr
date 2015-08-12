package br.com.kermeson.sgvbr.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.kermeson.sgvbr.SpringConfiguration;
import br.com.kermeson.sgvbr.ui.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.util.Callback;

public class SpringFXMLLoader {

	private static Logger LOG = Logger.getLogger(SpringFXMLLoader.class);
	private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(
			SpringConfiguration.class);

	public static Controller load(String url) {
		InputStream fxmlStream = null;
		try {
			fxmlStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(url);
			FXMLLoader loader = new FXMLLoader();
			loader.setControllerFactory(new Callback<Class<?>, Object>() {
				@Override
				public Object call(Class<?> aClass) {
					return APPLICATION_CONTEXT.getBean(aClass);
				}
			});

			Node view = (Node) loader.load(fxmlStream);
			Controller controller = loader.getController();
			controller.setView(view);

			return controller;
		} catch (IOException e) {
			LOG.error("Can't load resource", e);
			throw new RuntimeException(e);
		}
	}
}
