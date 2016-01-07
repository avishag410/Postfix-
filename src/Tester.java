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
				
		/* TODO add more tests to the ValueToken class! */
	}

	/**
	 * Checks the PostfixCalculator class.
	 */
	private static void testPostfixCalculator() {
		PostfixCalculator c1 = new PostfixCalculator();
		c1.evaluate("2 3 +");
		test(c1.getCurrentResult()==5.0,""); //returns 5.0
		c1.evaluate("3 5 -");
		test(c1.getCurrentResult()==-2.0,""); // returns -2.0
		c1.evaluate("6 2 *");
		test(c1.getCurrentResult()==12.0,""); // returns 12.0
		c1.evaluate("10 4 /");
		test(c1.getCurrentResult()==2.5,""); // returns 2.5
		c1.evaluate("2 4 ^");
		test(c1.getCurrentResult()==16.0,""); // returns 16.0
		c1.evaluate("2 3 + 4 2 - *");
		test(c1.getCurrentResult()==10.0,""); // returns 10.0
		c1.evaluate("2 3 ^ 4 2 * / 7 -");
		test(c1.getCurrentResult()==-6.0,""); // returns -6.0
		c1.evaluate("2 3 ^ 4 2 * / -7 -");
		test(c1.getCurrentResult()==8.0,""); // returns 8.0
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