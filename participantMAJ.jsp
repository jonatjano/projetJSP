<%-- ======================================
		produitMAJ.jsp
========================================= --%>
<%@ page import="java.util.*,beans.*" %>

<% String titre = "MISE A JOUR PARTICIPANT"; %>

<%@include file="ihm/miseEnPageSPORT1.jsp" %>

<%	// ==============  CORPS =================================================
	Participant p = (Participant)request.getAttribute("participant");
	out.println("<center><h3>mise a jour participant</h3></center>");
	out.println("<center><table>");
	out.println("	<tr class=\"enteteTableau\"><th>idp</th><th>nom</th><th>age</th></tr>");
	out.println("	<form method=get action=controleur>");
	//out.println("	<form method=get action=echo.jsp>");
	out.println("	<tr class =\"lignePaire\">");
	out.println("	<td>" + p.getIdp() + "</td>");
	out.println("	<td><input name=nom value="+p.getNom()+"></td>");
	out.println("	<td><input name=age type=\"number\" value="+p.getAge()+"></td>");
	out.println("	</tr>");
	out.println("	<tr>");
	out.println("	<td colspan=4><input type=submit value=valider></td>");
	out.println("	</tr>");
	out.println("	<input type=hidden name=idp value="+p.getIdp()+">");
	out.println("	<input type=hidden name=cmd value=participantMAJValid>");
	out.println("	</form>");
	out.println("</table></center>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />
