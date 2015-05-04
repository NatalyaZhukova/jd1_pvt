package admin;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tables.*;

public class ShowCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List<News> list=null;
		List<Category> categories;
		Iterator<News> iterator;
		
		String category = request.getParameter("cat");
		String date = request.getParameter("date");
		String categoryName="";
		String dateName="";
		
		nDaoImpl myDao = nDaoImpl.getDao();
		categories = myDao.getCategories();
		
		if ((category==null) && (date==null)) {
			  list = myDao.getAllNews();
		 }
		 else if (category!=null) {
			 int id = Integer.parseInt(category);
			  list = myDao.getNewsByCategory(id);
			  
		 }
		 else if (date!=null){
			list=myDao.getNewsByDate(date);
			
		 }
		
		
		iterator = list.iterator();
		StringBuffer st = new StringBuffer();
		st.append("<ul>");
		while(iterator.hasNext()) {
			News n = iterator.next();
			st.append("<li>");
			st.append("<a href=\"adminController?operation=editnews&id=");
			st.append(n.getId());
			st.append("\">");
			st.append(n.getTitle());
			st.append("</a>");
			st.append("</li>");
		}
		st.append("</ul>");
		
		StringBuffer menu = new StringBuffer();
		for (int i=0; i<categories.size(); i++){
			menu.append("<li><a href='adminController?cat=");
			menu.append(categories.get(i).getId());
			menu.append("'>");
			menu.append(categories.get(i).getName());
			menu.append("</a></li>");
		}
		
		List<String> dates = myDao.getDatesWithNews();
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mainadmin.jsp");
		request.setAttribute("menu", menu.toString());
		request.setAttribute("news", st.toString());
		request.setAttribute("dates", dates);
		
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, e);
			}
	}

}
