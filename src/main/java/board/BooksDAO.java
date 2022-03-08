package board;

import java.util.List;

import controller.ListCommand;

public interface BooksDAO {
	
	public void insert(BooksVO booksVO);
	public BooksVO selectByNum(Long num);
	public List<BooksVO> selectAll();
	public int count();
	public Object selectByIsbn(String isbn);
	
	public List<BooksVO> selectByKeyword(ListCommand listCommand);
	

}
