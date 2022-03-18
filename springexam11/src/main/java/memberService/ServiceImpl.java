package memberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import Member.MemberVO;
import Member.UserDAO;
import controller.MailHandler;
import utils.Tempkey;


@Service
public class ServiceImpl implements MemberService {
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Autowired
	JavaMailSender mailSender;

	@Override
	public void updateAuthstatus(String email) throws Exception {
		userDAO.updateAuthstatus(email);
	}

	@Override
	public void regist(MemberVO memberVO) throws Exception {
		
		userDAO.insert(memberVO);
		String key = new Tempkey().getKey(10, false);
		
		System.out.println("key 생성");
		userDAO.createAuthkey(memberVO.getEmail(), key);

		System.out.println(key);
		System.out.println("메일 보내기");
		
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("[홈페이지 이메일 인증]"); // 메일제목
		sendMail.setText( // 메일내용
				"<h1>메일인증</h1>" +
				"<a href='http:/localhost:8080/springexam11/emailConfirm?email=" + memberVO.getEmail()+
				"&key=" + key +
				"' target='_blenk'>이메일 인증 확인</a>");
		sendMail.setFrom("ejdd9630@gmail.com", "보낼사람 이름"); // 보낸이
		sendMail.setTo(memberVO.getEmail()); // 받는이
		sendMail.send();

		System.out.println("메일 보내기 완료");
	}
	

}
