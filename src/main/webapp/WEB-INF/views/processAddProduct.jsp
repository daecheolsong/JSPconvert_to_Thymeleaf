<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="jspbook.jspbook.dto.Product" %>
<%@ page import="jspbook.jspbook.repository.ProductRepository" %>

<%
        request.setCharacterEncoding("utf-8");

        String productId = request.getParameter("productId");
        String name = request.getParameter("name");
        String unitPrice = request.getParameter("unitPrice");
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");
        String category = request.getParameter("category");
        String unitsInStock = request.getParameter("unitsInStock");
        String condition = request.getParameter("condition");

        Integer price;

        if (unitPrice.isEmpty()) {
            price = 0;
        }
        else {
            price = Integer.valueOf(unitPrice);
        }

        long stock;

        if (unitsInStock.isEmpty()) {
            stock = 0;
        }
        else
            stock = Long.valueOf(unitsInStock);

        ProductRepository dao = ProductRepository.getInstance();

        Product newProduct = new Product();

        newProduct.setProductId(productId);
        newProduct.setCondition(condition);
        newProduct.setCategory(category);
        newProduct.setManufacturer(manufacturer);
        newProduct.setDescription(description);
        newProduct.setUnitsInStock(stock);
        newProduct.setPname(name);
        newProduct.setUnitPrice(price);

        dao.addProduct(newProduct);

        response.sendRedirect("./products.jsp");

        %>

