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

@WebServlet("/addPlayer")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PlayerDao playerDao;
    
	@Override
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		playerDao = daoFactory.getPlayerDao();
	}
	
    public AddPlayer() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/addPlayer.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Player player = new Player();
		player.setFirstname(request.getParameter("firstname"));
		player.setLastname(request.getParameter("lastname"));
		player.setSexe(request.getParameter("sexe"));
		
		playerDao.addPlayer(player);
		response.sendRedirect("/AppTennisJ2ee/listPlayer");
	}

}
