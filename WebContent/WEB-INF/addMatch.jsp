<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ajouter un match</title>
</head>
<body>
	<%@ include file="menuBar.jsp" %>
	<div class="row m-3 justify-content-center">
		<form action="addMatch" method="post">
			<div class="row m-3">
				<label for="joueurs">Joueurs</label>
				<select name="joueurs">
					<c:forEach var="player" items="${ players }">
						<option>${ player.firstname } ${ player.lastname }</option>
					</c:forEach>
				</select>
			</div>
			<div class="row m-3">				
				<div class="col">
					<label for="winnerFirstName">Winner</label>
					<input type="text" class="form-control" name="winnerFirstname" placeholder="Firstname"> 
				</div>
				<div class="col">
					<label for=""> _ </label>
					<input type="text" class="form-control" name="winnerLastname"placeholder="Lastname"> 
				</div>
			</div>
			<div class="row m-3">
				<div class="col">
					<label for="finalistFirstName">Finalist</label>
					<input type="text" class="form-control" name="finalistFirstname"> 
				</div>
				<div class="col">
					<label for=""> _ </label>
					<input type="text" class="form-control" name="finalistLastname"> 
				</div>
			</div>
			<div class="row m-3">
				<div class="col-6">
					<label for="idTournament">Tournament ID</label>
					<input type="text" class="form-control" name="idTournament"> 
				</div>
			</div>
			<div class="row m-3">
				<div class="col-6">
					<label for="year">Year</label>
					<input type="text" class="form-control" name="year"> 
				</div>
			</div>
			<div class="row m-3">
				<div class="col text-right">
					<button type="submit" class="btn btn-primary" name="action" value="addMatch">Ajouter match</button>
				</div>
			</div>
			
			
		</form>
	</div>
	
</body>
</html>