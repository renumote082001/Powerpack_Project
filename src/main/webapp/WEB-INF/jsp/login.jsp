<html>
    <head></head>
    <body>
        <form name="loginForm" id="loginForm" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            Username: <input type="text" name="username" id="username"/><br/><br/>
            Password: <input type="password" name="password" id="password"/><br/><br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
