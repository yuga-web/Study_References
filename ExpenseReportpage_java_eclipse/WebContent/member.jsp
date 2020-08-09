<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to SS Softslotions</h1>
<h3>Expense Report Portal</h3>
<form  method="post"action="Redirectportal">
<table>
<tr>
<td>Select Type</td>
<td><button name="exp" value="monthCompExp">Monthly Company Expenses</button></td>
<td><button name="exp" value="dailyOffExp">Daily Office Expenses</button></td>
<td><button name="exp" value="BusinessTripExp">Business Trip Expenses</button></td>
</tr>
</table>
</form>


</body>
</html>