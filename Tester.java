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
		testOpenBracket();
		testCloseBracket();
		testPowOp();
		testSubstractOp();
		testPostfixCalculator();
		
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
	 * Checks the ValueToken class.
	 */
	private static void testValueToken() {
		
		ValueToken t1 = new ValueToken(5.1);
		test(t1.getValue() == 5.1, "Value should be 5.1.");
		test(t1.toString().equals("5.1"), "Value toString should be 5.1.");
		
		/* TODO - return int number as double:  10.0 instead of 10 */
		t1=new ValueToken(-10);
		test(t1.getValue()==-10,"Value should be -10");
		test((t1.toString()).equals("-10"),"Value toString should be -10.");
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
		/* TODO - check division by 0
		test(t1.operate(-15, 0) == 1,"IllegalArgumentException : Can not divide by zero");
		*/
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
	 * Checks the OpenBracket class
	 */
	
	private static void testOpenBracket(){
		OpenBracket t1= new OpenBracket();
		test(t1.toString() == "(","String value should be (");
	}
	
	/**
	 * Checks the CloseBracket class
	 */
	private static void testCloseBracket(){
		CloseBracket t1= new CloseBracket();
		test(t1.toString() == ")","String value should be )");
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
		test(t1.operate(81, 40) == 41,"Value should be 41.");
		test(t1.toString()== "-","String value should be -");
	}
	
	/**
	 * Checks the PostfixCalculator class.
	 */
	
	
	private static void testPostfixCalculator() {
		PostfixCalculator c1 = new PostfixCalculator();
		c1.evaluate("2 3 +");
		test(c1.getCurrentResult()==5.0,"Value should be 5.0"); //returns 5.0
		c1.evaluate("3 5 -");
		test(c1.getCurrentResult()==-2.0,"Value should be -2.0"); // returns -2.0
		c1.evaluate("6 2 *");
		test(c1.getCurrentResult()==12.0,"Value should be 12.0"); // returns 12.0
		c1.evaluate("10 4 /");
		test(c1.getCurrentResult()==2.5,"Value should be 2.5"); // returns 2.5
		c1.evaluate("2 4 ^");
		test(c1.getCurrentResult()==16.0,"Value should be 16.0"); // returns 16.0
		c1.evaluate("2 3 + 4 2 - *");
		test(c1.getCurrentResult()==10.0,"Value should be 10.0"); // returns 10.0
		c1.evaluate("2 3 ^ 4 2 * / 7 -");
		test(c1.getCurrentResult()==-6.0,"Value should be -6.0"); // returns -6.0
		c1.evaluate("2 3 ^ 4 2 * / -7 -");
		test(c1.getCurrentResult()==8.0,"Value should be 8.0"); // returns 8.0
		c1.evaluate("2 3 ^ 4 2 * / -7 -");
		test(c1.getCurrentResult()==8.0,"Value should be 8.0"); // returns 8.0
		c1.evaluate("2 3 ^ 4 2 * / -7 -");
		test(c1.getCurrentResult()==8.0,"Value should be 8.0"); // returns 8.0
		
		
		
		//c1.evaluate("4 5 $"); // SYNTAX ERROR: invalid token $
		//c1.evaluate("7.0.1"); // SYNTAX ERROR: invalid number 7.0.1
		//c1.evaluate("5 6 7 4"); // SYNTAX ERROR: write here whatever
		//description you want
		//c1.evaluate("*"); // SYNTAX ERROR: cannot perform operation * (or
		//whatever description you choose to give here)
		//c1.evaluate("5 6 * 4 2 * 1 2 *"); // SYNTAX ERROR: invalid
		//expression
	}
}