package model;

public class Pantalla {
	private int id;
	private String sTexto;
	
	public Pantalla(int id, String sTexto) {
		setId(id);
		setsTexto(sTexto);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getsTexto() {
		return sTexto;
	}

	public void setsTexto(String sTexto) {
		this.sTexto = sTexto;
	}

	@Override
	public String toString() {
		return "Pantalla [id=" + id+ ", sTexto=" + sTexto + "]";
	}
	
 
}
