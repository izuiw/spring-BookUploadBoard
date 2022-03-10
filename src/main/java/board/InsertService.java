package board;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
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
			InputStream inputStream = image.getInputStream();
			
			boolean isValid = FileUtils.validImgFile(inputStream);
			System.out.println("검증:"+isValid);
			if(!isValid) {
				System.out.println("이미지 파일 아님");
				throw new NotImageFileException("image" + insertVO.getImage());
			}
			
			UUID uuid = UUID.randomUUID();
			String originalFilename = image.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFilename);
			String webpath = "/resources/upload/";
			String realpath = request.getSession().getServletContext().getRealPath(webpath);

			
			
			filename = uuid + "." + ext;
			
			
			try {
				
				image.transferTo(new File(realpath + filename));
			}catch(IOException e) {
				e.printStackTrace();
			}

		}

		insertVO.setFilename(filename);
		System.out.println("서비스 클래스 : " + insertVO);

		if(insertVO != null) {	
			BooksVO booksVO = new BooksVO(insertVO.getIsbn(), insertVO.getFilename(),

					insertVO.getName(), insertVO.getWriter(), insertVO.getPublisher(), insertVO.getContent(),
					insertVO.getPrice());
			booksDAO.insert(booksVO);
			System.out.println("booksVO : " + booksVO);
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
