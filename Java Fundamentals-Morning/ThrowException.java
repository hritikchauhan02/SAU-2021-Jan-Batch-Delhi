
public class ThrowException {
	
	static void division(int x, int y) throws ArithmeticException {
		if(y == 0) {
			throw new ArithmeticException("Division by zero Exception");
		} else {
			System.out.println(x/y);
		}
	}
	
	public static void main(String args []) {
		try {
			division(10,2);
			division(10,0);
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
	}

}
