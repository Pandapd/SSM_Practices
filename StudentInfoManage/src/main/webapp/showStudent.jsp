<%--
  Created by IntelliJ IDEA.
  User: xu960
  Date: 2021/5/9
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ID查询学生信息</title>
</head>
<body>
<div align="center">
    <hr/>
    <h3>ID查询学生信息</h3>
    <form action="${pageContext.request.contextPath}/student/selectStudent.do" method="post">
        <table>
            <tr>
                <td>学生id:</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type="submit" value="查询"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
