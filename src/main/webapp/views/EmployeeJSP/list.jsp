<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap5.min.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>
    <title>Employee List</title>
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
                <p class="h2 fw-normal mb-3">Employee List</p>
                <hr>
            </div>
            <div class="pt-3 ps-5 pe-5">
                <div>
                    <form class="form-inline" action="${pageContext.request.contextPath}/search-emp" method="post">
                        <div class="row justify-content-end">
                            <div class="col-sm-4 pe-0">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa-solid fa-magnifying-glass"></i><br>
                                        </span>
                                    </div>
                                    <input type="text" id="search" name="search" class="form-control"
                                           value="${search}" placeholder="User search">
                                </div>
                            </div>
                            <div class="col-sm-3 pe-0">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa-solid fa-filter"></i>&nbsp; Filter by
                                        </span>
                                    </div>
                                    <select class="form-select" id="criteria" name="criteria">
                                        <option value="name" ${criteria=="name" ? 'selected':''}>Name</option>
                                        <option value="address" ${criteria=="address" ? 'selected':''}>Address</option>
                                        <option value="phone" ${criteria=="phone" ? 'selected':''}>Phone</option>
                                        <option value="dept" ${criteria=="dept" ? 'selected':''}>Department</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-1 pe-0 pe-lg-3 pb-3">
                                <button type="submit" class="btn btn-info text-white w-100">
                                    Search
                                </button>
                            </div>
                        </div>
                    </form>
                    <table id="myTable" class="table table-striped table-bordered" id="emp-table">
                        <thead class="bg-light border-bottom-0">
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Date of birth</th>
                            <th>Address</th>
                            <th>Phone number</th>
                            <th>Department</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listOfEmployee}" var="employee">
                            <tr>
                                <td>${employee.employeeId}</td>
                                <td>${employee.employeeName}</td>
                                <td><fmt:formatDate value="${employee.employeeBirthdate}" pattern="yyyy-MM-dd"/></td>
                                <td>${employee.employeeAddress}</td>
                                <td>${employee.employeePhone}</td>
                                <td>${employee.department}</td>
                                <td><a href="${pageContext.request.contextPath}/view-emp?id=${employee.employeeId}"
                                       class="text-decoration-none"><i class="fas fa-edit"></i> View</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="text-center">
                        <p class="text-danger">${ERROR}</p>
                    </div>
                </div>
            </div>
        </div>
        <!--END CONTENT-->
    </div>
</div>

<script>
    $('#myTable').DataTable({
        searching: false,
        ordering: false,
        info: false,
        lengthChange: false,
        "pageLength": 10,
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
</body>

</html>