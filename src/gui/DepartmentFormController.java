package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable{

	@FXML
	private TextField txtId;
	@FXML
	private TextField txtName;
	@FXML
	private Label labelErrorName;
	@FXML
	private Button btSave;
	@FXML
	private Button btCancel;
	
	@FXML 
	public void btSaveAction() {
		System.out.println("btSaveAction");
	}
	
	@FXML 
	public void btCancelAction() {
		System.out.println("btCancelAction");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		// - initializeNodes(): aplica as restri��es quando a View DepartmentForm for iniciada
		initializeNodes();
	}
	
	// M�todo que adiciona restri��es aos <TextField>
	private void initializeNodes() {
		
		// Restringe o <TextField> "txtId" para ter somente n�meros inteiros
		Constraints.setTextFieldInteger(txtId);
		
		// Restringe o <TextField> "txtName" para ter o limite de apenas 30 caracteres
		Constraints.setTextFieldMaxLength(txtName, 30);
	}
}
