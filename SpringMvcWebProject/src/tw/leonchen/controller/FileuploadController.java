package tw.leonchen.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;




import tw.leonchen.model.Picture;
import tw.leonchen.model.PictureService;


@Controller
public class FileuploadController {
	 String s;
	@Autowired
	private HttpServletRequest req;
	
	@Autowired
	private PictureService pservice;


	
	@RequestMapping(path="/fileuploadentrypage",method = RequestMethod.GET)
	 public String processEntryPage() {		 
		 return "Fileupload";
	 }
	
	@RequestMapping(path="/fileuploadcontroller",method = RequestMethod.POST)
	public  String /*ResponseEntity<byte[]>*/ processFileupload(@RequestParam(name="myfile") MultipartFile mfile,Model m) throws IllegalStateException, IOException{
		String filename= mfile.getOriginalFilename();
		System.out.println("檔名"+filename);
	 String savepath =req.getServletContext().getRealPath("/")+"uploadtempDir\\";
    //建立儲存路徑 :現在的專案的路徑+/+一個資料夾\\
	 File file = new File(savepath);
	 file.mkdirs();
	 //建一個資料夾
	 
	 File savefile = new File(file,filename);
	 //存檔                   //路徑  檔名
	// mfile.transferTo(savefile); 
	//把圖片儲存路徑儲存到資料庫
	 System.out.println("檔名"+filename+"路徑"+savefile);
	 
	 InputStream inn = mfile.getInputStream();
	 FileOutputStream fos = new FileOutputStream(savefile);
	 byte[] bb = new byte[1024];
	 int le = -1;
	 while((le=inn.read(bb))!=-1) {
		 fos.write(bb,0,le);		 
	 }
 String url ="uploadtempDir/";
//	 System.out.println(url);
	 m.addAttribute("selection",url);
	 
	 if(filename!=null&& filename.length()!=0) {
		 savePicture(filename,savepath+filename);
		 System.out.println(savepath+filename);
	 }
	
//	 List<Picture> List = pservice.selectAll();
//	 for(Picture ll : List) {
//		  File w2 = new File(file,ll.getFilename());
//		  ByteArrayInputStream bais = new ByteArrayInputStream(ll.getPicture()); 
//		  BufferedImage bi1 =ImageIO.read(bais); 
//          ImageIO.write(bi1, "jpg", new FileOutputStream(w2));//不管輸出什麼格式圖片,此處不需改動   
//	 }

	 m.addAttribute("picture",pservice.selectAll());

	 
	

//	 HttpHeaders headers = new HttpHeaders();
//	 headers.setContentType(MediaType.IMAGE_JPEG);//IMAGE_JPEG
	return "success";
	 
		//return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(savefile),headers,HttpStatus.OK);
	}
	
	public void   savePicture(String filename,String savefilepath) throws IOException {
		Picture pic = new Picture();
		pic.setFilename(filename);
		
		InputStream in = new FileInputStream(savefilepath);
		
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     BufferedImage read = ImageIO.read( in);
	     ImageIO.write(read, "jpg", baos);
	     //將目標檔案轉換成byte陣列
	     byte[] bytes = baos.toByteArray();
		
		
//		byte[] b = new byte[in.available()];
//	
//		in.read();
		in.close();
	     pic.setPicture(bytes);
	     pservice.insert(pic);
//	     System.out.println(b);
//	s = Base64.getEncoder().encodeToString(b); 
	    
	}
}
