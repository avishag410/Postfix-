/**
 * 
 * Abstract class describing calculator
 *
 */

public abstract class Calculator {
	protected StackAsArray stack;
	/**
	 * 
	 * @param expr an expression to calculate
	 * 
	 */
	public abstract void evaluate(String expr);
	
	/**
	 * 
	 * @return current result
	 * @throws NullPointerException if stack is empty or contains an invalid value
	 */
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
