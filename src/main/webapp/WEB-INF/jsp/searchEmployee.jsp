<%@ include file="header.jsp"%>
    <div class="container">
        <h3 class="my-3">Search for an Employee</h3>
        <div class="row mt-2">
            <div class="col-10">
                <form class="d-flex">
                    <input class="form-control me-3" type="search" placeholder="First name" aria-label="firstName">
                    <input class="form-control me-3" type="search" placeholder="Last name" aria-label="lastName">
                    <input class="form-control me-3" type="search" placeholder="Position" aria-label="position">
                    <button class="btn btn-success me-3" type="submit">Search</button>
                    <button class="btn btn-secondary me-3" type="clear">Clean</button>
                  </form>
            </div>
        </div>
    </div>
</body>
</html>