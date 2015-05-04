
package tables;

import java.util.List;


public interface nDao {
  abstract Category getCategory(int id);
  abstract List<Category> getCategories();
  abstract int addCategory(Category category);
  abstract int deleteCategory(int id);

  abstract User getUser(String email);
  abstract List<User> getUsers();
  abstract int addUser(User user);
  abstract int deleteUser(String email);
  
  abstract News getNews(int id);
  abstract List<News> getNewsByCategory(int category);
  abstract List<News> getNewsByDate(String date);
  abstract List<News> getAllNews();
  abstract int addNews(News news);
  abstract int updateNews(News news);
  abstract int deleteNews(int id);
  abstract List<String> getDatesWithNews();
}
