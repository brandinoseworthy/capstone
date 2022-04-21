<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>


<section class="h-100 gradient-custom-2">
    <div class="container py-5 h-300">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="card" style="border-radius: 1rem;">

                <div class="col-lg-10 d-flex align-items-center" style="display: block; margin: 0 auto;">
                    <div class="card-body p-4 p-lg-5 text-black">


                        <div class="d-flex align-items-center mb-3 pb-1">
                            <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                            <span class="h1 fw-bold mb-0"
                                  style="color: rgba(243,129,129,.9); display: block; margin:0 auto;">We hope to have a playdate soon! </span>
                        </div>

                        <div class="row">
                            <c:forEach items="${children}" var="child">
                                <div class="col-md-4" style="display: block; margin: 0 auto;">
                                    <br>
                                    <div class="card" style="height: 100%;">
                                        <img src="${child.image}" class="card-img-top" alt="..."
                                             style="height: 380px; object-fit: cover;">

                                        <div class="card-body">
                                            <h5 class="card-title"
                                                style="text-align: center"> ${child.firstName} ${child.lastName}   </h5>
                                            <p class="card-text" style="text-align: center">Age: ${child.age}</p>
                                            <p class="card-text">${child.about}</p>

                                        </div>


                                    </div>

                                </div>
                            </c:forEach>
                            <div class="row"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>