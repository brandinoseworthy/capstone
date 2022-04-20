<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>


<%--<c:forEach items="${user}" var="user">--%>
<%--    ${child.userId}<Br>--%>
<%--</c:forEach>--%>

<%--<table class="table">--%>
<%--    <tr scope="row">--%>

<%--        <th>First Name</th>--%>
<%--        <th>Last Name</th>--%>
<%--        <th>Age</th>--%>
<%--    </tr>--%>
<%--    <c:forEach items="${children}" var="child">--%>
<%--        <tr scope="row">--%>

<%--            <td>${child.firstName}</td>--%>

<%--            <td>${child.lastName}</td>--%>

<%--            <td>${child.age}</td>--%>

<%--            <td>--%>
<%--                <form action="/user/removeChild" method="post">--%>
<%--                    <button type="submit">--%>
<%--                        <input type="hidden" name="childId" id="childId" value="${child.id}">--%>
<%--                        Remove--%>
<%--                    </button>--%>
<%--                </form>--%>

<%--            </td>--%>

<%--        </tr>--%>


<%--    </c:forEach>--%>
<%--</table>--%>

<%--<div class="row">--%>
<%--<c:forEach items="${children}" var="child">--%>
<%--    <div class="col-md-4">--%>
<%--        <br>--%>
<%--        <div class="card" style="width: 18rem;">--%>
<%--            <img src="${child.image}" class="card-img-top" alt="...">--%>

<%--            <div class="card-body">--%>
<%--                <h5 class="card-title"> ${child.firstName} ${child.lastName} - ${child.age} </h5>--%>
<%--                <p class="card-text">${child.lastName}</p>--%>
<%--                    &lt;%&ndash;        <a href="#" class="btn btn-primary">Go somewhere</a>&ndash;%&gt;--%>
<%--                <form action="/user/removeChild" method="post">--%>
<%--                    <button type="submit">--%>
<%--                        <input type="hidden" name="childId" id="childId" value="${child.id}">--%>
<%--                        Remove--%>
<%--                    </button>--%>
<%--                </form>--%>
<%--            </div>--%>


<%--        </div>--%>

<%--    </div>--%>
<%--</c:forEach>--%>
<%--<div class="row"></div>--%>












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
                    <div class="col-lg-10 d-flex align-items-center" style="display: block; margin: 0 auto;">
                        <div class="card-body p-4 p-lg-5 text-black">


                            <div class="d-flex align-items-center mb-3 pb-1">
                                <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                <span class="h1 fw-bold mb-0" style="color: rgba(243,129,129,.9); display: block; margin:0 auto;">My Children </span>
                            </div>




                            <div class="row" >
                                <c:forEach items="${children}" var="child">
                                    <div class="col-md-4"  style="display: block; margin: 0 auto;">
                                        <br>
                                        <div class="card" style="height: 100%;">
                                            <img src="${child.image}" class="card-img-top" alt="..." style="height: 380px; object-fit: cover;">

                                            <div class="card-body">
                                                <h5 class="card-title"  style="text-align: center"> ${child.firstName} ${child.lastName}   </h5>
                                                <p class="card-text" style="text-align: center">Age: ${child.age}</p>
                                                <p class="card-text">${child.lastName}</p>
                                                    <%--        <a href="#" class="btn btn-primary">Go somewhere</a>--%>


                                                
                                                <form action="/user/removeChild" method="post">
                                                    <button type="submit">
                                                        <input type="hidden" name="childId" id="childId" value="${child.id}">
                                                        Remove
                                                    </button>
                                                </form>
                                            </div>


                                        </div>

                                    </div>
                                </c:forEach>
                                <div class="row"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
</section>




<jsp:include page="../include/footer.jsp"/>