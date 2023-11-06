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
    <title>Booking Office View</title>
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
                <p class="h2 fw-normal mb-3">Booking office view</p>
                <hr>
            </div>

            <div class="pt-5 ps-5 pe-5">
                <div>

                    <!--ADD CODE HERE-->

                    <form action="UpdateBooking" method="post">
                        <input type="hidden" value="${e.officeId}" placeholder="${e.officeId}" name="id">
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="txtDestination">
                                    <span>Booking office name </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="txtDestination" name="name" required
                                       value="${e.officeName}" placeholder="${e.officeName}">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="txtDepartureTime">
                                    <span>Trip </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <select name="trip" class="form-select" id="txtDepartureTime">
                                    <c:forEach items="${listC}" var="c">
                                        <option value="${c.tripId}" ${e.tripId==c.tripId ? 'selected' : '' }>${c.destination}</option>
                                    </c:forEach>
                                </select><br>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="txtDriver">
                                    <span>Phone number</span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="tel" pattern="[0]{1}[0-9]{9}" class="form-control" id="txtDriver" required
                                       name="phone"
                                       value="${e.officePhone}" placeholder="${e.officePhone}">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="txtCarType">
                                    <span>Place</span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <select name="place" class="form-select" id="txtCarType">
                                    <option ${e.officePlace=='Hanoi' ? 'selected' : '' }>Hanoi</option>
                                    <option ${e.officePlace=='Hung Yen' ? 'selected' : '' }>Hung Yen</option>
                                    <option ${e.officePlace=='hai Phong' ? 'selected' : '' }>Hai Phong</option>
                                    <option ${e.officePlace=='Lang Son' ? 'selected' : '' }>Lang Son</option>
                                </select><br>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="txtMaximumTickerNumber">
                                    <span>Price</span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="txtMaximumTickerNumber"
                                       name="price" required value="${e.officePrice}" placeholder="${e.officePrice}">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="txtDepartureDate">
                                    <span>From Date</span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="date" class="form-control" name="dateFrom" required id="txtDepartureDate"
                                       value="${e.startContractDeadline}" placeholder="${e.startContractDeadline}"><br>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="txtDepartureDate2">
                                    <span>To Date</span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="date" class="form-control" name="dateTo" required id="txtDepartureDate2"
                                       value="${e.endContractDeadline}" placeholder="${e.endContractDeadline}"><br>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i>
                            Update
                        </button>
                        <a href="DeleteBooking?id=${e.officeId}" class="btn btn-danger"
                           onclick="return confirm('Are you sure you want to delete this item')" role="button"
                           title="Delete" data-toggle="tooltip"><i class="material-icons"><i class="fas fa-redo"></i>
                            Delete </i></a>

                    </form>
                    <!--END CODE HERE-->
                </div>
            </div>
        </div>
        <!--END CONTENT-->
    </div>
</div>

</body>

</html>