<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>

<section class="h-100 gradient-custom-2">
    <div class="container py-5 h-300">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="card" style="border-radius: 1rem;">

                <div class="col-lg-10 d-flex align-items-center" style="display: block; margin: 0 auto">
                    <div class="card-body p-4 p-lg-5 text-black">


                        <div class="d-flex align-items-center mb-3 pb-1">
                            <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                            <span class="h1 fw-bold mb-0"
                                  style="color: rgba(243,129,129,.9); display: block; margin:0 auto;">Find New Playdate Pals </span>
                        </div>


                        <div class="input-group" style="display: block; margin: 0 auto;">
                            <form name="searchForm" action="/playdatepost/search" method="get">

                                <input type="text" class="form-control rounded" placeholder="${searchValue}"
                                       name="searchId" aria-label="Search" aria-describedby="search-addon"
                                       style="margin:0 auto; display: block; text-align: center"/>
                                <br>
                                <button type="submit" class="btn btn-outline-primary "
                                        style="display: block; margin: 0 auto; ">SEARCH
                                </button>
                            </form>

                        </div>
                        <br>

                        <c:if test="${not empty searchValue}">
                            <h4>Search Result: ${playDatePosts.size()}</h4>
                        </c:if>

                        <table class="table table-striped">
                            <thead>
                            <tr>

                                <th scope="col" style="width : 1cm"></th>
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
                                    <td><a href="/user/profile/${playdateposts.userId}"
                                           onmouseover="this.style.color='#3a3939'"
                                           onmouseout="this.style.color='#e88382'" style="color:  #e88382;">View</a>
                                    </td>
                                    <td>${playdateposts.playdateDate}</td>
                                    <td>${playdateposts.playdateTime}</td>
                                    <td>${playdateposts.postMessage}</td>
                                    <td>${playdateposts.location}</td>


                                    <td>
                                        <button type="submit">
                                            <input type="hidden" name="" id="" value="">
                                            <a href="/childrenattending/willbetheres/${playdateposts.userId}"
                                               style="color: #222222"> &hearts; </a>
                                        </button>


                                    </td>

                                    <c:forEach items="${userChild}" var="userChild">

                                        <form action="/playdatepost/addchildregister" method="post">

                                            <td><input type="checkbox" checked="checked" name="playdatepost"
                                                       id="playdatepostId" value="${playdateposts.id}"
                                                       style="display: none" ;></td>
                                            <td>
                                                <button type="submit"
                                                        onmouseover="this.style.color='#3a3939'; this.style.fontWeight='bold'"
                                                        onmouseout="this.style.color='#e88382';this.style.fontWeight='normal'"
                                                        onclick="style.display = 'none'"
                                                        style="color:  #e88382;  ">
                                                    <input type="hidden" name="child" id="childId"
                                                           value="${userChild.id}">
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


<jsp:include page="../include/footer.jsp"/>