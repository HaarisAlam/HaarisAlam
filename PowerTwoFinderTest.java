package myjunit;

import static org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import myjunit.PowerTwoFinder;

/**
 * @author haarisalam
 * 
 */
class PowerTwoFinderTest {
	private PowerTwoFinder p2f;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		p2f = new PowerTwoFinder();
	}

	@Test
	@DisplayName("Simple test for power of 2")
	public void testIsPowerOfTwo() {
		assertEquals(true, p2f.isPowerOfTwo(64), "Valid power of 2 should reutrn true.");
	}

	@DisplayName("Ensure correct handling of odd numbers and even non-powers of 2")
	public void testIsPowerOfTwoWithOdd() {
		assertEquals(false, p2f.isPowerOfTwo(10), "Not all even numbers are powers of 2.");
		assertEquals(false, p2f.isPowerOfTwo(19), "Odd numbers cannot be a power of 2.");
	}

}
