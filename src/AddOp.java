
/**
 * 
 * Class which represents "addition" operation
 *
 */
public class AddOp extends BinaryOp {
	
	/**
	 * 
	 * @param left the left operand 
	 * @param right the right operand
	 * @return result of : left + right
	 */
	@Override
	public double operate(double left,double right){
		return left+right;
	}
	
	/**
	 * 
	 * Return string represents the operation "addition"
	 * @return "+" as a string
	 */
	@Override
	public String toString() {
		return "+";
		
	}
}