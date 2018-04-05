<%-- ======================================
		epreuves.jsp
========================================= --%>

<%@ page import="java.util.*,beans.*" %>

<% String titre="LISTE DES EPREUVES"; %>

<%@include file="ihm/miseEnPageSPORT1.jsp" %>



<%	// ==============  CORPS =================================================
	List<Epreuve> epreuves = (List<Epreuve>)request.getAttribute("epreuves");
	String coul="lignePaire";
	out.println("<table>");
	out.println("<tr class=\"enteteTableau\">" + 
				"<th><a href=\"controleur?cmd=epreuves&trie=ide\">ide</a></th>" + 
				"<th><a href=\"controleur?cmd=epreuves&trie=nom\">nom</a></th>" + 
				"<th><a href=\"controleur?cmd=epreuves&trie=categ\">categ</a></th>" + 
				"<th><a href=\"controleur?cmd=epreuves&trie=datep\">datep</a></th>" + 
				"<th><a href=\"controleur?cmd=epreuves&trie=tarifClub\">tarifClub</a></th>" + 
				"<th><a href=\"controleur?cmd=epreuves&trie=tarifNonClub\">tarifNonClub</a></th>" + 
				"</tr>");
				
	for (Epreuve e : epreuves)
	{
		coul=(coul.equals("lignePaire"))?"ligneImpaire":"lignePaire";
	        out.println("<tr class=\""+coul+"\">");

		String href="controleur?cmd=inscriptionEpreuve&ide="+e.getIde();
		out.println("<td><a href="+href+">"+e.getIde()+"</a></td>");
		out.println("<td>"+e.getNom()+"</td>");
		out.println("<td>"+e.getCateg()+"</td>");
		out.println("<td>"+e.getDatep()+"</td>");
		out.println("<td>"+e.getTarifClub()+"</td>");
		out.println("<td>"+e.getTarifNonClub()+"</td>");
		out.println("</tr>");
	}
	out.println("</table></center>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />
