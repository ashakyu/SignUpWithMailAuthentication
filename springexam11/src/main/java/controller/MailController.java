package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Member.MemberVO;
import memberService.MemberService;

@Controller
public class MailController {
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registerGet(MemberVO vo) {
		return "/regist";
	}
	@RequestMapping(value ="regist", method=RequestMethod.POST)
	@ResponseBody
	public String registerPost(@ModelAttribute("regist") MemberVO vo, RedirectAttributes rttr) throws Exception {
		
		System.out.println("controller 옴");
		System.out.println(vo);
		memberService.regist(vo);

		rttr.addFlashAttribute("msg", "regSucceess");
	
		System.out.println("메일보내기 성공");
		return "regist";
	}
	@RequestMapping(value="/emailConfirm", method=RequestMethod.GET)
	public String emailConfirm(String email, Model model) throws Exception {
		memberService.updateAuthstatus(email);
		
		model.addAttribute("email", email);
		
		return "/emailConfirm";
	}
}
