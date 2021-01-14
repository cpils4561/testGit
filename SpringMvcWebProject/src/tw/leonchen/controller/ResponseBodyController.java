package tw.leonchen.controller;


import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ResponseBodyController {

	@RequestMapping(path="/response/puomeow" ,method = RequestMethod.GET)
	public @ResponseBody String processResponseBody() {
		return "this is from puomeow";
	}
	
	@RequestMapping(path="/response/puomeow2" ,method = RequestMethod.GET
			,produces = "text/plain;charset=UTF-8")
	public @ResponseBody String processEncodeResponseBody() {
		return "來自破貓的訊息";
	}
	
	@RequestMapping(path="/response/puomeow3" ,method = RequestMethod.GET
			,produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String>   processEntityResponseBody(){
		return new ResponseEntity<String>("你已經死了(403)",HttpStatus.FORBIDDEN);
		
	}
	
	@RequestMapping(path="/response/images",method = RequestMethod.GET
			,produces = "text/plain;charset=UTF-8")
	public void processImagesByArray(HttpServletRequest req,HttpServletResponse resp) throws IOException {
	 InputStream in = req.getServletContext().getResourceAsStream("/WEB-INF/resources/images/abc.jpg");	
	 IOUtils.copy(in,resp.getOutputStream());
	}
	
	@RequestMapping(path="/response/images2",method = RequestMethod.GET
			,produces = "text/plain;charset=UTF-8")
	public @ResponseBody byte[] processImagesByteArray(HttpServletRequest req,HttpServletResponse resp) throws IOException {
	 InputStream in = req.getServletContext().getResourceAsStream("/WEB-INF/resources/images/abc.jpg");	
	 resp.setContentType(MediaType.IMAGE_JPEG_VALUE);
	 return IOUtils.toByteArray(in);
	}
	
}
