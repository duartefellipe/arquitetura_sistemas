package camada_dados;

import java.util.Date;
import java.util.List;

import entidades.result_set.Resultset;

/*
 * Fachada que representa todos os metodos que serao chamados na camada de dados
 */
public interface CamadaDadosInterface {

	Resultset buscaEmprestimosLeitor(int idLeitor);
	Resultset buscaEmprestimosLivroNConcluido(Integer idLivro);
	Resultset buscaEmprestimosNConcluidos(Resultset rs);
	void armazenarEmprestimos(Resultset rs);

}
