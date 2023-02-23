package camada_dominio;

import java.util.List;

import camada_dados.CamadaDadosInterface;
import camada_dados.CamadaDadosMock;
import entidades.EmprestimoDTO;
import entidades.LeitorDTO;
import entidades.SituacaoLeitorDTO;

public class LeitorMDS {
	
	// implementando o padrao Singleton
	private static LeitorMDS instance = null;
	private int idLeitor;
	
	private LeitorMDS(int idLeitor) {
		this.idLeitor = idLeitor;
	}

	public static LeitorMDS getInstance(int idLeitor) {
		if (instance  == null)
			instance = new LeitorMDS(idLeitor);
		return instance;
	}
	
	public static CamadaDadosInterface dados = new CamadaDadosMock();
	private String nome;
	


	public static LeitorMDS buscarLeitor(int idLeitor) {
		
		//1.2.1.1
		LeitorDTO dto = dados.buscarLeitor(idLeitor);
		
		LeitorMDS leitorEncontrado = getInstance(idLeitor);
		leitorEncontrado.nome = dto.getNome();
		
		return leitorEncontrado;
	}

	public SituacaoLeitorDTO getSituacaoAtual() {
		
		//1.2.2.1
		List<EmprestimoDTO> nc = dados.buscaNConcluidos(idLeitor);
		
		SituacaoLeitorDTO st = null;
		if (nc.isEmpty()) {
			//1.2.2.2
			st = new SituacaoLeitorDTO(nome, true);
		}
		return st;
	}

	public int getId() {
		return idLeitor;
	}

}
