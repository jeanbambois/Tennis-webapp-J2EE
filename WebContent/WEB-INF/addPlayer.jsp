<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ajouter un joueur</title>
</head>

<body>
	<%@ include file="menuBar.jsp" %>
	
	<div class="row m-3 justify-content-center">
		<div class="col-6 border border-secondary rounded">
			<h3 class="text-center">Modifier un joueur</h3>
			<form action="addPlayer" method="post">
				<div class="row m-3">
					<div class="col-2">
						<label for="firstname">Player</label>
					</div>				
					<div class="col-5">
						<input type="text" class="form-control" name="firstname" placeholder="Firstname"> 
					</div>
					<div class="col-5">
						<input type="text" class="form-control" name="lastname" placeholder="Lastname"> 
					</div>
				</div>
				<div class="row m-3">
					<div class="col-2">
						<label for="sexe">Sexe</label>
					</div>
					<div class="col-5">
						<input type="text" class="form-control" name="sexe" placeholder="M ou F"> 
					</div>
				</div>
				<div class="row m-3">
					<div class="col text-right">
						<button class="btn btn-outline-primary"><a href="/AppTennisJ2ee/listPlayer">Retour</a></button>
						<button type="submit" class="btn btn-primary" name="action">Ajouter</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	
</body>
</html>