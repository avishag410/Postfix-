/**
 * 
 * Class represents postfix calculator
 *
 */
public class PostfixCalculator extends Calculator {

	/**
	 * @param expr expression to calculate
	 * @throws ParseException if contains invalid expression
	 */
	public void evaluate(String expr) {
		ExpTokenizer expTokenizer = new ExpTokenizer(expr,true);
		stack = new StackAsArray();
		boolean madeOperation = false;
		// while tokens remain
		while (expTokenizer.hasMoreTokens()){
			Object token = expTokenizer.nextElement();
			//if the token is an operator
			if(token instanceof BinaryOp){
				try{
					double right = getCurrentResult();
					double left  = getCurrentResult();
					stack.push(((BinaryOp)token).operate(left, right));
					madeOperation = true;
				}
				catch (NullPointerException ex){
					throw new ParseException("SYNTAX ERROR: cannot perform operation " + ((BinaryOp)token).toString());
				}
			}
			//push the token (which must be a number) onto the stack
			else{
				if(token instanceof ValueToken){
					stack.push(((ValueToken)token).getValue());	
				}
			}
		}
		
		// Check if the expression we got contains only numbers
		if(!madeOperation && stack.size > 1){
			throw new ParseException("SYNTAX ERROR: expression must contains an operation token");
		}
		// Check if an operation have been made but we didn't get a unique result
		else if(stack.size != 1){
			throw new ParseException("SYNTAX ERROR: invalid expression");
		}
	}

}
