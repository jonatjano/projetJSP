<%-- ======================================
		produitMAJValid.jsp
========================================= --%>
<%@ page import="java.util.*,beans.*" %>

<% String titre = "CREATION PARTICIPANT"; %>

<%@include file="ihm/miseEnPageSPORT1.jsp" %>

<%	// ==============  CORPS =================================================
	Epreuve e = (Epreuve)request.getAttribute("epreuves");
	out.println("<h3>creation participant valid&eacute;e</h3>");
	out.println("<table>");
	out.println("	<tr class=\"enteteTableau\"><th>ide</th><th>nom</th><th>categ</th><th>datep</th><th>tarifClub</th><th>tarifNonClub</th></tr>");
	out.println("	<tr class=\"lignePaire\">");
	out.println("<td>"+e.getIde()+"</td>");
	out.println("<td>"+e.getNom()+"</td>");
	out.println("<td>"+e.getCateg()+"</td>");
	out.println("<td>"+e.getDatep()+"</td>");
	out.println("<td>"+e.getTarifClub()+"</td>");
	out.println("<td>"+e.getTarifNonClub()+"</td>");
	out.println("	</tr>");
	out.println("</table>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />
