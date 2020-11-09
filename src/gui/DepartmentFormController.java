package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable{

	// - entity: a entidade relacionada a esse formul�rio
	private Department entity;
	
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
	
	// Inje��o de depend�ncia por meio da Invers�o de controle
	public void setDeparment(Department entity) {
		this.entity = entity;
	}
	
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
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}
	
	// M�todo respons�vel por: 
	// 1) pegar os dados do objeto "entity"
	// 2) por meio desses dados popular/definir os <TextField> Id e Name da View DepartmentForm
	public void updateFormData() {
		
		// Programa��o defensiva caso o programador se esque�a de  fazer a inje��o do Department entity
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		
		// ------ DEFINIR AS <TextField> txtId e txtName ------ //
		
		// - String.valueOf(): converte o Id do objeto "entity" em String, pois o <TextField> trabalha Strings
		// - setText(): define a caixinha de texto <TextField> com o valor passado, nesse caso o Id
		txtId.setText(String.valueOf(entity.getId()));
		
		txtName.setText(entity.getName());
	}
}
