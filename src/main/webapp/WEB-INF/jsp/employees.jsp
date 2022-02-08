<%@ include file="header.jsp" %>

    <div class="container">
        <div class="row">
            <h1>Employees</h1>
        </div>
        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th>First name</th>
                    <th>Middle name</th>
                    <th>Last name</th>
                    <th>Position</th>
                </tr>
            </thead>
            <tbody>
                <tr th:each="employee : ${employees}">
                    <td th:text="${employee.firstName}">First name</td>
                    <td th:text="${employee.middleName}">Middle name</td>
                    <td th:text="${employee.lastName}">Last name</td>
                    <td th:text="${employee.position}">Position</td>
                </tr>
            </tbody>
        </table>
    </div>

    </body>

    </html>