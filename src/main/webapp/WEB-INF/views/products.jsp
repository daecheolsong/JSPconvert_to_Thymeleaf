<%--
  Created by IntelliJ IDEA.
  User: eocjf
  Date: 2022-03-02
  Time: 오후 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jspbook.jspbook.dto.Product" %>
<jsp:useBean id="productDAO" class="jspbook.jspbook.repository.ProductRepository" scope="session"/>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>상품목록</title>
</head>
<body>
    <jsp:include page="fragments/menu.jsp" />
    <div class="jumbotron">
        <div class="container">
            <h1 class ="display-3">상품목록</h1>
        </div>
    </div>
    <%
        ArrayList<Product> listOfProducts = productDAO.getAllProducts();
    %>
    <div class="container">
        <div class="row" align="center">
            <%
                for (int i = 0; i < listOfProducts.size(); i++) {
                    Product product = listOfProducts.get(i);
            %>
            <div class="col-md-4">
                <h3><%=product.getPname()%></h3>
                <p><%=product.getDescription()%></p>
                <p><%=product.getUnitPrice()%>원</p>
            </div>

            <%
                }
            %>
        </div>
        <hr>
    </div>
    <jsp:include page="fragments/footer.jsp"/>
</body>
</html>
