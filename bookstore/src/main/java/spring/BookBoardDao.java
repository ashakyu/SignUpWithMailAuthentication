package spring;

import java.util.List;

public interface BookBoardDao {
	public void insert(BookBoard bookboard);
	public List<BookBoard> selectAll();
	public BookBoard selectById(int id);
	public List<BookBoard> selectBySearch(String seachType, String keyword);
	public Object selectByIsbn(String isbn);
}
	