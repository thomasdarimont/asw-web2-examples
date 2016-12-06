<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
 <h1>Benutzer&uuml;bersicht</h1>

 <h2>Neuen Benutzer anlegen</h2>
 <form action="processForm" method="POST">
  <input name="firstname" type="text" placeholder="Vorname"></input>
  <br>
  <input name="lastname" type="text" placeholder="Nachname"></input>
  <br>
  <button>Hinzuf&uuml;gen</button>
 </form>
 <h2>Vorhendene Benutzer</h2>
 <ul>
  <c:forEach items="${users}" var="user">
   <li>
    <c:out value="${user.displayName}" />
   </li>
  </c:forEach>
 </ul>
</body>
</html>