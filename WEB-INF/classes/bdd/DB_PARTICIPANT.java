// sous module specfique de gestion des acces a la table PARTICIPANT
// Table : Participant(idp, nom, age)
package bdd;

import java.sql.*;
import java.util.*;
import beans.*;

/*
 * NB : Pour utiliser cette classe, il faut disposer d'un driver JDBC au minimum en version 4.
   (à cause de l'utilisation de getGeneratedKeys())
 */

public class DB_PARTICIPANT {

  Connection conn;
  PreparedStatement ps_select;
  PreparedStatement ps_insert;
  PreparedStatement ps_update;
  PreparedStatement ps_delete;

  public DB_PARTICIPANT(Connection conn) {
     this.conn=conn;
     try{
        ps_select = conn.prepareStatement("select nom,age from participant where idp=?");
  	ps_insert = conn.prepareStatement("insert into participant values(default,?,?)",ps_insert.RETURN_GENERATED_KEYS);
        ps_update = conn.prepareStatement("update participant set nom=?, age=? where idp=?");
        ps_delete = conn.prepareStatement("delete from participant where idp=?"); 
     } catch(SQLException ex){System.out.println(ex);}
  }
      
  public Participant getParticipant(int idp) throws Exception{
      Participant p=null;
      ps_select.setInt(1,idp);
      ResultSet rs = ps_select.executeQuery();
      if(rs.next()){
	  String nom = rs.getString("nom");
	  int age = rs.getInt("age");
          p = new Participant(idp,nom,age);        
      }
      return p;
  }

  //la méthode renvoie le numéro du participant qui vient d'être inséré et qui a
  //été généré automatiquement grace au type postgres SERIAL
  //Cela siginifie que la valeur de l'attribut idp de l'objet passé en paramètre
  //est ignorée.
  public int insertParticipant(Participant p) throws Exception{
			int clef = -1;

			ps_insert.setString(1,p.getNom());
			ps_insert.setInt(2,p.getAge());
			//le paramètre passé à executeUpdate permet de récupérer les clefs 
			//éventuellement générées automatiquement (via le type serial) au moment
			//de l'exécution de l'ordre SQL.
			ps_insert.executeUpdate();
			//on récupère les clefs générées (une seule ici)
			ResultSet clefs = ps_insert.getGeneratedKeys();
			if (clefs.next()) {
			    clef = clefs.getInt(1);
			}

			return clef;
  }
        
  public void updateParticipant(Participant p) throws Exception{
			ps_update.setString(1,p.getNom());
			ps_update.setInt(2,p.getAge());
			ps_update.setInt(3,p.getIdp());
			ps_update.executeUpdate();
  }

  public void deleteParticipant(int idp) throws Exception{
		ps_delete.setInt(1,idp);
		ps_delete.executeUpdate();
  }

  // cette méthode ne peut être utilisée que dans cette classe
  // elle ne peut pas être utilisée dans d'autres classes
  private ArrayList<Participant> getParticipants(String req) throws Exception{
	// pre-condition: req est de la forme "SELECT * FROM Participant ..."
	// car il s'agit d'extraire un ensemble de participants

        Participant par;
	ArrayList<Participant> apar = null;

		apar = new ArrayList<Participant>(); 
		Statement st = conn.createStatement(); 
		ResultSet rs = st.executeQuery(req); 
		while(rs.next()){ 
		    par = new Participant(rs.getInt("idp"), rs.getString("nom"), rs.getInt("age")); 
		    apar.add(par); 
		} 
	return apar;
  }

  public ArrayList<Participant> getParticipants() throws Exception{
	return getParticipants("select * from participant");
  }


}
