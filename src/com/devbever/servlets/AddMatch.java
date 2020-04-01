package com.devbever.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devbever.beans.Match;
import com.devbever.dao.DaoFactory;
import com.devbever.dao.MatchDao;
import com.devbever.dao.PlayerDao;

@WebServlet("/addMatch")
public class AddMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MatchDao matchDao;
	PlayerDao playerDao;
    
	@Override
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		matchDao = daoFactory.getMatchDao();
		playerDao = daoFactory.getPlayerDao();
	}
	
    public AddMatch() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("players", playerDao.getList());
		request.getServletContext().getRequestDispatcher("/WEB-INF/addMatch.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("addMatch")) {
			Match match = new Match();
			
			String winnerFirstname = request.getParameter("winnerFirstName");
			String winnerLastname = request.getParameter("winnerLastName");
			String finalistFirstname = request.getParameter("finalistFirstName");
			String finalistLastname = request.getParameter("finalistLastName");
			int idTournament = Integer.parseInt(request.getParameter("idTournament"));
			int year = Integer.parseInt(request.getParameter("year"));
			
			match.setWinnerFirstname(winnerFirstname);
			match.setWinnerLastname(winnerLastname);
			match.setFinalistFirstname(finalistFirstname);
			match.setFinalistLastname(finalistLastname);
			match.setIdTournament(idTournament);
			match.setYear(year);
			
			matchDao.addMatch(match);
		}
		
	}
}
