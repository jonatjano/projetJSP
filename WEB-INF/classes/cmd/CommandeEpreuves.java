package cmd;

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
		List<Epreuve> epreuves = null;
		
		
	  	String trie = req.getParameter("trie");
		if (trie == null)
			trie = "";
			
		String nomTrie = null;
		if (trie.equals("ide"))
			nomTrie = "ide";
		if (trie.equals("nom"))
			nomTrie = "nom";
		if (trie.equals("categ"))
			nomTrie = "categ";
		if (trie.equals("datep"))
			nomTrie = "datep";
		if (trie.equals("tarifClub"))
			nomTrie = "tarifClub";
		if (trie.equals("tarifNonClub"))
			nomTrie = "tarifNonClub";
			
		if (nomTrie != null)
			epreuves = db.getDB_EPREUVE().getEpreuves(nomTrie);
		else
			epreuves = db.getDB_EPREUVE().getEpreuves();
			
		req.setAttribute("epreuves", epreuves);
		return next;
	}

}
