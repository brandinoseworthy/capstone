<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<%--    <h1>Playdate Post</h1>--%>

<%--<form action="/user/createplaydatePost" method="get"  style="display: inline-block";>--%>

<%--&lt;%&ndash;    <input type="hidden" name="playdatePost" id="playdatePostId" value="${form.id}">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="hidden" name="createAt" id="createAtId" value="${form.createAt}">&ndash;%&gt;--%>
<%--    <br>--%>
<%--&lt;%&ndash;    By: <input type="number" name="userId" id="userId" value="${form.userId}" style="display: inline-block;";>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <br>&ndash;%&gt;--%>

<%--    New Playdate Post: <input type="jsonString" name="postMessage" id="postMessageId" value="${form.postMessage}" style="display: inline-block;";>--%>
<%--    <br>--%>
<%--    Location <input type="text" name="location" id="locationId" value="${form.location}" style="display: inline-block;";>--%>
<%--    <br>--%>

<%--    Date: <input type="date"  name="playdateDate" id="playdateDateId"  style="display: inline-block;";>--%>
<%--    Time:  <input type="time"  name="playdateTime" id="playdateTimeId"  style="display: inline-block;";>--%>
<%--    <br>--%>

<%--    <br>--%>
<%--    <br>--%>
<%--    <button type="submit"> Submit</button>--%>



<%--</form>--%>

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
                    <div class="col-lg-7 d-flex align-items-center" style="display: block; margin: 0 auto;" >
                        <div class="card-body p-4 p-lg-5 text-black">


                            <div class="d-flex align-items-center mb-3 pb-1">
                                <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                <span class="h1 fw-bold mb-0" style="color: rgba(243,129,129,.9); display: block; margin: 0 auto;" > <c:if test="${empty form.id}">
                                    Create Playdate Post
                                </c:if>

                                 <c:if test="${not empty form.id}">
                                     Update Playdate Post
                                 </c:if>  </span>
                            </div>


                            <form action="/user/createplaydatePost" method="get"  style="display: block; margin: auto";>


                                <%--    <input type="hidden" name="playdatePost" id="playdatePostId" value="${form.id}">--%>
                                <%--    <input type="hidden" name="createAt" id="createAtId" value="${form.createAt}">--%>
                                <br>
                                <%--    By: <input type="number" name="userId" id="userId" value="${form.userId}" style="display: inline-block;";>--%>
                                <%--    <br>--%>





<%--                                New Playdate Post: <input type="jsonString" name="postMessage" id="postMessageId" value="${form.postMessage}" style="display: inline-block;";>--%>

                                    <div class="form-outline mb-4">
                                        <%--
                                                                              Username : <input type="text" name="username">--%>
                                            <input type="hidden" name="id" id="id" value="${form.id}">
                                            <label class="form-label" for="form2Example17" >Playdate Post ${form.id}</label>
                                            <input type="jsonString" id="form2Example17" class="form-control form-control-lg" name="postMessage" id="postMessageId"  value="${form.postMessage}"style="display: inline-block;";/>
                                            <c:forEach items='${bindingResult.getFieldErrors("postMessage")}' var="error">
                                                <div style="color: red">${error.getDefaultMessage()}</div>
                                            </c:forEach>
                                    </div>
                                <br>
<%--                                Location <input type="text" name="location" id="locationId" value="${form.location}" style="display: inline-block;";>--%>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example17">Location</label>
                                        <input type="text" class="form-control form-control-lg" name="location" id="locationId" value="${form.location}" style="display: inline-block;";/>
                                        <c:forEach items='${bindingResult.getFieldErrors("location")}' var="error">
                                            <div style="color: red">${error.getDefaultMessage()}</div>
                                        </c:forEach>

                                    </div>
                                <br>

<%--                                Date: <input type="date"  name="playdateDate" id="playdateDateId"  style="display: inline-block;";>--%>
<%--                                    <c:if test="${empty form.id}">--%>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example17">Date</label>
                                            <input type="date" class="form-control form-control-lg" name="playdateDate" id="playdateDateId" style="display: inline-block;";/>
                                    </div>
<%--                                    </c:if>--%>
<%--                                Time:  <input type="time"  name="playdateTime" id="playdateTimeId"  style="display: inline-block;";>--%>

<%--                                    <c:if test="${empty form.id}">--%>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example17">Time</label>
                                            <input type="time" class="form-control form-control-lg"name="playdateTime" id="playdateTimeId" style="display: inline-block;";/>
                                    </div>
<%--                                    </c:if>--%>
                                <br>


                                    <div class="pt-1 mb-4">
                                        <%--                                        <button type="submit"> Submit </button>--%>
                                        <button class="btn btn-dark btn-lg btn-block" type="submit" style="background-color: #f38181">Submit</button>
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
