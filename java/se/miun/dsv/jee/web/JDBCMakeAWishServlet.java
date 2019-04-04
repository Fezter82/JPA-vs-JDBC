package se.miun.dsv.jee.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.miun.dsv.jee.model.LittleKid;
import se.miun.dsv.jee.model.Toy;
import utils.JdbcDAO;

/**
 * Servlet implementation class JDBCMakeAWishServlet
 */
@WebServlet("/makeAJDBCWish" )
public class JDBCMakeAWishServlet extends HttpServlet {
	private static final long serialVersionUID = 9L;
	
	private JdbcDAO jdbcDAO = new JdbcDAO();
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		int howGood = Integer.parseInt(request.getParameter("howGood"));
		
		LittleKid kid = new LittleKid(firstName, lastName, age, howGood);
		
		List<Toy> toyList = new ArrayList<Toy>();
		
		for(int i=1; i<=3; i++) {
			String toyName = request.getParameter("toy" + Integer.toString(i));
			String manufac = "JDBC";
			
			if(!toyName.equals(""));{
				toyList.add(new Toy(toyName, manufac));
			}
		}
		
		if(jdbcDAO.addWish(kid, toyList)) {
			message = "Santa has recieved your wish list!";
		} else {
			message = "Wish list could not be sent. Have you been good enough this year?";
		}
					
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/resultPage").forward(request, response);
	}

}
