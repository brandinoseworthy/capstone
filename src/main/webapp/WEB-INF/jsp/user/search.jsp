<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<form action="/user/search" method="get">

    <input type="text" placeholder="${searchValue}" name="searchId" style="display: inline-block;">
    <button type="submit">Submit</button>

</form>

<c:if test="${not empty searchValue}">
    <h4>Search Result: ${users.size()}</h4>
</c:if>



<c:forEach items="${users}" var="user">
    ${user.email}<Br>
</c:forEach>

<table class="table">
    <tr scope="row">
        <th>Email</th>
        <th>First Name</th>
        <th>Last Name</th>

    </tr>
    <c:forEach items="${users}" var="user">
        <tr scope="row">
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.lastName}</td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp" />
