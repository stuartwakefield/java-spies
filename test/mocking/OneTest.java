package mocking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OneTest {
	
	private One one;
	private MockTwo two;
	
	@Before
	public void setUp() {
		two = new MockTwo();
		one = new One(two);
	}
	
	@Test
	public void testOne() {
		two.doGoReturn = true;
		one.go("Gary");
		assertEquals("Hello, Gary!", two.doGoMessage);
	}
	
	@Test(expected=Error.class)
	public void testOneFailure() {
		two.doGoReturn = false;
		one.go("World");
	}
	
	private class MockTwo extends Two {
		
		public String doGoMessage;
		public boolean doGoReturn;
		
		@Override
		public boolean doGo(String message) {
			doGoMessage = message;
			return doGoReturn;
		}
		
	}
}
