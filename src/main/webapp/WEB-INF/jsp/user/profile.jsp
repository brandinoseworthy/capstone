<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <%--    <link href="<c:url value="../../../pub/css/header.css" />" rel="stylesheet">--%>
    <%--    <link href="<c:url value="../../../pub/css/profile.css" />" rel="stylesheet">--%>

    <%----%>
    <title>Sample Project</title>

    <link href="<c:url value="../../../pub/css/profile.css" />" rel="stylesheet">
</head>

<body>

<%--<div class="container">--%>
<%--    <a href="/index">Index</a> &nbsp; | &nbsp;--%>
<%--    <a href="/login/register">Sign Up</a> &nbsp;| &nbsp;--%>
<%--    <a href="/user/search">Search</a> &nbsp;| &nbsp;&nbsp;--%>
<%--    <a href="/user/playdatePost">Playdate Post</a> &nbsp;|&nbsp;&nbsp;--%>
<%--    <a href="/user/userPlaydatePosts">User Posts</a> &nbsp;| &nbsp;&nbsp;--%>
<%--    <a href="/login/logout">Logout</a> |--%>






<%--    <sec:authorize access="hasAuthority('ADMIN')">--%>
<%--        &lt;%&ndash;    <sec:authorize access="hasAuthority('ADMIN', 'User')">     <-- to add more users&ndash;%&gt;--%>
<%--    <a href="/user/search">Search User</a> &nbsp;| &nbsp;&nbsp;--%>
<%--        &lt;%&ndash;    this does not prevernt someone from typing this in browser and get here. Go to User controller to prevent access&ndash;%&gt;--%>
<%--    </sec:authorize>--%>


<%--    <sec:authorize access="!isAuthenticated()">--%>
<%--    | <a href="/login/login">Login</a> &nbsp;| &nbsp;&nbsp;--%>
<%--    <a href="/login/register">Sign Up</a> &nbsp;|--%>
<%--    </sec:authorize>--%>


<%--    <sec:authorize access="isAuthenticated()">--%>

<%--    <a href="/user/userPlaydatePosts">MyPlaydatePosts</a>  |--%>
<%--    <a href="/user/playdatePost">+ Playdate Post</a> &nbsp;|&nbsp;&nbsp;--%>
<%--    <a href="/user/addChild">+ Child</a> &nbsp;| &nbsp;&nbsp;--%>
<%--    <a href="/user/searchforplaydate">Find PlaydatePosts</a> &nbsp;| &nbsp;&nbsp;--%>
<%--    <a href="/user/userChildren">MyChildren</a> &nbsp;| &nbsp;&nbsp;--%>
<%--    <a href="/login/logout">Logout</a> &nbsp;| &nbsp;&nbsp;--%>
<%--        <sec:authentication property="principal.username" />--%>
<%--    </sec:authorize>--%>





<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Playdate Posts</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/user/profile">Home</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Playdate Posts
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="/user/searchforplaydate">Find Playdates</a></li>
                            <li><a class="dropdown-item" href="/user/playdatePost">Create Playdate Post</a></li>
                            <li><a class="dropdown-item" href="/user/userPlaydatePosts"> MyPlaydate Posts</a></li>
                        </ul>
                    </li>


                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Account
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="/user/addChild">Add Child</a></li>
                            <li><a class="dropdown-item" href="#">Edit Account</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/login/logout">Logout</a>
                    </li>


                    <li class="nav-item">

                        <a class="nav-link active" aria-current="page" href="#">
                            <sec:authentication property="principal.username" />
                        </a>

                    </li>
                </sec:authorize>


                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/login/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"href="/login/register">Sign Up</a>
                    </li>

                </sec:authorize>


            </ul>
        </div>
    </div>

</nav>








<hr>


<h1>USER PROFILE PAGE </h1>














<%--                 styling                                 --%>

<section class="h-100 gradient-custom-2">

    <form  action="/user/profile" method="get">


    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-lg-9 col-xl-7">
                <div class="card">
                    <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px;">
                        <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
                            <img src="${form.imageURL}" class="img-fluid img-thumbnail mt-4 mb-2" name="imageURL" style="width: 130px; z-index: 1">
                            <button type="button" class="btn btn-outline-dark" data-mdb-ripple-color="dark" style="z-index: 1;">
                                Edit profile
                            </button>
                        </div>
                        <div class="ms-3" style="margin-top: 130px;">

                            <input  type="hidden"  name="firstName" id="firstNameId" value="${form.firstName}" />
                            <h5 style="color: white">${form.firstName}</h5>
                            <p>New York</p>
                        </div>
                    </div>
                    <div class="p-4 text-black" style="background-color: #f8f9fa;">
<%--                        <div class="d-flex justify-content-end text-center py-1">--%>
<%--                            <div>--%>
<%--                                <p class="mb-1 h5">253</p>--%>
<%--                                <p class="small text-muted mb-0">Photos</p>--%>
<%--                            </div>--%>
<%--                            <div class="px-3">--%>
<%--                                <p class="mb-1 h5">1026</p>--%>
<%--                                <p class="small text-muted mb-0">Followers</p>--%>
<%--                            </div>--%>
<%--                            <div>--%>
<%--                                <p class="mb-1 h5">478</p>--%>
<%--                                <p class="small text-muted mb-0">Following</p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                    </div>
                    <br>
                    <br>
                    <div class="card-body p-4 text-black">
                        <div class="mb-5">
                            <p class="lead fw-normal mb-1">About</p>
                            <div class="p-4" style="background-color: #f8f9fa;">
                                <p class="font-italic mb-1" >${form.description}</p>

                            </div>
                        </div>
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <p class="lead fw-normal mb-0">Recent photos</p>
                            <p class="mb-0"><a href="#!" class="text-muted">Show all</a></p>
                        </div>
                        <div class="row g-2">
                            <div class="col mb-2">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(112).webp" alt="image 1" class="w-100 rounded-3">
                            </div>
                            <div class="col mb-2">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(107).webp" alt="image 1" class="w-100 rounded-3">
                            </div>
                        </div>
                        <div class="row g-2">
                            <div class="col">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(108).webp" alt="image 1" class="w-100 rounded-3">
                            </div>
                            <div class="col">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(114).webp" alt="image 1" class="w-100 rounded-3">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    </form>
</section>

<jsp:include page="../include/footer.jsp" />
