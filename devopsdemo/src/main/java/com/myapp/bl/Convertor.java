package com.myapp.bl;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Convertor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Map createNumberMapper() {
		
		
		Map<Long, String> numberMap = new HashMap<Long, String>();
		numberMap.put((long)0, "zero");
		numberMap.put((long)1, "one");
		numberMap.put((long)2, "two");
		numberMap.put((long)3, "three");
		numberMap.put((long)4, "four");
		numberMap.put((long)5, "five");
		numberMap.put((long)6, "six");
		numberMap.put((long)7, "seven");
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
		numberMap.put((long)30, "thirty");
		numberMap.put((long)40, "forty");
		numberMap.put((long)50, "fifty");
		numberMap.put((long)60, "sixty");
		numberMap.put((long)70, "seventy");
		numberMap.put((long)80, "eighty");
		numberMap.put((long)90, "ninty");
		return numberMap;
	}
	
	private Map upperLimitNumber () {
		
		Map<Integer, String> upperNumberMap = new HashMap<Integer, String>();
		upperNumberMap.put(100, " hundred");
		upperNumberMap.put(1000, " thousand");
		upperNumberMap.put(100000, " lakh");
		upperNumberMap.put(10000000, " crore");
		return upperNumberMap;
		
	}
	
	private static List <Integer> createNumberSystemList()
    {
        List <Integer> list = new ArrayList<Integer>();
        list.add(10000000);
        list.add(100000);
        list.add(1000);
        list.add(100);
        return list;
    }
	
	public String convertNumberToText (String number) {
		
		String returnStr = "";
		String newStr = number;
		
		if(number.contains(",")) {
			newStr = number.replaceAll(",", "");
			//System.out.println(newStr);
		}
		
		long newNumber =  Long.parseLong(newStr);
		
		returnStr = convertNumberToText(newNumber);
		return returnStr;
		
	}
	
	
	public String convertNumberToText (long number) {
		
		Map<Integer, String> mapper = createNumberMapper();
		Map<Integer, String> upperMap = upperLimitNumber();
		
//		System.out.println("Input number is >>>"+number);
		
		String returnStr ="";
				
		if (mapper.containsKey(Long.valueOf(number))) {
			returnStr = findInMapper(number, mapper);
			//System.out.println("returnStr is >>>"+returnStr);
			return andAppender(returnStr);
		}
		
		List<Integer> intList = createNumberSystemList();
		
		Iterator <Integer> iterator = intList.iterator();
		
		while(iterator.hasNext()) {
			
			int item = iterator.next();
			
			String prefix = (String) upperLimitNumber().get(Integer.valueOf(item));
			//System.out.println(" item >>>>>>>>>" + item + " prefix is >>"+ prefix);
			
			if(number >= item) {
				//System.out.println(" item >>>" + item);
				//System.out.println(" -----*** Inside *** number >>>"+ number);
				
				returnStr = convertNumberToText(number / item) + prefix;
				long nums = number % item ;
				
				if (nums > 0) {
					returnStr = returnStr + " " + convertNumberToText(nums);
				}
				//System.out.println("returnStr is >>> &&&& ----"+returnStr);
				return andAppender(returnStr);
			}
		}
		
			
		returnStr = findInMapper(number / 10 * 10 , mapper) + " " + findInMapper(number % 10 , mapper);
		//System.out.println("returnStr is >.......>>"+returnStr);
		return andAppender(returnStr);
	}

	
	private String findInMapper(long l, Map<Integer, String> mapper) {
		String str = mapper.get(Long.valueOf(l));
		return str;
	}
	
	public String andAppender(String str) {
		
		//System.out.println("Without And >>"+str);
		String returnStr = str;
		
		if (str.contains(" and ")) {
			//System.out.println("With And >>"+returnStr);
			return returnStr;
		}
		
		if(str.endsWith("hundred")) {
			//System.out.println("With And >>"+returnStr);
			return returnStr;
		}
		else if (str.contains("hundred")) {
			String parts[] = str.split("hundred");
			returnStr = parts [0] + "hundred and" + parts [1];
			//System.out.println("With And >>"+returnStr);
			return returnStr;
		}
		return returnStr;	
	}

}
