<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="../include/header.jsp" />

<%--<h1>Add Child</h1>--%>


<%--<form  action="/user/addChildSubmit" method="get">--%>


<%--    &lt;%&ndash;                                    <h5 class="fw-bold mb-0 pb-3" style="letter-spacing: 1px; ">Add Child</h5>&ndash;%&gt;--%>

<%--                                        <div class="form-outline mb-4">--%>

<%--                                            &lt;%&ndash;                                        Child First Name <input type="text" name="childFirstName" id="childFirstNamId" value="${childForm.childFirstName}">&ndash;%&gt;--%>
<%--                                            <input type="text" id="form2Example27" class="form-control form-control-lg" name="childFirstName" id="childFirstNamId" value="${childForm.childFirstName}" placeholder="Child First Name"/>--%>
<%--                                            &lt;%&ndash;                                        <label class="form-label" for="form2Example27">Child First Name</label>&ndash;%&gt;--%>
<%--                                            <c:forEach items='${bindingResult.getFieldErrors("childFirstName")}' var="error">--%>
<%--                                                <div style="color: red">${error.getDefaultMessage()}</div>--%>
<%--                                            </c:forEach>--%>
<%--                                        </div>--%>

<%--                                        <div class="form-outline mb-4">--%>

<%--                                            &lt;%&ndash;                                        Child Last Name <input type="text" name="childLastName" id="childLastNameId" value="${childForm.childLastName}">&ndash;%&gt;--%>
<%--                                            <input type="text" id="form2Example27" class="form-control form-control-lg" type="text" name="childLastName" id="childLastNameId" value="${childForm.childLastName}" placeholder="Child Last Name"/>--%>
<%--                                            &lt;%&ndash;                                        <label class="form-label" for="form2Example27">Child Last Name</label>&ndash;%&gt;--%>
<%--                                        </div>--%>

<%--                                        <div class="form-outline mb-4">--%>
<%--                                            &lt;%&ndash;                                        Child Age <input type="number" name="childAge" id="childAgeId" value="${childForm.childAge}">&ndash;%&gt;--%>
<%--                                            <input type="number" id="form2Example27" class="form-control form-control-lg" name="childAge" id="childAgeId" value="${childForm.childAge}" placeholder="Child Age"/>--%>
<%--                                            &lt;%&ndash;                                        <label class="form-label" for="form2Example27">Child Age</label>&ndash;%&gt;--%>

<%--                                            <input type="hidden" name="user_id" value="${childForm.userId}" >--%>

<%--                                        </div>--%>

<%--&lt;%&ndash;                                        <div class="form-outline mb-4">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            &lt;%&ndash;                                        Child Age <input type="number" name="childAge" id="childAgeId" value="${childForm.childAge}">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            <input type="email" id="form2Example27" class="form-control form-control-lg" name="userEmail" id="userEmailId" value="${childForm.userEmail}" placeholder="Confirm Email"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            &lt;%&ndash;                                        <label class="form-label" for="form2Example27">Child Age</label>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            <c:forEach items='${bindingResultChild.getFieldErrors("userEmail")}' var="error">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                <div style="color: red">${error.getDefaultMessage()}</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            </c:forEach>&ndash;%&gt;--%>

<%--&lt;%&ndash;                                            <input type="hidden" name="user_id" value="${childForm.userId}" >&ndash;%&gt;--%>

<%--&lt;%&ndash;                                        </div>&ndash;%&gt;--%>

<%--                                        <button class="btn btn-dark btn-lg btn-block" type="submit" style="background-color: #f38181">Add Child</button>--%>
<%--                                        </div>--%>
<%--</form>--%>



<%--*****--%>



<section  class="clear" style="background-color: #9A616D; clear: both">
    <div class="container py-5 h-300">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-7">
                <div class="card" style="border-radius: 1rem;">
<%--                                        <div class="row g-0">--%>
<%--                    &lt;%&ndash;                        <div class="col-lg-5 d-none d-md-block">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                            <img src="https://images.pexels.com/photos/7869833/pexels-photo-7869833.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                 alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; " />&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        </div>&ndash;%&gt;--%>
                    <div class="col-lg-10 d-flex align-items-center" style="display: block; margin: 0 auto">
                        <div class="card-body p-4 p-lg-5 text-black">


                            <div class="d-flex align-items-center mb-3 pb-1">
                                <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                <span class="h1 fw-bold mb-0" style="color: rgba(243,129,129,.9); display: block; margin:0 auto;">Add Child </span>
                            </div>


                            <form  action="/user/addChildSubmit" method="get">


                                <%--                                    <h5 class="fw-bold mb-0 pb-3" style="letter-spacing: 1px; ">Add Child</h5>--%>

                                <div class="form-outline mb-4">

                                    <%--                                        Child First Name <input type="text" name="childFirstName" id="childFirstNamId" value="${childForm.childFirstName}">--%>
                                    <input type="text" id="form2Example27" class="form-control form-control-lg" name="childFirstName" id="childFirstNamId" value="${childForm.childFirstName}" placeholder="Child First Name"/>
                                    <%--                                        <label class="form-label" for="form2Example27">Child First Name</label>--%>
                                    <c:forEach items='${bindingResult.getFieldErrors("childFirstName")}' var="error">
                                        <div style="color: red">${error.getDefaultMessage()}</div>
                                    </c:forEach>
                                </div>

                                <div class="form-outline mb-4">

                                    <%--                                        Child Last Name <input type="text" name="childLastName" id="childLastNameId" value="${childForm.childLastName}">--%>
                                    <input type="text" id="form2Example27" class="form-control form-control-lg" type="text" name="childLastName" id="childLastNameId" value="${childForm.childLastName}" placeholder="Child Last Name"/>
                                    <%--                                        <label class="form-label" for="form2Example27">Child Last Name</label>--%>
                                </div>

                                <div class="form-outline mb-4">
                                    <%--                                        Child Age <input type="number" name="childAge" id="childAgeId" value="${childForm.childAge}">--%>
                                    <input type="number" id="form2Example27" class="form-control form-control-lg" name="childAge" id="childAgeId" value="${childForm.childAge}" placeholder="Child Age"/>
                                    <%--                                        <label class="form-label" for="form2Example27">Child Age</label>--%>
                                        <c:forEach items='${bindingResult.getFieldErrors("childAge")}' var="error">
                                            <div style="color: red">${error.getDefaultMessage()}</div>
                                        </c:forEach>
                                    <input type="hidden" name="user_id" value="${childForm.userId}" >

                                </div>



                                <button class="btn btn-dark btn-lg btn-block" type="submit" style="background-color: #f38181">Add Child</button>
                        </div>
                        </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />