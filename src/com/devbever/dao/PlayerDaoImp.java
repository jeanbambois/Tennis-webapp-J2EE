package com.devbever.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.devbever.beans.Player;

public class PlayerDaoImp implements PlayerDao{
	DaoFactory daoFactory;
	
	public PlayerDaoImp(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<Player> getList() {
		List<Player> players = new ArrayList<Player>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			connexion = daoFactory.getConnection();
			// Ouverture de la connexion pour les statments
			statement = connexion.createStatement();

			// execution requette
			result = statement.executeQuery("SELECT * FROM joueur;");

			// Récupération données
			while (result.next()) {
				int id = result.getInt("id");
				String lastname = result.getString("nom");
				String firstname = result.getString("prenom");
				String sexe = result.getString("sexe");

				Player player = new Player();
				player.setId(id);
				player.setFirstname(firstname);
				player.setLastname(lastname);
				player.setSexe(sexe);
				

				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {
				if (result != null)
					result.close();
				if (statement != null)
					statement.close();
				if (connexion != null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}

		return players;
	}

	@Override
	public Player getPlayer(int id) {
		Connection connexion = null;
		PreparedStatement statement = null; 

       try{
           connexion = daoFactory.getConnection();
           statement=connexion.prepareStatement("SELECT * FROM JOUEUR WHERE ID=?");

           statement.setLong(1, id);
           ResultSet rs= statement.executeQuery();

               if ( rs.next() ) {
            	   Player player = new Player();
            	   
                   player.setId(rs.getInt( "id" ));
                   player.setFirstname(rs.getString( "prenom" ));
                   player.setLastname(rs.getString( "nom" ));
                   player.setSexe(rs.getString( "sexe" ));
                   
                   return player;
               } else {
                   return null;
               }
       }
        catch ( Exception exception ) {
           throw new RuntimeException( exception );
       }
	}

	
	
	@Override
	public void updatePlayer(Player player) {
		Connection connexion = null;
        PreparedStatement statement = null; 

       try{

           connexion = daoFactory.getConnection();
           statement=connexion.prepareStatement("UPDATE JOUEUR SET NOM=?,PRENOM=?, SEXE=? WHERE ID=?");


             statement.setString(1, player.getFirstname());
             statement.setString(2, player.getLastname());
             statement.setString(3, player.getSexe());
             int id = Integer.valueOf(player.getId());
             statement.setLong(4, id);
             statement.executeUpdate();
       }
        catch ( Exception exception ) {
           throw new RuntimeException( exception );
       }


	}

	@Override
	public void addPlayer(Player player) {
		Connection connexion = null;
		PreparedStatement statement = null;
		
		try {
			connexion = daoFactory.getConnection();
			String strSql = "INSERT INTO joueur(PRENOM,NOM,SEXE) VALUES(?,?,?)";
			statement = connexion.prepareStatement(strSql);
			
			statement.setString(1, player.getFirstname());
			statement.setString(2, player.getLastname());
			statement.setString(3, player.getSexe());
			
			statement.executeUpdate();
			
		}
		catch ( Exception exception )
		{
			throw new RuntimeException( exception );
		}
		
	}

	@Override
	public void deletePlayer(int id) {
		Connection connexion = null;
		PreparedStatement statement = null;
		
		try {
			connexion = daoFactory.getConnection();
			String strSql = "DELETE FROM joueur WHERE id=?";
			statement = connexion.prepareStatement(strSql);
			
			statement.setInt(1, id);
			
			statement.executeUpdate();			
		}
		catch ( Exception exception )
		{
			throw new RuntimeException( exception );
		}
	}

}
