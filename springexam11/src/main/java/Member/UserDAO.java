package Member;

public interface UserDAO {
	//이메일 인증
	public void createAuthkey(String email, String userkey) throws Exception;
	public void updateAuthstatus(String email) throws Exception;
	public void insert(MemberVO memberVO);
	
}
