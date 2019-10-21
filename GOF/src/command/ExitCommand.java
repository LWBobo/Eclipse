package command;

public class ExitCommand implements Command {

	Function f ;

	public ExitCommand() {

		f =  new SystemExitFunc();	
				
	}

	public ExitCommand(Function f) {
		super();
		this.f = f;
	}
	
	@Override
	public void excute() {
		f.function();
		
	}
}
