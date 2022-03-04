<%--
  Created by IntelliJ IDEA.
  User: eocjf
  Date: 2022-03-02
  Time: 오후 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jspbook.jspbook.dto.Product" %>
<%@ page import="jspbook.jspbook.repository.ProductRepository" %>
<html>
<head>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css"/>
    <title>제품 상세 정보</title>
</head>
<body>
    <jsp:include page="fragments/menu.jsp"/>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">상품 정보</h1>
        </div>
    </div>

    <%
        String id = request.getParameter("id");
        ProductRepository dao = ProductRepository.getInstance();
        Product product = dao.getProductById(id);
    %>

    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h3><%=product.getPname()%></h3>
                <p><%=product.getDescription()%></p>
                <p> <b>상품 코드 : <b><span class="badge badge-danger"> <%=product.getProductId()%></span> </b></b></p>
                <p> <b>제조사</b> : <%=product.getManufacturer()%></p>
                <p> <b>분류</b> : <%=product.getCategory()%></p>
                <p> <b>제고수</b> : <%=product.getUnitsInStock()%></p>
                <h4><%=product.getUnitPrice()%>원</h4>
                <p> <a href="#" class="btn btn-info">상품 주문 &raquo;</a>
                <a href="/products" class="btn btn-secondary">상품 목록 &raquo;</a>
            </div>
        </div>
    </div>
    <jsp:include page="fragments/footer.jsp"/>
</body>
</html>
