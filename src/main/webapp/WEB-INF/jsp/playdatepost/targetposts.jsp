<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<section class="h-100 gradient-custom-2">
    <div class="container py-5 h-300">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-10">
                <div class="card" style="border-radius: 1rem;">

                    <div class="col-lg-10 d-flex align-items-center" style="display: block; margin: 0 auto">
                        <div class="card-body p-4 p-lg-5 text-black">


                            <div class="d-flex align-items-center mb-3 pb-1">
                                <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                <span class="h1 fw-bold mb-0"
                                      style="color: rgba(243,129,129,.9); display: block; margin:0 auto;">Explore Playdate Posts </span>
                            </div>


                            <table class="table">
                                <tr scope="row">
                                    <th style="width : 3cm">Date</th>
                                    <th>Time</th>
                                    <th>Location</th>
                                    <th>Playdate Post</th>

                                    <th></th>

                                </tr>
                                <c:forEach items="${postList}" var="post">
                                    <tr scope="row">
                                        <td>${post.playdateDate}</td>
                                        <td>${post.playdateTime}</td>
                                        <td>${post.location}</td>
                                        <td>${post.postMessage}</td>


                                        <td><a href="http://localhost:8080/playdatepost/createpost/${post.id}"
                                               onmouseover="this.style.fontWeight='bold'"
                                               onmouseout="this.style.fontWeight='normal'"
                                               style="color: rgba(243,129,129,.9);"> Attend</a></td>

                                    </tr>

                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>
<jsp:include page="../include/footer.jsp"/>