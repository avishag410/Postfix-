/**
 * Class represents "subtraction" operation  
 */
public class SubstractOp extends BinaryOp {
	/**
	 *@param left the left operand
	 *@param right the right operand 
	 *@return the result of left-right
	 */
	public double operate(double left, double right) {
		return left-right;
	}
	/**
	 * 
	 * 
	 * Return string represents the operation "subtraction"
	 * @return "-" as a string 
	 */
	public String toString() {
		return "-";
	}

}