<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <script src="https://kit.fontawesome.com/32b1007cf0.js" crossorigin="anonymous"></script>
    <title>Employee View</title>
</head>

<body>
<div class="container-fluid">
    <!--NAVBAR-->
    <div class="row">
        <div class="col-2 px-0">
            <li class="list-group-item bg-light border-end-0 border-top-0 border-start-0">
                <a class="nav-link text-secondary text-decoration-none" href="#">
                    <i class="fas fa-users"></i>
                    Employee
                </a>
            </li>
        </div>
        <div class="col-10 px-0">
            <div class="nav-link bg-light d-flex flex-row-reverse border-bottom">
                <a class="nav-link link-primary text-decoration-none" href="${pageContext.request.contextPath}/logout">
                    <i class="fas fa-sign-out-alt"></i>
                    Logout
                </a>
                <a class="nav-link link-primary text-decoration-none me-4" href="#">
                    Welcome ${loginEmp.account}
                </a>
            </div>
        </div>
    </div>
    <!--END NAVBAR-->
    <div class="row">

        <!--SIDE BAR-->
        <div class="col-2 px-0">
            <div class="bg-light vh-100 border-end">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item bg-light">
                        <a href="${pageContext.request.contextPath}/employeehome" class="nav-link link-primary">
                            <i class="fas fa-tachometer-alt"></i>
                            Dashboard
                        </a>
                    </li>
                    <li class="list-group-item border-bottom bg-light">
                        <a href="#abc" class="nav-link link-primary" data-bs-toggle="collapse">
                            <i class="fas fa-chart-bar"></i>
                            Employee manager
                        </a>
                    </li>
                    <div id="abc" class="">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item border-bottom-0 bg-light">
                                <a href="${pageContext.request.contextPath}/list-emp"
                                   class="ms-3 nav-link link-primary">
                                    <i class="fas fa-list"></i>
                                    Employee list
                                </a>
                            </li>
                            <li class="list-group-item border-bottom bg-light">
                                <a href="${pageContext.request.contextPath}/add-emp" class="ms-3 nav-link link-primary">
                                    <i class="fas fa-plus"></i>
                                    Add Employee
                                </a>
                            </li>
                        </ul>
                    </div>
                </ul>
            </div>
        </div>
        <!--END SIDE BAR-->

        <!--CONTENT-->
        <div class="col-10 px-0">
            <div class="pt-5 ps-5 pe-5">
                <p class="h2 fw-normal mb-3">View Employee</p>
                <hr>
            </div>
            <div class="text-center">
                <p class="text-success">${NOTI}</p>
                <p class="text-danger">${ERROR}</p>
            </div>

            <div class="pt-5 ps-5 pe-5">
                <div>
                    <form action="${pageContext.request.contextPath}/view-emp?id=${employee.employeeId}"
                          method="post">
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="name">
                                    <span>Full Name </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="name" name="name"
                                       placeholder="Enter full name"
                                       value="${employee.employeeName}" required>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="phone">
                                    <span>Phone number </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="phone"
                                       name="phone" placeholder="Enter phone number" pattern="\d{10}"
                                       value="${employee.employeePhone}" required>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="bday">
                                    <span>Date of Birth </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="date" class="form-control" id="bday" name="bday"
                                       value="${bday}" required>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="sex">
                                    <span>Sex </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <div class="form-check-inline">
                                    <label class="form-check-label">
                                        <input type="radio" class="form-check-input" name="sex" id="sex"
                                               value="M" checked> Male
                                    </label>
                                </div>
                                <div class="form-check-inline">
                                    <label class="form-check-label">
                                        <input type="radio" class="form-check-input" name="sex" id="sex"
                                               value="F" ${employee.sex == "F" ? 'checked' : ''}> Female
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="address">
                                    <span>Address </span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="address"
                                       name="address" placeholder="Enter address" value="${employee.employeeAddress}">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="email">
                                    <span>Email </span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="email"
                                       name="email" placeholder="Enter email" value="${employee.employeeEmail}">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="account">
                                    <span>Account </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="account" name="account"
                                       placeholder="Enter account" value="${employee.account}" readonly>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="password">
                                    <span>Password </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="password" class="form-control" id="password" name="password"
                                       placeholder="Enter password"
                                       pattern="^(?=.*?[A-Z])(?=.*?[a-z]).{6,}$"
                                       value="${employee.password}"
                                       oninvalid="this.setCustomValidity('Password must be over 6 characters and at least a digit, an uppercase and a lowercase.')"
                                       oninput="setCustomValidity('')"
                                       required>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="dept">
                                    <span>Department </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <select class="form-control" id="dept" name="dept">
                                    <option value="employee" ${employee.department == "employee" ? 'selected':''}>
                                        Employee
                                    </option>
                                    <option value="parking" ${employee.department == "parking" ? 'selected':''}>
                                        Parking
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-7 text-center">
                                <button type="reset" class="btn btn-primary" onclick="history.back()"><i
                                        class="fas fa-backward"></i>
                                    Back
                                </button>
                                <button type="reset" class="btn btn-warning"><i class="fas fa-undo"></i>
                                    Reset
                                </button>
                                <button type="submit" class="btn btn-success"><i class="fas fa-file-pen"></i>
                                    Update
                                </button>
                                <a href="${pageContext.request.contextPath}/delete-emp?id=${employee.employeeId}"
                                   role="button" class="btn btn-danger"
                                   onclick="return confirm('Are you sure you want to delete this item')"
                                   role="button"><i class="fas fa-trash-can"></i>
                                    Delete
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--END CONTENT-->
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>