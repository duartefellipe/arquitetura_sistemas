package camada_dados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.EmprestimoDTO;
import entidades.LeitorDTO;
import entidades.LivroDTO;

/*
 * Classe falsa (Mock) que ira se comportar do jeito que é esperado no Fluxo principal. 
 */
public class CamadaDadosMock implements CamadaDadosInterface {

	@Override
	public LeitorDTO buscarLeitor(int idLeitor) {
		return new LeitorDTO(idLeitor);
	}

	@Override
	public List<EmprestimoDTO> buscaNConcluidos(int idLeitor) {
		// TODO Auto-generated method stub
		return new ArrayList<EmprestimoDTO>();
	}

	@Override
	public LivroDTO buscarLivro(int idLivro) {
		return new LivroDTO(idLivro);
	}

	@Override
	public List<EmprestimoDTO> buscaEmpLivroNConcluidos(int idLivro) {
		return new ArrayList<EmprestimoDTO>();
	}

	@Override
	public void armazenaEmprestimoLivro(int idLeitor, Integer idLivro, Date dataEmprestimo, Date dataDevolucao) {
		// faz nada no fluxo principal
		
	}

}
