package com.devbever.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devbever.dao.DaoFactory;
import com.devbever.dao.PlayerDao;

@WebServlet("/listPlayer")
public class ListPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PlayerDao playerDao;
    
	@Override
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		playerDao = daoFactory.getPlayerDao();
	}
	
    public ListPlayer() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("players", playerDao.getList());
		request.getServletContext().getRequestDispatcher("/WEB-INF/listPlayer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
