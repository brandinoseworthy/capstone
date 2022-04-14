<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="../include/header.jsp" />

<h1>Add Child</h1>


<form  action="/user/addChildSubmit" method="get">

    COMMENTED OUT CHILD--%>
    <%--                                    <h5 class="fw-bold mb-0 pb-3" style="letter-spacing: 1px; ">Add Child</h5>--%>

                                        <div class="form-outline mb-4">

                                            <%--                                        Child First Name <input type="text" name="childFirstName" id="childFirstNamId" value="${childForm.childFirstName}">--%>
                                            <input type="text" id="form2Example27" class="form-control form-control-lg" name="childFirstName" id="childFirstNamId" value="${childForm.childFirstName}" placeholder="Child First Name"/>
                                            <%--                                        <label class="form-label" for="form2Example27">Child First Name</label>--%>
                                            <c:forEach items='${bindingResultChild.getFieldErrors("childFirstName")}' var="error">
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
                                            <c:forEach items='${bindingResultChild.getFieldErrors("childAge")}' var="error">
                                                <div style="color: red">${error.getDefaultMessage()}</div>
                                            </c:forEach>

                                            <input type="hidden" name="user_id" value="${childForm.userId}" >

                                        </div>

                                        <div class="form-outline mb-4">
                                            <%--                                        Child Age <input type="number" name="childAge" id="childAgeId" value="${childForm.childAge}">--%>
                                            <input type="email" id="form2Example27" class="form-control form-control-lg" name="userEmail" id="userEmailId" value="${childForm.userEmail}" placeholder="Confirm Email"/>
                                            <%--                                        <label class="form-label" for="form2Example27">Child Age</label>--%>
                                            <c:forEach items='${bindingResultChild.getFieldErrors("userEmail")}' var="error">
                                                <div style="color: red">${error.getDefaultMessage()}</div>
                                            </c:forEach>

                                            <input type="hidden" name="user_id" value="${childForm.userId}" >

                                        </div>

                                        <button class="btn btn-dark btn-lg btn-block" type="submit" style="background-color: #f38181">Add Child</button>
                                        </div>
</form>




<jsp:include page="../include/footer.jsp" />