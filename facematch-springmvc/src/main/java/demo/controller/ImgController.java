package demo.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Controller
public class ImgController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@RequestMapping("/index.do")
	public String index(ModelMap modelMap) {
		return "face/index";
	}
	
	@ResponseBody
	@RequestMapping("/img.do")
	public void index(@RequestParam("img") CommonsMultipartFile img,ModelMap modelMap) {
			this.transTO(img);
	}
	
	private void transTO(MultipartFile file){
		String path = "C:/temp/img";
		File file2 = new File(path);
		
		if (!file2.exists()) {
			file2.mkdirs();
		}
		
		File file3 = new File(path + File.separator + "cover.png");
		if (file3.exists()) {
			file3.delete();
		}
		
		try {
			file.transferTo(file3);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
