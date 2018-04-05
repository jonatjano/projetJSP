package cmd;

import javax.servlet.*;
import javax.servlet.http.*;
import bdd.DBS;
import beans.Epreuve;

// Cette cde recupere update un pdt:

public class CommandeEpreuveAddValid implements Commande {
  private final String next;

  public CommandeEpreuveAddValid(String next) {
        this.next = next;
  }

  public String execute(HttpServletRequest req) throws Exception {
	  DBS db = DBS.getInstance();

	  String nom = req.getParameter("nom");
  	  String categ = req.getParameter("categ");
	  String datep = req.getParameter("datep");
	  int tarifClub = Integer.parseInt(req.getParameter("tarifClub"));
	  int tarifNonClub = Integer.parseInt(req.getParameter("tarifNonClub"));

	  Epreuve epreuve = new Epreuve(nom, categ, datep, tarifClub, tarifNonClub);
	  int ide = db.getDB_EPREUVE().insertEpreuve(epreuve);
	  epreuve.setIde(ide);

	  req.setAttribute("epreuve", epreuve);
      return next;
  }

}
