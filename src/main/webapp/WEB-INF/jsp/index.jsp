<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head></head>
    <body>
        <sec:authentication property="principal" var="curUser" scope="request"/>
        ${curUser.name} - ${curUser.authorities}<br/><br/>
        <a href="addUser.htm">Add User</a>&nbsp;&nbsp;<a href="listUser.htm">List User</a>
    </body>
</html>
