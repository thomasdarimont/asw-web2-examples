<!DOCTYPE HTML>
<%@page import="java.util.Map"%>
<html>
<body>

 <table>
  <tr>
   <th>Key</th>
   <th>Value</th>
  </tr>
  <%
  	for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
  %>
  <tr>
   <td><%=entry.getKey()%></td>
   <td><%=entry.getValue()%></td>
  </tr>
  <%
  	}
  %>
 </table>
</body>
</html>