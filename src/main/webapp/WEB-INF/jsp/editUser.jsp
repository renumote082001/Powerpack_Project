<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <script type="text/javascript">
           
        </script>
    </head>
    <body >
        <h1>Edit User</h1>
        <form:form name="editUser" modelAttribute="user" method="POST" action="editUser.htm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <form:hidden path="userId"/>
            <label>Name: </label><form:input path="name" /><br/><br/>
            <label>Username: </label><form:input path="username" /><br/><br/>
            <label>Role: </label><form:select path="role"><form:option value="${user.role.id}">${user.role.label}</form:option></form:select><br/><br/>
            <input type="submit" value="Submit"/>&nbsp;&nbsp;&nbsp;<input type="button" value="Cancel" onclick="window.location.href = 'listUser.htm?msg=Cancelled';"/>
        </form:form>
        <br/><br/>
        ${msg}${param.msg}
    </body>
</html>

