package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.BookBoard;
import spring.BookBoardDao;

@Controller
public class BookDetailController {
	private BookBoardDao bookboardDao;
	
	public void setBookBoardDao(BookBoardDao bookboardDao) {
		this.bookboardDao = bookboardDao;
	}
	
	@RequestMapping("/detail/{num}")
	public String detail(@PathVariable("num") int num, Model model) {
		BookBoard bookboard = bookboardDao.selectById(num);
		if(bookboard == null) {
			
		}
		model.addAttribute("book", bookboard);
		return "book_detail";
	}
}
