package admin;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tables.Category;
import tables.News;
import tables.nDaoImpl;

public class EditNewsCommand extends Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		nDaoImpl myDao = nDaoImpl.getDao();
		int id=Integer.parseInt(request.getParameter("id"));
		News news = myDao.getNews(id);
		request.setAttribute("news", news);
		List<Category> categories = myDao.getCategories();
		request.setAttribute("categories", categories);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/editnews.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, e);
			
		}
		
		
	}

}
