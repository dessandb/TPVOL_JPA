package sopra.vol.test;

import junit.framework.TestCase;

public class TEST1 extends TestCase {

	
		public void testOne() {
			Calculatrice cal = new Calculatrice(5, 2);
			Assert.assertEquals(7, cal.plus());
			if(cal.plus() != 7) {
				Assert.fail("dffdndn");
			}
		}
		public void testTwo() {
			System.out.println("Test Two");
		}
	}
	
