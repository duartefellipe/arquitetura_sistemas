package entidades;

public class SituacaoLeitorDTO {

	private String nome;
	private boolean situacao;

	public SituacaoLeitorDTO(String nome, boolean situacao) {

		this.nome = nome;
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nome:"+nome+",situacao="+situacao;
	}
}
