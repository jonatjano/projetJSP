<%-- ======================================
		inscriptionEpreuves.jsp
========================================= --%>

<%@ page import="java.util.*,beans.*" %>

<% Epreuve epreuve = (Epreuve)request.getAttribute("epreuve"); %>
<% String titre="LISTE DES Inscription de l'epreuve "+epreuve.getIde() +","+ epreuve.getNom(); %>
<%@include file="ihm/miseEnPageSPORT1.jsp" %>


<%	// ==============  CORPS =================================================
	List<InscriptionPE> inscriptions = (List<InscriptionPE>)request.getAttribute("inscriptions");
	if(inscriptions==null || inscriptions.size()==0) out.println("pas d'inscription");
	String coul="lignePaire";
	out.println("<table>");
	out.println("<tr class=\"enteteTableau\"><th>idp</th><th>nom</th><th>categTarif</th></tr>");

	for (InscriptionPE i : inscriptions)
	{
		coul=(coul.equals("lignePaire"))?"ligneImpaire":"lignePaire";
	    out.println("<tr class=\""+coul+"\">");

		String href="controleur?cmd=participant&idp="+i.getIdp();
		out.println("<td><a href="+href+">"+i.getIdp()+"</a></td>");
		
		out.println("<td>"+i.getNomParticipant()+"</td>");
		out.println("<td>"+i.getCategTarif()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	// ==============  CORPS =================================================
%>

<jsp:include page="ihm/miseEnPageSPORT2.jsp" />
