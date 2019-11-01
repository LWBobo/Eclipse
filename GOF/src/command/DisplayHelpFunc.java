package command;

public class DisplayHelpFunc implements Function {
	 private String funcname ;
	 
	public DisplayHelpFunc() {
	}
	
	public String getFuncname() {
		return funcname;
	}

	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}

	public DisplayHelpFunc(String funcname) {
		super();
		this.funcname = funcname;
	}

	@Override
	public void function() {
		   System.out.println("我可以打开帮助界面!");		
	}

}
