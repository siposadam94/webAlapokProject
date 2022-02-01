<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Products</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <link rel="stylesheet" href="login-style.css">
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-4">
                    <h1>Products</h1>
                </div>

            </div>
            <br/>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Category</th>
                        <th scope="col">Description</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Unit</th>
                        <th scope="col">Purchase Price $</th>
                        <th scope="col">Selling Price $</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.products}" var="name">
                    <tr>
                        <td><c:out value="${name.name}"/></td>
                        <td><c:out value="${name.category}"/></td>
                        <td><c:out value="${name.description}"/></td>
                        <td><c:out value="${name.quantity}"/></td>
                        <td><c:out value="${name.unit}"/></td>
                        <td><c:out value="${name.purchasePrice}"/></td>
                        <td><c:out value="${name.sellingPrice}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                crossorigin="anonymous"></script>
    </body>
</html>
