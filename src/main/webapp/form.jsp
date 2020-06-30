<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="laptop" class="com.myproject.pojo.Laptop" />
<c:set target="${laptop}" property="name" value="FIRST" />
<jsp:setProperty name="laptop" property="productGroup" value="0" />


<h1>Adding a new laptop</h1>
<form method="post" action="${pageContext.request.contextPath}/addlaptop" autocomplete="off">
    <div class="form-group">
        <label for="name">Name</label>
        <input name="name" type="text" class="form-control" id="name" value="<jsp:getProperty name="laptop" property="name" />">
    </div>
    <div class="form-group">
        <label for="productGroup">ProductGroup</label>
        <input name="productGroup" type="text" class="form-control" id="productGroup" value="<jsp:getProperty name="laptop" property="productGroup" />">
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <input name="price" type="text" class="form-control" id="price" value="<jsp:getProperty name="laptop" property="price" />">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>