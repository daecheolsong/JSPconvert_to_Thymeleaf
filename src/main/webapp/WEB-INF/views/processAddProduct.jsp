<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="jspbook.jspbook.dto.Product" %>
<%@ page import="jspbook.jspbook.repository.ProductRepository" %>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*"%>
<%@ page import="java.util.Enumeration" %>

<%
        request.setCharacterEncoding("utf-8");
        String realFolder = "C:/Users/eocjf/Desktop/images";
        int maxSize = 5 * 1024 * 1024;
        String encType = "utf-8";

        MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());


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

        Integer stock;

        if (unitsInStock.isEmpty()) {
            stock = 0;
        }
        else
            stock = Integer.valueOf(unitsInStock);

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



        Enumeration files = multi.getFileNames();
        String fname = (String) files.nextElement();
        String fName = multi.getFilesystemName(fname);

        newProduct.setFilename(fName);

        dao.addProduct(newProduct);
        response.sendRedirect("/products");


        %>

