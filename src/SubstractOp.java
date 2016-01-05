/* 
 * Class represents "subtraction" operation  
 */
public class SubstractOp extends BinaryOp {
	/*
	 *@param left the left operand
	 *@param right the right operand 
	 *@return the result of left-right
	 */
	@Override
	public double operate(double left, double right) {
		return left-right;
	}
	/*
	 * 
	 * @see CalcToken#toString()
	 * Return string represents the operation "subtraction"
	 * @return "-" as a string 
	 */
	@Override
	public String toString() {
		return "-";
	}

}