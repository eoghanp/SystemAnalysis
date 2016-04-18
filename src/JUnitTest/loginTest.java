package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dataIO.DBHandler;


public class loginTest {

	@Test
	public void test() {
		DBHandler validLoginTest = new DBHandler();
		
		assertEquals(true, validLoginTest.isValidLogin("Manager", "manager"));
	}
}
