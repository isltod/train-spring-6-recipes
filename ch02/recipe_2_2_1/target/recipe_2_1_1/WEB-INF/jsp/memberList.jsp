<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Member List</title>
  </head>
  <body>
    <h2>Guests Members</h2>
    <table>
      <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
      </tr>
      <c:forEach var="m" items="${guests}">
        <tr>
          <td>${m.name}</td>
          <td>${m.phone}</td>
          <td>${m.email}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
