package camada_dados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.TabelaEmprestimo;
import entidades.TabelaLeitor;
import entidades.TabelaLivro;
import entidades.result_set.Resultset;
import entidades.result_set.Tabela;

/*
 * Classe falsa (Mock) que ira se comportar do jeito que é esperado no Fluxo principal. 
 */
public class CamadaDadosMock implements CamadaDadosInterface {

	@Override
	public Resultset buscaEmprestimosLeitor(int idLeitor) {
		
		//1.1.1
		Resultset rs = new Resultset();
		
		TabelaLeitor tabelaLeitor = new TabelaLeitor();
		rs.addTabela("leitor", tabelaLeitor);
		tabelaLeitor.addNovoLeitor(idLeitor,"joao");
		
		
		TabelaEmprestimo tabelaEmprestimo = new TabelaEmprestimo();
		rs.addTabela("emprestimo", tabelaEmprestimo);
	
		return rs;
	}

	@Override
	public Resultset buscaEmprestimosLivroNConcluido(Integer idLivro) {
		Resultset rs = new Resultset();
		
		TabelaLivro tabelaLivro = new TabelaLivro();
		rs.addTabela("livro", tabelaLivro);
		tabelaLivro.addNovoLivro(idLivro);

		TabelaEmprestimo tabelaEmprestimo = new TabelaEmprestimo();
		rs.addTabela("emprestimo", tabelaEmprestimo);
//		tabelaEmprestimo.addNovoEmprestimo(1, idLivro);
		
	
		return rs;
	}

	@Override
	public Resultset buscaEmprestimosNConcluidos(Resultset rs) {
		TabelaLeitor tabelaLeitor = new TabelaLeitor();
		rs.addTabela("leitor", tabelaLeitor);
		tabelaLeitor.addNovoLeitor(rs.getLinhas("novosEmprestimos").next().getInt("idLeitor"),"joao");
		return rs;
	}

	@Override
	public void armazenarEmprestimos(Resultset rs) {}
		

}
