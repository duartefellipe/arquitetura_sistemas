package camada_dominio;

import java.util.Date;
import java.util.List;

import camada_dados.CamadaDadosInterface;
import camada_dados.CamadaDadosMock;
import camada_dominio.padrao_comando.Comando;
import entidades.SituacaoLeitorDTO;

public class ControladorEfetuarEmprestimo {
	
	public CamadaDadosInterface dados = new CamadaDadosMock(); 
	
	public enum Tipos {
		INICIAR_EMPRESTIMO, EMPRESTAR_LIVRO, ENCERRAR_EMPRESTIMO
	}
	
	public Object servico(Tipos tipoServico, int idLeitor) {
		switch (tipoServico) {
			case INICIAR_EMPRESTIMO:
				Comando rt = new IniciarEmprestimoRTC(idLeitor, dados);
				return rt.executar();
			default:
				return null;
		}
	}

	public Object servico(Tipos tipoServico, Integer idAlgo, List<Integer> emprestimos) {
		Comando rt;
		switch (tipoServico) {
			case EMPRESTAR_LIVRO:
				rt = new EmprestarLivroRTC(idAlgo,emprestimos, dados);
				return rt.executar();
				
			case ENCERRAR_EMPRESTIMO:
				rt = new EncerrarEmprestimoRTC(idAlgo,emprestimos, dados);
				return rt.executar();
			default:
				return null;
		}
	}		

}
