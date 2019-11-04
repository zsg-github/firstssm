<%--
  Created by IntelliJ IDEA.
  User: zsg
  Date: 2019/8/10
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Input</title>
</head>
<%--
<form action="addstu" method="POST" />
    <input name="stuNo" />
    <input name="stuName" />
    <input name="stuAge" />
    <input type="submit" value="增加"/>
</form>
 原来的添加语句中 没有ModelAttribute,当添加后需要 在在controller里面添加一个对应的bean
 map.put("employee", new Employee());

--%>
<form:form action="${pageContext.request.contextPath }/controller/addstu"
           method="POST" modelAttribute="student">
    <c:if test="${student.stuName!=null}">
        <input type="hidden" name="_method" value="PUT"/>
    </c:if>
    stuNo:<form:input path="stuNo"/>
    <form:errors path="stuNo"></form:errors>
    <br>
    stuName:<form:input path="stuName"/>
    <form:errors path="stuName"></form:errors>
    <br>
    stuAge:<form:input path="stuAge"/>
    <form:errors path="stuAge"></form:errors>
    <br>
    stuRegTime:<form:input path="stuRegTime"/>
    <form:errors path="stuRegTime"></form:errors>
    <br>
    <input type="submit" value="增加"/>

</form:form>

    <!--
        1.数据类型转换
        2.数据类型格式化
        3.数据校验
            1)如何校验？注解？
            2)验证出错转向哪一个页面？
            3)错误消息如何显示和国际化
    -->



</body>
</html>
