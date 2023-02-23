package entidades;

import entidades.result_set.Tabela;

public class TabelaLeitor extends Tabela{

	public TabelaLeitor() {
		super("Leitor");

		// atributos que apareceram no modelo conceitual
		this.addColuna("id");
		this.addColuna("nome");
		
		// atributo derivado criado no projeto
		this.addColuna("situacaoLeitor");
	}

	public void addNovoLeitor(int idLeitor, String nomeLeitor) {	
		Linha novaLinha = new LinhaTabelaLeitor(idLeitor,nomeLeitor);
		this.addLinha(novaLinha);
	}
//	
//	public  TableLeitorRow getRow(int rowId) {
//		return (TableLeitorRow)getRow(rowId);
//	}
}
