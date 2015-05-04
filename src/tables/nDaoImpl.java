package tables;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class nDaoImpl implements nDao {
    
    Connection con;
    
  private  nDaoImpl() {
        try {
        	Properties prop = new Properties();
        	InputStream input = new FileInputStream("D:\\myprojects\\java\\NewsFeed\\WebContent\\WEB-INF\\config.properties");
        	prop.load(input);
        	
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = prop.getProperty("database");
            String name = prop.getProperty("dbuser");
            String password = prop.getProperty("dbpass");
            
            con = DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  private static nDaoImpl inst;
  
  public static nDaoImpl getDao() {
      if (inst==null) {
      inst = new nDaoImpl();
      }
      return inst;
  }
  

    @Override
    public Category getCategory(int id) {
        PreparedStatement pst;
        Category cat=null;
        try {
            String query = "SELECT * FROM category WHERE id=?;";
            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            while (result.next()){
            cat = new Category();
            cat.setId(result.getInt(1));
            cat.setName(result.getString(2));
            }
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cat;
    }

    @Override
    public List<Category> getCategories() {
       List<Category> categories = new ArrayList<Category>();
       Statement statement;
       
       try {
    	String query = "SELECT * FROM category;";
		statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		while (result.next()) {
			Category cat = new Category();
			cat.setId(result.getInt(1));
			cat.setName(result.getString(2));
			categories.add(cat);
		}
		statement.close();
		
	} catch (SQLException ex) {
		 Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
	}
       
	return categories;
       
    }

    @Override
    public int addCategory(Category category) {
        int res=0;
        PreparedStatement pst;
        
        
        try {
        	String query = "INSERT INTO category (id, name) VALUES (?, '?')";
			pst = con.prepareStatement(query);
			pst.setInt(1, category.getId());
			pst.setString(2, category.getName());
			res = pst.executeUpdate();
			pst.close();
			
		} catch (SQLException ex) {
			 Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        
        return res;
    }

    @Override
    public int deleteCategory(int id) {
        int res=0;
        PreparedStatement pst;
        
        String query = "DELETE FROM category WHERE id=?;";
        try {
			pst=con.prepareStatement(query);
			pst.setInt(1, id);
	        res = pst.executeUpdate();
	        pst.close();
		} catch (SQLException ex) {
			 Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return res;
    }

    @Override
    public User getUser(String email) {
    	  PreparedStatement pst;
          User user=null;
          try {
              String query = "SELECT * FROM user WHERE email=?;";
              pst = con.prepareStatement(query);
              pst.setString(1, email);
              ResultSet result = pst.executeQuery();
              while (result.next()) {
              user = new User();
              user.setEmail(result.getString(1));
              user.setPassword(result.getString(2));
              user.setFirst_name(result.getString(3));
              user.setLast_name(result.getString(4));
              }
              pst.close();
              
          } catch (SQLException ex) {
              Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          return user;
    }

    @Override
    public List<User> getUsers() {
    	   List<User> users = new ArrayList<User>();
         Statement statement;
         
         
         try {
      	String query = "SELECT * FROM users;";
  		statement = con.createStatement();
  		ResultSet result = statement.executeQuery(query);
  		while (result.next()) {
  			User user = new User();
            user.setEmail(result.getString(1));
            user.setPassword(result.getString(2));
            user.setFirst_name(result.getString(3));
            user.setLast_name(result.getString(4));
            users.add(user);
  		}
  		statement.close();
  	} catch (SQLException ex) {
  		Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
  	}
    
  	return users;
         
    }

    @Override
    public int addUser(User user) {
        int res=0;
        PreparedStatement pst;
        
        
        try {
        	String query = "INSERT INTO user (email, password, first_name, last_name) VALUES ('?', '?', '?', '?');";
			pst = con.prepareStatement(query);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFirst_name());
			pst.setString(4, user.getLast_name());
			res = pst.executeUpdate();
			pst.close();
			
		} catch (SQLException ex) {
		  Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return res;
    }

    @Override
    public int deleteUser(String email) {
        int res=0;
        PreparedStatement pst;
        
        
        try {
        	String query = "DELETE FROM user WHERE email='?';";
			pst = con.prepareStatement(query);
			pst.setString(1, email);
		    res=pst.executeUpdate();
		    pst.close();
		} catch (SQLException ex) {
			Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

        
        return res;
    }

    @Override
    public News getNews(int id) {
    	  PreparedStatement pst;
          News news=null;
          try {
              String query = "SELECT * FROM news WHERE id=?;";
              pst = con.prepareStatement(query);
              pst.setInt(1, id);
              ResultSet result = pst.executeQuery();
              while(result.next()){
              news = new News();
              news.setId(result.getInt(1));
              news.setCategory(result.getInt(2));
              news.setAuthor(result.getString(3));
              news.setTitle(result.getString(4));
              news.setRelease_date(result.getString(5));
              news.setAnnotation(result.getString(6));
              news.setFull_text(result.getString(7));
              }
              pst.close();
              
          } catch (SQLException ex) {
              Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          return news;
    }

    @Override
    public List<News> getAllNews() {
    	 List<News> news = new ArrayList<News>();
         Statement statement;
         
         
         try {
      	String query = "SELECT * FROM news ORDER BY release_date;";
  		statement = con.createStatement();
  		ResultSet result = statement.executeQuery(query);
  		while (result.next()) {
  			News oNews = new News();
  			 oNews.setId(result.getInt(1));
             oNews.setCategory(result.getInt(2));
             oNews.setAuthor(result.getString(3));
             oNews.setTitle(result.getString(4));
             oNews.setRelease_date(result.getString(5));
             oNews.setAnnotation(result.getString(6));
             oNews.setFull_text(result.getString(7));
  			news.add(oNews);
  		}
  		statement.close();
  		
  	} catch (SQLException ex) {
  		Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
  	}
         
  	return news;
         
      
    }

    @Override
    public int addNews(News news) {
        int res=0;
        PreparedStatement pst;
        
        
        try {
        	String query = "INSERT INTO news (id, category, author, title, release_date, annotation, full_text) VALUES (?,?,?,?,?,?,?);";
			pst = con.prepareStatement(query);
			pst.setInt(1, news.getId());
			pst.setInt(2, news.getCategory());
			pst.setString(3, news.getAuthor());
			pst.setString(4, news.getTitle());
			pst.setString(5, news.getRelease_date());
			pst.setString(6, news.getAnnotation());
			pst.setString(7, news.getFull_text());
			res=pst.executeUpdate();
			pst.close();
		} catch (SQLException ex) {
			Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        
        
        return res;
    }

    @Override
    public int deleteNews(int id) {
        int res=0;
        PreparedStatement pst;
        
        
        try {
        	String query = "DELETE FROM news WHERE id=?;";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
		    res = pst.executeUpdate();
		    pst.close();
		} catch (SQLException ex) {
			Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return res;
      
    }


	@Override
	public List<News> getNewsByCategory(int category) {
		 List<News> news = new ArrayList<News>();
         PreparedStatement pst;
         
         
         try {
      	String query = "SELECT * FROM news WHERE category=?;";
  		pst = con.prepareStatement(query);
  		pst.setInt(1, category);
  		ResultSet result = pst.executeQuery();
  		while (result.next()) {
  			News oNews = new News();
  			 oNews.setId(result.getInt(1));
             oNews.setCategory(result.getInt(2));
             oNews.setAuthor(result.getString(3));
             oNews.setTitle(result.getString(4));
             oNews.setRelease_date(result.getString(5));
             oNews.setAnnotation(result.getString(6));
             oNews.setFull_text(result.getString(7));
  			news.add(oNews);
  		}
  		pst.close();
  		
  	} catch (SQLException ex) {
  		Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
  	}
         
  	return news;
         
      
	}


	@Override
	public List<News> getNewsByDate(String date) {
		 List<News> news = new ArrayList<News>();
         PreparedStatement pst;
         
         
         try {
      	String query = "SELECT * FROM news WHERE release_date=?;";
  		pst = con.prepareStatement(query);
  		pst.setString(1, date);
  		ResultSet result = pst.executeQuery();
  		while (result.next()) {
  			News oNews = new News();
  			 oNews.setId(result.getInt(1));
             oNews.setCategory(result.getInt(2));
             oNews.setAuthor(result.getString(3));
             oNews.setTitle(result.getString(4));
             oNews.setRelease_date(result.getString(5));
             oNews.setAnnotation(result.getString(6));
             oNews.setFull_text(result.getString(7));
  			news.add(oNews);
  		}
  		pst.close();
  		
  	} catch (SQLException ex) {
  		Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
  	}
         
  	return news;
	}


	@Override
	public List<String> getDatesWithNews() {
		List<String> dates=null;
		Statement statement;
        
        
        try {
     	String query = "SELECT DISTINCT release_date FROM news ORDER BY release_date ";
 		statement = con.createStatement();
 		dates = new ArrayList<String>();
 		ResultSet result = statement.executeQuery(query);
 		
 		while (result.next()) {
 			String date = result.getString(1);
 			dates.add(date);
 		}
 		statement.close();
 		
 	} catch (SQLException ex) {
 		Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
 	}
		
		
		return dates;
	}


	@Override
	public int updateNews(News news) {
		int res=0;
	 	PreparedStatement pst;
	        
	        
	   try {
	       String query = "UPDATE  news SET  category=?, author=?, title=?, release_date=?, annotation=?, full_text=? WHERE id=?;";
			pst = con.prepareStatement(query);
			pst.setInt(1, news.getCategory());
			pst.setString(2, news.getAuthor());
			pst.setString(3, news.getTitle());
			pst.setString(4, news.getRelease_date());
			pst.setString(5, news.getAnnotation());
			pst.setString(6, news.getFull_text());
			pst.setInt(7, news.getId());
			res = pst.executeUpdate();
			pst.close();
			} catch (SQLException ex) {
				Logger.getLogger(nDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
			}
	        
	        return res;
		
		
	}
    
}
