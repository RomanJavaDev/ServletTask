
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<ul class="list-group">
    <li class="list-group-item">${laptop.id}</li>
    <li class="list-group-item">${laptop.name}</li>
    <li class="list-group-item">${laptop.productGroup}</li>
    <li class="list-group-item">${laptop.price}</li>
</ul>

<br>
<a href="/laptops/">Main page</a>