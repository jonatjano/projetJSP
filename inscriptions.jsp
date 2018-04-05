<%-- ======================================
		participants.jsp
========================================= --%>

<%@ page import="java.util.*,beans.*" %>

<% String titre = "LISTE DES INSCRIPTION"; %>

<%@include file="ihm/miseEnPageSPORT1.jsp" %>

<%	// ==============  CORPS =================================================
	List<InscriptionPE> inscription = (List<InscriptionPE>)request.getAttribute("inscriptions");
	String coul="lignePaire";
	out.println("<table>");
	// nom du participant, nom de l'épreuve, date de l'épreuve et catégorie du tarif d'inscription
	out.println("<tr class=\"enteteTableau\"><th>nom participant</th><th>nom epreuve</th><th>date epreuve</th><th>categorie de tarif</th></tr>");
	for (InscriptionPE i : inscription)
	{
		coul=(coul.equals("lignePaire"))?"ligneImpaire":"lignePaire";
	    out.println("<tr class=\""+coul+"\">");

		out.println("<td>"+i.getNomParticipant()+"</td>");
		out.println("<td>"+i.getNomEpreuve()+"</td>");
		out.println("<td>"+i.getDateEpreuve()+"</td>");
		out.println("<td>"+i.getCategTarif()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />
