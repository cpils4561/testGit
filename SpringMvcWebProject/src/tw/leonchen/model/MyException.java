package tw.leonchen.model;


public class MyException  extends RuntimeException{
	private static final long serialVersionUID =1L;
    public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private String msg;
    public MyException (String msg) {
    	this.msg=msg;
    	
    }
	 
}
