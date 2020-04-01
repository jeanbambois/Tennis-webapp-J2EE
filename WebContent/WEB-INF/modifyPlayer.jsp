<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifier un joueur</title>
</head>

<body>
	<%@ include file="menuBar.jsp" %>
	
	<div class="row m-3 justify-content-center">
		<div class="col-6 border border-secondary rounded">
			<h3 class="text-center">Modifier un joueur</h3>
			<form action="modifyPlayer" method="post">
				<div class="row m-3">
					<div class="col-2">
						<label for="id">Player ID</label>
					</div>
					<div class="col-5">
						<input type="text" class="form-control" name="id"  readonly="readonly" value="${ player.id }"> 
					</div>
				</div>
				<div class="row m-3">
					<div class="col-2">
						<label for="firstname">Player</label>
					</div>				
					<div class="col-5">
						<input type="text" class="form-control" name="firstname" value="${ player.firstname }"> 
					</div>
					<div class="col-5">
						<input type="text" class="form-control" name="lastname" value="${ player.lastname }"> 
					</div>
				</div>
				<div class="row m-3">
					<div class="col-2">
						<label for="sexe">Sexe</label>
					</div>
					<div class="col-5">
						<input type="text" class="form-control" name="sexe" value="${ player.sexe }"> 
					</div>
				</div>
				<div class="row m-3">
					<div class="col text-right">
						<button class="btn btn-outline-primary"><a href="/AppTennisJ2ee/listPlayer">Retour</a></button>
						<button type="submit" class="btn btn-primary" name="action">Modifier</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	
</body>
</html>