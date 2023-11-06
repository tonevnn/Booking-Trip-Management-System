<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Car List</title>
</head>

<body>
<div class="container-fluid">
    <!--NAVBAR-->
    <jsp:include page="nav.jsp"></jsp:include>
    <!--END NAVBAR-->
    <div class="row">

        <!--SIDE BAR-->
        <jsp:include page="sideMenu.jsp"></jsp:include>
        <!--END SIDE BAR-->

        <!--CONTENT-->
        <div class="col-10 px-0">
            <div class="pt-5 ps-5 pe-5">
                <p class="h2 fw-normal mb-3">Car list</p>
                <hr>
            </div>
            <div class="pt-3 ps-5 pe-5">
                <%--Phan trang--%>
                <!--Serch-->
                <div class="">
                    <form class="form-inline" action="${pageContext.request.contextPath}/searchCar" method="get">
                        <div class="row justify-content-end">
                            <div class="col-sm-4 pe-0">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa-solid fa-magnifying-glass"></i><br>
                                        </span>
                                    </div>
                                    <input type="text" id="search" name="keyword" class="form-control"
                                           value="${keyword}" placeholder="Car search">
                                </div>
                            </div>
                            <div class="col-sm-3 pe-0">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa-solid fa-filter"></i>&nbsp; Search by
                                        </span>
                                    </div>
                                    <select class="form-select" id="criteria" name="criteria">
                                        <option value="licensePlate" ${criteria=="licensePlate" ? 'selected':''}>License
                                            plate
                                        </option>
                                        <option value="carColor" ${criteria=="carColor" ? 'selected':''}>Color</option>
                                        <option value="carType" ${criteria=="carType" ? 'selected':''}>Type</option>
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
<%--                </div>--%>

                <!--Serch-->
                <%--Phan trang--%>
<%--                <div>--%>
                    <!--ADD CODE HERE-->
                    <table class="table table-striped table-bordered" id="myTable">
                        <thead class="bg-light border-bottom-0">
                        <tr>
                            <th scope="col" style="width: 16%">License plate</th>
                            <th scope="col" style="width: 16%">Car color</th>
                            <th scope="col" style="width: 16%">Car type</th>
                            <th scope="col" style="width: 16%">Company</th>
                            <th scope="col" style="width: 16%">Park ID</th>
                            <th scope="col" style="width: 20%">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.listCars}" var="car">
                            <tr>
                                <td class="">${car.licensePlate}</td>
                                <td class="">${car.carColor}</td>
                                <td class="">${car.carType}</td>
                                <c:forEach items="${company}" var="c">
                                    <c:if test="${c.officeId == car.company}">
                                        <td>${c.officeName}</td>
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${parkId}" var="p">
                                    <c:if test="${p.parkId == car.parkId}">
                                        <td>${p.parkName}</td>
                                    </c:if>
                                </c:forEach>
                                <td class="">
                                <span class="me-3">
                                <a href="${pageContext.request.contextPath}/updateCar?licensePlate=${car.licensePlate}"
                                   class="text-decoration-none"><i class="fas fa-edit"></i> Edit</a>
                                </span>
                                    <span>
                                <a href="${pageContext.request.contextPath}/deleteCar?licensePlate=${car.licensePlate}"
                                   class="text-decoration-none"
                                   onclick="return confirm('Are you sure to delete this car?')"><i
                                        class="fas fa-trash-alt"></i> Delete</a>
                                    </span>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <c:forEach begin="1" end="${end}" var="i">
                        <a href="${pageContext.request.contextPath}/listCar?index=${i}">${i}</a>
                    </c:forEach>

                    <!--END CODE HERE-->
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
        "bPaginate": false,
        "paging": false
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>