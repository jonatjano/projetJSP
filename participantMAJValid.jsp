<%-- ======================================
		produitMAJValid.jsp
========================================= --%>
<%@ page import="java.util.*,beans.*" %>

<% String titre = "MISE A JOUR PARTICIPANT"; %>

<%@include file="ihm/miseEnPageSPORT1.jsp" %>

<%	// ==============  CORPS =================================================
	Participant p = (Participant)request.getAttribute("participant");
	out.println("<h3>mise a jour participant valid&eacute;e</h3>");
	out.println("<table>");
	out.println("	<tr class=\"enteteTableau\"><th>idp</th><th>nom</th><th>age</th></tr>");
	out.println("	<tr class=\"lignePaire\">");
	out.println("<td>" + p.getIdp() + "</td>");
	out.println("<td>" + p.getNom() + "</td>");
	out.println("<td>" + p.getAge() + "</td>");
	out.println("	</tr>");
	out.println("</table>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />
