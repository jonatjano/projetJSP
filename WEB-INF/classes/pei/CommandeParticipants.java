package pei;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.Participant;
import bdd.DBS;

// Cette cde recupere l'ensemble des participants:
//
public class CommandeParticipants implements Commande {
  private final String next;

  public CommandeParticipants(String next) {
        this.next = next;
  }

  public String execute(HttpServletRequest req) throws Exception {
	  DBS db = DBS.getInstance();
	  List<Participant> participants = db.getDB_PARTICIPANT().getParticipants();
	  req.setAttribute("participants", participants);
          return next;
  }

}
