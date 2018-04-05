package cmd;

import javax.servlet.*;
import javax.servlet.http.*;
import bdd.DBS;
import beans.Participant;

// Cette cde recupere update un pdt:

public class CommandeParticipantMAJValid implements Commande {
  private final String next;

  public CommandeParticipantMAJValid(String next) {
        this.next = next;
  }

  public String execute(HttpServletRequest req) throws Exception {
	  DBS db = DBS.getInstance();

	  int idp = Integer.parseInt(req.getParameter("idp"));
	  String nom = req.getParameter("nom");
	  int age = Integer.parseInt(req.getParameter("age"));

	  Participant participant = db.getDB_PARTICIPANT().getParticipant(idp);
	  participant.setNom(nom);
	  participant.setAge(age);

	  db.getDB_PARTICIPANT().updateParticipant(participant);
	  req.setAttribute("participant", participant);
      return next;
  }

}
