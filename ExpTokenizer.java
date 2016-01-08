import java.util.Enumeration;
/*
 * if direction is true, we will tokenize from left to right,
 * if direction is false, then we will tokenize from right to left.
 */
public class ExpTokenizer extends Object implements Enumeration<Object>  {
	//fields
	private String [] result;
	private boolean direction;
	private int index;
	
	//constructor
	public ExpTokenizer(String exp) {
		this.result = exp.split(" ");
		this.direction = true;
		this.index = 0;
	}
	
	public ExpTokenizer(String exp,boolean direction) {
		result = exp.split(" ");
		this.direction = direction;
		if(!this.direction)
			this.index=result.length-1;
		else 
			this.index = 0;
	}
	
	
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
		else if (token.equals("("))
			resultToken =  new OpenBracket();
		else if (token.equals(")"))
			resultToken =  new CloseBracket();
//TODO - If regex isn't valid delete those lines
/*
		// Check if the token contains a number
		else if (token.matches(".*\\d+.*"))
			try{
				resultToken = new ValueToken(Double.parseDouble(token));
			}
			catch(Exception ex){
				throw new ParseException("SYNTAX ERROR: invalid number " + token);
			}
		else{
			throw new ParseException("SYNTAX ERROR: invalid token " + token);
		}
*/
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
	private boolean isNumber(String s){
		char c;
		for(int i=0; i<s.length() ;i++){
			c=s.charAt(i);
			if(c!='-' && (c<'0' || c>'9'))
				return false;
		}
			
		return true;
	}
	@Override
	public boolean hasMoreElements() {
		if(this.direction)
			return (this.index != this.result.length);
		else
			return (this.index >= 0);
	}
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

	public boolean hasMoreTokens() {
		return hasMoreElements();
	}

	public int countTokens() {
		if(this.direction)
			return (this.result.length - this.index);
		else
			return (this.index+1);
	}
	

	public static void main(String args[]){
		
		//System.out.println(isNumber("));
	}

	
}