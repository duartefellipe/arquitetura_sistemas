package entidades;

import java.util.Date;

import entidades.result_set.Tabela;

public class TabelaEmprestimo extends Tabela {
	
	public TabelaEmprestimo() {
		super("emprestimo");

		// atributos que apareceram no modelo conceitual
		this.addColuna("idEmprestimo");
		this.addColuna("idLeitor");
		this.addColuna("idLivro");
		this.addColuna("dataEmprestimo");
		this.addColuna("dataDevolucao");

	}

	public void addNovoEmprestimo(int idLeitor, int idLivro) {
		Linha novaLinha = new LinhaTabelaEmprestimo(linhas.size(),idLeitor,idLivro, new Date(), null);
		this.addLinha(novaLinha);
	}

}
