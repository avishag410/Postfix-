

/**
 * 
 * Class which represents "division" operation
 *
 */
public class DivideOp extends BinaryOp {
	/**
	 *@param left the left operand
	 *@param right the right operand
	 *@return result of left/right 
	 */
	public double operate(double left, double right) {
		if(right==0)
			throw new IllegalArgumentException("Can not divide by 0");
		else
			return left/right;
		
	}
	/**
	
	 *Return string represents the operation "division"
	 * @return "/" as a string
	 */
	public String toString() {
		return "/";
		
	}
}
