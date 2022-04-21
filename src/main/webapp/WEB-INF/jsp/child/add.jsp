<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="../include/header.jsp"/>

<section class="h-100 gradient-custom-2">
    <div class="container py-5 h-300">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-7">
                <div class="card" style="border-radius: 1rem;">

                    <div class="col-lg-10 d-flex align-items-center" style="display: block; margin: 0 auto">
                        < class="card-body p-4 p-lg-5 text-black">


                        <div class="d-flex align-items-center mb-3 pb-1">
                            <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                            <span class="h1 fw-bold mb-0"
                                  style="color: rgba(243,129,129,.9); display: block; margin:0 auto;">Add Child </span>
                        </div>


                        <form action="/child/addsubmit" method="get">


                            <div class="form-outline mb-4">

                                <input type="text" id="form2Example27" class="form-control form-control-lg"
                                       name="childFirstName" id="childFirstNamId"
                                       value="${childForm.childFirstName}" placeholder="Child First Name"/>
                                <c:forEach items='${bindingResult.getFieldErrors("childFirstName")}' var="error">
                                    <div style="color: red">${error.getDefaultMessage()}</div>
                                </c:forEach>
                            </div>

                            <div class="form-outline mb-4">
                                <%--comment--%>
                                <input type="text" id="form2Example27" class="form-control form-control-lg"
                                       type="text" name="childLastName" id="childLastNameId"
                                       value="${childForm.childLastName}" placeholder="Child Last Name"/>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="number" id="form2Example27" class="form-control form-control-lg"
                                       name="childAge" id="childAgeId" value="${childForm.childAge}"
                                       placeholder="Child Age"/>
                                <c:forEach items='${bindingResult.getFieldErrors("childAge")}' var="error">
                                    <div style="color: red">${error.getDefaultMessage()}</div>
                                </c:forEach>
                                <input type="hidden" name="user_id" value="${childForm.userId}">

                            </div>

                            <div class="form-outline mb-4">

                                <input type="text" class="form-control form-control-lg" name="image" id="imageId"
                                       value="${childForm.image}" placeholder="Optional: Insert Image Address"/>
                            </div>

                            <div class="form-outline mb-4">
                                <%--comment--%>
                                <input type="text" id="form2Example27" class="form-control form-control-lg"
                                       type="text" name="about" id="aboutId"
                                       value="${childForm.about}" placeholder="Optional: About"/>
                            </div>


                            <button class="btn btn-dark btn-lg btn-block" type="submit"
                                    style="background-color: #f38181">Add Child
                            </button>
                        
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>