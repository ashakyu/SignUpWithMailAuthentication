package memberService;

import Member.MemberVO;

public interface MemberService {
	
	public void regist(MemberVO memberVO) throws Exception;
	public void updateAuthstatus(String email) throws Exception;
}
