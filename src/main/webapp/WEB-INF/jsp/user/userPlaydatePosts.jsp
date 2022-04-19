<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1>User Play Date Posts</h1>


<%--<form action="/user/userPlaydatePosts/" method="get">--%>

<%--    <input type="number" placeholder="${user_id}" name="user_id">--%>
<%--    <button type="submit">Submit</button>--%>

<%--</form>--%>

<%--<c:if test="${not empty user_id}">--%>
<%--    <h4>User Posts: ${postList.size()}</h4>--%>
<%--</c:if>--%>



<%--<c:forEach items="${postList}" var="post">--%>
<%--    ${post.id}<Br>--%>
<%--</c:forEach>--%>



<table class="table">
    <tr scope="row">
        <th>Created At</th>
        <th>Playdate Post</th>
        <th>Location</th>
        <th>Date</th>
        <th>Time</th>

    </tr>
    <c:forEach items="${postList}" var="post">
        <tr scope="row">
            <td >${post.createAt}</td>
            <td>${post.postMessage}</td>
            <td>${post.location}</td>
            <td>${post.playdateDate}</td>
            <td>${post.playdateTime}</td>
            <td><a href="http://localhost:8080/user/createplaydatePost/${post.id}"> Edit</a> </td>

        </tr>
    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp" />
<jsp:include page="../include/footer.jsp" />