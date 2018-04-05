<%-- ======================================
		produitMAJ.jsp
========================================= --%>
<%@ page import="java.util.*,beans.*" %>

<% String titre = "MISE A JOUR EPREUVE"; %>

<%@include file="ihm/miseEnPageSPORT1.jsp" %>

<%	// ==============  CORPS =================================================
	Epreuve e = ((List<Epreuve>)request.getAttribute("epreuves")).get(0);
	out.println("<center><h3>mise a jour epreuve</h3></center>");
	out.println("<center><table>");
	out.println("	<tr class=\"enteteTableau\"><th>ide</th><th>nom</th><th>categ</th><th>datep</th><th>tarifClub</th><th>tarifNonClub</th></tr>");
	out.println("	<form method=get action=controleur>");
	//out.println("	<form method=get action=echo.jsp>");
	out.println("	<tr class =\"lignePaire\">");
	out.println("	<td></td>");
	out.println("	<td><input name=nom value=" + e.getNom() + "></td>");
	out.println("	<td><input name=categ value=" + e.getCateg() + "></td>");
	out.println("	<td><input name=datep value=" + e.getDatep() + "></td>");
	out.println("	<td><input name=tarifClub type=\"number\" value=" + e.getTarifClub() + "></td>");
	out.println("	<td><input name=tarifNonClub type=\"number\" value=" + e.getTarifNonClub() + "></td>");
	out.println("	</tr>");
	out.println("	<tr>");
	out.println("	<td colspan=4><input type=submit value=valider></td>");
	out.println("	</tr>");
	out.println("	<input type=hidden name=ide value="+e.getIde()+">");
	out.println("	<input type=hidden name=cmd value=epreuveMAJValid>");
	out.println("	</form>");
	out.println("</table></center>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />
