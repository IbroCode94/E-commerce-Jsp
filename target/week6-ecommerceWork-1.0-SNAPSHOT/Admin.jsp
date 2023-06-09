
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-commerce Store Admin Dashboard</title>
    <link rel="stylesheet" href="style.css">
    <style>
        /* Set default font family and color */
        body {
            font-family: Arial, sans-serif;
            color: #333;
        }

        /* Set header style */
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 1rem;
            background-color: #f2f2f2;
        }
        header h1 {
            left: 50%;
            color: #721c24;
            box-shadow:
                    2px 2px 5px #888888,
                    -2px -2px 5px #000000;
            border-radius: 5px;
        }

        /* Style logout link */
        header a {
            text-decoration: none;
            color: #666;
            border: 1px solid #666;
            padding: 0.5rem;
            border-radius: 5px;
            box-shadow:
                    2px 2px 5px #888888,
                    -2px -2px 5px #000000;

        }

        /* Style search form */
        nav form {
            margin: 1rem 0;
        }

        nav label {
            margin-right: 0.5rem;
        }

        nav input[type="text"] {
            padding: 0.5rem;
            border-radius: 5px;
            border: none;
            box-shadow: 0 0 3px rgba(0, 0, 0, 0.3);
        }

        nav button[type="submit"] {
            padding: 0.5rem;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* Style navigation links */
        nav ul {
            display: flex;
            justify-content: flex-end;
        }

        nav li {
            margin-left: 1rem;
        }

        nav a {
            text-decoration: none;
            color: #333;
        }

        nav a:hover {
            text-decoration: underline;
        }

        /* Style products table */
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 0.5rem;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            align-items: center;
            background-color: #f2f2f2;
        }

        /* Style remove button */
        .remove-btn {
            padding: 0.5rem;
            background-color: #ff6961;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .remove-btn:hover {
            background-color: #ff4136;
        }

        /* Style form for updating price and quantity */
        form {
            display: inline-block;
        }

        form label {
            display: inline-block;
            margin-right: 10px;
        }

        form input[type="number"] {
            width: 80px;
            padding: 5px;
            border-radius: 4px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            margin-right: 10px;
        }

        form button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        form button[type="submit"]:hover {
            background-color: #3e8e41;
        }

    </style>
</head>
<body>
<header>
    <h1>Welcome Admin</h1>
    <a href="#">Logout</a>
</header>
<nav>
    <form>
        <label for="search">Search Products:</label>
        <input type="text" id="search" name="search">
        <button type="submit">Search</button>
    </form>
    <ul>
        <%--        <li><a href="#">View Orders</a></li>--%>
        <%--        <li><a href="#">Add Product</a></li>--%>
    </ul>
</nav>
<main>
    <h2>Products List</h2>
    <table>
        <thead>
        <tr>
            <th>ADDING PRODUCT</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%--            <td>Product 1</td>--%>
            <%--            <td>$10.00</td>--%>
            <%--            <td>20</td>--%>
            <td>
                <form  method="post", action="AddProduct">
                    <label for="productName">Set Product Name:</label>
                    <select  id="productName" name="productName">
                        <option>AirPods</option>
                        <option>Air Jordan</option>
                        <option>t-shirt</option>
                        <option>Vin-Watch</option>
                        <option>smartWatch</option>
                        <option>Nike Air max</option>
                        <option>Perfume</option>
                        <option>AppleWatch</option>
                        <option>Watch</option>
                        <option>Camera</option>
                        <option>Gray Nike</option>
                        <option>Black lense</option>
                    </select>
                    <label for="price">Set Price:</label>
                    <input type="number" id="price" name="price">
                    <label for="quantity">Set Quantity:</label>
                    <input type="number" id="price" name="quantity">
                    <label for="category">Set Category:</label>
                    <input type="text" id="price" name="category">
                    <label for="image">Set Product Image:</label>
                    <input type="text" id="price" name="image">
                    <button type="submit">Add Product</button>
                </form>
                <%--                <form>--%>
                <%--                    <label for="quantity">Set Quantity:</label>--%>
                <%--                    <input type="number" id="quantity" name="quantity">--%>
                <%--                    <button type="submit">Update</button>--%>
                <%--                </form>--%>
                <%--                <button class="remove-btn">Remove</button>--%>
            </td>
        </tr>
        </tbody>
    </table>
    <br>
    <br>
    <br>



    <h2>Products List</h2>
    <table>
        <thead>
        <tr>
            <th>VIEW PRODUCT</th>
        </tr>
        </thead>
        <tbody>
        <tr>

            <td>
                <div >
                    <label for="productName"> Product Name:</label>
                    <span>GHVHGFG</span>
                    <label for="price">Set Price:</label>
                    <span>54</span>
                    <label for="quantity">Set Quantity:</label>
                    <span>HGGF</span>
                    <label for="category">Set Category:</label>
                    <span>CVFN</span>
                    <label for="image">Set Product Image:</label>
                    <span>VBNNV</span>

                </div>

            </td>
        </tr>
        </tbody>
    </table>



    <br>
    <br>
    <table>
        <thead>
        <tr>
            <th>REMOVING PRODUCT</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%--            <td>Product 1</td>--%>
            <%--            <td>$10.00</td>--%>
            <%--            <td>20</td>--%>
            <td>
                <form  method="post", action="AdminRemoveServlet">
                    <label for="productID">Remove Product:</label>
                    <input type="number" id="productID" name="productID">
                    <button type="submit">Remove Product</button>
                </form>
                <%--                <form>--%>
                <%--                    <label for="quantity">Set Quantity:</label>--%>
                <%--                    <input type="number" id="quantity" name="quantity">--%>
                <%--                    <button type="submit">Update</button>--%>
                <%--                </form>--%>
                <%--                <button class="remove-btn">Remove</button>--%>
            </td>
        </tr>
        </tbody>
    </table>
    <br>
    <br>
    <br>
    <table>
        <thead>
        <tr>
            <th>UPDATE PRODUCT</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%--            <td>Product 1</td>--%>
            <%--            <td>$10.00</td>--%>
            <%--            <td>20</td>--%>
            <td>
                <form method="post", action="AddProduct">
                    <label for="productID">Set New Price:</label>
                    <input type="number" id="price" name="price">
                    <label for="productID">Set New Quantity:</label>
                    <input type="number" id="productID" name="productID">
                    <button type="submit">Update Product</button>
                </form>
                <%--                <form>--%>
                <%--                    <label for="quantity">Set Quantity:</label>--%>
                <%--                    <input type="number" id="quantity" name="quantity">--%>
                <%--                    <button type="submit">Update</button>--%>
                <%--                </form>--%>
                <%--                <button class="remove-btn">Remove</button>--%>
            </td>
        </tr>
        </tbody>
    </table>

</main>
</body>
</html>