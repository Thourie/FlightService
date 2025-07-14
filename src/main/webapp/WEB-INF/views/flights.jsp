<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Список перелётов</title>
  <meta charset="UTF-8">
  <style>
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
      position: sticky;
      top: 0;
    }
    tr:nth-child(even) {
      background-color: #f9f9f9;
    }
    tr:hover {
      background-color: #f1f1f1;
    }
    .no-flights {
      margin: 20px;
      padding: 10px;
      background-color: #ffeeee;
      border: 1px solid #ffcccc;
    }
  </style>
</head>
<body>
<h1>Список перелётов</h1>

<c:choose>
  <c:when test="${empty flights}">
    <div class="no-flights">
      Нет доступных перелётов
    </div>
  </c:when>
  <c:otherwise>
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Номер рейса</th>
        <th>Аэропорт вылета</th>
        <th>Дата вылета</th>
        <th>Аэропорт прилёта</th>
        <th>Дата прилёта</th>
        <th>ID самолёта</th>
        <th>Статус</th>
        <th>Действия</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${flights}" var="flight">
        <tr>
          <td>${flight.id}</td>
          <td>${flight.flightNo}</td>
          <td>${flight.departureAirportCode}</td>
          <td>${flight.departureDate}</td>
          <td>${flight.arrivalAirportCode}</td>
          <td>${flight.arrivalDate}</td>
          <td>${flight.aircraftId}</td>
          <td>${flight.status}</td>
          <td>
            <a href="/tickets?flightId=${flight.id}">Билеты</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:otherwise>
</c:choose>

<div style="margin-top: 20px;">
  <a href="/">На главную</a>
</div>
</body>
</html>