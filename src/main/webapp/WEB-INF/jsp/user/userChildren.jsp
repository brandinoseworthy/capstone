<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />


<c:forEach items="${user}" var="user">
    ${child.userId}<Br>
</c:forEach>

<table class="table">
    <tr scope="row">

        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
    </tr>
    <c:forEach items="${children}" var="child">
        <tr scope="row">

            <td>${child.firstName}</td>
            <td>${child.lastName}</td>
            <td>${child.age}</td>
        </tr>
    </c:forEach>
</table>





<jsp:include page="../include/footer.jsp" />