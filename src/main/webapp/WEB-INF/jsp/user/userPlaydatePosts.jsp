<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<%--<h1>User Play Date Posts</h1>--%>


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



<%--<table class="table">--%>
<%--    <tr scope="row">--%>
<%--        <th>Created At</th>--%>
<%--        <th>Playdate Post</th>--%>
<%--        <th>Location</th>--%>
<%--        <th>Date</th>--%>
<%--        <th>Time</th>--%>

<%--    </tr>--%>
<%--    <c:forEach items="${postList}" var="post">--%>
<%--        <tr scope="row">--%>
<%--            <td >${post.createAt}</td>--%>
<%--            <td>${post.postMessage}</td>--%>
<%--            <td>${post.location}</td>--%>
<%--            <td>${post.playdateDate}</td>--%>
<%--            <td>${post.playdateTime}</td>--%>
<%--            <td><a href="http://localhost:8080/user/createplaydatePost/${post.id}"> Edit</a> </td>--%>

<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>








<section  class="clear" style="background-color: #9A616D; clear: both">
    <div class="container py-5 h-300">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-10">
                <div class="card" style="border-radius: 1rem;">
<%--                    <div class="row g-0">--%>
<%--                        <div class="col-lg-5 d-none d-md-block">--%>
<%--                            <img src="https://images.pexels.com/photos/7869833/pexels-photo-7869833.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"--%>
<%--                                 alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; " />--%>
<%--                        </div>--%>
                        <div class="col-lg-10 d-flex align-items-center" style="display: block; margin: 0 auto">
                            <div class="card-body p-4 p-lg-5 text-black">


                                <div class="d-flex align-items-center mb-3 pb-1">
                                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                    <span class="h1 fw-bold mb-0" style="color: rgba(243,129,129,.9); display: block; margin:0 auto;">My Playdate Posts </span>
                                </div>


                                <table class="table" >
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
                                            <td><a href="http://localhost:8080/user/createplaydatePost/${post.id}" style="color: rgba(243,129,129,.9);"> Edit</a> </td>

                                        </tr>
                                    </c:forEach>
                                </table>
                                <form action="/login/loginSubmit" method="post">
<%--                            </div>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>




















<jsp:include page="../include/footer.jsp" />
<jsp:include page="../include/footer.jsp" />