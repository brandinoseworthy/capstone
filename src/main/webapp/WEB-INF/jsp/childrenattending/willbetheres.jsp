<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp" />


<%--Not working yet--%>
<h1> WILL BE THERE </h1>

<table class="table" >
    <tr scope="row">
        <th>Child Id</th>
        <th>First Name</th>
        <th>Last Name</th>

    </tr>
    <c:forEach items="${childAttendings}" var="childAttendings">
        <tr scope="row">
            <td>${childAttendings.childAttending}</td>
                <%--            <td>${user.firstName}</td>--%>
        </tr>
    </c:forEach>
</table>



<jsp:include page="../include/footer.jsp" />
