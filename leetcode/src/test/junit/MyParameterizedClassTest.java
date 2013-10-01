package test.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyParameterizedClassTest {

	private int multiplier;
	
	public MyParameterizedClassTest(int testParameter) {
		// TODO Auto-generated constructor stub
		this.multiplier = testParameter;
	}
	
	//Create the test data
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] data = new Object[][] { { 1 }, { 5 }, { 121 } };
		return Arrays.asList(data);
	}
	
	@Test
	public void testMultiplyException(){
		
		MyClass tester = new MyClass();
		assertEquals("Result", multiplier * multiplier, 
				tester.multiply(multiplier, multiplier));
		
	}

}
