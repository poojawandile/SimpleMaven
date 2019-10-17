<%@ page import="java.util.*"%>
<%@ page import="com.myapp.toggle.*"%>
<%@ page import="java.security.Principal"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<style>
.editorDemoTable {
  background-color: #FFF8C9;
  border-spacing: 0;
}
.editorDemoTable td{
  border: 1px solid #777;
  margin: 0 !important;
  padding: 2px 3px;
}
.editorDemoTable thead {
  background-color: #2E6C80;
  color: #FFF;
}
.editorDemoTable thead td {
	font-weight: bold;
	font-size: 13px;
}
</style>
<h1 style="color: #4485b8;">&nbsp;</h1>
<p>&nbsp;</p>
	<form action="MainServlet" method="post">
		<table class="editorDemoTable"
			style="vertical-align: top; width: 1000px; height: 135px;">
			<thead>
				<tr style="height: 23px;">
					<td style="text-align: center; width: 200px; height: 23px;"><strong></strong></td>
					<td style="text-align: center; width: 10px; height: 23px;"></td>
					<td style="text-align: center; width: 150px; height: 23px;">&nbsp;</td>
					<td style="text-align: center; width: 111px; height: 23px;">&nbsp;</td>
				</tr>
			</thead>
			
			<tbody>
				<tr style="height: 103px;">
					<td style="width: 200px; height: 103px;"><strong>Number	of Fib elements</strong></td>
					<td style="width: 10px; height: 103px;">
						<input name="numOfFibElements" type="text" />
						<!--  <input name="Action" type="hidden" value="GenerateFibSeries" />  -->
					</td>
					<td style="width: 150px; height: 103px;"><span
						style="line-height: 35px;"><input type="Submit"
							value="Generate Fib Series" /> </span></td>
					<td style="width: 210px; height: 103px; text-align: left;">
						<%
							Object obj = request. getSession().getAttribute("Fibseries");
							//int arr[] = (int[]) obj;
							//String fibSeries = Arrays.toString(arr);
							String fibSeries = new String ("");
							
							if(obj != null){
								fibSeries = obj.toString();
							}
							session.removeAttribute("Fibseries");
							
							
						%> <strong> <%=fibSeries%>
					</strong>
					</td>
				</tr>
			</tbody>

			<tbody>
				<tr style="height: 103px;">
					<td style="width: 200px; height: 103px;"><strong>Number of Prime numbers </strong></td>
					<td style="width: 10px; height: 103px;">
						<input name="numOfPrimeNumbers" type="text" />
						<!--  <input name="Action" type="hidden" value="GeneratePrimeNumbers" />  -->
					</td>
					<td style="width: 150px; height: 103px;"><span
						style="line-height: 35px;"><input type="Submit"
							value="Generate Prime numbers" /> </span></td>
					<td style="width: 210px; height: 103px; text-align: left;">
						<%
							Object obj1 = request.getSession().getAttribute("PrimeNumbers");
							//int arr1[] = (int[]) obj1;
							//String primeNumbers = Arrays.toString(arr1);
							
							String primeNumbers = new String("");
							if(obj1 != null){
								primeNumbers = obj1.toString();
							}
							
							session.removeAttribute("PrimeNumbers");
						%> 
						<strong><%=primeNumbers%></strong>

					</td>
				</tr>
			</tbody>
			
			<%
			
				boolean genNumInWords = MyFeatures.FEATURE_GEN_NUMBERS.isActive();
				System.out.println(" &&&&&&& ******* - FEATURE_GEN_NUMBERS >>"+genNumInWords);
				boolean sortNumbersFeatures = MyFeatures.FEATURE_SORT_NUMBERS.isActive();
				System.out.println(" &&&&&&& ******* - FEATURE_SORT_NUMBERS >>"+sortNumbersFeatures);
				if (sortNumbersFeatures)
				{
			%>
			
			<tbody>
				<tr style="height: 103px;">
					<td style="width: 200px; height: 103px;"><strong>Comma Separated numbers</strong></td>
					<td style="width: 10px; height: 103px;">
						<input name="sortNumbers" type="text" />
						
					<td style="width: 150px; height: 103px;"><span
						style="line-height: 35px;"><input type="Submit"
							value="Seln Sort the numbers" /> </span></td>
					<td style="width: 210px; height: 103px; text-align: left;">
						<%
							Object obj2 = request.getSession().getAttribute("SortedNumbers");
							int arr2[] = (int[]) obj2;
							String sortedNumbers = Arrays.toString(arr2);
							if (sortedNumbers.equals("null")) {
								sortedNumbers = "";
							}
							
							session.removeAttribute("SortedNumbers");
						%> <strong><%=sortedNumbers%></strong>
					</td>
				</tr>
			</tbody>
			<% 
				}
				if (genNumInWords)
				{
			%>
			
			<tbody>
				<tr style="height: 103px;">
					<td style="width: 200px; height: 103px;"><strong>Give number in numerical</strong></td>
					<td style="width: 10px; height: 103px;">
						<input name="numericals" type="text" />
						
					<td style="width: 150px; height: 103px;"><span
						style="line-height: 35px;"><input type="Submit"
							value="Generate the numerical in words" /> </span></td>
					<td style="width: 210px; height: 103px; text-align: left;">
						<%
						Object obj3 = request.getSession().getAttribute("numInWords");
						String numInWordsStr = new String("");
						if(obj3 != null){
							numInWordsStr = obj3.toString();
						}
						
						session.removeAttribute("numInWords");
						%><strong><%=numInWordsStr%></strong>
					</td>
				</tr>
			</tbody>
			<% }
				
				%>
			<tbody>
			<thead>
			<tr style="height: 23px;">
					<td style="text-align: center; width: 200px; height: 23px;">&nbsp;</td>
					<td style="text-align: center; width: 10px; height: 23px;">&nbsp;</td>
					<td style="text-align: center; width: 150px; height: 23px; color:white; font-size: x-large;"><strong>Have a Nice Day</strong></td>
					<td style="text-align: center; width: 111px; height: 23px;">&nbsp;</td>
				</tr>
			</thead>	
			</tbody>
			
		</table>
	</form>

</body>
</html>