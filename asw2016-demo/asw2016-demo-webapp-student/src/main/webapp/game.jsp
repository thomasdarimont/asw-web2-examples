<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ASW-WEB2 Student-Files (Complete)</title>
    <style>
        * {
            font-size: 32px;
        }

        body {
            background-image: url("res/cottonCandy.jpg");
            text-align: center;
            cursor:url(res/elfCursor.png), auto;
        }

        #hint {
            color: white;
            position: relative;
            top:-333px;
            left:163px;
        }

        button {
            border: 3px #F062AC solid;
            background-color: #F0B6D4;
            color:white;
            cursor:url(res/elfCursor.png), auto;
        }

        input{
            border: 3px #F062AC solid;
            background-color: #F0B6D4;
            color:white;
            cursor:url(res/elfCursor.png), auto;
        }

        li{
            cursor:url(res/elfCursor.png), auto;
        }

        ul li{
            list-style:none;
        }

        ul li img {
            border:5px #F062AC solid;
        }

        #unicorn {
            max-width: 50%;
        }

        .center {
            display: inline-block;
        }

    </style>
</head>
<body>
<div id="content" class="center">
    <!--<h1>Number Guessing Game</h1>-->
    <img alt="Number guessing game" src="res/logo.png">

    <div class="box">
        <ul>
            <li>
                <a href="guess-my-number"><img alt ="Start easy game" src="res/startNewGameSimple.gif" title="You will need to guess a number between 0 to 100"></a>
            </li>
            <li>
                <a href="guess-my-number?max=1000"><img alt="Start hard game" src="res/startNewGameHard.gif" title="You will need to guess a number between 0 to 1000"></a>
            </li>
        </ul>
    </div>
    <img alt="Puking Unicorn" src="res/unicorn2.png" id="unicorn">
    <div id="hint" class="box"><%=request.getAttribute("hint") != null ? request.getAttribute("hint") : ""%>
    </div>
    <form action="guess-my-number" method="POST">
        <input type="number" name="guess" placeholder="Enter your guess..." required/>
        <button>Try</button>
    </form>
</div>
</body>
</html>