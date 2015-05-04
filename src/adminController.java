

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tables.*;
import admin.*;

/**
 * 
 * Servlet implementation class adminController
 */
@WebServlet("/adminController")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	nDaoImpl dao;
    public adminController() {
        super();
        dao = nDaoImpl.getDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		
		Command com = null;
		
		if(operation == null)
		{
			com =  new ShowCommand();
			
		}
		else if(operation.equals("addnews"))
		{
			com = new AddNewsCommand();
		}
		else if(operation.equals("addwritenews"))
		{
			com = new AddWriteNewsCommand();
		}
		else if(operation.equals("editnews")){
			com = new EditNewsCommand();
		}
		else if (operation.equals("editwritenews")){
			com = new EditWriteNewsCommand();
		}
		com.execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
