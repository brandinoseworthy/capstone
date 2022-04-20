<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<%--<form action="/user/search" method="get">--%>

<%--    <input type="text" placeholder="${searchValue}" name="searchId" style="display: inline-block;">--%>
<%--    <button type="submit">Submit</button>--%>

<%--</form>--%>

<%--<c:if test="${not empty searchValue}">--%>
<%--    <h4>Search Result: ${users.size()}</h4>--%>
<%--</c:if>--%>


<h1>User Roles</h1>
<%--<c:forEach items="${users}" var="user">--%>
<%--    ${user.email}<Br>--%>
<%--</c:forEach>--%>

<table class="table" >
    <tr scope="row">
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>

    </tr>
    <c:forEach items="${users}" var="user">
        <tr scope="row">
            <td>${user.userId}</td>

<%--            <td>${user.firstName}</td>--%>
        </tr>
    </c:forEach>
</table>





<jsp:include page="../include/footer.jsp" />
