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
                        <a href="${pageContext.request.contextPath}/BookingList" class="ms-3 nav-link link-primary">
                            <i class="fas fa-list"></i>
                            Booking office list
                        </a>
                    </li>
                    <li class="list-group-item border-bottom bg-light">
                        <a href="${pageContext.request.contextPath}/AddBooking" class="ms-3 nav-link link-primary">
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
                        <a href="${pageContext.request.contextPath}/listParkingLot" class="ms-3 nav-link link-primary">
                            <i class="fas fa-list"></i>
                            Parking lot list
                        </a>
                    </li>
                    <li class="list-group-item border-bottom bg-light">
                        <a href="${pageContext.request.contextPath}/addParkingLot" class="ms-3 nav-link link-primary">
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
            <div id="tripMenu" class="collapse show">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item border-bottom-0 bg-light">
                        <a href="${pageContext.request.contextPath}/trip-list" class="ms-3 nav-link link-primary">
                            <i class="fas fa-list"></i>
                            Trip list
                        </a>
                    </li>
                    <li class="list-group-item border-bottom bg-light">
                        <a href="${pageContext.request.contextPath}/trip-add" class="ms-3 nav-link link-primary">
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
                        <a href="${pageContext.request.contextPath}/ticket-list" class="ms-3 nav-link link-primary">
                            <i class="fas fa-list"></i>
                            Ticket list
                        </a>
                    </li>
                    <li class="list-group-item border-bottom bg-light">
                        <a href="${pageContext.request.contextPath}/ticket-add" class="ms-3 nav-link link-primary">
                            <i class="fas fa-plus"></i>
                            Add Ticket
                        </a>
                    </li>
                </ul>
            </div>
        </ul>
    </div>
</div>