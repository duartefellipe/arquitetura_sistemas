package entidades.result_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import entidades.Linha;

public class Tabela {
	
	private Map<String, Coluna> colunas;
	protected List<Linha> linhas;
	private String nome;
	
	public Tabela(String nome) {
		this.nome = nome;
		colunas = new HashMap<String, Coluna>();
		linhas = new ArrayList<Linha>();
	}
	
	public void addColuna(String nomeColuna) {
		colunas.put(nomeColuna, new Coluna(nomeColuna));
	}
	
	public void addLinha(Linha novaLinha) {
		linhas.add(novaLinha);
	}

	public  Linha getLinha(int idLinha) {
		return linhas.get(idLinha);
	};
	
	public Iterator<Linha> iterador() {
		return linhas.iterator();
	}

}
