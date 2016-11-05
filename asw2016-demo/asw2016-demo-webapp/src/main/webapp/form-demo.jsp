<html>
<body>

 <h1>Benutzerregistrierung</h1>
 <form action="/asw2016-demo-webapp/resources/signup" method="POST">

  <div>
   <label for="firstname">Vorname</label>
   <input name="firstname" type="text" value="" required></input>
  </div>

  <div>
   <label for="lastname">Nachname</label>
   <input name="lastname" type="text" value="" required></input>
  </div>

  <div>
   <label for="email">Email</label>
   <input name="email" type="email" value="" required></input>
  </div>

  <div>
   <input type="submit" value="Absenden"></input>
  </div>
 </form>
</body>
</html>