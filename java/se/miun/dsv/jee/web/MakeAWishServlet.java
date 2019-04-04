package se.miun.dsv.jee.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.miun.dsv.jee.model.LittleKid;
import se.miun.dsv.jee.service.MakeAWishService;

/**
 * Servlet implementation class MakeAWishServlet
 */
@WebServlet("/MakeAWish")
public class MakeAWishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	MakeAWishService MakeAWish;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		int howGood = Integer.parseInt(request.getParameter("howGood"));
		
		LittleKid kid = new LittleKid(firstName, lastName, age, howGood);
		
		List<String> toyList = new ArrayList<String>();
		
		for(int i=1; i<=3; i++) {
			String toy = request.getParameter("toy" + Integer.toString(i));
			if(!toy.equals(""));{
				toyList.add(toy);
			}
		}		

		try {
			MakeAWish.makeAWish(kid, toyList);
			message = "Santa has recieved your wish list!";
		} catch (Exception e) {
			message = "Wish list could not be sent. Have you been good enough this year?";
			e.printStackTrace();
		}
			
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/resultPage").forward(request, response);
	}

}
