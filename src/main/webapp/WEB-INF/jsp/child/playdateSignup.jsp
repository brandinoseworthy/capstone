<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />


    <h1>Child Sign Up for Play Date</h1>


<%--<br>--%>

<form action="/child/playdateSignup" method="get">--%>
        <input type="hidden" name="id" value="${form.id}" >
        Post Id <input type="number" name="post" id="postId" value="${form.playdatePostId}">
    Child Id <input type="number" name="child" id="childId" value="${form.childId}">
    </form>
<%--<form action="/child/playdateSignup" method="get">--%>
<%--    <input type="hidden" name="id" value="${form.id}" >--%>
<%--    Email <input type="email" name="email" id="emailId" value="${form.email}">--%>
<%--    <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">--%>
<%--        <div style="color: red">${error.getDefaultMessage()}</div>--%>
<%--    </c:forEach>--%>
<%--    <br>--%>
<%--    First Name <input type="text" name="firstName" id="firstNameId" value="${form.firstName}">--%>
<%--    <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">--%>
<%--        <div style="color: red">${error.getDefaultMessage()}</div>--%>
<%--    </c:forEach>--%>
<%--    <br>--%>
<%--    Last Name <input type="text" name="lastName" id="lastNameId" value="${form.lastName}">--%>
<%--    <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">--%>
<%--        <div style="color: red">${error.getDefaultMessage()}</div>--%>
<%--    </c:forEach>--%>
<%--    <br>--%>
<%--    Zip <input type="text" name="zip" id="zipId" value="${form.zip}">--%>
<%--    <c:forEach items='${bindingResult.getFieldErrors("zip")}' var="error">--%>
<%--        <div style="color: red">${error.getDefaultMessage()}</div>--%>
<%--    </c:forEach>--%>
<%--    <br>--%>
<%--    Password <input type="password" name="password" id="passwordId" >--%>
<%--    <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">--%>
<%--        <div style="color: red">${error.getDefaultMessage()}</div>--%>
<%--    </c:forEach>--%>
<%--    <br>--%>
<%--    Confirm Password <input type="password" name="confirmPassword" id="confirmPasswordId">--%>
<%--    <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">--%>
<%--        <div style="color: red">${error.getDefaultMessage()}</div>--%>
<%--    </c:forEach>--%>
<%--    <br>--%>
<%--    <br>--%>

<%--    <button type="submit"> Submit</button>--%>

<%--</form>--%>