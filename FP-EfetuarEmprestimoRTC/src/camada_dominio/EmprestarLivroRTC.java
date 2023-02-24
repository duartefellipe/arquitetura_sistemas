package camada_dominio;

import java.util.Date;
import java.util.List;

import camada_dados.CamadaDadosInterface;
import camada_dominio.padrao_comando.Comando;
import entidades.EmprestimoDTO;
import entidades.LeitorDTO;
import entidades.LivroDTO;
import entidades.SituacaoLeitorDTO;

public class EmprestarLivroRTC implements Comando {

	private int idLivro;
	private CamadaDadosInterface dados;
	private List<Integer> emprestimos;

	public EmprestarLivroRTC(int idLeitor, List<Integer> emprestimos, CamadaDadosInterface dados) {
		this.idLivro = idLivro;
		this.dados = dados;
		this.emprestimos = emprestimos;
	}

	@Override
	public Object executar() {
		//2.1.1
		LivroDTO livro = dados.buscarLivro(idLivro);
		//2.1.2
		List<EmprestimoDTO>nc = dados.buscaEmpLivroNConcluidos(idLivro);
		//2.1.3
		if(nc.isEmpty()) emprestimos.add(idLivro);

		//data atual + 30 dias
		return Comando.calculaDataDevolucao(new Date()); 
	}

}
