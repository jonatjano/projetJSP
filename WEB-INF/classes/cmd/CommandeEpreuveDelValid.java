package cmd;

import javax.servlet.*;
import javax.servlet.http.*;
import bdd.DBS;
import beans.Epreuve;

// Cette cde recupere update un pdt:

public class CommandeEpreuveDelValid implements Commande {
  private final String next;

  public CommandeEpreuveDelValid(String next) {
        this.next = next;
  }

  public String execute(HttpServletRequest req) throws Exception {
	  DBS db = DBS.getInstance();

  	  int ide = Integer.parseInt(req.getParameter("ide"));

	  db.getDB_PARTICIPANT().deleteParticipant(ide);
      return next;
  }

}
