package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.BookBoard;
import spring.BookBoardDao;

@Controller
public class BookListController {
	private BookBoardDao bookboardDao;
	
	public void setBookBoardDao(BookBoardDao bookboardDao) {
		this.bookboardDao = bookboardDao;
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		List<BookBoard> books = bookboardDao.selectAll();
		model.addAttribute("books", books);
		return "/book_list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String list(@ModelAttribute("condition")ListCommand listCommand , Model model) {
		if(listCommand.getKeyword() != null) {
			List<BookBoard> books = bookboardDao.selectBySearch(listCommand.getKeyword(),listCommand.getSearchType());
			System.out.println(listCommand.toString());
			model.addAttribute("books", books);
			System.out.println(model.toString());
			return "book_list";
		}
		return "book_list";
	}
}
