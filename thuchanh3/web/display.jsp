<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>House List</title>
    </head>
    <body>
        <h2>Kết quả tìm kiếm</h2>
        <table border="1">
            <tr>
                <th>ID</th><th>Address</th><th>Area</th><th>Type</th><th>Action</th>
            </tr>
            <c:forEach items="${data}" var="h">
                <tr>
                    <td>${h.id}</td>
                    <td>${h.address}</td>
                    <td>${h.area}</td>
                    <td>${h.type}</td>
                    <td>
                        <c:choose>
                            <c:when test="${h.sold == 0}">
                                <a href="house?action=buy&id=${h.id}">Buy</a>
                            </c:when>
                            <c:otherwise>Sold</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="index.jsp">Quay lại tìm kiếm</a>
    </body>
</html>