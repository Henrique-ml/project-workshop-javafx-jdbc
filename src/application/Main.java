package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Instancia do objeto "new FXMLLoader"
			// Agora � a INST�NCIA e n�o a chamada do M�TODO
			// Importante essa instancia��o para manipula��o da tela antes do carregamento dela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			Parent parent = loader.load(); // Carrega a View (tela)
			Scene mainScene = new Scene(parent); // Instancia o objeto principal da View "AnchorPane"
			primaryStage.setScene(mainScene); // Configura a Scene com o container "AnchorPane" e o que tiver nele
			primaryStage.setTitle("Sample JavaFX application"); // T�tulo da View
			primaryStage.show(); // Mostra tudo (mesmo sem o mainScene mostrar� uma tela branca - sem nada)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
