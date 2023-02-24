package camada_dados;

import java.util.Date;
import java.util.List;

import entidades.EmprestimoDTO;
import entidades.LeitorDTO;
import entidades.LivroDTO;

/*
 * Fachada que representa todos os metodos que serao chamados na camada de dados
 */
public interface CamadaDadosInterface {

	LeitorDTO buscarLeitor(int idLeitor);
	List<EmprestimoDTO> buscaNConcluidos(int idLeitor);
	LivroDTO buscarLivro(int idLivro);
	List<EmprestimoDTO> buscaEmpLivroNConcluidos(int idLivro);
	void armazenaEmprestimoLivro(int idLeitor, Integer idLivro, Date dataEmprestimo, Date dataDevolucao);

}
