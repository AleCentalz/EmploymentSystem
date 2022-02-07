<%@ include file="header.jsp" %>

    <div class="container">
        <h3 class="my-3">Add a new Employee to the System</h3>
        <div class="row">
            <div class="col-2">
                <img src="<c:url value='/img/profile-pic.jpg'/>" alt="Employee's photo"/>
            </div>
            <div class="col-6">
                <form:form action="#" th:action="@{/addEmployee}" th:object="{$employee}" method="post">
                    <label for="first-name" class="col-form-label">First name</label>
                    <input type="text" id="first-name" class="form-control" required th:field="{firstName}" placeholder="Your Name">
                     
                    <label for="middle-name" class="col-form-label">Middle Name</label>
                    <input type="text" id="middle-name" class="form-control" th:field="{middleName}" placeholder="Your Middle Name">

                    <label for="last-name" class="col-form-label">Last name</label>
                    <input type="text" id="last-name" class="form-control" required th:field="{lastName}" placeholder="Your Last Name">

                    <label for="position" class="col-form-label">Position</label>
                    <input type="text" id="position" class="form-control" required th:field="{position}" placeholder="Your Position">

                    <label for="birh-date" class="col-form-label">Birth date</label>
                    <input type="date" id="birth-date" class="form-control" required th:field="{birthDate}">

                    <button type="submit" class="btn btn-primary mt-4 me-3">Add Employee</button>
                    <a class="btn btn-secondary mt-4" role="button" href="/">Cancel</a>
                    </form>
            </div>
        </div>
    </div>

    </body>

    </html>