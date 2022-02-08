<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <link rel="stylesheet" href="login-style.css">
    </head>

    <body>
        <div class="container">
            <form class="loginHandler bg-white" action="loginHandler" method="post">
                <div class="d-flex flex-row bd-highlight mb-3">

                    <div class="p-2 bd-highlight">
                        <i class="bi bi-person-fill main-icon"></i>
                    </div>
                    <div class="p-2 bd-highlight">
                        <h1>User Login</h1>
                    </div>
                </div>

                <br>
                <div class="form-floating mb-3">

                    <div class="input-group mb-3">
                    <span class="input-group-text bg-white">
                        <i class="bi bi-person-fill small-icon"></i>
                    </span>
                        <input type="text" class="form-control" placeholder="user name" aria-label="Username"
                               aria-describedby="basic-addon1" name="username">
                    </div>

                    <div class="input-group mb-3">
                    <span class="input-group-text bg-white">
                        <i class="bi bi-key-fill small-icon"></i>
                    </span>
                        <input type="password" class="form-control" placeholder="password" aria-label="Password"
                               aria-describedby="basic-addon1" name="password">
                    </div>
                    <p id="loginMsg">
                        <%--el lel próbáljam ki--%>
                        <c:if test="${not requestScope.loginError}">
                            <c:out value="Érvénytelen belépési adatok!"/>
                        </c:if>
                    </p>
                    <div class="row text-end">
                        <a href="#" class="forgot-password">forgot password</a>
                    </div>
                </div>
                <br/>

                <input class="btn btn-lg btn-primary" type="submit" value="Login">
                <br/>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                crossorigin="anonymous"></script>
    </body>

</html>
