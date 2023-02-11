**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#2:      |     |
| -------------- | --- |
| Student Names: |     |
| Daniel Picazo    |
| Oliver Molina    |
| Quentin Jennings  |
| Nouruddine Jaffan |
||

# 1 - Introduction

In this assignment, we explored and dived into the intricacies of software testing using JUnit and JMock by testing two modified classes of the JFreeChart program: Range and DataUtilities. In this scenario we were tasked with performing black-box testing on 5 functions in each program, meaning we have no knowledge of the internal workings of each function and must employ black-box testing methodologies to successfully find defects within the program.

# 2 - Detailed description of unit test strategy

To summarize our unit test strategy for the RangeTest unit testing, for each test case we partitioned the total range of inputs into meaningful/significant subsections and used equivalence class testing and boundary value testing simultaneously - for instance, testing the lower bound and upper bound of a range and values in the range and outside of the range gives a complete picture of the functionality. Splitting our test cases up for this gives us a more effective insight into what parts of the program specifically work incorrectly and allowed us to design further test cases with these defects in mind in a sort of iterative cycle until all potential grounds have been covered.

For DataUtilitiesTest the strategy was not as cut and clear as we would not be testing functions with clear and defined boundaries so we employed methodologies similar to creating a decision table in which we checked the potential different cases for failure, although we did not actually create tables due to the small scope of each unit tested and only 1 or 2 variables to mess with.
Input partitions were determined for each unit tested and are detailed in Section 3 along with its justifications.

For input partitions we had to determine how we could cover all the necessary test cases for a function without redundancy. To do this, we determined a partitioning for most test cases’ inputs where it was deemed fitting. For others we used a decision table approach as opposed to input partitioning.


# 3 - Test cases developed

<ins>RangeTest</ins>
---

**combine()**
--

Used decision-table approach. Cases that had to be checked, in order:
- Ranges overlap
- One range is a subset of the other
- Ranges are separated and have no overlap
- Ranges are adjacent and one’s upper bound is equal to the other’s lower bound
- First input range is null
- Second input range is null
- Both range inputs are null

**CombineOverlappingRanges():**

    Description: Checks the combination of two Ranges where one’s upper bound is higher than the other’s lower bound, but its lower bound is not. 

**CombineSubsetRanges()**

    Description: Checks the combination of two Ranges where one range is a subset of another

**CombineSeparatedRanges()**

    Description: Checks the combination of two Ranges where one’s upper bound is lower than the other’s lower bound (no overlap). 

**CombineAdjacentRanges()**

    Description: Checks the combination of two Ranges where one’s upper bound bound is equal to the other’s lower bound. 

**CombinedRangeShouldBeRange1()**

    Description: Checks that combining a Range with null will just return the passed in null. 

**CombinedRangeShouldBeRange2()**

    Description: Once again checks that combining a Range with null will just return the passed in null, this time with the order of arguments swapped. 

**CombinedRangeShouldBeNull()**

    Description: Checks if the combination of passing in two nulls as arguments is also null.

**constrain():**
--
Input Value Partitions, in order:
- Lower bound
- Upper bound
- In-range
- Out-of-range

**ConstrainReturnValueShouldBeLowerBound()**

    Description: Checks the constrain() method with a value lower than the Range’s lower bound. 

**ConstrainReturnValueShouldBeUpperBound()**

    Description: Checks the constrain() method with a value higher than the Ranger’s upper bound. 

**ConstrainReturnValueShouldBe5()**

    Description: Checks the constrain() method with a value within the range (in this case, 5 with a range [0,10]). 

**ConstrainReturnValueShouldBeZero()**

    Description: Checks the constrain() method when passed in a value out-of-range to a Range of [0,0].


**contains():**
--
Input Value Partitions:
- Lower bound
- Upper bound
- In-range
- Out-of-range

**ContainsReturnsTrue()**

    Partition: In-Range

    Description: Checks the contains() method when passed in a value within the range. 

**ContainsReturnsFalse()**

    Partition: Out-of-Range

    Description: Checks the contains() method when passed in a value out of the range. 

