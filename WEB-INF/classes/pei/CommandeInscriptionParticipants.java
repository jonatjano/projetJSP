package pei;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

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

	  Participants participant = db.getParticipant(idp);
	  List<InscriptionPE> inscriptions = db.getInscriptionParticipantPE(idp);

	  req.setAttribute("participant", participant);
	  req.setAttribute("inscriptions", inscriptions);
          return next;
  }

}
