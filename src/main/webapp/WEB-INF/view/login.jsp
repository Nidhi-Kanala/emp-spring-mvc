    
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Page</title>
</head>
<body>
    <h1>Login page !!</h1>
    <form action="/users/login" method="post">
        UserName: <input type="text" name="username" placeholder="Enter your username">
        Password: <input type="password" name="password" placeholder="Enter your password">

        <button type="submit">Login</button>
    </form>
</body>
</html>