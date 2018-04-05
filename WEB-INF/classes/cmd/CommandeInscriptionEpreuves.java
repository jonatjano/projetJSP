package cmd;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bdd.DBS;
import beans.Epreuve;
import beans.InscriptionPE;

// Cette cde recupere l'ensemble des Inscriptions d'un participant donne:
//
public class CommandeInscriptionEpreuves implements Commande
{
	private final String next;

	public CommandeInscriptionEpreuves(String next)
	{
		this.next = next;
	}

	public String execute(HttpServletRequest req) throws Exception
	{
		int ide = Integer.parseInt(req.getParameter("ide"));
		DBS db = DBS.getInstance();

		Epreuve epreuve = db.getDB_EPREUVE().getEpreuve(ide);
		List<InscriptionPE> inscriptions = db.getDB_INSCRIPTION().getInscriptionsEpreuve(ide);

		req.setAttribute("epreuve", epreuve);
		req.setAttribute("inscriptions", inscriptions);
		return next;
	}
}
