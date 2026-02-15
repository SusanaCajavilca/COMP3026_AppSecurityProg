<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
<div align="center">
        <h1>User Registration Page</h1>

        <form action="<%=request.getContextPath()%>/HashedUserServlet" method="post">
            <table style="width: 50%;">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" required /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" required /></td>
                </tr>
                <tr>
                    <td>Mobile Number</td>
                    <td><input type="text" name="mobileNumber" required pattern="[0-9]{10}" 
                               title="Enter a valid 10-digit mobile number" /></td>
                </tr>
                <tr>
                    <td>Email ID</td>
                    <td><input type="email" name="emailId" required /></td>
                </tr>
            </table>
            <br/>
            <input type="submit" value="Submit" />
        </form>
    </div>


</body>
</html>