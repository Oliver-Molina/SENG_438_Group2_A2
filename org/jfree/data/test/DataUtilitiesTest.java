package org.jfree.data.test;

import static org.junit.Assert.*;


import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

public class DataUtilitiesTest extends DataUtilities {
	Mockery mockingContext;
	Values2D values;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mockingContext  = new Mockery();
		values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
		    {
		         one(values).getRowCount();
		         will(returnValue(2));
		         one(values).getValue(0, 0);
		         will(returnValue(7.5));
		         one(values).getValue(1, 0);
		         will(returnValue(2.5));
		     }
		});
	}
	
	// Testing method calculateColumnTotal(Values2D data, int column)
	@Test
	public void calculateColumnTotalForTwoValues() {
		double result = DataUtilities.calculateColumnTotal(values,0);
		assertEquals("CalculateColumnTotal should return 10 but instead returned" + result, result, 10.0, .000000001d);
	}
	
	// Testing method calculateRowTotal(Values2D data, int row)
	public void () throws Exception{
		
	}
	
	// Testing method createNumberArray(double[] data)
	public void () throws Exception{
		
	}
	
	// Testing method createNumberArray2D(double[][] data)
	public void () throws Exception{
		
	}
	
	// Testing method getCumulativePercentages(KeyedValues data)
	public void () throws Exception{
		
	}

	@After
	public void tearDown() throws Exception {
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
