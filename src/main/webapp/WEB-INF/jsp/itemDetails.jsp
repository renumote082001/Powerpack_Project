<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Item Details</title>
    <!-- Include any necessary CSS or JavaScript -->
</head>
<body>
    <h2>Item Details</h2>
    
    <c:if test="${not empty items}">
        <table border="1">
            <tr>
                <th>Item ID</th>
                <th>Level</th>
                <th>Code</th>
                <th>Item Description</th>
                <th>Next Level</th>
            </tr>
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>${item.itemId}</td>
                    <td>${item.level}</td>
                    <td>${item.code}</td>
                    <td>${item.itemDescription}</td>
                    <td>${item.nextLevel}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty items}">
        <p>No items found for level ${param.level}</p>
    </c:if>
</body>
</html>
