
public abstract class Calculator {
	protected StackAsArray stack;
	public abstract void evaluate(String expr);
	
	public double getCurrentResult(){
		if(stack.size > 0){
			Object result = stack.pop();
			if(result instanceof Double){
				return (double)result;	
			}
		}
		throw new NullPointerException("The stack is empty or contains an invalid value.");
	}
}
