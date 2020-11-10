// Exce��o para validar um formul�rio
// Ir� carregar as mensagens de erro caso existam

package model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// Serve para guardar quais s�o os erros dos campos <TextField> Id e Name da View DepartmentForm
	private Map<String, String> errors = new HashMap<>(); // <nome do campo, mensagem de erro>
	
	// For�ar insntancia��o da exce��o com um construtor
	public ValidationException(String msg) {
		super(msg);
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	// M�todo que permitir� adicionar um elemento na cole��o "errors"
	public void addError(String fieldName, String errorMessage) {
		errors.put(fieldName, errorMessage);
	}
}
