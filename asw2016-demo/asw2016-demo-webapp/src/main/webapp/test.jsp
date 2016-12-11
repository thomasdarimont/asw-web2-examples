<html>
  <head>
    <title> Meine erste JSP </title>
  </head>
  <body>
    <h1> Meine erste JSP </h1>
    <%
      // beliebiger Java-Code ...
      out.println( "Hallo" );
      
      // Neben out sind noch viele weitere implizite Objekte in einer JSP verfügbar
      // https://www.tutorialspoint.com/jsp/jsp_implicit_objects.htm
    %>
    <%= request.getRemoteHost() %>
    ...
  </body>
</html>