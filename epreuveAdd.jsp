<%-- ======================================
		produitMAJ.jsp
========================================= --%>
<%@ page import="java.util.*,beans.*" %>

<% String titre = "MISE A JOUR EPREUVE"; %>

<%@include file="ihm/miseEnPageSPORT1.jsp" %>

<%	// ==============  CORPS =================================================
	out.println("<center><h3>mise a jour epreuve</h3></center>");
	out.println("<center><table>");
	out.println("	<tr class=\"enteteTableau\"><th>ide</th><th>nom</th><th>categ</th><th>datep</th><th>tarifClub</th><th>tarifNonClub</th></tr>");
	out.println("	<form method=get action=controleur>");
	out.println("	<tr class =\"lignePaire\">");
	out.println("	<td></td>");
	out.println("	<td><input name=nom></td>");
	out.println("	<td><input name=categ></td>");
	out.println("	<td><input name=datep></td>");
	out.println("	<td><input name=tarifClub type=\"number\"></td>");
	out.println("	<td><input name=tarifNonClub type=\"number\"></td>");
	out.println("	</tr>");
	out.println("	<tr>");
	out.println("	<td colspan=4><input type=submit value=valider></td>");
	out.println("	</tr>");
	out.println("	<input type=hidden name=cmd value=epreuveAddValid>");
	out.println("	</form>");
	out.println("</table></center>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />
