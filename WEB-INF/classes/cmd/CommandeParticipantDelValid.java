package cmd;

import javax.servlet.*;
import javax.servlet.http.*;
import bdd.DBS;
import beans.Participant;

// Cette cde recupere update un pdt:

public class CommandeParticipantDelValid implements Commande {
  private final String next;

  public CommandeParticipantDelValid(String next) {
        this.next = next;
  }

  public String execute(HttpServletRequest req) throws Exception {
	  DBS db = DBS.getInstance();

  	  int idp = Integer.parseInt(req.getParameter("idp"));

	  db.getDB_PARTICIPANT().deleteParticipant(idp);
      return next;
  }

}
