<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ASW-WEB2 Student-Files (Complete)</title>
<style>
* {
 font-size: 32px;
}

#hint {
 color: red;
}
</style>
</head>
<body>
 <div id="content">
  <h1>Number Guessing Game</h1>

  <div class="box">
   <ul>
    <li>
     <a href="guess-my-number">Start a new Game! (Easy) [0,100)</a>
    </li>
    <li>
     <a href="guess-my-number?max=1000">Start a new Game! (Hard) [0,1000)</a>
    </li>
   </ul>
  </div>
  <div id="hint" class="box"><%=request.getAttribute("hint") != null ? request.getAttribute("hint") : ""%></div>
  <form action="guess-my-number" method="POST">
   <input type="number" name="guess" placeholder="Enter your guess..." required />
   <button>Try</button>
  </form>
 </div>
</body>
</html>