package cmd;

import javax.servlet.*;
import javax.servlet.http.*;
import bdd.DBS;
import beans.Participant;

// Cette cde recupere update un pdt:

public class CommandeParticipantAddValid implements Commande {
  private final String next;

  public CommandeParticipantAddValid(String next) {
        this.next = next;
  }

  public String execute(HttpServletRequest req) throws Exception {
	  DBS db = DBS.getInstance();

	  String nom = req.getParameter("nom");
	  int age = Integer.parseInt(req.getParameter("age"));

	  Participant participant = new Participant(nom, age);
	  int idp = db.getDB_PARTICIPANT().insertParticipant(participant);
	  participant.setIdp(idp);

	  req.setAttribute("participant", participant);
      return next;
  }

}
