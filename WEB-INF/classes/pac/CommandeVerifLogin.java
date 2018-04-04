package pac;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Cette cde permet de valider la connexion (ou non !)
// Si la connexion est validée, la session est initialisée avec le
// droit associé à l'utilisateur connecté.
// La méthode execute de cette commande contrairement aux autres
// ne renvoie pas toujours le même nom de JSP.
//
public class CommandeVerifLogin implements Commande {
	private final String next;

	public CommandeVerifLogin(String next) {
		this.next = next;
	}

	public String execute(HttpServletRequest req) throws Exception {

		//variable contenant le nom de la JSP qui devra etre activee ensuite
		String cible = next;

		//   nom=user
		//   pass=userpwd

		String nom = req.getParameter("nom");
		String pass = req.getParameter("pass");

		if (!((nom.equals("user") || nom.equals("admin")) && pass.equals(nom + "pwd"))) {
			cible = "login.jsp";
		}
		else if (nom.equals("user") && pass.equals("userpwd")) {
			HttpSession session = req.getSession(true);
			session.setAttribute("droitCmd", "all");
		}
		else if (nom.equals("admin") && pass.equals("adminpwd")) {
			HttpSession session = req.getSession(true);
			session.setAttribute("droitCmd", "admin");
		}


		//A COMPLETER
		//analyse du login et du mot de passe stockes dans la requete HTTP
		//Si erreur sur login ou mot de passe, alors, en passant par le controleur,
		//faire en sorte que login.jsp soit activee
		//en lui transmettant eventuellement un message d'erreur
		//si login et mot de passe sont ok, alors il faut creer une nouvelle session et stocker dedans
		//le droit de la personne connectee. Dans ce cas, c'est accueil.jsp qui doit etre activee.
		//NB : on accepte deux comptes : user/userpwd et admin/adminpwd.
		return cible;
	}

}