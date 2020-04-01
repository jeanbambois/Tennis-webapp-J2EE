<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des joueurs</title>
</head>

<body>
	<%@ include file="menuBar.jsp" %>
	
	<div class="row m-3 justify-content-center">
		<div class="col-6 border border-secondary rounded">
			<h3 class="text-center">Liste des Joueurs</h3>
			<a href="/AppTennisJ2ee/addPlayer">
				<button class="btn btn-primary">Ajouter un joueur</button>
			</a>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col" style="width:10%">#</th>
			      <th scope="col" style="width:20%">Prenom</th>
			      <th scope="col" style="width:20%">Nom</th>
			      <th scope="col" style="width:20%">Sexe</th>
				  <th scope="col" style="width:20%"></th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:forEach var="player" items="${ players }">
					<form method="get" action="modifyPlayer">
						<tr>
							<td><c:out value="${ player.id }"/></td>
						  	<td><c:out value="${ player.firstname }"/> <c:out value="${ match.winnerLastname }"/></td>
						  	<td><c:out value="${ player.lastname }"/> <c:out value="${ match.finalistLastname }"/></td>
							<td><c:out value="${ player.sexe }"/></td>
							<td class="d-flex">
								<input type="hidden" name="idPlayer" value="${ player.id }" />
								<button type="submit" class="btn btn-outline-primary mr-1" name="action" value="modif">Modifier</button>
								<button type="submit" class="btn btn-outline-warning" name="action" value="delete">Supprimer</button>							
							</td>
						</tr>
					</form>
				  </c:forEach>
		
			  </tbody>
			</table>
		</div>
	</div>
	
	
</body>
</html>