<div class="row">
    <div class="col-2 px-0">
        <li class="list-group-item bg-light border-end-0 border-top-0 border-start-0">
            <a class="nav-link text-secondary text-decoration-none" href="#">
                <i class="fas fa-ticket"></i>
                Ticket
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