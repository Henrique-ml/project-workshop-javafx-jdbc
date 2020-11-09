package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable{

	private Department entity;
	
	// Deped�ncia
	private DepartmentService service;
	
	// Inje��o de depend�ncia por meio da Invers�o de controle
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
		
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
	
	public void setDeparment(Department entity) {
		this.entity = entity;
	}
	
	// Agora o <Button> "btSave" ir� ter a funcionalidade de salvar OU atualizar um Department
	@FXML 
	public void OnBtSaveAction(ActionEvent event) {
		
		// Programa��o defensiva caso o programador se esque�a de fazer a inje��o do Department entity e do DepartmentService service
		// Faz-se essa Programa��o defensiva pois as Inje��es de Depend�ncia est�o sendo feitas manualmente e n�o com um Framework e etc
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		// try-catch: pois se est� mexendo com banco de dados (o m�todo saveOrUpdate())
		try {
			// - getFormData(): vai retornar os dados das <TextField> Id e Name e instanciar um Department 
			entity = getFormData();
			
			// Agora o objeto "entity" � o objeto dos <TextField> que vai ter OU N�O um Id
			// - saveOrUpdate(): o m�todo ir� checar se o objeto "entity" tem Id == 0 (salvar) OU Id != 0 (atualizar)
			service.saveOrUpdate(entity);
			
			// Fechar a janela depois que o Department foi salvo OU atualizado
			// - Utils.currentStage(event): Refer�ncia para a View atual, ou seja, a View do DepartmentForm
			// - close(): fecha a View do DepartmentForm
			Utils.currentStage(event).close();
		}
		catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	private Department getFormData() {
		Department obj = new Department();
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		
		return obj;
		
	}

	// Agora o <Button> btCancel fecha View do DepartmentForm
	@FXML 
	public void OnBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}
	
	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}
}
