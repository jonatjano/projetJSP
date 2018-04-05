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

public class DB_INSCRIPTION {

	Connection conn;
	PreparedStatement ps_select;
	PreparedStatement ps_insert;
	PreparedStatement ps_select_participant;
	PreparedStatement ps_select_epreuve;
	PreparedStatement ps_update;
	PreparedStatement ps_delete;

	public DB_INSCRIPTION(Connection conn)
	{
		this.conn=conn;
		try
		{
			ps_select = conn.prepareStatement("select categtarif from inscription where idp=? AND ide=?");
			ps_insert = conn.prepareStatement("insert into inscription values(?,?,?)");
			ps_select_participant = conn.prepareStatement (
				"select i.idp,i.ide,i.categtarif,p.nom AS nomParticipant,e.nom AS nomEpreuve,e.datep from inscription i, epreuve e, participant p where e.ide=i.ide and p.idp=i.idp and i.idp=? order by i.idp"
			);
			ps_select_epreuve = conn.prepareStatement (
				"select i.idp,i.ide,i.categtarif,p.nom AS nomParticipant,e.nom AS nomEpreuve,e.datep from inscription i, epreuve e, participant p where e.ide=i.ide and p.idp=i.idp and e.ide=? order by e.ide"
			);
			ps_update = conn.prepareStatement("update inscription set categtarif=? where idp=? AND ide=?");
			ps_delete = conn.prepareStatement("delete from inscription where idp=? AND ide=?");
		} catch(SQLException ex){ System.out.println(ex); }
	}

	public Inscription getInscription(int idp, int ide) throws Exception
	{
		Inscription i = null;
		ps_select.setInt(1,idp);
		ps_select.setInt(2,ide);
		ResultSet rs = ps_select.executeQuery();
		if(rs.next())
		{
			//   nom, categ, datep, tarifclub, tarifnonclub
			String categtarif = rs.getString("categtarif");
			i = new Inscription(idp, ide, categtarif);
		}
		return i;
	}

	//la méthode renvoie le numéro du participant qui vient d'être inséré et qui a
	//été généré automatiquement grace au type postgres SERIAL
	//Cela siginifie que la valeur de l'attribut ide de l'objet passé en paramètre
	//est ignorée.
	public int insertInscription(Inscription i) throws Exception
	{
		int clef = -1;

		ps_insert.setInt(1,i.getIdp());
		ps_insert.setInt(2,i.getIde());
		ps_insert.setString(3,i.getCategTarif());
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

	public void updateInscription(Inscription i) throws Exception
	{
		ps_update.setString(1,i.getCategTarif());
		ps_update.setInt(2,i.getIdp());
		ps_update.setInt(3,i.getIde());

		ps_update.executeUpdate();
	}

	public void deleteInscription(int idp, int ide) throws Exception
	{
		ps_delete.setInt(1,idp);
		ps_delete.setInt(2,ide);
		ps_delete.executeUpdate();
	}

	// cette méthode ne peut être utilisée que dans cette classe
	// elle ne peut pas être utilisée dans d'autres classes
	private ArrayList<Inscription> getInscriptions(String req) throws Exception
	{
		Inscription ins;
		ArrayList<Inscription> ains = null;

		ains = new ArrayList<Inscription>();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(req);
		while(rs.next()){
			ins = new Inscription(
			rs.getInt("idp"), rs.getInt("ide"), rs.getString("categtarif"));
			ains.add(ins);
		}
		return ains;
	}

	public ArrayList<Inscription> getInscriptions() throws Exception
	{
		return getInscriptions("select * from inscription order by ide, idp");
	}

	// cette méthode ne peut être utilisée que dans cette classe
	// elle ne peut pas être utilisée dans d'autres classes
	public ArrayList<InscriptionPE> getInscriptionsParticipant(int idp) throws Exception
	{
		InscriptionPE ins;
		ArrayList<InscriptionPE> ains = null;

		ains = new ArrayList<InscriptionPE>();
		ps_select_participant.setInt(1, idp);
		ResultSet rs = ps_select_participant.executeQuery();
		while(rs.next()){
			ins = new InscriptionPE(
				rs.getInt("idp"), rs.getInt("ide"),
				rs.getString("categtarif"), rs.getString("nomParticipant"),
				rs.getString("nomEpreuve"), rs.getString("datep")
			);
			ains.add(ins);
		}
		return ains;
	}

	// cette méthode ne peut être utilisée que dans cette classe
	// elle ne peut pas être utilisée dans d'autres classes
	public ArrayList<InscriptionPE> getInscriptionsEpreuve(int ide) throws Exception
	{
		InscriptionPE ins;
		ArrayList<InscriptionPE> ains = null;

		ains = new ArrayList<InscriptionPE>();
		ps_select_epreuve.setInt(1, ide);
		ResultSet rs = ps_select_epreuve.executeQuery();
		while(rs.next()){
			ins = new InscriptionPE(
				rs.getInt("idp"), rs.getInt("ide"),
				rs.getString("categtarif"), rs.getString("nomParticipant"),
				rs.getString("nomEpreuve"), rs.getString("datep")
			);
			ains.add(ins);
		}
		return ains;
	}
}
