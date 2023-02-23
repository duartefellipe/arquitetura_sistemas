/**
 * 
 */
package entidades;

import entidades.result_set.Tabela;

/**
 * @author Fellipe
 *
 */
public class TabelaLivro extends Tabela {

	public TabelaLivro() {
		super("livro");

		// atributos que apareceram no modelo conceitual
		this.addColuna("id");
		
		// atributo derivado criado no projeto
		this.addColuna("situacaoLivro");
	}

	public void addNovoLivro(Integer idLivro){	
			Linha novaLinha = new LinhaTabelaLivro(idLivro);
			this.addLinha(novaLinha);
	}

}
