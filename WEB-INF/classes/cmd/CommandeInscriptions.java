package cmd;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.InscriptionPE;
import bdd.DBS;

// Cette cde recupere l'ensemble des participants:
//
public class CommandeInscriptions implements Commande
{
	private final String next;

	public CommandeInscriptions(String next)
	{
		this.next = next;
	}

	public String execute(HttpServletRequest req) throws Exception
	{
		DBS db = DBS.getInstance();
		List<InscriptionPE> inscriptions = db.getDB_INSCRIPTION().getInscriptionPEs();
		req.setAttribute("inscriptions", inscriptions);
		return next;
	}

}
