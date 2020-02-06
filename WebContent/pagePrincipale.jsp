<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Page principale</title>
</head>
<body>
	<% String pseudo = (String) session.getAttribute("utilisateur"); %>
	<h2>Bonjour <%= pseudo %> !</h2>
	<p>Opérations disponibles</p>
	<ul>
		<li>
			<a href="#">Compte courant</a>
		</li>
		<li>
			<a href="<%= request.getContextPath() + "/upload.html" %>">Uploader un fichier</a>
		</li>
		<li>
			<a href="<%= request.getContextPath() + "/fin.html" %>">Déconnexion</a>
		</li>
	</ul>
	<p>Nombre de personnes online sur le site : ${counter.activeSessionNumber}</p>
</body>
</html>