import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import camada_dominio.EmprestimoMDS;
import entidades.SituacaoLeitorDTO;
/*
 * Inicialmente vai simular a camada de apresentacao do diagrama de sequência
 */
public class CamadaApresentacao {
  public static void main(String[] args) {
	  
	int idLeitor = 13;
	List<Integer> livrosSolicitados = new ArrayList<Integer>();
	livrosSolicitados.add(1);
	
	//passo 1.1
	EmprestimoMDS md = EmprestimoMDS.getInstance();
	
	// passo 1.2
	SituacaoLeitorDTO st = md.iniciarEmprestimo(idLeitor);
	
	for (Integer idLivro: livrosSolicitados) {
	// passo 2.1
		Date dataDev = md.emprestarLivro(idLivro); 
	}	
	
	
	//passo 3.1
	md.encerrarEmprestimo();
  }
}
