package command;

public class SystemExitFunc implements Function {

	private String funcname ;
	
	public String getFuncname() {
		return funcname;
	}

	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}

	public SystemExitFunc() {
		super();
	}

	public SystemExitFunc(String funcname) {
		super();
		this.funcname = funcname;
	}
	
	@Override
	public void function() {
		System.out.println("我用于退出系统!");
		
	}

}
