
package com.myapp.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.myapp.bl.BusinessLogicProcessor;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

public class BusinessLogicTest {
	private BusinessLogicProcessor busLogic;
	//private Logger myLogger;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Do nothing for now 
		System.out.println("In setUpBeforeClass");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Do nothing for now
		
	}

	@Before
	public void setUp() throws Exception {
		busLogic = new BusinessLogicProcessor();
		//myLogger = Logger.getLogger("InfoLogging");
		
	}

	@After
	public void tearDown() throws Exception {
		// Do nothing for now
		
	}
	
	@Test
	public void testIsEven() {
		int num = 2;
		boolean even = busLogic.isEven(num);
		assertTrue(even);
		assertFalse(busLogic.isEven(3));
	}
	
	
	@Test
	public void testGeneratePrimeNum() {
		int [] expectedPrimeNumbers = {1,2,3,5,7,11,13,17,19,23};
		int numOfPrimeDigs = expectedPrimeNumbers.length;
		int [] generatedPrimeNums = busLogic.generatePrimeNums(numOfPrimeDigs);
		//System.out.println(" Expected Prime Numbers           is >>"+Arrays.toString(expectedPrimeNumbers));
		//System.out.println(" generatedPrimeNums Prime Numbers is >>"+Arrays.toString(generatedPrimeNums));
		assertArrayEquals(expectedPrimeNumbers, generatedPrimeNums);
		/*
		int [] expArr1 = {1};
		int [] geArr1 = busLogic.generatePrimeNums(expArr1.length);
		assertArrayEquals(expArr1, geArr1);
		*/
	}
	
	@Test
	public void testGeneratePrimeNums() {
		String[] inputStr = {"-1"}; 
		String[] expectedResult = {"Enter a valid number"};
		String[] resultStr = {busLogic.generatePrimeNums(inputStr[0])};
		assertArrayEquals(expectedResult,resultStr);
	}

	@Test
	public void testGenerateFibSeries() {
		int[] expectedSeries = { 0, 1, 1, 2, 3, 5, 8, 13 };
		int len = expectedSeries.length;
		int[] generatedSeries = busLogic.generateFibSeries(len);
		//myLogger.log(Level.FINE, "Testing Logger **************");
		//System.out.println(" >>> expected Fib Series >>" + Arrays.toString(expectedSeries));
		//System.out.println(" >>> generated Fib Series>>" + Arrays.toString(generatedSeries));
		assertArrayEquals(expectedSeries, generatedSeries);
	}
	
	@Test
	public void testStrGeneratedFibSeries() {
		String input = "-1";
		String returnedStr = busLogic.generateFibSeries(input);
		String expectedStr = "Enter a valid number";
		assertEquals(expectedStr, returnedStr);
		assertEquals(expectedStr, busLogic.generateFibSeries("nfe"));
	}
	
	@Test
	public void testStrGeneratedFibSeries1() {
		String input = "10";
		String expectedStr = "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]";
		String returnedStr = busLogic.generateFibSeries(input);
		assertEquals(expectedStr, returnedStr);
	}
	
	@Test
	public void testSorting() {
		
		//int [] inArr = {3,4,5,6,7,1,2,10};
		
		String strNumbersToBeSorted = "15,3,4,5,6,7,1,2,10";
		int[] inArr = Arrays.asList(strNumbersToBeSorted.split(","))
                .stream()
                .map(String::trim)
                .mapToInt(Integer::parseInt).toArray();
		//System.out.println("inArr Arr >>>" + Arrays.toString(inArr));
		
		int [] expectedArr = {1,2,3,4,5,6,7,10,15}; // give sorted array of the above inArr here
		int [] returnArr = busLogic.sortArrayInAscnOrder(inArr);
		//System.out.println("expectedArr Arr >>>" + Arrays.toString(expectedArr));
		//System.out.println("returned Arr >>>" + Arrays.toString(returnArr));
		assertArrayEquals(expectedArr, returnArr);
		
		//System.out.println("********In side testSorting");
	}
}	
