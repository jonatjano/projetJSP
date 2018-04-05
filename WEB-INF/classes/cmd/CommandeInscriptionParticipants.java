package cmd;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bdd.DBS;
import beans.Participant;
import beans.InscriptionPE;

// Cette cde recupere l'ensemble des Inscriptions d'un participant donne:
//
public class CommandeInscriptionParticipants implements Commande
{
	private final String next;

	public CommandeInscriptionParticipants(String next)
	{
		this.next = next;
	}

	public String execute(HttpServletRequest req) throws Exception
	{
		int idp = Integer.parseInt(req.getParameter("idp"));
		DBS db = DBS.getInstance();

		Participant participant = db.getDB_PARTICIPANT().getParticipant(idp);
		List<InscriptionPE> inscriptions = db.getDB_EPREUVE().getInscriptionsParticipant(idp);

		req.setAttribute("participant", participant);
		req.setAttribute("inscriptions", inscriptions);
		return next;
	}
}
