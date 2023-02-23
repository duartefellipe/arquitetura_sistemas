package entidades;

public class LeitorDTO {

	private String nome;
	private int idLeitor;

	public LeitorDTO(int idLeitor) {
		this.idLeitor = idLeitor;
	}

	public String getNome() {
		return nome;
	}

}
