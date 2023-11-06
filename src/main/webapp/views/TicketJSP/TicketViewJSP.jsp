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
    <title>Ticket View</title>
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
                <p class="h2 fw-normal mb-3">Ticket View <c:if test="${requestScope.message ne null}"><span
                        class="text-danger">${requestScope.message}</span></c:if></p>
                <hr>
            </div>

            <div class="pt-5 ps-5 pe-5">
                <div class="">
                    <!--ADD CODE HERE-->
                    <div class="row mb-3">
                        <div class="col-2">
                            <label class="fw-bold">
                                <span>Customer</span>
                            </label>
                        </div>
                        <div class="col-5">
                            <label class="fst-italic">
                                <span>${requestScope.ticket.customerName}</span>
                            </label>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-2">
                            <label class="fw-bold">
                                <span>Booking time</span>
                            </label>
                        </div>
                        <div class="col-5">
                            <label class="fst-italic">
                                <span>${requestScope.ticket.bookingTime}</span>
                            </label>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-2">
                            <label class="fw-bold">
                                <span>Trip</span>
                            </label>
                        </div>
                        <div class="col-5">
                            <label class="fst-italic">
                                <span>${requestScope.destination}</span>
                            </label>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-2">
                            <label class="fw-bold">
                                <span>License plate </span>
                            </label>
                        </div>
                        <div class="col-5">
                            <label class="fst-italic">
                                <span>${requestScope.ticket.licensePlate}</span>
                            </label>
                        </div>
                    </div>
                    <%--            <div class="row mb-3">--%>
                    <%--              <div class="col-7 text-center">--%>
                    <%--                <button type="reset" class="btn btn-warning"><i class="fas fa-undo"></i>--%>
                    <%--                  Reset</button>--%>
                    <%--                <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i>--%>
                    <%--                  Edit</button>--%>
                    <input type="hidden" name="ticketId" value="${requestScope.ticket.ticketId}">
                    <%--              </div>--%>
                    <%--            </div>--%>
                    <!--END CODE HERE-->
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
