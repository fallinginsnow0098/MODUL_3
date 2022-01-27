<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Simple Login</title>

    <style>
        .login {
            height: 100%;
            width: 50%;
            margin: 0;
            padding: 10px;
            border: 1px #CCC solid;
            background-color: blanchedalmond;
        }

        .login input {
            padding: 5px;
            margin: 5px
        }
    </style>
</head>

<body>
<form method="post" action="/login">
    <div class="login">
        <h2>Login</h2>
        <label>
            <input type="text" name="username" size="30" placeholder="username"/>
        </label>
        <label>
            <input type="password" name="password" size="30" placeholder="password"/>
        </label>
        <input type="submit" value="Sign in"/>
    </div>
</form>
</body>
</html>