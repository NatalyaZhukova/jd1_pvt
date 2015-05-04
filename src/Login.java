

import java.io.IOException;

import tables.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tables.nDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	nDaoImpl myDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
    	super.init();
    	 myDao = nDaoImpl.getDao();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user;
		RequestDispatcher dispatcher;
		user = myDao.getUser(username);
		if (user==null) {
			request.setAttribute("error", "ƒанного пользовател€ не существует");
			dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		else if (user.getPassword().equals(password)) {
			request.setAttribute("user", username);
			dispatcher = request.getRequestDispatcher("/adminController");	
			dispatcher.forward(request, response);
			
		}
		else {
			request.setAttribute("error", "Ќеправильное им€ пользовател€ и\\или пароль");
			dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
