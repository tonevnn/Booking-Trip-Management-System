<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>
    <title>Booking Office List</title>
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
                <p class="h2 fw-normal mb-3">Booking office list</p>
                <hr>
            </div>

            <div class="pt-3 ps-5 pe-5">
                <div>
                    <form class="form-inline" action="SearchBooking" method="get">
                        <div class="row justify-content-end">
                            <div class="col-sm-4 pe-0">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa-solid fa-magnifying-glass"></i><br>
                                        </span>
                                    </div>
                                    <input type="text" id="search" name="keyword" class="form-control"
                                           value="${keyword}" placeholder="Parking lot search">
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
                                        <option value="id" ${criteria=="id" ? 'selected':''}>Id</option>
                                        <option value="name" ${criteria=="name" ? 'selected':''}>name</option>
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
<%--            </div>--%>

<%--            <div class="pt-5 ps-5 pe-5">--%>
<%--                <div>--%>
                    <!--ADD CODE HERE-->
                    <table class="table table-striped table-bordered" id="myTable">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Booking Office</th>
                            <th scope="col">Trip</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listB}" var="b">
                            <tr>
                                <td>${b.officeId}</td>
                                <td>${b.officeName}</td>
                                <c:forEach items="${listT}" var="t">
                                    <c:if test="${b.tripId==t.tripId}">
                                        <td>${t.destination}</td>
                                    </c:if>
                                </c:forEach>
                                <td><a href="ViewBooking?id=${b.officeId}" class="text-decoration-none"><i
                                        class="far fa-eye"></i> View</a></td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>


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
        "pageLength": 10,
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>