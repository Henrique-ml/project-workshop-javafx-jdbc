package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.entities.DepartmentService;

public class DepartmentListController implements Initializable{
	
	// N�O FAZER - para n�o ter um forte acomplamento
	// private DepartmentService service = new DepartmentService(); 
	
	private DepartmentService service;

	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML	
	private TableColumn<Department, Integer> tableColumnId; // <tipo da <TableView> que a coluna est� inserida, tipo da coluna>
	@FXML
	private TableColumn<Department, String> tableColumnName;
	@FXML
	private Button btNew;
	
	// Carregar os departamentos nessa lista "obsList" com o m�todo updateTableView()
	// Depois associar esses Departments com a <TableView> para os Departments aparecerem nela
	private ObservableList<Department> obsList;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	
	// FAZER - Inje��o de depend�ncia por meio da Invers�o de controle
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
	
	// M�todo faz:
	// 1) acessa o objeto "service" 
	// 2) carrega os Departments em uma lista
	// 3) manda esses Departments para a lista "obsList" instanciando essa "obsList"
	// 4) carrega os itens na <TabelView> e mostrar na tela
	public void updateTableView() {
		
		// Como a inje��o de depend�ncia � manual, sem uso de frameworks ou containers de inje��o autom�tica
		// Ent�o caso o programador esque�a de injetar a depend�ncia, n�o ter� como usar os servi�os da classe DepartmentService
		// Por isso lan�ar uma exce��o caso o service for NULL (n�o tenha injetado a depend�ncia)
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		// 1) e 2)
		List<Department> list = service.findAll();
		
		// 3)
		obsList = FXCollections.observableArrayList(list);
		
		// 4)
		tableViewDepartment.setItems(obsList);
	}

}
