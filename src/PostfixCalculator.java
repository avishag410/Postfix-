public class PostfixCalculator extends Calculator {

	public void evaluate(String expr) {
		ExpTokenizer expTokenizer = new ExpTokenizer(expr,true);
		stack = new StackAsArray();
		boolean madeOperation = false;
		while (expTokenizer.hasMoreTokens()){
			Object token = expTokenizer.nextElement();
			if(token instanceof BinaryOp){
				try{
					double right = getCurrentResult();
					double left  = getCurrentResult();
					stack.push(((BinaryOp)token).operate(left, right));
					madeOperation = true;
				}
				catch (NullPointerException ex){
					throw new ParseException("SYNTAX ERROR:  cannot perform operation " + ((BinaryOp)token).toString());
				}
			}
			else{
				if(token instanceof ValueToken){
					stack.push(((ValueToken)token).getValue());	
				}
			}
		}
		
		if(stack.size != 1){
			if(!madeOperation){
				throw new ParseException("SYNTAX ERROR: expression must contains an operation token");
			}
			else{
				throw new ParseException("SYNTAX ERROR: invalid expression");
			}
		}
	}

}
