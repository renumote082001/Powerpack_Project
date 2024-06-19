<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Item List</title>
    <style>
    </style>
</head>
<body>
    <h2>Item List</h2>
    <table border="1">
        <tr>
            <th>Item ID</th>
            <th>Level</th>
            <th>Code</th>
            <th>Item Description</th>
            <th>Next Level</th>
        </tr>
        <c:forEach var="item" items="${itemList}">
            <tr>
                <td>${item.itemId}</td>
                <td>${item.level}</td>
                <td>${item.code}</td>
                <td>${item.itemDescription}</td>
                <td>${item.nextLevel}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html