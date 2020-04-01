package com.devbever.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devbever.dao.DaoFactory;
import com.devbever.dao.MatchDao;


@WebServlet("/listMatch")
public class ListMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MatchDao matchDao;
	       
	@Override
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		matchDao = daoFactory.getMatchDao();
	}
	
    public ListMatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("matchs", matchDao.getList());
		request.getServletContext().getRequestDispatcher("/WEB-INF/listMatch.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
