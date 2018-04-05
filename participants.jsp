<%-- ======================================
		participants.jsp
========================================= --%>

<%@ page import="java.util.*,beans.*" %>

<% String titre = "LISTE DES PARTICIPANTS"; %>

<%@include file="ihm/miseEnPageSPORT1.jsp" %>

<%	// ==============  CORPS =================================================
	List<Participant> participants = (List<Participant>)request.getAttribute("participants");
	String coul="lignePaire";
	out.println("<table>");
	out.println("<tr class=\"enteteTableau\"><th>idp</th><th>nom</th><th>age</th></tr>");
	for (Participant p : participants) 
	{
		coul=(coul.equals("lignePaire"))?"ligneImpaire":"lignePaire";
	    out.println("<tr class=\""+coul+"\">");
	    
		String href="controleur?cmd=inscriptionEpreuves&idp="+p.getIdp();
		out.println("<td><a href="+href+">"+p.getIdp()+"</a></td>");
		out.println("<td>"+p.getNom()+"</td>");
		out.println("<td>"+p.getAge()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />
