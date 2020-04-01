package com.devbever.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.devbever.beans.Match;

public class MatchDaoImp implements MatchDao{
	DaoFactory daoFactory;
		
	public MatchDaoImp(DaoFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	@Override
	public List<Match> getList() {
		List<Match> matchs = new ArrayList<Match>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connexion = daoFactory.getConnection();
			
			statement = connexion.createStatement();
			
			String req = 
					"select 	" +
					"	mt.id as matchId, mt.ID_EPREUVE as epreuveID, mt.ID_FINALISTE as finalisteId, mt.ID_VAINQUEUR as vainqueurId,\r\n" + 
					"	j.ID as joueurFinalId, j.NOM as joueurFinalNom, j.PRENOM as joueurFinalPrenom, j.SEXE as joueurFinalSexe,\r\n" + 
					"	j2.ID as joueurVainqId, j2.NOM as joueurVainqNom, j2.PRENOM as joueurVainqPrenom, j2.SEXE as joueurVainqSexe,\r\n" + 
					"	e.ID as epreuveId, e.ID_TOURNOI as tournoiId, e.ANNEE as anneeEpreuve, e.TYPE_EPREUVE as typeEpreuve\r\n" + 
					
					"	from match_tennis mt \r\n" + 
					"	inner join joueur j on mt.ID_FINALISTE = j.ID \r\n" + 
					"	inner join joueur j2 on mt.ID_VAINQUEUR = j2.ID \r\n" + 
					"	inner join epreuve e on mt.ID_EPREUVE = e.ID;";
			rs = statement.executeQuery(req);
			
			while(rs.next()) {
				int idMatch = rs.getInt("matchId");
				String winnerFirstname = rs.getString("joueurVainqNom");
				String winnerLastname = rs.getString("joueurVainqPrenom");
				String finalistFirstname = rs.getString("joueurFinalPrenom");
				String finalistLastname = rs.getString("joueurFinalNom");
				int idTournament = rs.getInt("tournoiId");
				int year = rs.getInt("anneeEpreuve");
				
				Match match = new Match();
				match.setIdMatch(idMatch);
				match.setWinnerFirstname(winnerFirstname);
				match.setWinnerLastname(winnerLastname);
				match.setFinalistFirstname(finalistFirstname);
				match.setFinalistLastname(finalistLastname);
				match.setIdTournament(idTournament);
				match.setYear(year);
				
				matchs.add(match);
				
			}
			System.out.println("___ GETLIST REQ ___");
		}  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {
				if (rs != null)
					rs.close();
				if (statement != null)
					statement.close();
				if (connexion != null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}
		return matchs;
	}

	@Override
	public void addMatch(Match match) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			
			String req = "";
			preparedStatement = connexion.prepareStatement(req);
			preparedStatement.setString(1, match.getFinalistFirstname());
			preparedStatement.setString(2, match.getFinalistFirstname());
			preparedStatement.setString(3, match.getWinnerFirstname());
			preparedStatement.setString(4, match.getWinnerLastname());
			preparedStatement.setInt(5, match.getIdTournament());
			preparedStatement.setInt(6, match.getYear());


			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
