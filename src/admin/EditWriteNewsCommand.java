package admin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tables.News;
import tables.nDaoImpl;

public class EditWriteNewsCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		nDaoImpl myDao = nDaoImpl.getDao();
		News news = new News();
		
		news.setId(Integer.parseInt(request.getParameter("id")));
		news.setCategory(Integer.parseInt(request.getParameter("category")));
		news.setTitle(request.getParameter("title"));
		news.setRelease_date(request.getParameter("release_date"));
		news.setAuthor(request.getParameter("author"));
		news.setAnnotation(request.getParameter("annotation"));
		news.setFull_text(request.getParameter("fulltext"));
		myDao.updateNews(news);
		
		try {
			response.sendRedirect("adminController");
		} catch (IOException e) {
			Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}

}
