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
    <title>Parking</title>
</head>

<body>
<div class="container-fluid">
    <!--NAVBAR-->
    <div class="row">
        <div class="col-2 px-0">
            <li class="list-group-item bg-light border-end-0 border-top-0 border-start-0">
                <a class="nav-link text-secondary text-decoration-none" href="#">
                    <i class="fas fa-square-parking"></i>
                    Parking
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
                        <a href="${pageContext.request.contextPath}/parkinghome" class="nav-link link-primary">
                            <i class="fas fa-tachometer-alt"></i>
                            Dashboard
                        </a>
                    </li>
                    <li class="list-group-item border-bottom bg-light">
                        <a href="#bookingMenu" class="nav-link link-primary" data-bs-toggle="collapse">
                            <i class="fas fa-cart-shopping"></i>
                            Booking office manager
                        </a>
                    </li>
                    <div id="bookingMenu" class="collapse">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item border-bottom-0 bg-light">
                                <a href="${pageContext.request.contextPath}/BookingList"
                                   class="ms-3 nav-link link-primary">
                                    <i class="fas fa-list"></i>
                                    Booking office list
                                </a>
                            </li>
                            <li class="list-group-item border-bottom bg-light">
                                <a href="${pageContext.request.contextPath}/AddBooking"
                                   class="ms-3 nav-link link-primary">
                                    <i class="fas fa-plus"></i>
                                    Add booking office
                                </a>
                            </li>
                        </ul>
                    </div>
                    <li class="list-group-item border-bottom bg-light">
                        <a href="#carMenu" class="nav-link link-primary" data-bs-toggle="collapse">
                            <i class="fas fa-car"></i>
                            Car manager
                        </a>
                    </li>
                    <div id="carMenu" class="collapse">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item border-bottom-0 bg-light">
                                <a href="${pageContext.request.contextPath}/listCar" class="ms-3 nav-link link-primary">
                                    <i class="fas fa-list"></i>
                                    Car list
                                </a>
                            </li>
                            <li class="list-group-item border-bottom bg-light">
                                <a href="${pageContext.request.contextPath}/addCar" class="ms-3 nav-link link-primary">
                                    <i class="fas fa-plus"></i>
                                    Add Car
                                </a>
                            </li>
                        </ul>
                    </div>
                    <li class="list-group-item border-bottom bg-light">
                        <a href="#parkingMenu" class="nav-link link-primary" data-bs-toggle="collapse">
                            <i class="fas fa-chart-bar"></i>
                            Parking lot manager
                        </a>
                    </li>
                    <div id="parkingMenu" class="collapse">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item border-bottom-0 bg-light">
                                <a href="${pageContext.request.contextPath}/listParkingLot"
                                   class="ms-3 nav-link link-primary">
                                    <i class="fas fa-list"></i>
                                    Parking lot list
                                </a>
                            </li>
                            <li class="list-group-item border-bottom bg-light">
                                <a href="${pageContext.request.contextPath}/addParkingLot"
                                   class="ms-3 nav-link link-primary">
                                    <i class="fas fa-plus"></i>
                                    Add parking lot
                                </a>
                            </li>
                        </ul>
                    </div>
                    <li class="list-group-item border-bottom bg-light">
                        <a href="#tripMenu" class="nav-link link-primary" data-bs-toggle="collapse">
                            <i class="fas fa-plane"></i>
                            Trip manager
                        </a>
                    </li>
                    <div id="tripMenu" class="collapse">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item border-bottom-0 bg-light">
                                <a href="${pageContext.request.contextPath}/trip-list"
                                   class="ms-3 nav-link link-primary">
                                    <i class="fas fa-list"></i>
                                    Trip list
                                </a>
                            </li>
                            <li class="list-group-item border-bottom bg-light">
                                <a href="${pageContext.request.contextPath}/trip-add"
                                   class="ms-3 nav-link link-primary">
                                    <i class="fas fa-plus"></i>
                                    Add Trip
                                </a>
                            </li>
                        </ul>
                    </div>
                    <li class="list-group-item border-bottom bg-light">
                        <a href="#ticketMenu" class="nav-link link-primary" data-bs-toggle="collapse">
                            <i class="fas fa-ticket"></i>
                            Ticket manager
                        </a>
                    </li>
                    <div id="ticketMenu" class="collapse">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item border-bottom-0 bg-light">
                                <a href="${pageContext.request.contextPath}/ticket-list"
                                   class="ms-3 nav-link link-primary">
                                    <i class="fas fa-list"></i>
                                    Ticket list
                                </a>
                            </li>
                            <li class="list-group-item border-bottom bg-light">
                                <a href="${pageContext.request.contextPath}/ticket-add"
                                   class="ms-3 nav-link link-primary">
                                    <i class="fas fa-plus"></i>
                                    Add Ticket
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
                <p class="h2 fw-normal mb-3">Welcome to Parking Management</p>
                <hr>
            </div>

            <div class="pt-5 ps-5 pe-5">
                <div>
                    <!--ADD CODE HERE-->


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