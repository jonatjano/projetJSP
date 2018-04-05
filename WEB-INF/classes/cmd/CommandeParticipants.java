package cmd;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.Participant;
import bdd.DBS;

// Cette cde recupere l'ensemble des participants:
//
public class CommandeParticipants implements Commande
{
  private final String next;

  public CommandeParticipants(String next)
  {
        this.next = next;
  }

  public String execute(HttpServletRequest req) throws Exception
  {
	  DBS db = DBS.getInstance();
	  
	  
		
	  
	  List<Participant> participants = null;
	  String trie = req.getParameter("trie");
		if (trie == null)
			trie = "";
			
		String nomTrie = null;
		if (trie.equals("ide"))
			nomTrie = "ide";
		if (trie.equals("nom"))
			nomTrie = "nom";
		if (trie.equals("age"))
			nomTrie = "age";
			
		if (nomTrie != null)
			participants = db.getDB_PARTICIPANT().getParticipants(nomTrie);
		else
			participants = db.getDB_PARTICIPANT().getParticipants();
			
	  	req.setAttribute("participants", participants);
        return next;
  }

}
