<!DOCTYPE html>
<html lang="en">

<head>
  <title>Admin Pannel</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/netmeds.css">
  <script src="<%=request.getContextPath()%>/js/jquery-3.6.4.js"></script>
</head>

<style>
  form {
    max-width: 400px;
    margin: 0 auto;
  }

  label,
  input {
    display: block;
    margin-bottom: 10px;
  }

  button {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 10px 20px;
    cursor: pointer;
  }

  .error-message {
    color: red;
    margin-top: 5px;
  }
</style>

<body>
  <div class="wrapper">
    <!-- --------------------Header Start------------------ -->
    <jsp:include page="header.jsp" />
    <!-- --------------------Header Ends------------------ -->

    <h2>Add Product</h2>
    <form action="<%=request.getContextPath()%>/loginRegistration">
      <label for="file">Product Image:</label>
      <input type="file" id="file" name="image">

      <label for="product_name">Product Name:</label>
      <input type="text" id="product_name" name="product_name">

      <label for="description">Description:</label>
      <textarea id="description" name="description"></textarea>

      <label for="manufacturer">Manufacturer:</label>
      <input type="text" id="manufacturer" name="manufacturer">

      <label for="price">Price:</label>
      <input type="text" id="price" name="price">

      <label for="stock">Stock:</label>
      <input type="text" id="stock" name="stock">

      <label for="categories">Categories:</label>
      <select id="categories" name="categories">
        <option value="1">Medicine</option>
        <option value="2">Wellness</option>
        <option value="3">Beauty</option>
        <option value="4">Health Care</option>
      </select>

      <input type="hidden" value="admin" name="checkForm">

      <button type="submit" value="Add Product">Add Product</button>
    </form>

    <!-- -----------------------Footer Start-------------------- -->
    <jsp:include page="footer.jsp" />
    <!-- -----------------------Footer End--------------------- -->
  </div>
</body>

</html>
