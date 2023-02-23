package entidades;

import java.util.Date;

public class LinhaTabelaEmprestimo extends Linha {

	public LinhaTabelaEmprestimo(int idEmprestimo, int idLeitor, int idLivro, Date dataEmprestimo, Date dataDevolucao) {
		valores.put("idEmprestimo",idEmprestimo);
		valores.put("idLeitor",idLeitor);
		valores.put("idLivro",idLivro);
		valores.put("dataEmprestimo",dataEmprestimo);
		valores.put("dataDevolucao",dataDevolucao);
	}
	
}
