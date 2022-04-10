<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<c:if test="${empty form.id}">
    <h1>Sign Up</h1>
</c:if>

<c:if test="${not empty form.id}">
    <h1>Edit User</h1>
</c:if>

<form action="/user/registerSubmit" method="get">
    <input type="hidden" name="id" value="${form.id}" >
    Email <input type="email" name="email" id="emailId" value="${form.email}">
    <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
        <div style="color: red">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    First Name <input type="text" name="firstName" id="firstNameId" value="${form.firstName}">
    <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
        <div style="color: red">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Last Name <input type="text" name="lastName" id="lastNameId" value="${form.lastName}">
    <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
        <div style="color: red">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Zip <input type="text" name="zip" id="zipId" value="${form.zip}">
    <c:forEach items='${bindingResult.getFieldErrors("zip")}' var="error">
        <div style="color: red">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Password <input type="password" name="password" id="passwordId" >
    <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
        <div style="color: red">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Confirm Password <input type="password" name="confirmPassword" id="confirmPasswordId">
    <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
        <div style="color: red">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    <br>



    <br>
    Child First Name <input type="text" name="childFirstName" id="childFirstNamId" value="${childForm.childFirstName}">
    <br>
    Child Last Name <input type="text" name="childLastName" id="childLastNameId" value="${childForm.childLastName}">
    <br>
    Child Age <input type="number" name="childAge" id="childAgeId" value="${childForm.childAge}">
    <br>
    <input type="hidden" name="user_id" value="${childForm.userId}" >
    <br>
    <br>




    Optional:
    <br>
    Quick Description <input type="text" name="description" id="descriptionId" value="${form.description}">

    <br>
    Favorite Play Date Location(s) <input type="text" name="favoritePlaceForPlaydates" id="favoritePlaceForPlayDatesId" value="${form.favoritePlaceForPlaydates}">
    <br>
    Check Box <input type="checkbox" name="checkbox">
    <c:forEach items='${bindingResult.getFieldErrors("checkbox")}' var="error">
        <div style="color: red">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    <br>
    <button type="submit"> Submit</button>

</form>







<jsp:include page="../include/footer.jsp" />
