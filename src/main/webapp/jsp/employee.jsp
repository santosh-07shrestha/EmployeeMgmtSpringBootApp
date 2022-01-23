<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee Details</title>
</head>
<body>



<form:form action="addEmployee" modelAttribute="employee" method="POST" >
      <table>
          <tr>
              <td>First Name:</td>
              <td><form:input required="required" path="first_name" /></td>
          </tr>
          <tr>
              <td>Last Name:</td>
              <td><form:input required="required" path="last_name" /></td>
          </tr>
           <tr>
              <td>Gender:</td>
              <td><form:input required="required"  path="gender" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="reset" value="Reset" />
              </td>
              <td><input type="submit" value="Add Employee" > </td>
          </tr>
          <p> Note: ${msg }</p>
      </table>
  </form:form>
  
  <a href="viewEmployee">View All Employees</a>

</body>
</html>