package camada_dominio;

import java.util.Date;
import java.util.List;

import camada_dados.CamadaDadosMock;
import camada_dados.CamadaDadosInterface;
import entidades.EmprestimoDTO;
import entidades.LeitorDTO;
import entidades.LivroDTO;
import entidades.SituacaoLeitorDTO;

public class EfetuarEmprestimoRT {
	public CamadaDadosInterface dados = new CamadaDadosMock(); 
	
	
	private Date calculaDataDevolucao(Date dataEmprestimo) {
		Long prazo = (3600000L)*24*30;
		return new Date(dataEmprestimo.getTime() + prazo);
	}	
	

	public SituacaoLeitorDTO iniciarEmprestimo(int idLeitor){
		//1.1.1
		LeitorDTO leitor = dados.buscarLeitor(idLeitor);
		//1.1.2
		List<EmprestimoDTO>nc = dados.buscaNConcluidos(idLeitor);
		
		SituacaoLeitorDTO st = null;
		if(nc.isEmpty()){
			//1.1.3
			String nome = leitor.getNome();
			//1.1.4
			st = new SituacaoLeitorDTO(nome, true);
		};
		
		return st;
	}

	public Date emprestarLivro(int idLivro, List<Integer> emprestimos) {
		
		//2.1.1
		LivroDTO livro = dados.buscarLivro(idLivro);
		//2.1.2
		List<EmprestimoDTO>nc = dados.buscaEmpLivroNConcluidos(idLivro);
		//2.1.3
		if(nc.isEmpty()) emprestimos.add(idLivro);

		//data atual + 30 dias
		return calculaDataDevolucao(new Date()); 
	}

	public void encerrarEmprestimo(int idLeitor, List<Integer> emprestimos) {
		
		for (Integer idLivro : emprestimos) {
			//3.1.1
			LivroDTO livro = dados.buscarLivro(idLivro);
			//3.1.2
			List<EmprestimoDTO>nc = dados.buscaEmpLivroNConcluidos(idLivro);
			Date dataEmprestimo = new Date();
			Date dataDevolucao = calculaDataDevolucao(dataEmprestimo); 
			//3.1.3
			if(nc.isEmpty()) dados.armazenaEmprestimoLivro(idLeitor, idLivro, dataEmprestimo, dataDevolucao);
		} 
		
		
	}

}
