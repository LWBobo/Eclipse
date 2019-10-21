package command;

public class HelpCommand implements Command {
	
	Function f ;
	
	public HelpCommand(Function f) {
		super();
		this.f = f;
	}

	public HelpCommand() {
		f = new DisplayHelpFunc();
	}

	@Override
	public void excute() {
		f.function();
		
	}

}
