<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des matchs</title>
</head>

<body>
	<%@ include file="menuBar.jsp" %>
	
	<div class="row m-3 justify-content-center">
		<div class="col-8 border border-secondary rounded">
			<h3 class="text-center">Liste des matchs</h3>
			<a href="/AppTennisJ2ee/addMatch" class="nav-link"><button class="btn btn-primary">Ajouter un match</button></a>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col" style="width:10%">#</th>
			      <th scope="col" style="width:25%">Winner</th>
			      <th scope="col" style="width:20%">Finalist</th>
			      <th scope="col" style="width:20%">Tournament</th>
				  <th scope="col" style="width:20%">Year</th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:forEach var="match" items="${ matchs }">
					<form method="get" action="ModifierUtilisateur">
						<tr>
							<td><c:out value="${ match.idMatch }"/></td>
						  	<td><c:out value="${ match.winnerFirstname }"/> <c:out value="${ match.winnerLastname }"/></td>
						  	<td><c:out value="${ match.finalistFirstname }"/> <c:out value="${ match.finalistLastname }"/></td>
							<td><c:out value="${ match.idTournament }"/></td>
							<td><c:out value="${ match.year }"/></td>
						</tr>
					</form>
				  </c:forEach>
		
			  </tbody>
			</table>
		</div>
	</div>
	
	
</body>
</html>