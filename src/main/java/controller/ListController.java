package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.BooksDAO;
import board.BooksVO;

@Controller
public class ListController {
	
	private BooksDAO booksDAO;
	
	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		int count = booksDAO.count();
		List<BooksVO> list = booksDAO.selectAll();

		model.addAttribute("count", count);
		model.addAttribute("list", list);		
		return "/books/book_list";
	}
	
	
	
	

}
