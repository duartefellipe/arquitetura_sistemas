package camada_dominio;

import java.util.Date;
import java.util.List;

import camada_dados.CamadaDadosInterface;
import camada_dominio.padrao_comando.Comando;
import entidades.EmprestimoDTO;
import entidades.LeitorDTO;
import entidades.LivroDTO;
import entidades.SituacaoLeitorDTO;

public class EncerrarEmprestimoRTC implements Comando {

	private int idLeitor;
	private CamadaDadosInterface dados;
	private List<Integer> emprestimos;

	public EncerrarEmprestimoRTC(int idLeitor, List<Integer> emprestimos, CamadaDadosInterface dados) {
		this.idLeitor = idLeitor;
		this.dados = dados;
		this.emprestimos = emprestimos;
	}

	@Override
	public Object executar() {
		for (Integer idLivro : emprestimos) {
			//3.1.1
			LivroDTO livro = dados.buscarLivro(idLivro);
			//3.1.2
			List<EmprestimoDTO>nc = dados.buscaEmpLivroNConcluidos(idLivro);
			Date dataEmprestimo = new Date();
			Date dataDevolucao = Comando.calculaDataDevolucao(dataEmprestimo); 
			//3.1.3
			if(nc.isEmpty()) dados.armazenaEmprestimoLivro(idLeitor, idLivro, dataEmprestimo, dataDevolucao);
		} 
		
		return null;
	}

}
