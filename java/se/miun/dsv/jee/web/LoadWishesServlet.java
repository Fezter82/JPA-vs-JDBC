package se.miun.dsv.jee.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.miun.dsv.jee.model.LittleKid;
import se.miun.dsv.jee.service.MakeAWishService;
import utils.JdbcDAO;

/**
 * Servlet implementation class LoadWishesServlet
 */
@WebServlet("/loadWishes")
public class LoadWishesServlet extends HttpServlet {
	private static final long serialVersionUID = 7L;
	
	private JdbcDAO jdbcDAO = new JdbcDAO();
       
	@EJB
	MakeAWishService MakeAWish;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/****** JPA SECTION ***********/
		List<LittleKid> jpaKids = null;
		
		try {
			jpaKids = MakeAWish.loadWishes();
		} catch (Exception e) {
			e.printStackTrace();
		}	
        
		if(jpaKids.size() > 0) {
			request.setAttribute("kids", jpaKids);
		}
		
		/***** JDBC SECTION ***********/
		List<LittleKid> jdbcKids = null;
		jdbcKids = jdbcDAO.getWishes();
				
		if(jdbcKids.size() > 0) {
			request.setAttribute("jdbcKids", jdbcKids);
		}
		
		getServletContext().getRequestDispatcher("/meetSanta").forward(request, response);
		
	}    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
