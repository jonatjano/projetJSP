package pei;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.Epreuve;
import bdd.DBS;

// Cette cde recupere l'ensemble des participants:
//
public class CommandeEpreuves implements Commande
{
	private final String next;

	public CommandeEpreuves(String next)
	{
		this.next = next;
	}

	public String execute(HttpServletRequest req) throws Exception
	{
		DBS db = DBS.getInstance();
		List<Epreuve> epreuve = db.getDB_EPREUVE().getEpreuves();
		req.setAttribute("epreuve", epreuve);
		return next;
	}

}
