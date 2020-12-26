package model;

public class Radar {

	private int id;
	private boolean bLLuvia;
	private boolean bTrafico;
	
	public Radar(int id, boolean bLLuvia, boolean bTrafico) {
		setId(id);
		setbLLuvia(bLLuvia);
		setbTrafico(bTrafico);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isbLLuvia() {
		return bLLuvia;
	}

	public void setbLLuvia(boolean bLLuvia) {
		this.bLLuvia = bLLuvia;
	}

	public boolean isbTrafico() {
		return bTrafico;
	}

	public void setbTrafico(boolean bTrafico) {
		this.bTrafico = bTrafico;
	}

	@Override
	public String toString() {
		return "Radar [id=" + id + ", bLLuvia=" + bLLuvia + ", bTrafico=" + bTrafico + "]";
	}
	
	
}
