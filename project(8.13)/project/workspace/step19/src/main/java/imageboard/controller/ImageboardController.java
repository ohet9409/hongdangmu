package imageboard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import imageboard.bean.ImageboardDTO;

@Controller
public class ImageboardController {
	@RequestMapping(value = "/imageboard/imageboardWrtieForm", method = RequestMethod.GET)
	public String imageboardWriteForm() {
		return "imageboardWriteForm"; // /imageboard/imageboardWrtieForm.jsp
	}

	// 매개변수 MultipartFile img는
	// <input type = "file" name = "img">의 name과 일치해야 한다.
	@RequestMapping(value = "/imageboard/imageboardWrtie", method = RequestMethod.POST)
	public ModelAndView imageboardWrite(MultipartFile img, HttpServletRequest request) {
		String filePath = "D:\\android_3rd_oh\\Dropbox\\spring\\workspace\\step19\\src\\main\\webapp\\storage";
		System.out.println("img = " + img);
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);
		String imageId = request.getParameter("imageId");
		String imageName = request.getParameter("imageName");
		String imageContent = request.getParameter("imageContent");
		int imagePrice = 0;
		if (request.getParameter("imagePrice") != null)
			imagePrice = Integer.parseInt(request.getParameter("imagePrice"));
		int imageQty = 0;
		if (request.getParameter("imageQty") != null)
			imageQty = Integer.parseInt(request.getParameter("imageQty"));
		System.out.println("imageId = " + imageId);
		try {
			// img.getInputStream() : 업로드한 파일 데이터를 읽어오는 InputStream을 구한다.
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImage1(fileName);
		imageboardDTO.setImageId(imageId);
		imageboardDTO.setImageContent(imageContent);
		imageboardDTO.setImageName(imageName);
		imageboardDTO.setImagePrice(imagePrice);
		imageboardDTO.setImageQty(imageQty);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("imageboardWrite");
		modelAndView.addObject("imageboardDTO", imageboardDTO);
		return modelAndView;
	}
}
