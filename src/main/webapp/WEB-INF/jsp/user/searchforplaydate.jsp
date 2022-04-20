<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<%--<jsp:include page="../include/header.jsp" />--%>

<%--<form action="/user/searchforplaydate" method="get">--%>

<%--    <input type="text" placeholder="${searchValue}" name="searchId" style="display: inline-block;">--%>
<%--    <button type="submit">Submit</button>--%>

<%--</form>--%>

<%--<c:if test="${not empty searchValue}">--%>
<%--    <h4>Search Result: ${playDatePosts.size()}</h4>--%>
<%--</c:if>--%>




<%--<table class="table">--%>
<%--    <tr scope="row">--%>

<%--        <th>Playdate Post</th>--%>
<%--        <th>Location</th>--%>
<%--        <th>Date</th>--%>
<%--        <th>Time</th>--%>
<%--        <th>Playdate</th>--%>
<%--        <th colspan="2" >Who would like to go?</th>--%>

<%--        <th>See Who's Going</th>--%>
<%--&lt;%&ndash;        <th>userId</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th>postId</th>&ndash;%&gt;--%>

<%--    </tr>--%>
<%--    <c:forEach items="${playDatePosts}" var="playdateposts">--%>
<%--        <tr scope="row">--%>

<%--            <td><input type="hidden" name="postMessage">${playdateposts.postMessage}</td>--%>
<%--            <td>${playdateposts.location}</td>--%>
<%--            <td>${playdateposts.playdateDate}</td>--%>
<%--            <td>${playdateposts.playdateTime}</td>--%>
<%--            <form action="/user/playdateSearchRegisterChild" method="get">--%>
<%--            <td><input  type="radio"  id="playdatepostId"value="${playdateposts.id}" ></td>--%>
<%--&lt;%&ndash;            <td>${playdateposts.userId}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>${playdateposts.id}</td>&ndash;%&gt;--%>
<%--            </form>--%>

<%--            <br>--%>

<%--                <c:forEach items="${userChild}" var="userChild">--%>
<%--            <form action="/user/playdateSearchRegisterChild" method="get">--%>
<%--            <td><button type="submit" name="addChildToPlaydatePost" >--%>
<%--                form--%>
<%--                <input type="hidden" name="childId" value="${userChild.id}" >--%>
<%--                    ${userChild.firstName}  </button> </td>--%>
<%--                    &lt;%&ndash;            <tr scope="row">&ndash;%&gt;--%>

<%--                    &lt;%&ndash;                <td>${userChild.firstName}</td>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <td>${userChild.lastName}</td>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <td>${userChild.age}</td>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;--%>
<%--                            </tr>&ndash;%&gt;--%>
<%--            </form>--%>
<%--                </c:forEach>--%>




<%--        <td><button type="submit" onclick=location.href="childrenattending/willbetheres"> Will Be Theres</button> </td>--%>




<%--    </c:forEach>--%>
<%--</table>--%>


<%--<jsp:include page="../include/footer.jsp" />--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp" />

<%--<form name="searchForm" action="/user/searchforplaydate" method="get">--%>

<%--    <input type="text" placeholder="${searchValue}" name="searchId" style="display: inline-block;">--%>
<%--    <button type="submit">Submit</button>--%>

<%--</form>--%>

<%--<c:if test="${not empty searchValue}">--%>
<%--    <h4>Search Result: ${playDatePosts.size()}</h4>--%>
<%--</c:if>--%>




<%--<table class="table">--%>
<%--    <tr scope="row">--%>

<%--        <th>Playdate Post</th>--%>
<%--        <th>Location</th>--%>
<%--        <th>Date</th>--%>
<%--        <th>Time</th>--%>
<%--        <th colspan="4" style="text-align:center;">Who's Going?</th>--%>


<%--    </tr>--%>
<%--    <c:forEach items="${playDatePosts}" var="playdateposts">--%>
<%--        <tr scope="row">--%>
<%--            <td>${playdateposts.postMessage}</td>--%>
<%--            <td>${playdateposts.location}</td>--%>
<%--            <td>${playdateposts.playdateDate}</td>--%>
<%--            <td>${playdateposts.playdateTime}</td>--%>

<%--            <c:forEach items="${userChild}" var="userChild">--%>
<%--            <form  action="/user/playdateSearchRegisterChild" method="post">--%>

<%--                <td><input  type="checkbox"   name="playdatepost" id="playdatepostId"value="${playdateposts.id}" ></td>--%>
<%--                <td>--%>
<%--                        <button type="submit" >--%>
<%--                            <input type="hidden" name="child" id="childId" value="${userChild.id}" >--%>
<%--                            ${userChild.firstName}--%>
<%--                        </button>--%>
<%--                </td>--%>
<%--            </form>--%>
<%--            </c:forEach>--%>
<%--            <td>  <button type="submit" >--%>
<%--                <input type="hidden" name="" id="" value="" >--%>
<%--                    Will Be Theres--%>
<%--            </button></td>--%>

<%--        </tr>--%>

<%--    </c:forEach>--%>
<%--</table>--%>




<%--     **********************************                     --%>






<%--<div class="input-group" style="display: block; margin: 0 auto;">--%>
<%--    <form name="searchForm" action="/user/searchforplaydate" method="get">--%>

