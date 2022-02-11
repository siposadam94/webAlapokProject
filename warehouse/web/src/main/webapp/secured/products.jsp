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
        <style>
            .modal-bg {
                position: fixed;
                width: 100%;
                height: 100%;
                top: 0;
                left: 0;
                background-color: rgba(0, 0, 0, 0.4);
                display: flex;
                align-items: center;
                visibility: hidden;
                opacity: 0;
                transition: visibility 0s, opacity 0.2s;
            }

            .modal-body {
                display: flex;
                justify-content: center;
            }
        </style>
    </head>
    <body>
        <div class="modal-bg">
            <div class="modal-body">
                <div class="spinner-border text-primary" style="width: 80px; height: 80px;" role="status"></div>
            </div>
        </div>

        <div class="container">
            <div class="row" style="height: 100px;">
                <h1 class="text-center">Products</h1>
            </div>

            <div class="row align-items-center justify-content-around" style="height: 100px;">
                <div class="col-4">
                    <div class="col input-group">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupCategory">Category</label>
                        </div>
                        <select class="custom-select" id="inputGroupCategory" style="width: 50%;">
                            <option selected>All</option>
                        </select>
                    </div>
                </div>
                <div class="col-4">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupUnit">Unit</label>
                        </div>
                        <select class="custom-select" id="inputGroupUnit" style="width: 50%;">
                            <option selected>All</option>
                        </select>
                    </div>
                </div>
            </div>
            <br/>
            <div class="row justify-content-start">
                <div class="col-4">
                    <button type="button" class="btn btn-success" id="btn-fetchProducts">Frissités</button>
                </div>
            </div>
            <table class="table" id="productTable">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Category</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Unit</th>
                        <th scope="col">Purchase Price $</th>
                        <th scope="col">Selling Price $</th>
                        <th scope="col">Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sessionScope.products}" var="product">
                        <tr>
                            <td><c:out value="${product.name}"/></td>
                            <td><c:out value="${product.category}"/></td>
                            <td><c:out value="${product.quantity}"/></td>
                            <td><c:out value="${product.unit}"/></td>
                            <td><c:out value="${product.purchasePrice}"/></td>
                            <td><c:out value="${product.sellingPrice}"/></td>
                            <td><c:out value="${product.description}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
                crossorigin="anonymous"></script>
        <script type="text/javascript">
        </script>
        <script>
            $("#btn-fetchProducts").click(function () {
                $(".modal-bg").css({"visibility": "visible", "opacity": 1});

                $.ajax({
                    method: "get",
                    url: "../api/ProductService/getProducts",
                })
                    .done(function (products) {
                        setTimeout(function () {
                            $("#productTable").find("tr:gt(0)").remove();

                            products.forEach((product) => {
                                const myRow = document.createElement("tr");

                                Object.entries(product)
                                    .forEach(([key]) => {
                                        const myCol = document.createElement("td");
                                        myCol.innerText = product[key];
                                        myRow.appendChild(myCol);
                                    });
                                $("#productTable > tbody").append(myRow);
                            });
                            $(".modal-bg").css({"visibility": "hidden", "opacity": 0});
                        }, 1000);
                    });
            });

            $(window).on('load', function () {

                let categorySelect = $("#inputGroupCategory");
                let inputGroupUnit = $("#inputGroupUnit");
                $.ajax({
                    method: "get",
                    url: "../api/CategoryService/getCategories",
                })
                    .done(function (categories) {
                        categories.forEach((category) => {
                            console.log(category);
                            let opt = document.createElement('option');
                            opt.value = category[0];
                            opt.innerHTML = category[1];
                            categorySelect.append(opt);
                        });
                    });
                $.ajax({
                    method: "get",
                    url: "../api/UnitService/getUnits",
                })
                    .done(function (units) {
                        units.forEach((unit) => {
                            console.log(unit);
                            let opt = document.createElement('option');
                            opt.value = unit[0];
                            opt.innerHTML = unit[1];
                            inputGroupUnit.append(opt);
                        });
                    });
            });

        </script>
    </body>
</html>
