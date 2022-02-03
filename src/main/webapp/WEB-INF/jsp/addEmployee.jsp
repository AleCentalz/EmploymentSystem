<%@ include file="header.jsp" %>

    <div class="container">
        <h3 class="my-3">Add a new Employee to the System</h3>
        <div class="row">
            <div class="col-2">
                <%-- <img src="<c:url value='${../../../resources/static/profile-pic.jpg}'/>" alt="Employee's photo"/> --%>
            </div>
            <div class="col-6">
                <form:form action="">
                    <label for="firstName" class="col-form-label">First name</label>
                    <input type="text" id="firstName" class="form-control" required>

                    <label for="firstName" class="col-form-label">Middle Name</label>
                    <input type="text" id="middleName" class="form-control">

                    <label for="firstName" class="col-form-label">Last name</label>
                    <input type="text" id="lastName" class="form-control" required>

                    <label for="firstName" class="col-form-label">Position</label>
                    <input type="text" id="position" class="form-control" required>

                    <label for="firstName" class="col-form-label">Birth date</label>
                    <input type="date" id="birthDate" class="form-control" required>

                    <button type="submit" class="btn btn-primary mt-4 me-3">Add Employee</button>
                    <a class="btn btn-secondary mt-4" role="button" href="/">Cancel</a>
                    </form>
            </div>
        </div>
    </div>

    </body>

    </html>