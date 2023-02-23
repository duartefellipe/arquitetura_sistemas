package camada_dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import camada_dados.CamadaDadosInterface;
import camada_dados.CamadaDadosMock;
import entidades.EmprestimoDTO;
import entidades.SituacaoLeitorDTO;

public class EmprestimoMDS {

	private List<Integer> emprestimos;
	private LeitorMDS leitor;
	public static CamadaDadosInterface dados = new CamadaDadosMock();

	// implementando o padrao Singleton
	private static EmprestimoMDS instance;
	
	private EmprestimoMDS() {
		emprestimos = new ArrayList<Integer>();
	}

	public static EmprestimoMDS getInstance() {
		if (instance == null)
			instance = new EmprestimoMDS();
		return instance;
	}
	
	private Date calculaDataDevolucao(Date dataEmprestimo) {
		Long prazo = (3600000L)*24*30;
		return new Date(dataEmprestimo.getTime() + prazo);
	}	
	
	public SituacaoLeitorDTO iniciarEmprestimo(int idLeitor) {
		
		//1.2.1
		LeitorMDS leitor = LeitorMDS.buscarLeitor(idLeitor);
		this.leitor = leitor;
		//1.2.2
		SituacaoLeitorDTO st = leitor.getSituacaoAtual();
		
		return st;
	}

	public Date emprestarLivro(Integer idLivro) {
		//2.1.1
		LivroMDS livro = LivroMDS.buscarLivro(idLivro);
		
		//2.1.2
		List<EmprestimoDTO>nc = livro.buscaEmprestimosNConcluidos();
		
		//2.1.3
		if(nc.isEmpty()) emprestimos.add(idLivro);

		//data atual + 30 dias
		return calculaDataDevolucao(new Date()); 
		
	}

	public void encerrarEmprestimo() {
		
		//3.1.1
		Iterator<Integer> it = emprestimos.iterator();
		while(it.hasNext()) {
			Integer idLivro = it.next();
			
			//3.1.2
			SituacaoLeitorDTO st = leitor.getSituacaoAtual();
			if (st.getSituacao()) {
				//3.1.3
				LivroMDS livro = LivroMDS.buscarLivro(idLivro);
				//3.1.4
				List<EmprestimoDTO> ncl = livro.buscaEmprestimosNConcluidos();

				//3.1.5
				if (ncl.isEmpty()) {
					Date dataEmprestimo = new Date();
					Date dataDevolucao = calculaDataDevolucao(dataEmprestimo);
					dados.armazenaEmprestimoLivro(leitor.getId(),idLivro, dataEmprestimo,dataDevolucao);
				};
				
			}
		}
	}

}
