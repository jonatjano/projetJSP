<%-- ======================================
		inscriptionParticipants.jsp              
========================================= --%>

<%@ page import="java.util.*,beans.*" %>

<% Participant participant = (Participant)request.getAttribute("participant"); %>
<% String titre="LISTE DES INSCRIPTION du participant "+participant.getNom(); %>
<%@include file="ihm/miseEnPageSPORT1.jsp" %>


<%	// ==============  CORPS =================================================
	List<InscriptionPE> inscriptions = (List<InscriptionPE>)request.getAttribute("inscriptions");
	if(inscriptions==null || inscriptions.size()==0) out.println("pas d'inscription");
	String coul="lignePaire";
	out.println("<table>");
	out.println("<tr class=\"enteteTableau\"><th>ide</th><th>nom</th><th>categ</th><th>datep</th><th>tarifClub</th><th>tarifNonClub</th></tr>");
	for (InscriptionPE i : inscriptions)
	{
		coul=(coul.equals("lignePaire"))?"ligneImpaire":"lignePaire";
	        out.println("<tr class=\""+coul+"\">");
	        
		out.println("<td>"+i.getIde()+"</td>");
		out.println("<td>"+i.getNom()+"</td>");
		out.println("<td>"+i.getCateg()+"</td>");
		out.println("<td>"+i.getDatep()+"</td>");
		out.println("<td>"+i.getTarifClub()+"</td>");
		out.println("<td>"+i.getTarifNonClub()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />



