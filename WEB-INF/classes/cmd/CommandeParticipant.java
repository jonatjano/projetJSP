package cmd;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.Participant;
import bdd.DBS;

// Cette cde recupere un participant:
// Le numero de participant est dans la requete HTTP
//
public class CommandeParticipant implements Commande
{
	private final String next;

	public CommandeParticipant(String next)
	{
		this.next = next;
	}

	public String execute(HttpServletRequest req) throws Exception
	{
		DBS db = DBS.getInstance();
		
		int idp = Integer.parseInt(req.getParameter("idp"));
		Participant participant = db.getDB_PARTICIPANT().getParticipant(idp);
		
	  	List<Participant> participants = new ArrayList<Participant>();
	  	participants.add(participant);

		req.setAttribute("participants", participants);
		return next;
	}

}
