import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import camada_dados.CamadaDadosInterface;
import camada_dados.CamadaDadosMock;
import camada_dominio.EmprestimoMTE;
import camada_dominio.LeitorMTE;
import camada_dominio.excecoes.LivroIndisponivelExcecao;
import entidades.TabelaEmprestimo;
import entidades.result_set.Resultset;

/*
 * Inicialmente vai simular a camada de apresentacao do diagrama de sequência
 */
public class CamadaApresentacao {
  public static void main(String[] args) {
	  
	int idLeitor = 13;
	List<Integer> livrosSolicitados = new ArrayList<Integer>();
	livrosSolicitados.add(1);
	livrosSolicitados.add(2);
	livrosSolicitados.add(3);
	
	CamadaDadosInterface dados = new CamadaDadosMock();
	
	//passo 1.1
	Resultset rs = dados.buscaEmprestimosLeitor(idLeitor);
	//passo 1.2
	rs = LeitorMTE.getSituacaoAtual(rs, idLeitor);
	
	TabelaEmprestimo novosEmprestimos = null;
	
	for (Integer idLivro: livrosSolicitados) {
	// passo 2.1
		rs = dados.buscaEmprestimosLivroNConcluido(idLivro);
		rs.addTabela("novosEmprestimos", novosEmprestimos);
		
		rs = EmprestimoMTE.emprestarLivro(rs,idLeitor,idLivro);
		novosEmprestimos = (TabelaEmprestimo) rs.getTabela("novosEmprestimos");
	}	

	//3.1
	rs = dados.buscaEmprestimosNConcluidos(rs);
	
	//3.2
	try {
		rs = EmprestimoMTE.encerrarEmprestimos(rs);
		dados.armazenarEmprestimos(rs);
	} catch (LivroIndisponivelExcecao e) {
		e.printStackTrace();
	}
	
  }
}
