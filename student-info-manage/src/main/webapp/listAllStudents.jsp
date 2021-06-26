<%--
  Created by IntelliJ IDEA.
  User: xu960
  Date: 2021/5/9
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看所有学生信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            // 当前页面dom加载后直接查询学生信息
            loadStudentsInfo();

            // 按钮点击
            $("#reload-info-btn").click(function () {
                loadStudentsInfo();
            })
        })
        
        function loadStudentsInfo() {
            // ajax请求所有学生json信息，并添加到列表
            $.ajax({
                url:"${pageContext.request.contextPath}/student/queryAllStudents.do",   // Controllerl路由
                method:"get",
                dataType:"json",
                success:function (data) {
                    $("#info").html("");    //清除旧的数据
                    $.each(data, function (i, n) {
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("</tr>");
                    })
                }
            })
        }
    </script>
</head>
<body>

<div align="center">
    <hr/>
    <h3>查看所有学生信息</h3>
    <table>
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        </thead>
        <tbody id="info">
        </tbody>
    </table>
    <input type="button" id="reload-info-btn" value="查询学生数据">

    <form action="${pageContext.request.contextPath}/student/queryAllStudents.do" method="post">

    </form>
</div>
</body>
</html>
