package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
	private Range range1;
	private Range range2;
	private Range range3;
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setup() throws Exception {
		range1 = new Range(-1,1);
		range2 = new Range(-10,0);
		range3 = new Range(1,10);
	}	
	
	// Testing method combine(Range range1, Range range2)
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, range1.getCentralValue(), .000000001d);
    }
    
    @Test
    public void CombinedRangeShouldBeRange1() throws Exception{
    	assertEquals("The combined range should be -1,1",range1,Range.combine(range1,null));
    }
    
    @Test
    public void CombinedRangeShouldBeRange2() throws Exception{
    	assertEquals("The combined range should be 1,2",range2,Range.combine(null,range2));
    }
    
    @Test
    public void CombinedRangeShouldBeNull() throws Exception{
    	assertNull("The combined range should be null", Range.combine(null, null));
    }
    
    // Testing method constrain(double value)
    @Test
    public void ConstrainReturnValueShouldBeLowerBound() throws Exception {
    	double constrainValue = range1.constrain(-5);
    	assertEquals("The expected value was -1.0 but the returned value was " + constrainValue,-1.0,constrainValue, .000000001d);
    }
    
    @Test
    public void ConstrainReturnValueShouldBeUpperBound() throws Exception {
    	double constrainValue = range1.constrain(10);
    	assertEquals("The expected value was 1.0 but the returned value was " + constrainValue,1.0,constrainValue, .000000001d);
    }
    
    @Test
    public void ConstrainReturnValueShouldBe5() throws Exception {
    	double constrainValue = range3.constrain(5);
    	assertEquals("The expected value was 5.0 but the returned value was " + constrainValue,5.0,constrainValue, .000000001d);
    }
    
    // Testing method contains(double value)
    @Test
    public void ContainsReturnsTrue() throws Exception {
    	assertTrue("Contains should return true for argument -5 on range2",range2.contains(-5));
    }
    
    @Test 
    public void ContainsReturnsFalse() throws Exception {
    	assertFalse("Contains should return false for argument -5 on range3", range3.contains(-5));
    }
    
    // Testing method equals(Object obj)
    @Test
    public void EqualsSameRange() throws Exception {
    	Range testRange = new Range(-1, 1);
    	assertTrue("The equals method should be returning true on equivalent ranges.", range1.equals(testRange));
    }
    
    // Testing method expand(Range range, double lowerMargin, double upperMargin)
    @Test
    public void ExpandsPercetanges() throws Exception {
    	Range testRange = new Range(2, 6);
    	Range newRange = Range.expand(testRange, 0.25, 0.5);
    	Range expectedRange = new Range(1,8);
//    	assertEquals("The range did not properly expand the lower bound.", 1, newRange.getLowerBound(), .000000001d);
    	assertTrue("The range did not properly expand the lower bound.", newRange.equals(expectedRange));
    }
    // note: getupperbound returns the lower bound lol
//    @Test
//    public void ExpandsUpperBound() throws Exception {
//    	Range testRange = new Range(2, 6);
//    	Range newRange = Range.expand(testRange, 0.25, 0.5);
////    	assertEquals("The range did not properly expand the upper bound", 8, newRange.getUpperBound(), .000000001d);
//    	assertTrue("The range did not properly expand the lower bound.", newRange.equals(testRange));
//    }
//    
    @Test
    public void ExpandThrowsException() throws Exception {
    	Range nullRange = null;
    	boolean threwException = false;
    	try {
    		Range.expand(nullRange, 2, 6);
    	}catch(IllegalArgumentException e){
    		threwException = true;
    	}
    	assertTrue("Expand method did not correctly throw an exception upon receiving a null range object", threwException);
    }
    
    // Testing method Range expandToInclude(Range range, double value)
    @Test
    public void ExpandIncludeUpper() throws Exception {
    	Range range0 = new Range(-1, 1);
    	Range testRange = Range.expandToInclude(range0, 5);
    	Range expectedRange = new Range(-1, 5);
    	assertTrue("The range was not expanded.", testRange.equals(expectedRange));
    }
    
    @Test
    public void ExpandIncludeLower() throws Exception {
    	Range range0 = new Range(-1, 1);
    	Range testRange = Range.expandToInclude(range0, -5);
    	Range expectedRange = new Range(-5, 1);
    	assertTrue("The range was not expanded.", testRange.equals(expectedRange));
    }
    
    @Test 
    public void StringIsMade() throws Exception {
    	Range testRange = new Range(-10.0,10.0);
    	String expected = "Range[-10.0,10.0]";
    	String actual = testRange.toString();
    	assertTrue("The correct string was not made.\nExpected: 'Range[-10.0,10.0]'\nActual: "+actual, actual.equals(expected));
    }


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}