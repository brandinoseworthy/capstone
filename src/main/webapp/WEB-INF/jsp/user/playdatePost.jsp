<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

    <h1>Playdate Post</h1>

<form action="/user/createplaydatePost" method="get"  style="display: inline-block";>

<%--    <input type="hidden" name="playdatePost" id="playdatePostId" value="${form.id}">--%>
<%--    <input type="hidden" name="createAt" id="createAtId" value="${form.createAt}">--%>
    <br>
    By: <input type="number" name="userId" id="userId" value="${form.userId}" style="display: inline-block;";>
    <br>
    New Playdate Post: <input type="jsonString" name="postMessage" id="postMessageId" value="${form.postMessage}" style="display: inline-block;";>
    <br>
    Location <input type="text" name="location" id="locationId" value="${form.location}" style="display: inline-block;";>
    <br>
    <br>

    <br>
    <br>
    <button type="submit"> Submit</button>

</form>










<jsp:include page="../include/footer.jsp" />
