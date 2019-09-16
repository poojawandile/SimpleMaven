package com.myapp.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.bl.BusinessLogicProcessor;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println(" ######  %%%% -  INSIDE THE DO POST OF THE MAIN SERVLET %%%%  ######");
				
		String strPrimeElements = request.getParameter("numOfPrimeNumbers");
		String strFibElements = request.getParameter("numOfFibElements");
		String strNumbersToBeSorted = request.getParameter("sortNumbers");
		
		BusinessLogicProcessor bp = new BusinessLogicProcessor();
		
			if(!strPrimeElements.equalsIgnoreCase("")) {
				System.out.println(" In side Myservlet strPrimeElements >>"+ strPrimeElements);
				
				// check if strFibElements is a valid number if true set the result in string in Fibseries if false set the error message in the string. 
				// In BP write method to validate if the num is correct, in BP write a method to convert int arr to str, change the method generateFibseries
				// to return string.
				
				 //int numOfPrimeElem = Integer.parseInt(strPrimeElements); - old logic
				 //int[] arr = bp.generatePrimeNums(numOfPrimeElem); - old logic
				
				
				String primeNumberStr = bp.generatePrimeNums(strPrimeElements);
				System.out.println("In side Myservlet Generated Prime Numbers >>" + primeNumberStr);
				request.getSession().setAttribute("PrimeNumbers", primeNumberStr);
				response.sendRedirect("index.jsp");
			}
				
		if (!strFibElements.equalsIgnoreCase("")){
			System.out.println(" In side Myservlet strFibElements >>"+ strFibElements);
			
			String strFibSeries = bp.generateFibSeries(strFibElements);
			//System.out.println("In side Myservlet Generated Fib servies>>"+Arrays.toString(arr));
			request.getSession().setAttribute("Fibseries", strFibSeries);
			response.sendRedirect("index.jsp");
		}
		
		if(!strNumbersToBeSorted.equalsIgnoreCase("")) {
			System.out.println(" In side Myservlet strNumbersToBeSorted >>"+ strNumbersToBeSorted);
			
				int[] numbers = Arrays.asList(strNumbersToBeSorted.split(","))
	                      .stream()
	                      .map(String::trim)
	                      .mapToInt(Integer::parseInt).toArray();
				int [] sortedNumbersArray = bp.sortArrayInAscnOrder(numbers);
				request.getSession().setAttribute("SortedNumbers", sortedNumbersArray);
				response.sendRedirect("index.jsp");
			}	
		
	}

}
