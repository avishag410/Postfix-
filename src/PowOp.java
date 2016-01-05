/**
 * 
 * Class represents "power" operation
 *
 */
public class PowOp extends BinaryOp {
	/**
	 *
	 *@param left the left operand
	 *@param right the right operand
	 *@return result of left^right 
	 */
	@Override
	public double operate(double left, double right) {
		return Math.pow(left, right);
	}
	/**
	 *
	 *Return string represents the operation "power"  
	 *@return  "^" as a string 
	 */
	@Override
	public String toString() {
		return "^";
	}

}