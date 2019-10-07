package com.myapp.junit;

import static org.junit.Assert.*;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myapp.bl.Convertor;

public class ConvertorTest {

	Convertor convertor = new Convertor();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void convertNumberToTextTest() {

		Map<Long, String> numberMap = new HashMap<Long, String>();
		numberMap.put((long) 0, "zero");
		numberMap.put((long)1, "one");
		numberMap.put((long)2, "two");
		numberMap.put((long)3, "three");
		numberMap.put((long)4, "four");
		numberMap.put((long)5, "five");
		numberMap.put((long)6, "six");
		numberMap.put((long)8, "eight");
		numberMap.put((long)9, "nine");

		numberMap.put((long)10, "ten");
		numberMap.put((long)11, "eleven");
		numberMap.put((long)12, "twelve");
		numberMap.put((long)13, "thirteen");
		numberMap.put((long)14, "fourteen");
		numberMap.put((long)15, "fifteen");
		numberMap.put((long)16, "sixteen");
		numberMap.put((long)17, "seventeen");
		numberMap.put((long)18, "eighteen");
		numberMap.put((long)19, "nineteen");
		numberMap.put((long)20, "twenty");
		numberMap.put((long)89, "eighty nine");
		numberMap.put((long)99, "ninty nine");

		numberMap.put((long)21, "twenty one");
		numberMap.put((long)22, "twenty two");
		numberMap.put((long)29, "twenty nine");
		numberMap.put((long)30, "thirty");
		numberMap.put((long)39, "thirty nine");
		numberMap.put((long)59, "fifty nine");
		numberMap.put((long)100, "one hundred");
		numberMap.put((long)900, "nine hundred");
		numberMap.put((long)110, "one hundred and ten");
		numberMap.put((long)910, "nine hundred and ten");
		numberMap.put((long)870, "eight hundred and seventy");
		numberMap.put((long)875, "eight hundred and seventy five");
		numberMap.put((long)999, "nine hundred and ninty nine");
		numberMap.put((long)1000, "one thousand");
		numberMap.put((long)1100, "one thousand one hundred");
		numberMap.put((long)9900, "nine thousand nine hundred");
		numberMap.put((long)9990, "nine thousand nine hundred and ninty");
		numberMap.put((long)9995, "nine thousand nine hundred and ninty five");
		numberMap.put((long)10000, "ten thousand");
		numberMap.put((long)11345, "eleven thousand three hundred and forty five");
		numberMap.put((long)100000, "one lakh");
		numberMap.put((long)178988, "one lakh seventy eight thousand nine hundred and eighty eight");
		numberMap.put((long)9999988, "ninty nine lakh ninty nine thousand nine hundred and eighty eight");
		numberMap.put((long)99999988, "nine crore ninty nine lakh ninty nine thousand nine hundred and eighty eight");
		

		for (Map.Entry<Long, String> entry : numberMap.entrySet()) {
			String expectedOutput = entry.getValue();
			String actualOutput = convertor.convertNumberToText(entry.getKey());
			// System.out.println(" expectedOutput >>>>>>>>>"+expectedOutput);
			Assert.assertEquals("Falied Validation for >>> &&& >> " + entry.getKey(), expectedOutput, actualOutput);

		}

	}
	
