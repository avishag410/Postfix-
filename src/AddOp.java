
public class AddOp extends BinaryOp {
	
	@Override
	/**
	 * 
	 * @param left left operand 
	 * @param right right operand
	 * @return result of : left + right
	 */
	public double operate(double left,double right){
		return left+right;
	}
	@Override
	/**
	 * 
	 * @return the string represents the operation: left + right 
	 */
	public String toString() {
		return null;
	}
}