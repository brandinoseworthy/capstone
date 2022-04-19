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






<div class="input-group" style="display: block; margin: 0 auto;">
    <form name="searchForm" action="/user/searchforplaydate" method="get">

    <input type="text" class="form-control rounded" placeholder="${searchValue}"  name="searchId"  aria-label="Search" aria-describedby="search-addon" style="margin:0 auto; display: block; text-align: center"/>
    <button type="submit" class="btn btn-outline-primary " style="display: block; margin: 0 auto; ">SEARCH</button>
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

        <th scope="col">Playdate Post</th>
        <th scope="col">Location</th>
        <th scope="col">Date</th>
        <th scope="col">Time</th>
        <th colspan="2" style="text-align:center;">Sign Up</th>
        <th colspan="2">Already Going</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${playDatePosts}" var="playdateposts">
        <tr scope="row">
            <td>${playdateposts.postMessage}</td>
            <td>${playdateposts.location}</td>
            <td>${playdateposts.playdateDate}</td>
            <td>${playdateposts.playdateTime}</td>

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
            <td>  <button type="submit" >
                <input type="hidden" name="" id="" value="" >
                Will Be Theres
            </button></td>

        </tr>

    </c:forEach>







    </tbody>
</table>


<jsp:include page="../include/footer.jsp" />