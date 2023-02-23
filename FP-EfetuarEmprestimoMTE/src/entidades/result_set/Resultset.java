package entidades.result_set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import entidades.Linha;
import entidades.TabelaLeitor;
import entidades.TabelaLivro;


public class Resultset {
	
	private Map<String, Tabela> tabelas;

	public Resultset() {
		tabelas = new HashMap<String, Tabela>();
	}

	public void addTabela(String nomeTabela,Tabela novaTabela) {
		tabelas.put(nomeTabela, novaTabela);
	}
	
	public Tabela getTabela(String nomeTabela) {
		return tabelas.get(nomeTabela);
	}
	
	public Iterator<Linha> getLinhas(String nomeTabela){
		Tabela tabela = getTabela(nomeTabela);
		return tabela.iterador();
	};
	
	
	//metodos feitos para facilitar a manipulacao do ResultSet no dominio
	
	private void setSituacaoLeitor(boolean situacaoLeitor) {
		TabelaLeitor leitor = (TabelaLeitor)tabelas.get("leitor");
		Linha linhaUnica = leitor.getLinha(0);
		linhaUnica.setValor("situacaoLeitor", situacaoLeitor);
	}
	
	private void setSituacaoLivro(boolean situacaoLivro) {
		TabelaLivro livro = (TabelaLivro)tabelas.get("livro");
		Linha linhaUnica = livro.getLinha(0);
		linhaUnica.setValor("situacaoLivro", situacaoLivro);
	}
	
	public void set(String acao, boolean situacao) {
		switch (acao) {
		case "situacaoLeitor":
			setSituacaoLeitor(situacao);
			break;
			
		case "situacaoLivro":
			setSituacaoLivro(situacao);
			break;
		default:
			break;
		}
	}

}
