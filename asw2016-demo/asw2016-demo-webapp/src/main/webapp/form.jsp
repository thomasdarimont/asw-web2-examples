<%@page import="de.asw.courses.web2016.demo.backend.servlet.forms.FormServlet.User"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
 <h1>User Overview</h1>

 <h2>Create a new User</h2>
 <form action="processForm" method="POST">
  <input name="firstname" type="text" placeholder="Firstname"></input>
  <br>
  <input name="lastname" type="text" placeholder="Lastname"></input>
  <br>
  <button>Add User</button>
 </form>
 <h2>User Listing (scriptlets)</h2>
 <ul>
 <% 
 List<User> users = (List<User>)request.getAttribute("users");
 for(User user : users){
 %>
 <li> <%= user.getDisplayName() %></li>
 <% } %>
 </ul>
 
 <!-- 
 <h2>User Listing (Tag Lib)</h2>
 <ul>
  <c:forEach items="${users}" var="user">
   <li>
    <c:out value="${user.displayName}" />
   </li>
  </c:forEach>
 </ul>
  -->
</body>
</html>