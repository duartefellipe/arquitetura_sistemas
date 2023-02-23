package entidades;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Linha {
	
	protected Map<String, Object> valores;
	
	protected Linha() {
		valores = new HashMap<String,Object>();
	}
	
	public String getString(String colId) {
		return (String)valores.get(colId);
	}

	public Integer getInt(String idColuna) {
		return (Integer) valores.get(idColuna);
	}
	
	public Date getDate(String idColuna) {
		return (Date) valores.get(idColuna);
	}
	
	public Boolean getBoolean(String idColuna) {
		return (Boolean) valores.get(idColuna);
	}
	
	public void setValor(String idColuna, boolean valor) {
		valores.put(idColuna, valor);
	}

}
