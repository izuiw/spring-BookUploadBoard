package board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import controller.ListCommand;

public class BooksDAOImpl implements BooksDAO{
	
	private SqlSessionTemplate sqlST;

	public BooksDAOImpl (SqlSessionTemplate sqlST) {
		this.sqlST = sqlST;
	}
	
	@Override
	public void insert(BooksVO booksVO) {
		// TODO Auto-generated method stub
		sqlST.insert("insert", booksVO);
		
	}

	@Override
	public BooksVO selectByNum(Long num) {
		// TODO Auto-generated method stub
		return sqlST.selectOne("selectByNum", num);
	}

	@Override
	public List<BooksVO> selectAll() {
		// TODO Auto-generated method stub
		return sqlST.selectList("list");
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return sqlST.selectOne("count");
	}

	@Override
	public Object selectByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return sqlST.selectOne("selectByIsbn", isbn);
	}

	@Override
	public List<BooksVO>  selectByKeyword(ListCommand listCommand) {
		// TODO Auto-generated method stub
		
		return sqlST.selectList("selectByKeyword", listCommand);
	}

}
