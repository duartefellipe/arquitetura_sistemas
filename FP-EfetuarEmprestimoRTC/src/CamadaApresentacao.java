import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import camada_dominio.ControladorEfetuarEmprestimo;
import camada_dominio.EfetuarEmprestimoRT;
import camada_dominio.padrao_comando.Comando;
import entidades.SituacaoLeitorDTO;
/*
 * Inicialmente vai simular a camada de apresentacao do diagrama de sequência
 */
public class CamadaApresentacao {
  public static void main(String[] args) {
	  
	int idLeitor = 13;
	List<Integer> livrosSolicitados = new ArrayList<Integer>();
	livrosSolicitados.add(1);
	
	// lista de livros que serao emprestados
	List<Integer> emprestimos = new ArrayList<Integer>();
	EfetuarEmprestimoRT roteiro = new EfetuarEmprestimoRT();
	
	// passo 1.1
	ControladorEfetuarEmprestimo ctrComando = new ControladorEfetuarEmprestimo();
	
	SituacaoLeitorDTO st = (SituacaoLeitorDTO) ctrComando.servico(ControladorEfetuarEmprestimo.Tipos.INICIAR_EMPRESTIMO ,idLeitor);
	
	for (Integer idLivro: livrosSolicitados) {
		// passo 2.1
		Date dataDev = (Date) ctrComando.servico(ControladorEfetuarEmprestimo.Tipos.EMPRESTAR_LIVRO ,idLivro,emprestimos);
	}
	//passo 3.1
	ctrComando.servico(ControladorEfetuarEmprestimo.Tipos.ENCERRAR_EMPRESTIMO ,idLeitor,emprestimos);
  }
}
