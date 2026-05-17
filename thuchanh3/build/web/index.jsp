<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search House</title>
    </head>
    <body>
        <h2>Tìm kiếm nhà</h2>
        <form action="house" method="get">
            <input type="hidden" name="action" value="search">
            ID: <input type="text" name="id" value="${sessionScope.s_id}"><br>
            Address: <input type="text" name="address" value="${sessionScope.s_address}"><br>
            Area: <input type="number" name="area" value="${sessionScope.s_area}"><br>
            Type: <input type="text" name="type" value="${sessionScope.s_type}"><br>
            <button type="submit">Search</button>
        </form>
    </body>
</html> 