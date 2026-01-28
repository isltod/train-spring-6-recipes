<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Reservation Query</title>
  </head>
  <body>
    <form method="post">
      Cour Name
      <input type="text" name="courtName" value="${courtName}" />
      <input type="submit" value="Query" />
    </form>
    <table border="1">
      <tr>
        <th>Court Name</th>
        <th>Date</th>
        <th>Hour</th>
        <th>Player</th>
      </tr>
      <c:forEach items="${reservations}" var="reservation">
        <tr>
          <td>${reservation.courtName}</td>
          <td>${reservation.date}</td>
          <td>${reservation.hour}</td>
          <td>${reservation.player.name}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
