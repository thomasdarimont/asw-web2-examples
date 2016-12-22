<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<% request.setAttribute("systemProperties", java.lang.System.getProperties()); %>
 <table>
  <tr>
   <th>Key</th>
   <th>Value</th>
  </tr>
  <c:forEach var="entry" items="${systemProperties}">
   <tr>
    <td>
     <c:out value="${entry.key}" />
    </td>
    <td>
     <c:out value="${entry.value}" />
    </td>
   </tr>
  </c:forEach>
 </table>
</body>
</html>