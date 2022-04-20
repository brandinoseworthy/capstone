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
                        <a class="nav-link active" aria-current="page" href="/user/profile/${form.id}">Home</a>
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

