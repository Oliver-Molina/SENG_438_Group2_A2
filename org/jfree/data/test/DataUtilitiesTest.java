package org.jfree.data.test;

import static org.junit.Assert.*;


import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

public class DataUtilitiesTest extends DataUtilities {
//	Mockery mockingContext;
//	Values2D values;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// im pretty sure we have to add a setup in each method test
		// - danny
	}
	
	
	// Testing method calculateColumnTotal(Values2D data, int column)
	
	@Test
	public void calculateColumnTotalForTwoValues() {
		// setup
		Mockery mockingContext  = new Mockery();
		Values2D values = mockingContext.mock(Values2D.class);
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
		// test
		double result = DataUtilities.calculateColumnTotal(values,0);
		assertEquals("CalculateColumnTotal should return 10 but instead returned" + result, 10.0, result, .000000001d);
	}
	
	@Test //(expected = NullPointerException.class) // it says that invalid input returns 0
	public void calculateColumnTotalForInavlidColumn() {
		// setup
		Mockery mockingContext  = new Mockery();
		Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
		    {
		         one(values).getRowCount();
		         will(returnValue(2));
		         one(values).getValue(0, 5);
		         will(throwException(new IndexOutOfBoundsException("outta bounds bozo")));
		    }
		});
		// test
		double result = DataUtilities.calculateColumnTotal(values,5);
		assertEquals("CalculateColumnTotal with invalid column should return 0 but instead returned" + result, 0, result, .000000001d);
	}
	
	@Test (expected = NullPointerException.class)
	public void calculateColumnTotalForNullTable() throws Exception{
		DataUtilities.calculateColumnTotal(null,0);
	}
	
	
	// Testing method calculateRowTotal(Values2D data, int row)
	
	@Test
	public void calculateRowTotalForTwoValues() {
		// setup
		Mockery mockingContext  = new Mockery();
		Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
		    {
		         one(values).getColumnCount();
		         will(returnValue(2));
		         one(values).getValue(0, 0);
		         will(returnValue(7.5));
		         one(values).getValue(0, 1);
		         will(returnValue(1.0));
		    }
		});
		// test
		double result = DataUtilities.calculateRowTotal(values,0);
		assertEquals("CalculateColumnTotal should return 8.5 but instead returned" + result, 8.5, result, .000000001d);
	}
	
	@Test (expected = NullPointerException.class)
	public void calculateRowTotalForInavlidRow() {
		// setup
		Mockery mockingContext  = new Mockery();
		Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
		    {
		    	one(values).getColumnCount();
		    	will(returnValue(2));
		    	one(values).getValue(5, 0);
		    	will(throwException(new IndexOutOfBoundsException("outta bounds bozo")));
		    }
		});
		// test
		double result = DataUtilities.calculateRowTotal(values,4);
		assertEquals("CalculateColumnTotal with invalid column should return 0 but instead returned" + result, 0, result, .000000001d);
	}
	
	@Test (expected = NullPointerException.class)
	public void calculateRowTotalForNullTable() throws Exception{
		DataUtilities.calculateRowTotal(null,0);
	}
	
	
	// Testing method createNumberArray(double[] data)
	
	
	// Testing method createNumberArray2D(double[][] data)
	
	
	// Testing method getCumulativePercentages(KeyedValues data)

	
	@After
	public void tearDown() throws Exception {
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
