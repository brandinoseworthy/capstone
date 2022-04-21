<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <title>Sample Project</title>

    <link href="<c:url value="../../../pub/css/profile.css" />" rel="stylesheet">
</head>

<body>


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
                            <li><a class="dropdown-item" href="/playdatepost/search">Find Playdates</a></li>
                            <li><a class="dropdown-item" href="/user/playdatePost">Create Playdate Post</a></li>
                            <li><a class="dropdown-item" href="/playdatepost/userposts"> MyPlaydate Posts</a></li>
                        </ul>
                    </li>


                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Account
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="/child/add">Add Child</a></li>
                            <li><a class="dropdown-item" href="/user/mychildren"> View Children</a></li>

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

<br>
<section class="h-100 gradient-custom-2">

    <form  action="/user/profile" method="get">


        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-lg-9 col-xl-7">
                    <div class="card">
                        <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px;">
                            <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
                                <img src="${form.imageURL}" class="img-fluid img-thumbnail mt-4 mb-2" name="imageURL" style="width: 130px; z-index: 1">

                            </div>
                            <div class="ms-3" style="margin-top: 130px;">

                                <input  type="hidden"  name="firstName" id="firstNameId" value="${form.firstName}" />
                                <h5 style="color: white">${form.firstName}</h5>
                                <p>${form.townState}</p>
                            </div>
                        </div>
                        <div class="p-4 text-black" style="background-color: #f8f9fa;">

                        </div>
                        <br>
                        <br>
                        <div class="card-body p-4 text-black">
                            <div class="mb-5">
                                <p class="lead fw-normal mb-1">About</p>
                                <div class="p-4" style="background-color: #f8f9fa;">
                                    <p class="font-italic mb-1" >${form.description}</p>

                                </div>
                                <br>
                                <div class="mb-5">
                                    <p class="lead fw-normal mb-1">Favorite Playdate location(s)</p>
                                    <div class="p-4" style="background-color: #f8f9fa;">
                                        <p class="font-italic mb-1">${form.favoritePlaceForPlaydates}</p>

                                    </div>
                                </div>
                            </div>
                            <div class="d-flex justify-content-between align-items-center mb-4">
                                <p class="lead fw-normal mb-0">Explore</p>
                                <p class="mb-0"><a href="http://localhost:8080/playdatepost/userposts" class="text-muted">PlaydatePosts</a>  | <a href="http://localhost:8080/user/children/${form.id}" class="text-muted">View Children</a></p>
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