	@Test
	public void convertNumberToTextFromStrTest() {
		
		
		Map<String, String> numberMap = new HashMap<String, String>();
		numberMap.put("0", "zero");
		numberMap.put("1", "one");
		numberMap.put("2", "two");
		numberMap.put("3", "three");
		numberMap.put("4", "four");
		numberMap.put("5", "five");
		numberMap.put("6", "six");
		numberMap.put("8", "eight");
		numberMap.put("9", "nine");

		numberMap.put("10", "ten");
		numberMap.put("11", "eleven");
		numberMap.put("12", "twelve");
		numberMap.put("13", "thirteen");
		numberMap.put("14", "fourteen");
		numberMap.put("15", "fifteen");
		numberMap.put("16", "sixteen");
		numberMap.put("17", "seventeen");
		numberMap.put("18", "eighteen");
		numberMap.put("19", "nineteen");
		numberMap.put("20", "twenty");
		numberMap.put("89", "eighty nine");
		numberMap.put("99", "ninty nine");

		numberMap.put("21", "twenty one");
		numberMap.put("22", "twenty two");
		numberMap.put("29", "twenty nine");
		numberMap.put("30", "thirty");
		numberMap.put("39", "thirty nine");
		numberMap.put("59", "fifty nine");
		numberMap.put("100", "one hundred");
		numberMap.put("900", "nine hundred");
		numberMap.put("110", "one hundred and ten");
		numberMap.put("910", "nine hundred and ten");
		numberMap.put("870", "eight hundred and seventy");
		numberMap.put("875", "eight hundred and seventy five");
		numberMap.put("999", "nine hundred and ninty nine");
		numberMap.put("1,000", "one thousand");
		numberMap.put("1,100", "one thousand one hundred");
		numberMap.put("9,900", "nine thousand nine hundred");
		numberMap.put("9,990", "nine thousand nine hundred and ninty");
		numberMap.put("9,995", "nine thousand nine hundred and ninty five");
		numberMap.put("10,000", "ten thousand");
		numberMap.put("11,345", "eleven thousand three hundred and forty five");
		numberMap.put("1,00,000", "one lakh");
		numberMap.put("1,78,988", "one lakh seventy eight thousand nine hundred and eighty eight");
		numberMap.put("99,99,988", "ninty nine lakh ninty nine thousand nine hundred and eighty eight");
		numberMap.put("9,99,99,988", "nine crore ninty nine lakh ninty nine thousand nine hundred and eighty eight");
		numberMap.put("99,99,99,988", "ninty nine crore ninty nine lakh ninty nine thousand nine hundred and eighty eight");
		numberMap.put("999,99,99,988", "nine hundred and ninty nine crore ninty nine lakh ninty nine thousand nine hundred and eighty eight");
		numberMap.put("9999,99,99,999", "nine thousand nine hundred and ninty nine crore ninty nine lakh ninty nine thousand nine hundred and ninty nine");
		numberMap.put("99,999,99,99,999", "ninty nine thousand nine hundred and ninty nine crore ninty nine lakh ninty nine thousand nine hundred and ninty nine");
		numberMap.put("9,99,999,99,99,999", "nine lakh ninty nine thousand nine hundred and ninty nine crore ninty nine lakh ninty nine thousand nine hundred and ninty nine");
		
		
		

		for (Map.Entry<String, String> entry : numberMap.entrySet()) {
						
			String expectedOutput = entry.getValue();
			//System.out.println(" expectedOutput >>>>>>>>>"+expectedOutput);
			//System.out.println(" entry.getKey() >>>>>>>>>"+entry.getKey());
			String actualOutput = convertor.convertNumberToText(entry.getKey());
			
			Assert.assertEquals("Falied Validation for >>> &&& >> " + entry.getKey(), expectedOutput, actualOutput);

		}

	}
	

	@Test
	public void andAppenderTest() {

		
		  String expectedStrArry [] = {"zero", "one", "two", "three", "four", "five",
		  "six", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
		  "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
		  "eighty nine", "ninty nine", "twenty one", "twenty two", "twenty nine",
		  "thirty", "thirty nine", "fifty nine", "one hundred", "nine hundred",
		  "one hundred and ten", "nine hundred and ten", "eight hundred and seventy",
		  "eight hundred and seventy five", "nine hundred and ninty nine",
		  "one thousand", "one thousand one hundred", "nine thousand nine hundred",
		  "nine thousand nine hundred and ninty",
		  "nine thousand nine hundred and ninty five", "ten thousand",
		  "eleven thousand three hundred and forty five", "one lakh",
		  "one lakh seventy eight thousand nine hundred and eighty eight"};
		  
		  
		  
		  String inputStr [] = {"zero", "one", "two", "three", "four", "five", "six",
		  "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
		  "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
		  "eighty nine", "ninty nine", "twenty one", "twenty two", "twenty nine",
		  "thirty", "thirty nine", "fifty nine", "one hundred", "nine hundred",
		  "one hundred ten", "nine hundred ten", "eight hundred seventy",
		  "eight hundred seventy five", "nine hundred ninty nine", "one thousand",
		  "one thousand one hundred", "nine thousand nine hundred",
		  "nine thousand nine hundred ninty", "nine thousand nine hundred ninty five",
		 "ten thousand", "eleven thousand three hundred forty five", "one lakh",
		  "one lakh seventy eight thousand nine hundred eighty eight"};
		 

		String[] actualOuputArry = new String[inputStr.length];

		for (int i = 0; i < inputStr.length; i++) {
			actualOuputArry[i] = convertor.andAppender(inputStr[i]);
		}
		Assert.assertArrayEquals(" Validation has failed in andAppender ***** >>", expectedStrArry, actualOuputArry);

	}

}
