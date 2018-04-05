package pei;

import javax.servlet.*;
import javax.servlet.http.*;
import beans.Epreuve;
import bdd.DBS;

// Cette cde recupere un epreuve:
// Le numero de epreuve est dans la requete HTTP
//
public class CommandeEpreuve implements Commande
{
	private final String next;

	public CommandeEpreuve(String next)
	{
		this.next = next;
	}

	public String execute(HttpServletRequest req) throws Exception
	{
		DBS db = DBS.getInstance();

		int ide = Integer.parseInt(req.getParameter("ide"));
		Epreuve epreuve = db.getDB_EPREUVE().getEpreuve(ide);

		req.setAttribute("epreuve", epreuve);
		return next;
	}

}
