package camada_dominio;

import java.util.Date;
import java.util.Iterator;

import camada_dominio.excecoes.LivroIndisponivelExcecao;
import entidades.Linha;
import entidades.TabelaEmprestimo;
import entidades.TabelaLeitor;
import entidades.TabelaLivro;
import entidades.result_set.Resultset;

public class EmprestimoMTE {

	public static boolean getSituacaoAtual(Resultset rs, int idEmprestimo) {
		//1.2.3.1
		TabelaEmprestimo emprestimo = (TabelaEmprestimo)rs.getTabela("emprestimo");
		
		//1.2.3.2
		Linha linhaUnica = emprestimo.getLinha(idEmprestimo);
		try {
			Date dataDevolucao = linhaUnica.getDate("dataDevolucao");
			return dataDevolucao.before(new Date());
		} catch (NullPointerException e) {
			return false;
		}
	}

	public static Resultset emprestarLivro(Resultset rs, int idLeitor, int idLivro) {
		// 2.2.1
		Resultset rsSit = LivroMTE.getSituacaoAtual(rs,idLivro);
		
		TabelaEmprestimo novosEmprestimos = (TabelaEmprestimo) rsSit.getTabela("novosEmprestimos");
		
		if (novosEmprestimos == null){
			novosEmprestimos = new TabelaEmprestimo();
			rsSit.addTabela("novosEmprestimos", novosEmprestimos);
		}

		if (rsSit.getLinhas("livro").next().getBoolean("situacaoLivro")) {
			novosEmprestimos.addNovoEmprestimo(idLeitor, idLivro);
		};
		
		return rsSit;
	}

	public static Resultset encerrarEmprestimos(Resultset rs) throws LivroIndisponivelExcecao {
		
		int idLeitor = rs.getLinhas("leitor").next().getInt("idLeitor");

		//3.2.1
		rs = LeitorMTE.getSituacaoAtual(rs, idLeitor);
		
		
		if (rs.getLinhas("leitor").next().getBoolean("situacaoLeitor")) {
			//3.2.2
			Iterator<Linha> it = rs.getLinhas("novosEmprestimos");
			
			while (it.hasNext()) {
				Linha novoEmprestimo = (Linha) it.next();
				int idLivro = novoEmprestimo.getInt("idLivro");
				
				//3.2.3
				rs = LivroMTE.getSituacaoAtual(rs, idLivro);
				
				//3.2.4
				Linha livro = rs.getLinhas("livro").next();
				//3.2.5
				if (livro.getBoolean("situacaoLivro") == false) {
					throw new LivroIndisponivelExcecao(livro.getInt("idLivro"));
				};
			}
		}
		
		return rs;
	}

}
