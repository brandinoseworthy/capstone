<jsp:include page="../include/header.jsp" />

<form action="/login/loginSubmit" method="POST">
    <%--<form action="/login/loginSubmit" method="POST">--%>

    <%--    Username : <input type="text" name="username">--%>
    <%--    <br>--%>
    <%--    Password : <input type="text" name="password">--%>

    <%--    <br>--%>
    <%--    <button type="submit"> Submit </button>--%>

    <%--</form>--%>



    <section class="vh-100" style="background-color: #9A616D;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-xl-10">
                    <div class="card" style="border-radius: 1rem;">
                        <div class="row g-0">
                            <div class="col-md-6 col-lg-5 d-none d-md-block">
                                <img src="https://images.pexels.com/photos/7869833/pexels-photo-7869833.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                                     alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; " />
                            </div>
                            <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                <div class="card-body p-4 p-lg-5 text-black">

                                    <form action="/login/loginSubmit" method="POST">

                                        <div class="d-flex align-items-center mb-3 pb-1">
                                            <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                            <span  class="h1 fw-bold mb-0" style="color: rgba(243,129,129,.9);" >PlayDates <h4>Let kids be kids WITH Kids!</h4></span>
<%--                                            <span class="h1 fw-bold mb-0">PlayDates <h4>Let kids be kids WITH Kids!</h4></span>--%>
                                        </div>



                                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your account</h5>

                                        <div class="form-outline mb-4">
                                            <%--                                        Username : <input type="text" name="username">--%>
                                            <input type="text" id="form2Example17" class="form-control form-control-lg" name="username"/>
                                            <label class="form-label" for="form2Example17">Email address</label>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <%--                                            Password : <input type="text" name="password">  --%>
                                            <input type="password" id="form2Example27" class="form-control form-control-lg" name="password" />
                                            <label class="form-label" for="form2Example27">Password</label>
                                        </div>

                                        <div class="pt-1 mb-4">
                                            <%--                                        <button type="submit"> Submit </button>--%>
                                            <button class="btn btn-dark btn-lg btn-block" type="submit" style="background-color: #f38181">Login</button>
                                        </div>

                                        <a class="small text-muted" href="#!">Forgot password?</a>
                                        <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account? <a href="/user/register"
                                                                                                                  style="color: #393f81;">Register here</a></p>
                                        <a href="#!" class="small text-muted">Terms of use.</a>
                                        <a href="#!" class="small text-muted">Privacy policy</a>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>






<jsp:include page="../include/footer.jsp" />