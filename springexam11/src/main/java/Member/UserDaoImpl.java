package Member;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDAO{
	private SqlSessionTemplate sqlSessionTemplate;
	public UserDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void createAuthkey(String email, String userkey) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("userkey", userkey);
		
		sqlSessionTemplate.selectOne("createAuthkey", map);
		System.out.println("creteAuthkey 완료");
	}

	@Override
	public void updateAuthstatus(String email) throws Exception {
		sqlSessionTemplate.update("updateAuthstatus", email);
		System.out.println("updateAuthsatus 완료");
	}

	@Override
	public void insert(MemberVO memberVO) {
		sqlSessionTemplate.insert("insert", memberVO);
		System.out.println("insert완료");
	
	}

}
