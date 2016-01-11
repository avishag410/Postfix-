import java.util.Enumeration;
/**
 * if direction is true, we will tokenize from left to right,
 * if direction is false, then we will tokenize from right to left.
 */
public class ExpTokenizer extends Object implements Enumeration<Object>  {
	//fields
	private String [] result;
	private boolean direction;
	private int index;
	
	//constructor
	/**
	 * 
	 * @param exp string to calculate 
	 */
	public ExpTokenizer(String exp) {
		this.result = exp.split(" ");
		this.direction = true;
		this.index = 0;
	}
	/**
	 * 
	 * @param exp a string to calculate
	 * @param direction order reading expression 
	 */
	public ExpTokenizer(String exp,boolean direction) {
		result = exp.split(" ");
		this.direction = direction;
		if(!this.direction)
			this.index=result.length-1;
		else 
			this.index = 0;
	}
	
	/**
	 * @return Object the next element
	 * @exception ParseException if invalid token or value
	 */
	public Object nextElement() {
		CalcToken resultToken = null;
		String token =  nextToken();
		if (token.equals("+"))
			resultToken =  new AddOp();
		else if (token.equals("*"))
			resultToken =  new MultiplyOp();
		else if (token.equals("/"))
			resultToken =  new DivideOp();
		else if (token.equals("-"))
			resultToken =  new SubstractOp();
		else if (token.equals("^"))
			resultToken =  new PowOp();
		else if(isNumber(token))
		{
			try{
				resultToken = new ValueToken(Double.parseDouble(token));
			}
			catch(Exception ex){
				throw new ParseException("SYNTAX ERROR: invalid number " + token);
			}
		}
		else{
			throw new ParseException("SYNTAX ERROR: invalid token " + token);
		}
		return resultToken;	
	}

	//check is a string represents a number
	/**
	 * 
	 * @param s string
	 * @return if the string represents a number
	 */
	private boolean isNumber(String s){
		if(s.length() <= 0)
			return false;
		char c;
		for(int i=0; i<s.length() ;i++){
			c=s.charAt(i);
			if((c!='-' && c!='.') && (c<'0' || c>'9'))
				return false;
		}
			
		return true;
	}
	/**
	 * @return true if has more elements in the expression
	 */
	@Override
	public boolean hasMoreElements() {
		if(this.direction)
			return (this.index != this.result.length);
		else
			return (this.index >= 0);
	}
	/**
	 * 
	 * @return string represents the next token in the expression
	 */
	public String nextToken() {
		String ret;
		if(this.direction){
			ret= this.result[this.index];
			this.index++;
		}
			
		else{
			ret= this.result[this.index];
			this.index--;
		}
		return ret;
	}
	
	/**
	 * 
	 * @return true if has more tokens in the expression
	 */
	public boolean hasMoreTokens() {
		return hasMoreElements();
	}

	/**
	 * 
	 * @return number of current number of tokens
	 */
	public int countTokens() {
		if(this.direction)
			return (this.result.length - this.index);
		else
			return (this.index+1);
	}	
}