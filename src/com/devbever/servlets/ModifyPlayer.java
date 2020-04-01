package com.devbever.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devbever.beans.Player;
import com.devbever.dao.DaoFactory;
import com.devbever.dao.PlayerDao;

@WebServlet("/modifyPlayer")
public class ModifyPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PlayerDao playerDao;
    
	@Override
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		playerDao = daoFactory.getPlayerDao();
	}
	
    public ModifyPlayer() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("modif")) {
			Player player = new Player();
			player = playerDao.getPlayer(Integer.parseInt(request.getParameter("idPlayer")));
			request.setAttribute("player", player);
			request.getServletContext().getRequestDispatcher("/WEB-INF/modifyPlayer.jsp").forward(request, response);

		} else if (request.getParameter("action").equals("delete")) {
			playerDao.deletePlayer(Integer.parseInt(request.getParameter("idPlayer")));
			response.sendRedirect("/AppTennisJ2ee/listPlayer");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Player player = new Player();
		player.setId(Integer.parseInt(request.getParameter("id")));
		player.setFirstname(request.getParameter("firstname"));
		player.setLastname(request.getParameter("lastname"));
		player.setSexe(request.getParameter("sexe"));
		
		playerDao.updatePlayer(player);
		response.sendRedirect("/AppTennisJ2ee/listPlayer");
	}

}
