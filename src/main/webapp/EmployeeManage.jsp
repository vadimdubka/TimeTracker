<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page
        errorPage="ErrorPage.jsp" %>  <%--Tells the Container, “If something goes wrong here, forward the request to errorPage.jsp”.--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--Вставляем header with directives--%>
    <%@include file="Header.html" %>

    <p>developersEmail:${requestScope.developersEmail}</p>
    <p>adminEmail:${requestScope.adminEmail}</p>

    <h2>Список сотрудников компании</h2>
    <table>
        <c:forEach var="employee" items="${requestScope.allEmployees}">
            <tr>
                <td><c:out value="${employee.surName}"/></td>
            </tr>
        </c:forEach>
    </table>


    <%--Вставляем footer with jsp standart actions--%>
    <jsp:include page="Footer.html"/>

    <%--<% int x = 10 / 0; %>--%><%--Для возникновения ошибки и перехода на ErrorPage.jsp--%>
</body>
</html>



