package camada_dominio;

import java.util.Iterator;

import entidades.Linha;
import entidades.result_set.Resultset;

public class LivroMTE {

	public static Resultset getSituacaoAtual(Resultset rs, int idLivro) {
		//2.2.1.1
		rs.set("situacaoLivro", true);
		//2.2.1.2
		Iterator<Linha> it = rs.getLinhas("emprestimo");
		
		while (it.hasNext()) {
			boolean siti = EmprestimoMTE.getSituacaoAtual(rs, it.next().getInt("idEmprestimo"));
			if (siti == false) {
				//2.2.1.3
				rs.set("situacaoLivro", false);
				break;
			}
		}
		
		return rs;
	}

}
