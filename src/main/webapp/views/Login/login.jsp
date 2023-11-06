<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <script src="https://kit.fontawesome.com/1ec3eb69b6.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="login.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/login.css"/>
</head>

<body class="bg-light">
<div
        class="login-form container d-flex align-items-center justify-content-center position-absolute top-50 start-50 translate-middle"
>
    <div class="container-fluid pt-3 ps-5">
        <form action="<%=request.getContextPath()%>/login" method="post">

            <ul class="list-group">
                <li class="list-group-item bg-light">Please Sign-in</li>
                <li class="list-group-item">
                    <div class="text-danger text-center" role="alert">
                        <p>${NOTI}</p>
                    </div>
                    <div class="mb-3 mt-2">
                        <input type="text" id="account" name="account" class="form-control mb-3"
                               value="${rememberUsername}" placeholder="Account" required>
                    </div>
                    <div class="mb-3">
                        <input type="password" id="psw" name="psw" class="form-control mb-3" placeholder="Password"
                               required>
                    </div>
                    <div class="mb-3 form-check">
                        <input class="form-check-input" type="checkbox" value="yes" id="remember" name="remember"
                        ${rmbCheck=="yes" ? 'checked':''}>
                        <label class="form-check-label" for="remember"
                        >Remember Me</label
                        >
                    </div>
                    <div class="text-center mb-3">
                        <label
                                id="lblError"
                                class="lblError text-center text-danger"
                                style="display: none"
                        ></label>
                    </div>
                    <div class="mb-2">
                        <input
                                type="submit"
                                value="Login"
                                id="btnSubmit"
                                class="btnSubmit btn btn-success mb-3 w-100"
                        />
                        <br/>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</div>
</body>
</html>
