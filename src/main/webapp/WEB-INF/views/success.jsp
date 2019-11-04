<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@page isELIgnored="false" %>
<!--该设置代表在本jsp中使用el表达式，可以解析其中的值。
若isELIgnored设置为true，代表在本页不使用el表达式，当做字符串解析出来显示。
jsp中EL表达式不起作用的问题
问题在于web.xml版本，2.3之前默认不能解析，2.4以后默认可以解析
-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>


    <!--使用js处理post请求到delete请求-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                var href = $(this).attr("href");
                $("form").attr("action", href).submit();
                return false;
            });
        })
    </script>

</head>
<body>


<form action="" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
</form>

<h4>Success Page</h4>

    ${requestScope.student.stuNo}
    ${requestScope.student.stuName}
    ${requestScope.student.stuAge}
<br>
    <c:if test="${empty students}">
        查询结果为空
    </c:if>
    <c:if test="${!empty students}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>stuNo</th>
                <th>stuName</th>
                <th>stuAge</th>
                <th>stuRegTime</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${students}" var="stu">
                <tr>
                    <td>${stu.stuNo}</td>
                    <td>${stu.stuName}</td>
                    <td>${stu.stuAge}</td>
                    <td>${stu.stuRegTime}</td>
                    <td><a href="stu/${stu.stuNo}">Edit</a></td>
                    <td><a class="delete" href="stu/${stu.stuNo}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

<br>

    <a href="addstu">Add New Student</a>

<!--
    <form action="testFileUpload" method="post" enctype="multipart/form-data">
        file:<input type="file" name="file"/>
        desc:<input type="text" name="desc"/>
        <input type="submit" value="Submit"/>
    </form>

-->




</body>
</html>
