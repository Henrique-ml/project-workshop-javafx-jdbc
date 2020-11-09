/* 
	// Interface que permite um objeto "escutar" um evento de outro objeto
	// Esse outro objeto quando alterar os dados ele ir� emitir o evento
	// E o objeto que receber o Listener/Observer vai fazer alguma a��o quando esse evento for recebido
	
	
	
	
	// ------  ATUALIZAR A LISTA <TableView> DE Departments QUANDO SOFRER ALTERA��O  ------  //

	Padr�o de Projeto Observer (ideia de evento) 
	- programa��o de alto n�vel
	- forma de comunicar objetos (classes) de maneira altamente desacoplacada o objeto (classe) SUBJECT n�o conhece o objeto (classe) OBSERVER 
	- muito utilizado em qualquer aplica��o que lida com eventos, seja eventos de tela, servidor, etc


	Esta etapa � para a lista ser atualizada quando tiver alguma altera��o nela
	Ou seja, quando for salvo OU atualizado algum Department
	
	Para fazer isso � preciso:

	1) A View de DepartmentFormController (SUBJECT) salvar OU atualizar a <TableView> de Departments
	2) Quando a View de DepartmentFormController emitir um evento a View DepartmentListController (OBSERVER) receber� esse evento
	3) A listinha de Departments <TableView> tableViewDepartment atualizar� automaticamente

	- (SUBJECT): classe que emite um evento
	- (OBSERVER): classe que recebe um evento
*/
package gui.listeners;

public interface DataChangeListener {

	void onDataChanged();
}
