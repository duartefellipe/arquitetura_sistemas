package camada_dominio.excecoes;

public class LivroIndisponivelExcecao extends Exception{

	private Integer idLivro;

	public LivroIndisponivelExcecao(Integer idLivro) {
		this.idLivro = idLivro;
	}

}