**ContainsLowerBound()**

    Partition: Lower Bound

    Description: Checks the contains() method when passed in a value equal to the range’s lower bound.

**ContainsUpperBound()**

    Partition: Upper Bound

    Description: Checks the contains() method when passed in a value equal to the range’s upper bound.

**equals():**
-
Used decision-table approach. Cases that had to be checked, in order:
- The same object twice
- Two objects with different values
- Two objects with the same values

**EqualsSameRange()**

    Description: Tests for equality of an object on itself (aka the same object)

**NotEqualsRange()**

    Description: Tests for equality of two unequal objects

**EqualsSimilarRangeObject()**

    Description: Tests for equality of two separate objects with equal upper and lower bounds

**expand():**
-
Used decision-table approach. Cases that had to be checked, in order:
- Both ranges expanded
- Only bottom range expanded
- Only top range expanded
- Null base object passed in

**ExpandsPercentages()**

    Description: Tests for proper range expansion when both are expanded at same time

**ExpandsPercentagesBottom()**

    Description: Tests for proper range expansion when only bottom range is expanded

**ExpandsPercentagesTop()**

    Description: Tests for proper range expansion when only top range is expanded

**ExpandThrowsException()**

    Description: Tests for an InvalidParameterException when a null base object is passed in

<ins>DataUtilitiesTest</ins>
---
Input Value Partitions, in order:
- Valid column
- Invalid column greater than maximum index
- Invalid negative column index
- Null base object

**CalculateColumnTotal():**
-

**CalculateColumnTotalForTwoValues()**

    Description:  Checks for correct sum of values in a valid column.

**CalculateColumnTotalForInvalidColumn()**

    Description:  Checks if program returns 0 when trying to calculate the sum for a column with an index that is too large.

**CalculateColumnTotalForNegativeColumn()**

    Description:  Checks if program returns 0 when trying to calculate the sum for an invalid negative column index.

**CalculateColumnTotalForNullTable()**

    Description: Checks for an InvalidParameterException when a null base object is passed in.

**CalculateRowTotal():**
-

- Input Value Partitions, in order:
- Valid column
- Invalid column greater than maximum index
- Invalid negative column index
- Null base object

**CalculateRowTotalForTwoValues()**

    Description:  Checks for correct sum of all values in a valid row. 

**CalculateRowTotalForInvalidRow()**

    Description:  Checks if program returns 0 when trying to calculate a row index larger than or equal to the number of rows. 

**CalculateRowTotalForNegativeRow()**

    Description:  Checks if program returns 0 when trying to calculate the sum for an invalid negative row index.

**CalculateRowTotalForNullTable()**

    Description: Checks for an InvalidParameterException when a null base object is passed in.

**CreateNumberArray():**
-
- Input Value Partitions, in order:
- Valid array
- Empty array
- Null base array

**CreateNumberArray()**

    Description:  Checks if number array is equal to given double array

**CreateEmptyNumberArray()**

    Description:  Creates empty number array and checks if this is valid

**NullNumberArrayThrowsException()**

    Description: Tests for exception when null base array is used

**CreateNumberArray2D():**
-
- Input Value Partitions, in order:
- Valid 2D array
- Empty 2D array with undefined 2nd dimension (eg [1][])
- Empty 2D array with defined 2nd dimension (eg [1][1])
- Null base array

**CreateNumberArray2D()**

    Description:  Checks if 2D number array is equal to given 2D double array

**CreateEmptySecondDimensionNumberArray2D()**

    Description:  Creates 2D array with non-empty 1st dimension and empty 2nd dimension and checks if this is valid

**CreateEmptyNumberArray2D()** 

    Description:  Creates empty 2D number array and checks if this is valid

**Null2DNumberArrayThrowsException()**

    Description: Tests for exception when null base array is used

**GetCumulativePercentages():**
-
With the first test strange behavior was discovered with the GetCumulativePercentages function thanks to jMock so more specific tests were created to try and define this behavior. Described further in Section 5.

Used decision-table approach. Cases that had to be checked, in order:
- KeyedValues with a zero value key is used
- KeyedValues with a zero value key is used below size 3
- KeyedValues without a zero value key is used
- KeyedValues above size 5 is used
- KeyedValues with a non-number Comparable type (String here) is used
- Null base object is passed in

