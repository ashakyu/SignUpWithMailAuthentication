package spring;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class BookBoardDaoImpl implements BookBoardDao{
	private SqlSessionTemplate sqlSessionTemplate;
	public BookBoardDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public void insert(BookBoard bookboard) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("insert", bookboard);
	}

	@Override
	public List<BookBoard> selectAll() {
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public BookBoard selectById(int id) {
		List<BookBoard> results = sqlSessionTemplate.selectList("selectById",id);
		return results.isEmpty()? null:results.get(0);
	}

	@Override
	public List<BookBoard> selectBySearch(String keyword, String searchType) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		System.out.println(map.get("searchType"));
		System.out.println(map.get("keyword"));
		List<BookBoard> list = sqlSessionTemplate.selectList("selectBySearch", map);
		return list;
	}
	
	@Override
	public Object selectByIsbn(String isbn) {
		return sqlSessionTemplate.selectOne("selectByIsbn", isbn);
	}
	
	
}
