package controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.BooksVO;
import board.InsertService;
import board.InsertVO;
import board.NotImageFileException;

@Controller
@RequestMapping("/add")
public class InsertController {

	private InsertService insertService;

	public void setInsertService(InsertService insertService) {
		this.insertService = insertService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String handleAdd(@Valid @ModelAttribute("formData") InsertVO insertVO) {
		return "/books/book_reg_form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleAdd(@Valid @ModelAttribute("formData") InsertVO insertVO, Errors errors, HttpServletRequest request) throws Exception {
		
		new InsertValidator().validate(insertVO, errors);
		if(errors.hasErrors()) {
			System.out.println("입력실패");
			return "/books/book_reg_form";
		}
		
		if (insertService.isbnCheck(insertVO.getIsbn()) == true) {
			System.out.println("insertCon :  isbn 중복");
			return "/error/error_isbn";
		} 
		
		
		
		try {
			//System.out.println(insertVO);

			insertService.insert(insertVO, request);
			return "redirect:/list";

		} catch (NotImageFileException e) {
		
			return "/books/book_reg_form";
		} catch (Exception e) {
			e.printStackTrace();
			return "/books/book_reg_form";
		}
	}

}