**ZeroKey_GetCumulativePercentages()**

    Description:  Checks for correct cumulative percentage when the number 0 is used as a key in the KeyedValues object

**SizeTwoZeroKey_GetCumulativePercentages()**

    Description:  Checks for correct cumulative percentage for a KeyedValues with 2 KV pairs

**NoZeroKey_GetCumulativePercentages()**

    Description:  Checks for correct cumulative percentage when non-zero numbers are used as a key in the KeyedValues object

**SizeFive_GetCumulativePercentages()**

    Description:  Checks for correct cumulative percentage for a KeyedValues with 5 KV pairs

**StringKeys_GetCumulativePercentages()**

    Description:  Checks for correct cumulative percentage when strings are used as keys in the KeyedValues object

**NullThrowsException_GetCumulativePercentages()**

    Description:  Checks for an InvalidParameterException when a null base object is passed in.

# 4 - How the team work/effort was divided and managed

To determine our approach to creating test cases for the two files we all worked together on a plan of attack, determining which methods we would focus on, how we would partition a unit’s input and what boundary values to test. For each of the two test files, the methods were divided equally amongst the group. Usually, there would be multiple small online meetings throughout the week which consisted of 2 people, and the other 2 would meet at a later time to pick up where the others left off in a sort of consecutive pair programming. This continued consecutively to allow all members of the group to understand not only what they were doing, but what the others were doing. 

Additionally, group members would check over each other's test methods and give feedback or input change to have all the test methods function properly. This team division strategy was done in both RangeTest and DataUtilitiesTest.

All members contributed at all parts of the assignment and work was distributed equally and fairly.


# 5 - Difficulties encountered, challenges overcome, and lessons learned

Our group had many issues getting tests to work with JMock. JUnit test can be quite easy, and is often just about making sure you understand what the method is meant to return; however, for JMock, you are essentially hard-coding return values which can be incorrect if you do not understand what values a function should return. With black-box testing it can be difficult to understand exactly what value a function returns when you cannot see the internal workings of the program.

One of the major dead ends or drawbacks we noticed was with calculating the row/column total, or more specifically when passing in an invalid index. In the documentation, it states that `DataUtilities` will return 0 when receiving an invalid index. For `Values2D`, it states that it will throw an `IndexOutOfBoundsException` when receiving an invalid index (in our test methods’ case, negative and high out-of-bounds indices). From reading this, we were under the assumption that DataUtilities would catch this exception and return 0, so we made a mock object with `will(throwException)`, and were faced with errors. This showed an immediate drawback with mock testing, and thus we had to make the object return 0 when invoked for invalid indices manually. Mock testing is an iterative approach which can take a large amount of time and effort.

Another drawback was with our `getCumulativeValues()` unit test creation. We quickly discovered that the function was not working properly at all: it appeared keyed indexes were hard-coded into the function and the last value of an array would be discarded and replaced with null, resulting in incorrect cumulative sum values. We wanted to get to the bottom of what exact error was causing this with our testing but we were unable to effectively: testing different cases required hard-coding each input with jMock and because we didn’t really understand what was going on internally it was hard to replicate this broken behavior properly. This goes to show that black-box testing isn’t necessarily effective in all areas: for this specific function, finding the cause of the defects was nigh-impossible without white-box testing and a look at the program’s internal workings.

Ultimately we learnt that in spite of its flaws, JMock testing is very useful in the industry, as there may be many cases in which you wish to test a class whose dependent class is not yet finished or in the midst of being worked on. That being said, it isn’t useful in every scenario and in some cases white-box testing would be a better approach.


# 6 - Comments/feedback on the lab itself

This lab was an insightful look into the industry standards of software testing. The JUnit section was a nice refresher on previous classes where we briefly covered the program, and the JMock section was a new insight on a way to test a class whose dependents are not yet completed. 

It was interesting to develop tests for a software program we had yet to encounter, and learning about it in the process of testing it to better develop test cases as we went along.

---
---

>Thank you