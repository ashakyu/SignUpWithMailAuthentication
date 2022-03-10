package spring;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class BookRegisterService {
	private BookBoardDao bookboardDao;
	
	public BookRegisterService(BookBoardDao bookboardDao) {
		this.bookboardDao = bookboardDao;
	}
	
	public void regist(RegisterRequest req, HttpServletRequest request) throws IllegalStateException, IOException {
		BookBoard bookboard = (BookBoard) bookboardDao.selectByIsbn(req.getIsbn());
		if(bookboard!=null) {
			throw new AlreadyExistingBookException("dup isbn"+req.getIsbn());
		}
		String filename = null;
		MultipartFile uplaodFile = req.getImage();
		if(!uplaodFile.isEmpty()) {
			String orinalFileName = uplaodFile.getOriginalFilename();
			String ext= FilenameUtils.getExtension(orinalFileName);
			UUID uuid = UUID.randomUUID();
			
			filename = uuid+"."+ext;
			
			String root_path=request.getSession().getServletContext().getRealPath("/");
			String attach_path ="resources/upload";
			
			File makeFolder = new File(root_path + attach_path);
			if(!makeFolder.exists()) {
				makeFolder.mkdir();
			}
			System.out.println(root_path+attach_path+filename);
			//경로
			uplaodFile.transferTo(new File(root_path + attach_path +"/"+ filename));
			

		}
		req.setUploadFile(filename);
		
		BookBoard bb = new BookBoard(req.getIsbn(), req.getName(), req.getAuth(), req.getPublisher(),
				req.getPrice(), req.getUploadFile(), req.getDescription());
		bookboardDao.insert(bb);
	}
}
