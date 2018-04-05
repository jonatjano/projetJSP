package beans;

public class InscriptionPE extends Inscription
{
	String nomParticipant;
	String nomEpreuve;
	String dateEpreuve;

	public String getNomParticipant()
	{
		return nomParticipant;
	}

	public String getNomEpreuve()
	{
		return nomEpreuve;
	}

	public String getDateEpreuve()
	{
		return dateEpreuve;
	}

	public void setNomParticipant(String nomParticipant)
	{
		this.nomParticipant = nomParticipant;
	}

	public void setNomEpreuve(String nomEpreuve)
	{
		this.nomEpreuve = nomEpreuve;
	}

	public void setDateEpreuve(String dateEpreuve)
	{
		this.dateEpreuve = dateEpreuve;
	}

	public InscriptionPE()
	{}

	public InscriptionPE(int idp, int ide,  String categTarif, String nomParticipant, String nomEpreuve, String dateEpreuve)
	{
		super(idp,ide,categTarif);
		this.nomParticipant = nomParticipant;
		this.nomEpreuve = nomEpreuve;
		this.dateEpreuve = dateEpreuve;
	}

	public String toString()
	{
		return super.toString();
	}
}
