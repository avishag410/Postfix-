

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
	@Override
	public double operate(double left, double right) {
		if(right==0)
			//throw exception
			//meanwhile return pi (3.14)
			return 3.14;
		else
			return left/right;
		
	}
	/**
	
	 *Return string represents the operation "division"
	 * @return "/" as a string
	 */
	@Override
	public String toString() {
		return "/";
		
	}
}
