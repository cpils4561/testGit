package tw.leonchen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.leonchen.model.MyException;

@Controller
public class MySystemExceptionHandle {

	@ExceptionHandler(Exception.class)
	public Object exceptionHandle(Exception e) {
		String errmsg ="nononono exception jojo";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errmsg);
	}
	
	@ExceptionHandler(MyException.class)
	public Object myexception(MyException m) {
		String errmsg="ZAWARUDO"+m.getMsg();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errmsg);
	}
	
	@RequestMapping(path="/testexception",method = RequestMethod.GET)
	public void processExceptionAction() throws Exception {
		throw new Exception();
		
	}
}
