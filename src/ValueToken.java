/**
 * Class which represents a value token
 */
public class ValueToken extends CalcToken {
	
	private double value;
	
	public ValueToken(double value) {
		this.value = value;
	}

	/**
	 * Return the representation of a value token as string
	 * @override CalcToken method
	 * @return a number value as string
	 */
	public String toString() {
		String ans = ""+value;
		return ans;
	}

	/**
	 * Return the value of the token
	 * @return a number value as string
	 */
	public double getValue() {
		return value;
	}
}
