package camada_dominio;

import java.util.Iterator;
import java.util.List;

import entidades.Linha;
import entidades.result_set.Resultset;
import entidades.result_set.Tabela;

public class LeitorMTE {

	public static Resultset getSituacaoAtual(Resultset rs, int idLeitor) {
		
		//1.2.1
		rs.set("situacaoLeitor", true);
		
		//1.2.2
		Iterator<Linha> it = rs.getLinhas("emprestimo");
		
		while(it.hasNext()) {
			Linha linha = it.next();
			int idEmprestimo = linha.getInt("idEmprestimo");
			
			//1.2.3
			if (EmprestimoMTE.getSituacaoAtual(rs, idEmprestimo) == false) {
				//1.2.4
				rs.set("situacaoLeitor", false);
				break;
			};
			
		}
		
		return rs;
	}
	
	

}
