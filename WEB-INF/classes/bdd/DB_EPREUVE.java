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

public class DB_EPREUVE {

	Connection conn;
	PreparedStatement ps_select;
	PreparedStatement ps_insert;
	PreparedStatement ps_update;
	PreparedStatement ps_delete;

	public DB_EPREUVE(Connection conn)
	{
		this.conn=conn;
		try
		{
			ps_select = conn.prepareStatement("select nom, categ, datep, tarifclub, tarifnonclub from epreuve where ide=?");
			ps_insert = conn.prepareStatement(
			"insert into epreuve values(default,?,?,?,?,?)",
			ps_insert.RETURN_GENERATED_KEYS
			);
			ps_update = conn.prepareStatement("update epreuve set nom=?, categ=?, datep=?, tarifclub=?, tarifnonclub=? where ide=?");
			ps_delete = conn.prepareStatement("delete from epreuve where ide=?");
		} catch(SQLException ex){ System.out.println(ex); }
	}

	public Epreuve getEpreuve(int ide) throws Exception
	{
		Epreuve e = null;
		ps_select.setInt(1,ide);
		ResultSet rs = ps_select.executeQuery();
		if(rs.next())
		{
			//   nom, categ, datep, tarifclub, tarifnonclub
			String nom = rs.getString("nom");
			String categ = rs.getString("categ");
			String datep = rs.getString("datep");
			int tarifClub = rs.getInt("tarifclub");
			int tarifNonClub = rs.getInt("tarifnonclub");
			e = new Epreuve(ide, nom, categ, datep, tarifClub, tarifNonClub);
		}
		return e;
	}

	//la méthode renvoie le numéro du participant qui vient d'être inséré et qui a
	//été généré automatiquement grace au type postgres SERIAL
	//Cela siginifie que la valeur de l'attribut ide de l'objet passé en paramètre
	//est ignorée.
	public int insertEpreuve(Epreuve e) throws Exception
	{
		int clef = -1;

		try {
			ps_insert.setString(1,e.getNom());
			ps_insert.setString(2,e.getCateg());
			ps_insert.setDate(3,java.sql.Date.valueOf(e.getDatep()));
			ps_insert.setInt(4,e.getTarifClub());
			ps_insert.setInt(5,e.getTarifNonClub());
			//le paramètre passé à executeUpdate permet de récupérer les clefs
			//éventuellement générées automatiquement (via le type serial) au moment
			//de l'exécution de l'ordre SQL.
			ps_insert.executeUpdate();
			//on récupère les clefs générées (une seule ici)
			ResultSet clefs = ps_insert.getGeneratedKeys();
			if (clefs.next()) {
				clef = clefs.getInt(1);
			}
		}
		catch (Exception ex) {}

		return clef;
	}

	public void updateEpreuve(Epreuve e) throws Exception
	{
		try {
			ps_update.setString(1,e.getNom());
			ps_update.setString(2,e.getCateg());
			ps_update.setDate(3,java.sql.Date.valueOf(e.getDatep()));
			ps_update.setInt(4,e.getTarifClub());
			ps_update.setInt(5,e.getTarifNonClub());
			ps_update.setInt(6,e.getIde());

			ps_update.executeUpdate();
		}
		catch (Exception ex) {}
	}

	public void deleteEpreuve(int ide) throws Exception{
		ps_delete.setInt(1,ide);
		ps_delete.executeUpdate();
	}

	// cette méthode ne peut être utilisée que dans cette classe
	// elle ne peut pas être utilisée dans d'autres classes
	private ArrayList<Epreuve> getEpreuves(String req, String order) throws Exception
	{

		Epreuve epr;
		ArrayList<Epreuve> aepr = null;

		aepr = new ArrayList<Epreuve>();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(req + order);
		while(rs.next()){
			epr = new Epreuve(
			rs.getInt("ide"), rs.getString("nom"),
			rs.getString("categ"), rs.getString("datep"),
			rs.getInt("tarifclub"), rs.getInt("tarifnonclub"));
			aepr.add(epr);
		}
		return aepr;
	}

    public ArrayList<Epreuve> getEpreuves(String order) throws Exception{
  		return getEpreuves("select * from epreuve order by ", order);
    }

	public ArrayList<Epreuve> getEpreuves() throws Exception{
		return getEpreuves("ide");
	}


}
