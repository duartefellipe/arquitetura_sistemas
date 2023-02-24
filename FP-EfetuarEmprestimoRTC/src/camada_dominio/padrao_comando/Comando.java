package camada_dominio.padrao_comando;

import java.util.Date;

public interface Comando {
	Object executar();
	
	public static Date calculaDataDevolucao(Date dataEmprestimo) {
		Long prazo = (3600000L)*24*30;
		return new Date(dataEmprestimo.getTime() + prazo);
	}	
}
