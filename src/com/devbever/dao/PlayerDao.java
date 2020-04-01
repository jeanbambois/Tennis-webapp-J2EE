package com.devbever.dao;

import java.util.List;

import com.devbever.beans.Player;

public interface PlayerDao {
	List<Player> getList();
	Player getPlayer(int id);
	void updatePlayer(Player player);
	void addPlayer(Player player);
	void deletePlayer(int id);
}
