<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link href="<c:url value="../../../pub/css/header.css" />" rel="stylesheet">
<%----%>
    <title>Sample Project</title>


</head>

<body>

<div class="container">
    <a href="/index">Index</a> &nbsp; | &nbsp;
    <a href="/login/register">Sign Up</a> &nbsp;| &nbsp;
<%--    <a href="/user/search">Search</a> &nbsp;| &nbsp;&nbsp;--%>
<%--    <a href="/user/playdatePost">Playdate Post</a> &nbsp;|&nbsp;&nbsp;--%>
<%--    <a href="/user/userPlaydatePosts">User Posts</a> &nbsp;| &nbsp;&nbsp;--%>
<%--    <a href="/login/logout">Logout</a> |--%>






    <sec:authorize access="hasAuthority('ADMIN')">
        <%--    <sec:authorize access="hasAuthority('ADMIN', 'User')">     <-- to add more users--%>
     <a href="/user/search">ADMINSEARCH</a>
        <%--    this does not prevernt someone from typing this in browser and get here. Go to User controller to prevent access--%>
    </sec:authorize>


    <sec:authorize access="!isAuthenticated()">
    | <a href="/login/login">Login</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
    <a href="/user/search">Search</a> &nbsp;| &nbsp;&nbsp;
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
    | <a href="/user/addChild">+ Child</a>
    </sec:authorize>


<sec:authorize access="isAuthenticated()">
    <a href="/user/playdatePost">Playdate Post</a> &nbsp;|&nbsp;&nbsp;
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
    <a href="/user/userPlaydatePosts">User Posts</a> &nbsp;| &nbsp;&nbsp;
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
    <a href="/login/logout">Logout</a>

    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username" />
    </sec:authorize>




    <hr>

