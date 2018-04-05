<%-- ======================================
		produits.jsp
========================================= --%>

<%@ page import="java.util.*,pac.*" %>

<% String titre = "LISTE DES PRODUITS"; %>

<%@include file="ihm/miseEnPagePAC1.jsp" %>

<%	// ==============  CORPS =================================================
	List<Produit> produits = (List<Produit>)request.getAttribute("produits");
	String coul="lignePaire";
	out.println("<table>");
	out.println("<tr class=\"enteteTableau\"><th>np</th><th>lib</th><th>coul</th><th>qs</th></tr>");
	for (Produit p : produits) {
		coul=(coul.equals("lignePaire"))?"ligneImpaire":"lignePaire";
	        out.println("<tr class=\""+coul+"\">");
		String href="controleur?cmd=achatsProduit&np="+p.getNp();
		out.println("<td><a href="+href+">"+p.getNp()+"</a></td>");
		out.println("<td>"+p.getLib()+"</td>");
		out.println("<td>"+p.getCouleur()+"</td>");
		out.println("<td>"+p.getQs()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPagePAC2.jsp" />