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
    <script>
        function validateLicensePlate(){
            var licensePlate = document.getElementById("licensePlate").value;
            var carType = document.getElementById("carType").value;
            var carColor = document.getElementById("carColor").value;
            var regex = new RegExp("[0-9]{2}[A-Z]-[0-9]{4,5}");
            if (regex.test(licensePlate)) {
                return true;
            } else {
                document.getElementById("licensePlate").style.borderColor = "red";
                document.getElementById("errorName").innerHTML = "Your license plate must be true format(ex: 12A-3456)";
                alert("License plate is wrong");
                return false;
            }
        }
    </script>
    <title>Car Add</title>
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
                <p class="h2 fw-normal mb-3">Car Add</p>
                <hr>
            </div>
            <div class="text-center">
                <p class="text-success">${NOTI}</p>
                <p class="text-danger">${ERROR}</p>
            </div>

            <div class="pt-5 ps-5 pe-5">
                <div>
                    <!--ADD CODE HERE-->
                    <form onsubmit="return validateLicensePlate()" name = "addCarForm" action="${pageContext.request.contextPath}/addCar" method="post">
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="licensePlate">
                                    <span>License Plate </span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="licensePlate" name="licensePlate"
                                       placeholder="Enter license plate" required>
                            </div>
                            <span id="errorName"></span>
                        </div>

                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="carColor">
                                    <span>Car color</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="carColor" name="carColor"
                                       placeholder="Enter car color" required>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="carType">
                                    <span>Car type</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" id="carType" name="carType"
                                       placeholder="Enter car type" required>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="company">
                                    <span>Company</span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <select class="form-select" id="company" name="company">
                                    <c:forEach items="${company}" var="c">
                                        <option value="${c.officeId}">${c.officeName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-2">
                                <label class="fw-bold" role="button" for="parkId">
                                    <span>Park ID</span>
                                    <span class="text-danger">(*)</span>
                                </label>
                            </div>
                            <div class="col-5">
                                <select class="form-select" id="parkId" name="parkId">
                                    <c:forEach items="${parkId}" var="p">
                                        <option value="${p.parkId}">${p.parkName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-7 text-center">
                                <button type="reset" class="btn btn-warning"><i class="fas fa-undo"></i>
                                    Reset</button>
                                <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i>
                                    Add</button>
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