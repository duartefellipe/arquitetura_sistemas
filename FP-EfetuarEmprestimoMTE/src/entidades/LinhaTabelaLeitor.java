package entidades;

public class LinhaTabelaLeitor extends Linha {
	
	protected LinhaTabelaLeitor(int idLeitor, String nomeLeitor) {
		valores.put("idLeitor",idLeitor);
		valores.put("nome",nomeLeitor);
	}

	
}
