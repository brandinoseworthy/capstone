<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<h1>User Roles</h1>

<table class="table">
    <tr scope="row">
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>

    </tr>
    <c:forEach items="${users}" var="user">
        <tr scope="row">
            <td>${user.userId}</td>

        </tr>
    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp"/>
