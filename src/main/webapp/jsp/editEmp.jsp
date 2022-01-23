<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee Details</title>
</head>
<body>


<%-- <form:form method="POST" action="editsave" modelAttribute="student"> --%>
<form:form action="updateEmployee" modelAttribute="editEmp" method="POST" >
      <table>
      
      <tr>
              <td><form:hidden path="emp_id" /></td>
          </tr>
      
          <tr>
              <td>First Name:</td>
              <td><form:input path="first_name" /></td>
          </tr>
          <tr>
              <td>Last Name:</td>
              <td><form:input path="last_name" /></td>
          </tr>
           <tr>
              <td>Gender:</td>
              <td><form:input path="gender" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="reset" value="Reset" />
              </td>
              <td><input type="submit" value="Save" > </td>
          </tr>
      </table>
  </form:form>

</body>
</html>