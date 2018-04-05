package pei;
public class Inscription
{
	int idp;
	int ide;
	String categTarif;
	
	public int getIdp()
	{
		return idp;
	}
	
	public int getIde()
	{
		return ide;
	}
	
	public String getCategTarif()
	{
		return categTarif;
	}
	
	public void setIdp(int idp)
	{
		this.idp = idp;
	}
	
	public void setIde(int ide)
	{
		this.ide=ide;
	}
	
	public void setCategTarif(int categTarif)
	{
		this.categTarif=categTarif;
	}
	
	public Inscription()
	{}
	
	public Inscription(int idp, int ide,  String categTarif)
	{
		this.idp = idp;
		this.ide = ide;
		this.categTarif = categTarif;
	}
	
	public String toString()
	{
		return idp + "," + ide + "," + categTarif;
	}
}
