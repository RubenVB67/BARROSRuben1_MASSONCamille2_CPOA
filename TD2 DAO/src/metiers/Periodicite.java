package metiers;

public class Periodicite
{
	protected int id_periodicite;
	protected String libelle;
	
	public int getId() {
		return id_periodicite;
	}
	public void setId(int id_periodicite) {
		this.id_periodicite = id_periodicite;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Periodicite(int id_periodicite, String libelle) {
		super();
		this.id_periodicite = id_periodicite;
		this.libelle = libelle;
	}

}
