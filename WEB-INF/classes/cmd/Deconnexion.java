package cmd;

import javax.servlet.*;
import javax.servlet.http.*;

// Cette cde ne fait rien sinon de passer la main a next

public class Deconnexion implements Commande {
  private String next;

  public Deconnexion(String next) {
        this.next = next;
  }

  public String execute(HttpServletRequest req) throws Exception {
	  req.getSession(true).invalidate();
    return next;
  }
}
