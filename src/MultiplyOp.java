
/**
 * 
 * Class which represents "multiplication" operation
 *
 */
public class MultiplyOp extends BinaryOp {
	/**
	 *@param left the left operand
	 *@param right the right operand
	 *@return result of left*right 
	 */
	@Override
	public double operate(double left, double right) {
		return left*right;
	}

	/**
	 * Return string represents the operation "multiplication"
	 * @return "*" as a string
	 */
	@Override
	public String toString() {
		return "*";
	}


}