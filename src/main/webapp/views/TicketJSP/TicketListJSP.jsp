<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Ticket List</title>
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
                <p class="h2 fw-normal mb-3">Ticket list <c:if test="${requestScope.message ne null}"><span
                        class="text-danger">${requestScope.message}</span></c:if></p>
                <hr>
            </div>

            <div class="pt-3 ps-5 pe-5">
                <div class="">
                    <!--ADD CODE HERE-->
                    <!--SEARCH FORM-->
                    <form class="form-inline" action="${pageContext.request.contextPath}/ticket-search" method="post">
                        <div class="row justify-content-end">
                            <div class="col-sm-4 pe-0">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa-solid fa-magnifying-glass"></i><br>
                                            </span>
                                    </div>
                                    <input type="text" id="txtSearch" name="txtSearch" class="form-control"

                                           value="${requestScope.txtSearch != null ? requestScope.txtSearch : "" }"
                                           placeholder="Ticket Search">
                                </div>
                            </div>
                            <div class="col-sm-3 pe-0">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa-solid fa-filter"></i>&nbsp; Filter by
                                        </span>
                                    </div>
                                    <select class="form-select" id="searchFilter" name="searchFilter">
                                        <option value="trip" ${requestScope.searchFilter.equalsIgnoreCase("trip") ? 'selected':''}>
                                            Trip
                                        </option>
                                        <option value="licensePlate" ${requestScope.searchFilter.equalsIgnoreCase("licensePlate") ? 'selected':''}>
                                            License
                                            Plate
                                        </option>
                                        <option value="customer" ${requestScope.searchFilter.equalsIgnoreCase("customer") ? 'selected':''}>
                                            Customer
                                        </option>
                                        <option value="bookingTime" ${requestScope.searchFilter.equalsIgnoreCase("bookingTime") ? 'selected':''}>
                                            Booking
                                            Time
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-1 pe-0 pe-lg-3 pb-3">
                                <button type="submit" class="btn btn-info text-white w-100">
                                    Search
                                </button>
                            </div>
                            <div class="col-sm-1 pe-0 pb-3">
                                <select class="form-select" name="day">
                                    <c:forEach begin="1" end="31" var="index">
                                        <option value="${index}" ${requestScope.day == index ? 'selected' : ''}>
                                            <c:choose>
                                                <c:when test="${index < 10}">
                                                    0${index}
                                                </c:when>
                                                <c:otherwise>
                                                    ${index}
                                                </c:otherwise>
                                            </c:choose>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-sm-1 pe-0 pb-3">
                                <select class="form-select" name="month">
                                    <c:forEach begin="1" end="12" var="index">
                                        <option value="${index}" ${requestScope.month == index ? 'selected' : ''}>
                                            <c:choose>
                                                <c:when test="${index < 10}">
                                                    0${index}
                                                </c:when>
                                                <c:otherwise>
                                                    ${index}
                                                </c:otherwise>
                                            </c:choose>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-sm-1 pe-0 pb-3">
                                <select class="form-select" name="year">
                                    <c:choose>
                                        <c:when test="${(requestScope.years[0] != requestScope.years[1]) && (requestScope.years[0] < requestScope.years[1])}">
                                            <c:forEach begin="${requestScope.years[0]}" end="${requestScope.years[1]}"
                                                       var="index">
                                                <option value="${index}" ${requestScope.year == index ? 'selected' : ''}>
                                                        ${index}
                                                </option>
                                            </c:forEach>
                                        </c:when>
                                        <c:when test="${requestScope.years[0] == requestScope.years[1]}">
                                            <option value="${requestScope.years[0]}">
                                                    ${requestScope.years[0]}
                                            </option>
                                        </c:when>
                                    </c:choose>
                                </select>
                            </div>
                        </div>
                    </form>
                    <!--END SEARCH FORM-->
                    <c:choose>
                        <c:when test="${requestScope.ticketList.size() != 0}">
                            <table class="table table-striped table-bordered" id="myTable">
                                <thead class="bg-light border-bottom-0">
                                <tr>
                                    <th scope="col" style="width: 5%">No</th>
                                    <th scope="col" style="width: 16.66%">Trip</th>
                                    <th scope="col" style="width: 16.66%">License Plate</th>
                                    <th scope="col" style="width: 25%">Customer</th>
                                    <th scope="col" style="width: 16.66%">Booking Time</th>
                                    <th scope="col" style="width: 20%">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.ticketList}" var="ticket">
                                    <tr>
                                        <td class="">${ticket.ticketId}</td>
                                        <c:forEach items="${requestScope.tripList}" var="trip">
                                            <c:if test="${ticket.tripId == trip.tripId}">
                                                <td class="">${trip.destination}</td>
                                            </c:if>
                                        </c:forEach>
                                        <td class="">${ticket.licensePlate}</td>
                                        <td class="">${ticket.customerName}</td>
                                        <td class=""><fmt:formatDate type="time" value="${ticket.bookingTime}"
                                                                     pattern="HH:mm"/></td>
                                        <td class=""><span class="me-3">
                                            <a href="${pageContext.request.contextPath}/ticket-view?ticketId=${ticket.ticketId}"
                                               class="text-decoration-none"><i class="far fa-eye"></i> View</a>
                                        </span>
                                            <span>
                                            <a href="${pageContext.request.contextPath}/ticket-delete?ticketId=${ticket.ticketId}"
                                               class="text-decoration-none"
                                               onclick="return confirm('Are you sure to delete this trip?')"><i
                                                    class="fas fa-trash-alt"></i> Delete</a>
                                        </span>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <p class="H3 text-center">There is no ticket</p>
                        </c:otherwise>
                    </c:choose>
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
