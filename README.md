Sure! Here's the README with instructions for using the API with **Postman** in **English**.

---

## Instructions for Using the API with Postman

### 1. **Setup**
- Make sure your API is running (either on `localhost` or your preferred server).
- Install **Postman** if you haven't already: [Download Postman](https://www.postman.com/downloads/).

### 2. **Setting Up Postman**
Open **Postman** and follow the steps below to interact with your API:

---

### 3. **Get All Products** (GET)
- **URL**: `http://localhost:8080/api/products`
- **HTTP Method**: `GET`
- **Description**: This request will return all the products stored in your application.
- **Steps**:
    1. Open Postman.
    2. Select the `GET` method.
    3. Enter the URL `http://localhost:8080/api/products` in the address bar.
    4. Click **Send**.
- **Response**:
    - Status: `200 OK`
    - Body: The list of products (if there are products added).

---

### 4. **Add a New Product** (POST)
- **URL**: `http://localhost:8080/api/products`
- **HTTP Method**: `POST`
- **Description**: This request adds a new product.
- **Body** (Example JSON for a product):
  ```json
  {
    "id": 1,
    "name": "New Product",
    "price": 100.5
  }
  ```
- **Steps**:
    1. Open Postman.
    2. Select the `POST` method.
    3. Enter the URL `http://localhost:8080/api/products` in the address bar.
    4. Go to the **Body** tab, select the `raw` option, and choose `JSON` from the dropdown.
    5. Add the JSON data for the product.
    6. Click **Send**.
- **Response**:
    - Status: `201 Created`
    - Body: `"Product has been added successfully"`

---

### 5. **Update an Existing Product** (PUT)
- **URL**: `http://localhost:8080/api/products/{id}`
    - Replace `{id}` with the ID of the product you want to update.
- **HTTP Method**: `PUT`
- **Description**: This request updates an existing product based on the ID specified in the URL.
- **Body** (Example JSON for updating a product):
  ```json
  {
    "name": "Updated Product",
    "price": 150.75
  }
  ```
- **Steps**:
    1. Open Postman.
    2. Select the `PUT` method.
    3. Enter the URL `http://localhost:8080/api/products/{id}` (replace `{id}` with the actual product ID).
    4. Go to the **Body** tab, select the `raw` option, and choose `JSON` from the dropdown.
    5. Add the JSON with the updated `name` and `price` values.
    6. Click **Send**.
- **Response**:
    - Status: `200 OK`
    - Body: `"Product has been updated successfully"`

---

### 6. **Delete a Product** (DELETE)
- **URL**: `http://localhost:8080/api/products/{id}`
    - Replace `{id}` with the ID of the product you want to delete.
- **HTTP Method**: `DELETE`
- **Description**: This request deletes a product based on the provided ID.
- **Steps**:
    1. Open Postman.
    2. Select the `DELETE` method.
    3. Enter the URL `http://localhost:8080/api/products/{id}` (replace `{id}` with the product ID to delete).
    4. Click **Send**.
- **Response**:
    - If the product was deleted:
        - Status: `200 OK`
        - Body: `"Product has been deleted successfully"`
    - If the product was not found:
        - Status: `404 Not Found`
        - Body: `"Product with ID {id} not found"`

---

### 7. **Full Example Usage**:
Let’s assume you want to add a product with ID `1`, then update it and delete it.

1. **Add Product**:
    - Method: `POST`
    - URL: `http://localhost:8080/api/products`
    - Body:
      ```json
      {
        "id": 1,
        "name": "Product 1",
        "price": 50.0
      }
      ```

2. **Update Product**:
    - Method: `PUT`
    - URL: `http://localhost:8080/api/products/1`
    - Body:
      ```json
      {
        "name": "Updated Product 1",
        "price": 75.0
      }
      ```

3. **Delete Product**:
    - Method: `DELETE`
    - URL: `http://localhost:8080/api/products/1`

---
