<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>productGroup</th>
        <th>price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="laptop" items="${laptops}">
        <tr>
            <td scope="row">${laptop.id}</td>
            <td>${laptop.name}</td>
            <td>${laptop.productGroup}</td>
            <td>${laptop.price}</td>
            <td><a href="${pageContext.request.contextPath}/showlaptop?id=${mobile.id}">Link</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="/laptops/">Main page</a>