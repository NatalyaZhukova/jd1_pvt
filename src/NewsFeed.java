

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tables.Category;
import tables.News;
import tables.nDaoImpl;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/NewsFeed")
public class NewsFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	nDaoImpl myDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsFeed() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    }
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		myDao = nDaoImpl.getDao();
		RequestDispatcher dispatcher;
		
		List<Category> categories  = myDao.getCategories();
		StringBuffer menu = new StringBuffer();
		for (int i=0; i<categories.size(); i++){
			menu.append("<li><a href='NewsFeed?cat=");
			menu.append(categories.get(i).getId());
			menu.append("'>");
			menu.append(categories.get(i).getName());
			menu.append("</a></li>");
		}
		request.setAttribute("menu", menu.toString());
		
	List<News> newsList=null;	
	String category = request.getParameter("cat");
	String newspage = request.getParameter("id");
	 if ((category==null) && (newspage==null)) {
		  newsList = myDao.getAllNews();
	 }
	 else if (category!=null) {
		 int id = Integer.parseInt(category);
		  newsList = myDao.getNewsByCategory(id);
	 }
	 else {
		 int id = Integer.parseInt(newspage);
		 News news = myDao.getNews(id);
		 request.setAttribute("news", news);
		 dispatcher = request.getRequestDispatcher("/newspage.jsp");
		 dispatcher.forward(request, response);
	 }
	
	request.setAttribute("newsList", newsList);
	dispatcher = request.getRequestDispatcher("/newsfeed.jsp");
	dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