<%--    <input type="text" class="form-control rounded" placeholder="${searchValue}"  name="searchId"  aria-label="Search" aria-describedby="search-addon" style="margin:0 auto; display: block; text-align: center"/>--%>
<%--    <button type="submit" class="btn btn-outline-primary " style="display: block; margin: 0 auto; ">SEARCH</button>--%>
<%--    </form>--%>

<%--</div>--%>
<%--<br>--%>

<%--<c:if test="${not empty searchValue}">--%>
<%--    <h4>Search Result: ${playDatePosts.size()}</h4>--%>
<%--</c:if>--%>

<%--<table class="table table-striped">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--&lt;%&ndash;        <th scope="col">#</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="col">First</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="col">Last</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="col">Handle</th>&ndash;%&gt;--%>

<%--        <th scope="col">Playdate Post</th>--%>
<%--        <th scope="col">Location</th>--%>
<%--        <th scope="col">Date</th>--%>
<%--        <th scope="col">Time</th>--%>
<%--        <th colspan="2" style="text-align:center;">Sign Up</th>--%>
<%--        <th colspan="2">Already Going</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>

<%--    <c:forEach items="${playDatePosts}" var="playdateposts">--%>
<%--        <tr scope="row">--%>
<%--            <td>${playdateposts.postMessage}</td>--%>
<%--            <td>${playdateposts.location}</td>--%>
<%--            <td>${playdateposts.playdateDate}</td>--%>
<%--            <td>${playdateposts.playdateTime}</td>--%>

<%--            <c:forEach items="${userChild}" var="userChild">--%>
<%--                <form  action="/user/playdateSearchRegisterChild" method="post">--%>

<%--                    <td><input  type="checkbox"   name="playdatepost" id="playdatepostId"value="${playdateposts.id}" ></td>--%>
<%--                    <td>--%>
<%--                        <button type="submit" >--%>
<%--                            <input type="hidden" name="child" id="childId" value="${userChild.id}" >--%>
<%--                                ${userChild.firstName}--%>
<%--                        </button>--%>
<%--                    </td>--%>
<%--                </form>--%>
<%--            </c:forEach>--%>
<%--            <td>  <button type="submit" >--%>
<%--                <input type="hidden" name="" id="" value="" >--%>
<%--                Will Be Theres--%>
<%--            </button></td>--%>

<%--        </tr>--%>

<%--    </c:forEach>--%>


<%--    </tbody>--%>
<%--</table>--%>









<%--*******************************--%>

<section  class="clear" style="background-color: #9A616D; clear: both">
    <div class="container py-5 h-300">
        <div class="row d-flex justify-content-center align-items-center h-100">
<%--            <div >class="col-xl-12"--%>
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
                                <span class="h1 fw-bold mb-0" style="color: rgba(243,129,129,.9); display: block; margin:0 auto;">Find New Playdate Pals </span>
                            </div>


                            <div class="input-group" style="display: block; margin: 0 auto;">
                                <form name="searchForm" action="/user/searchforplaydate" method="get">

                                    <input type="text" class="form-control rounded" placeholder="${searchValue}"  name="searchId"  aria-label="Search" aria-describedby="search-addon" style="margin:0 auto; display: block; text-align: center"/>
                                    <br>
                                    <button type="submit" class="btn btn-outline-primary " style="display: block; margin: 0 auto; " >SEARCH</button>
                                </form>

                            </div>
                            <br>



                            <c:if test="${not empty searchValue}">
                                <h4>Search Result: ${playDatePosts.size()}</h4>
                            </c:if>

                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <%--        <th scope="col">#</th>--%>
                                    <%--        <th scope="col">First</th>--%>
                                    <%--        <th scope="col">Last</th>--%>
                                    <%--        <th scope="col">Handle</th>--%>
                                    <th scope="col" style="width : 1cm"> </th>
                                    <th scope="col" style="width : 3cm">Date</th>
                                    <th scope="col">Time</th>
                                    <th scope="col" style="width : 5cm">Playdate Post</th>
                                    <th scope="col" style="width : 4cm">Location</th>


                                    <th scope="col" style="text-align:right;"></th>
                                    <th colspan=100% style="text-align:right;"> Let's take...</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${playDatePosts}" var="playdateposts">
                                    <tr scope="row">
                                        <td><a href="/user/profile/${playdateposts.userId}">View</a>  </td>
                                        <td>${playdateposts.playdateDate}</td>
                                        <td>${playdateposts.playdateTime}</td>
                                        <td>${playdateposts.postMessage}</td>
                                        <td>${playdateposts.location}</td>



                                        <td>  <button type="submit" >
                                            <input type="hidden" name="" id="" value="" >
                                            &hearts;
                                        </button></td>

                                        <c:forEach items="${userChild}" var="userChild">

                                            <form  action="/user/playdateSearchRegisterChild" method="post">

                                                <td><input  type="checkbox"   name="playdatepost" id="playdatepostId"value="${playdateposts.id}" ></td>
                                                <td>
                                                    <button type="submit" >
                                                        <input type="hidden" name="child" id="childId" value="${userChild.id}" >
                                                            ${userChild.firstName}
                                                    </button>
                                                </td>
                                            </form>
                                        </c:forEach>


                                    </tr>

                                </c:forEach>


                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>







<jsp:include page="../include/footer.jsp" />