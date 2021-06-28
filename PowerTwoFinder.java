package myjunit;
public class PowerTwoFinder {
	
	public boolean isPowerOfTwo(int x) {
		
		while (x % 2 == 0) {
			x /= 2;
		}
		
		if (x == 1)
			return true;
		else
			return false;
	}
}
