<%--
  Created by IntelliJ IDEA.
  User: xu960
  Date: 2021/5/9
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生信息</title>
</head>
<body>
<div align="center">
    <hr/>
    <h3>删除学生信息</h3>
    <form action="${pageContext.request.contextPath}/student/removeStudent.do" method="post">
        <table>
            <tr>
                <td>学生id:</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type="submit" value="删除"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
