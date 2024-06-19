<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <script type="text/javascript">
            function editUser(userId){
                document.getElementById("userId").value=userId;
                document.getElementById("editForm").submit();
            }
            
        </script>
    </head>
    <body>
        <br/><br/><a href="index.htm">Home</a>&nbsp;&nbsp;<a href="logout">logout</a>
        <fieldset>
            <legend>User List</legend>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Username</th>
                            <th>Role</th>
                            <th>Active</th>
                            <th>Edit</th>
                        </tr>
                       </thead>
                       <tbody>
                           <c:forEach items="${userList}" var="user">
                               <tr>
                                   <td>${user.name}</td>
                                   <td>${user.username}</td>
                                   <td>${user.role.label}</td>
                                   <td>${user.active}</td>
                                   <td><a href="javascript:editUser(${user.userId});">Edit</a></td>      
                               </tr>
                            </c:forEach>
                       </tbody>
                </table>
                <br/><br/>
                <form name="editForm" id="editForm" method ="POST" action="showEditUser.htm">
                     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <input type="hidden" name="userId" id="userId"/>
             </fieldset>
         </body>
</html>
    
    

