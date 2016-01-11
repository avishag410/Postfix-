/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester {

	private static boolean testPassed = true;
	private static int testNum = 0;
	
	/**
	 * This entry function will test all classes created in this assignment.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// Each function here should test a different class.
		testValueToken();
		testAddOp();
		testMultiplyOp();
		testDivideOp();
		testPowOp();
		testSubstractOp();
		testPostfixCalculator();
		testExpTokenizer();
		
		/* TODO - write a function for each class */
		
		
		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}

	/**
	 * This utility function will count the number of times it was invoked. 
	 * In addition, if a test fails the function will print the error message.  
	 * @param exp The actual test condition
	 * @param msg An error message, will be printed to the screen in case the test fails.
	 */
	private static void test(boolean exp, String msg) {
		testNum++;
		
		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}
	
	/**
	 * This utility function checks if an exception is thrown while running a binary operation
	 * In addition this function will call to the Test function
	 * @param Binary operation which needs to throw an exception
	 * @param left parameter of the operation
	 * @param right parameter of the operation
	 * @param messageException a part of the message of the exception desired
	 * @param messageTest an error message to send to Test function
	 */
	private static void testOperationException(BinaryOp operation, double left, double right, String messageException, String messageTest){
		try{
			operation.operate(left, right);
			// this line must not happen if the exception have been thrown
			test (false, messageTest);
		}
		catch(Exception ex){
			if(ex.getMessage().contains(messageException))
				test(true, messageTest);
			else
				test(false, messageTest);
		}
	}
	
	/**
	 * This utility function checks if an exception is thrown while running a calculator
	 * In addition this function will call to the Test function
	 * @param calc - the calculator to test
	 * @param expr - the expression which will throw an exception
	 * @param messageException - a part of the message of the exception desired
	 * @param messageTest - an error message to send to Test function
	 */
	private static void testCalculatorException(Calculator calc, String expr, String messageException, String messageTest){
		try{
			calc.evaluate(expr);
			// this line must not happen if the exception have been thrown
			test (false, messageTest);
		}
		catch(Exception ex){
			if(ex.getMessage().contains(messageException))
				test(true, messageTest);
			else
				test(false, messageTest);
		}
	}
	
	/**
	 * Checks the ValueToken class.
	 */
	private static void testValueToken() {
		
		ValueToken t1 = new ValueToken(5.1);
		test(t1.getValue() == 5.1, "Value should be 5.1.");
		test(t1.toString().equals("5.1"), "Value toString should be \"5.1\".");
		
		t1=new ValueToken(-10);
		test(t1.getValue()==-10.0,"Value should be -10.0");
		test((t1.toString()).equals("-10.0"),"Value toString should be \"-10.0\".");
	}
	
	/**
	 * Checks the AddOp class
	 */
	private static void testAddOp(){
		AddOp t1=new AddOp();
		test(t1.operate(3, 4) == 7,"Value should be 7.");
		test(t1.operate(-2.59, -9.11) == -11.7,"Value should be -11.7 .");
		test(t1.operate(-15, 6.01) == -8.99,"Value should be -8.99.");
		test(t1.toString()== "+","String value should be +.");
	}
	
	/**
	 * Checks the DivideOp class
	 */
	private static void testDivideOp(){
		DivideOp t1=new DivideOp();
		test(t1.operate(5.0, -5) == -1,"Value should be -1.");
		test(t1.operate(9, -4.5) == -2,"Value should be -2.");
		test(t1.operate(0.000, 89) == 0,"Value should be 0.");
		testOperationException(t1,-15,0,"Can not divide by zero.","DivideOp should throw IllegalArgumentException");
		
		test(t1.toString()== "/","String value should be /");
	}

	/**
	 * Checks the MultiplyOp class
	 */
	private static void testMultiplyOp(){
		MultiplyOp t1=new MultiplyOp();
		test(t1.operate(0.00, 1) == 0,"Value should be 0.");
		test(t1.operate(-69, 1) == -69,"Value should be -69.");
		test(t1.operate(-7, -7.0) == 49.0,"Value should be 49.");
		test(t1.toString()== "*","String value should be *");
	}	

	/**
	 * Checks the PowOp class
	 */
	private static void testPowOp(){
		PowOp t1=new PowOp();
		test(t1.operate(0.00, 1) == 0,"Value should be 0.");
		test(t1.operate(-69, 0) == 1,"Value should be 1.");
		test(t1.operate(2, 8) == 256,"Value should be 256");
		test(t1.toString()== "^","String value should be ^");
	}

	/**
	 * Checks the SubstractOp class
	 */
	private static void testSubstractOp(){
		SubstractOp t1=new SubstractOp();
		test(t1.operate(0.00, 1) == -1,"Value should be -1.");
		test(t1.operate(1, 100) == -99,"Value should be -99.");
		test(t1.operate(-19, -8) == -11,"Value should be -11");
		test(t1.operate(8.1, 4) == 4.1,"Value should be 4.1 .");
		test(t1.toString()== "-","String value should be -");
	}
	
	/**
	 * Checks the PostfixCalculator class.
	 */
	private static void testPostfixCalculator() {
		PostfixCalculator c1 = new PostfixCalculator();
		
		c1.evaluate("2 3 +");
		test(c1.getCurrentResult()==5.0,"Value should be 5.0");
		c1.evaluate("3 5 -");
		test(c1.getCurrentResult()==-2.0,"Value should be -2.0");
		c1.evaluate("6 2 *");
		test(c1.getCurrentResult()==12.0,"Value should be 12.0");
		c1.evaluate("10 4 /");
		test(c1.getCurrentResult()==2.5,"Value should be 2.5");
		c1.evaluate("2 4 ^");
		test(c1.getCurrentResult()==16.0,"Value should be 16.0");
		c1.evaluate("2 3 + 4 2 - *");
		test(c1.getCurrentResult()==10.0,"Value should be 10.0");
		c1.evaluate("2 3 ^ 4 2 * / 7 -");
		test(c1.getCurrentResult()==-6.0,"Value should be -6.0");
		c1.evaluate("2 3 ^ 4 2 * / -7 -");
		test(c1.getCurrentResult()==8.0,"Value should be 8.0");
		c1.evaluate("2 3 ^ 4 2 * / -7 -");
		test(c1.getCurrentResult()==8.0,"Value should be 8.0");
		c1.evaluate("2 3 ^ 4 2 * / -7 -");
		test(c1.getCurrentResult()==8.0,"Value should be 8.0");
		c1.evaluate("1");
		test(c1.getCurrentResult()==1.0,"Value should be 1.0");
		
		testCalculatorException(c1,"4 5 $","SYNTAX ERROR: invalid token $", 
				"PostfixCalculator should throw 'invalid token'"); 
		
		testCalculatorException(c1,"7.0.1","SYNTAX ERROR: invalid number 7.0.1", 
				"PostfixCalculator should throw 'invalid number'"); 
		
		testCalculatorException(c1,"5 6 7 4","SYNTAX ERROR: expression must contains an operation token",
				"PostfixCalculator should throw 'expression must contains an operation token'"); 
		
		testCalculatorException(c1,"*","SYNTAX ERROR: cannot perform operation *",
				"PostfixCalculator should throw 'cannot perform operation'"); 
		
		testCalculatorException(c1,"5 6 * 4 2 * 1 2 *","SYNTAX ERROR: invalid expression",
				"PostfixCalculator should throw 'invalid expression'");
		
		testCalculatorException(c1,"     ","SYNTAX ERROR: invalid expression",
				"PostfixCalculator should throw 'invalid expression'");
		
		testCalculatorException(c1,"","SYNTAX ERROR: invalid token",
				"PostfixCalculator should throw 'invalid token'");
		
		testCalculatorException(c1,"1 *","SYNTAX ERROR: cannot perform operation *",
				"PostfixCalculator should throw 'cannot perform operation *'");
		
		testCalculatorException(c1,"1* 1 *","SYNTAX ERROR: invalid token 1*",
				"PostfixCalculator should throw 'invalid token'");
		
		try{
			c1.getCurrentResult();
			test(false, "getCurrentResult empty must throw an exception of type NullPointerException");
		}
		catch (Exception ex){
			test(ex instanceof NullPointerException,
					"getCurrentResult empty must throw an exception of type NullPointerException");
		}
	}
	
	
	private static void testExpTokenizer(){
		ExpTokenizer expTokenizer = new ExpTokenizer("2 3 +",true);
		
		test(expTokenizer.hasMoreElements(), "expTokenizer must have elements");
		test(expTokenizer.hasMoreTokens(), "expTokenizer must have tokens");
		test(expTokenizer.countTokens()==3, "expTokenizer must have 3 tokens");
		
		Object token = expTokenizer.nextElement();
		test(token instanceof CalcToken, "the element must be a calc token");
		test(token instanceof ValueToken, "the element must be a value token");
		test(((ValueToken)token).getValue() == 2.0, "the element must be 2.0");
		token = expTokenizer.nextElement();
		token = expTokenizer.nextElement();
		test(!(token instanceof ValueToken), "the element must be a AddOp token");
		test(token instanceof AddOp, "the element must be a AddOp token");
		test(((AddOp)token).toString() == "+", "the element must be +");
		
		expTokenizer = new ExpTokenizer("",true);
		test(expTokenizer.hasMoreElements(), "expTokenizer must have elements");
		test(expTokenizer.hasMoreTokens(), "expTokenizer must have tokens");
		test(expTokenizer.countTokens()==1, "expTokenizer must have 1 token");
		test(expTokenizer.nextToken()=="", "the element must be an empty string");
		test(!expTokenizer.hasMoreElements(), "expTokenizer must be empty");
		
		expTokenizer = new ExpTokenizer("%",true);
		try{
			expTokenizer.nextElement();
			// this line must not happen
			test(false, "ExpTokenizer must throw a parse exception");
		}
		catch (Exception ex){
			test(ex instanceof ParseException,
					"ExpTokenizer throw an exception with a type of ParseException");
		}
	}
}