package board;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

public class InsertService {

	private BooksDAO booksDAO;

	// 디폴트 생성자
	public InsertService() {
	}

	public InsertService(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}

	public void insert(InsertVO insertVO, HttpServletRequest request) throws IOException {
		
		String filename = null;

		MultipartFile image = insertVO.getImage();
		if (!image.isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String originalFilename = image.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFilename);
			String webpath = "/resources/upload";
			String realpath = request.getServletContext().getRealPath(webpath)+"/";

			
			
			filename = uuid + "." + ext;
			
			image.transferTo(new File(realpath + filename));

		}

		insertVO.setFilename(filename);
		//System.out.println("서비스 클래스 : " + insertVO);

		if(insertVO != null) {	
			BooksVO booksVO = new BooksVO(insertVO.getIsbn(), insertVO.getFilename(),

					insertVO.getName(), insertVO.getWriter(), insertVO.getPublisher(), insertVO.getContent(),
					insertVO.getPrice());
			booksDAO.insert(booksVO);
			//System.out.println("booksVO : " + booksVO);
		}
	}
	
	public Boolean isbnCheck(String isbn) {
		String tmpIsbn = (String) booksDAO.selectByIsbn(isbn);
		
		Boolean result = true;
		if (tmpIsbn != null) {
			System.out.println("isbn중복");
			result = true;
			
		} else if(tmpIsbn == null) {
			result = false;
		}
		
		return result;
	}

}
