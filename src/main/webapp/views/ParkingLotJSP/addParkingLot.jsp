<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script src="../../assets/js/Validator.js" type="text/javascript"></script>
    <%--    <link rel="stylesheet" type="text/css" href="css/styles.css"/>--%>
    <script src="https://kit.fontawesome.com/32b1007cf0.js" crossorigin="anonymous"></script>

    <title>Parking Lot Add</title>
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
                <p class="h2 fw-normal mb-3">Parking lot list</p>
                <hr>
            </div>

            <div class="pt-5 ps-5 pe-5">
                <div>
                    <!--ADD CODE HERE-->
                    <form action="${pageContext.request.contextPath}/addParkingLot" method="post" id="form-add">
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="pName">
                                    <span>Parking Name </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="pName" name="pName"
                                       placeholder="Enter Parking lot name" required>
                            </div>
                            <span></span>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="pPlace">
                                    <span>Place</span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <select class="form-select" id="pPlace" name="pPlace">
                                    <c:forEach items="${requestScope.place}" var="item">
                                        <option value="${item}">${item}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="pArea">
                                    <span>Area </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" pattern="[0-9]+(\.[0-9]{1,})?" min="0" class="form-control"
                                       id="pArea" name="pArea"
                                       placeholder="Enter area" required>
                            </div>
                            <div class="col-1"><label class="fw-bold">(m2)</label></div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="pPrice">
                                    <span>Price </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" pattern="[0-9]+(\.[0-9]{1,})?" class="form-control" id="pPrice"
                                       name="pPrice" placeholder="Enter price" required>
                            </div>
                            <div class="col-1"><label class="fw-bold">(VND)</label></div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-7 text-center">
                                <button type="reset" class="btn btn-warning"><i class="fas fa-undo"></i>
                                    Reset
                                </button>
                                <button type="submit" class="btn btn-success" onclick="hello()"><i
                                        class="fas fa-plus"></i>
                                    Add
                                </button>
                            </div>
                        </div>
                    </form>
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

