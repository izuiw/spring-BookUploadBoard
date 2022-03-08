package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import board.BooksDAO;
import board.BooksVO;

@Controller
public class ReadController {

	private BooksDAO booksDAO;
	
	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	
	@RequestMapping("/read/{num}")
	public String handleRead(@PathVariable("num")Long num, Model model) {
		
		BooksVO booksVO = booksDAO.selectByNum(num);
		
		if(booksVO == null) {
			return "redirect:/main";
		}
		model.addAttribute("list", booksVO);
		return "/books/book_detail";
		
	}
	
	
}
