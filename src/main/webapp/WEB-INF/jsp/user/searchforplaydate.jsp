<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp" />

<form action="/user/searchforplaydate" method="get">

    <input type="text" placeholder="${searchValue}" name="searchId" style="display: inline-block;">
    <button type="submit">Submit</button>

</form>

<c:if test="${not empty searchValue}">
    <h4>Search Result: ${playDatePosts.size()}</h4>
</c:if>




<table class="table">
    <tr scope="row">

        <th>Playdate Post</th>
        <th>Location</th>
        <th>Date</th>
        <th>Time</th>

    </tr>
    <c:forEach items="${playDatePosts}" var="playdateposts">
        <tr scope="row">
            <td>${playdateposts.postMessage}</td>
            <td>${playdateposts.location}</td>
            <td>${playdateposts.playdateDate}</td>
            <td>${playdateposts.playdateTime}</td>
            <td><button type="submit">Register Child</button> </td>
        </tr>

    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp" />
