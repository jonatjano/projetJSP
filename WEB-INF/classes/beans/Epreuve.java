package beans;

public class Epreuve
{
	int ide;
	String nom;
	String categ;
	String datep;
	int tarifClub;
	int tarifNonClub;

	public int getIde()
	{
		return ide;
	}

	public String getNom()
	{
		return nom;
	}

	public String getCateg()
	{
		return categ;
	}

	public String getDatep()
	{
		return datep;
	}

	public int getTarifClub()
	{
		return tarifClub;
	}

	public int getTarifNonClub()
	{
		return tarifNonClub;
	}

	public void setIde(int ide)
	{
		this.ide=ide;
	}

	public void setNom(String nom)
	{
		this.nom=nom;
	}

	public void setCateg(String categ)
	{
		this.categ=categ;
	}

	public void setDatep(String datep)
	{
		this.datep=datep;
	}

	public void setTarifClub(int tarifClub)
	{
		this.tarifClub=tarifClub;
	}

	public void setTarifNonClub(int tarifNonClub)
	{
		this.tarifNonClub=tarifNonClub;
	}

	public Epreuve()
	{}

	public Epreuve(int ide, String nom, String categ, String datep, int tarifClub, int tarifNonClub)
	{
		this.ide = ide;
		this.nom = nom;
		this.categ = categ;
		this.datep = datep;
		this.tarifClub = tarifClub;
		this.tarifNonClub = tarifNonClub;
	}

	public String toString()
	{
		return this.ide + "," + nom + "," + categ + "," + datep + "," + tarifClub + "," + tarifNonClub;
	}
}
