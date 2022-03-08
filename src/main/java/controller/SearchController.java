package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.BooksDAO;
import board.BooksVO;

@Controller
public class SearchController {

	
	private BooksDAO booksDAO;
	
	public void setBooksDAO (BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String handleSearch(Model model, @ModelAttribute("listCommand")ListCommand listCommand) {
		int searchCount = -1;
		//System.out.println("서치컨트롤 : " + keyword);
		//System.out.println(listCommand);
		List<BooksVO> searchList = booksDAO.selectByKeyword(listCommand);
		
		if(searchList  == null) {
			searchCount = 0;
		} else {
			searchCount = searchList.size();
		}
		//System.out.println("서치컨드롤 2 : " + searchCount + " / " + searchList);
		model.addAttribute("searchCount", searchCount);
		model.addAttribute("searchList", searchList);
		return "/books/book_list";
		
		
	}
	
}
