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
	out.println("<tr class=\"enteteTableau\"><th>ide</th><th>nom</th><th>categTarif</th><th>dateEpreuve</th></tr>");
	for (InscriptionPE i : inscriptions)
	{
		coul=(coul.equals("lignePaire"))?"ligneImpaire":"lignePaire";
	        out.println("<tr class=\""+coul+"\">");
	        
	        
		String href="controleur?cmd=epreuve&ide="+i.getIde();
		out.println("<td><a href="+href+">"+i.getIde()+"</a></td>");
		
		out.println("<td>"+i.getNomEpreuve()+"</td>");
		out.println("<td>"+i.getCategTarif()+"</td>");
		out.println("<td>"+i.getDateEpreuve()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />



