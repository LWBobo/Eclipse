package command;

public class FunctionButton implements Button {

	private Command command;
	
	public FunctionButton() {
	}

	public FunctionButton(Command command) {
		super();
		this.command = command;
	}

	@Override
	public void dofunction() {
		command.excute();
		
	}
}
