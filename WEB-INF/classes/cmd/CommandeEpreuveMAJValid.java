package cmd;

import javax.servlet.*;
import javax.servlet.http.*;
import bdd.DBS;
import beans.Epreuve;

// Cette cde recupere update un pdt:

public class CommandeEpreuveMAJValid implements Commande {
  private final String next;

  public CommandeEpreuveMAJValid(String next) {
        this.next = next;
  }

  public String execute(HttpServletRequest req) throws Exception {
	  DBS db = DBS.getInstance();

	  int ide = Integer.parseInt(req.getParameter("ide"));
	  String nom = req.getParameter("nom");
  	  String categ = req.getParameter("categ");
	  String datep = req.getParameter("datep");
	  int tarifClub = Integer.parseInt(req.getParameter("tarifClub"));
	  int tarifNonClub = Integer.parseInt(req.getParameter("tarifNonClub"));

	  Epreuve epreuve = db.getDB_EPREUVE().getEpreuve(ide);
	  epreuve.setNom(nom);
	  epreuve.setCateg(categ);
	  epreuve.setDatep(datep);
	  epreuve.setTarifClub(tarifClub);
	  epreuve.setTarifNonClub(tarifNonClub);

	  db.getDB_EPREUVE().updateEpreuve(epreuve);
	  req.setAttribute("epreuve", epreuve);
      return next;
  }

}
