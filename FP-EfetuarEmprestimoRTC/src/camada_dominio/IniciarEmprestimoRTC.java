package camada_dominio;

import java.util.List;

import camada_dados.CamadaDadosInterface;
import camada_dominio.padrao_comando.Comando;
import entidades.EmprestimoDTO;
import entidades.LeitorDTO;
import entidades.SituacaoLeitorDTO;

public class IniciarEmprestimoRTC implements Comando {

	private int idLeitor;
	private CamadaDadosInterface dados;

	public IniciarEmprestimoRTC(int idLeitor, CamadaDadosInterface dados) {
		this.idLeitor = idLeitor;
		this.dados = dados;
	}

	@Override
	public Object executar() {
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

}
