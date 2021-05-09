<%--
  Created by IntelliJ IDEA.
  User: xu960
  Date: 2020/11/10
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
            request.getContextPath()+"/";
%>
<html>
<head>
    <title>index</title>
    <base href="<%=basePath%>" />
</head>
<body>
<div align="center">
    <h2>学生信息管理</h2>
        <table>
            <tr>
                <td><a href="addStudent.jsp">添加学生信息</a></td>
            </tr>
            <tr>
                <td><a href="listAllStudents.jsp">查看所有学生信息</a></td>
            </tr>
            <tr>
                <td><a href="showStudent.jsp">ID查询学生信息</a></td>
            </tr>
            <tr>
                <td><a href="removeStudent.jsp">删除学生信息</a></td>
            </tr>
            <tr>
                <td><a href="modifyStudent.jsp">更新学生信息</a></td>
            </tr>

        </table>
</div>

</body>
</html>
