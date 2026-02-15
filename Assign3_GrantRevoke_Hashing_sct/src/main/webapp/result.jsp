<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sct.model.HashedUser" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registered Users</title>
</head>
<body>
<div align="center">
        <h1>All Registered Users</h1>

        <table border="1" cellpadding="5" style="width: 60%;">
            <tr>
                <th>Username</th>
     
                <!-- <th>Hashed Password</th> -->
                <th>Mobile Number</th>
                <th>Email ID</th>
            </tr>

            <%
                List<HashedUser> users = (List<HashedUser>) request.getAttribute("users");
                if (users != null) {
                    for (HashedUser u : users) {
            %>
            <tr>
                <td><%= u.getUsername() %></td>
                
                <!-- <td><%= u.getPassword() %></td> -->
                <td><%= u.getMobileNumber() %></td>
                <td><%= u.getEmailId() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="4">No users registered yet.</td>
            </tr>
            <%
                }
            %>
        </table>
        <br/>
        <a href="register.jsp">Back to Registration</a>
    </div>

</body>
</html>