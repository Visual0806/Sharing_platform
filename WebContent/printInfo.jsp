<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="com.entity.Student" />

<%
	Student u = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>学生信息管理系统</title>
  <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">学生信息管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->

  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->    
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      	<li class="layui-nav-item">
      		<a href="javascript:;">查看信息</a>
      		<dl class="layui-nav-child">
		        <form action="printInformation" method="post">
		        	<input class="layui-nav-item" type="submit" name="" value="查看个人信息">
		    	</form>
		    	<form action="searchClass" method="post">
		        	<input class="layui-nav-item" type="submit" name="" value="查看班级信息">
		    	</form>
	    	</dl>
	    </li>
        <li class="layui-nav-item">
          	<a href="alterInfo.jsp">修改个人信息</a>
        </li>
        <li class="layui-nav-item">
        	<a href="searchPhone.jsp">查找同学电话号码</a>
        </li>
        <li class="layui-nav-item">
        	<a href="searchCity.jsp">查找各城市同学信息</a>
        </li>
        <form action="logout" method="post">
	        <p><input class="layui-nav-item" type="submit" name="" value="注销账号"></p>
	  	</form>
      </ul>
    </div>
  </div>

  <div class="layui-body">
     	<table class="layui-table">
		  <colgroup>
		    <col width="150">
		    <col width="200">
		    <col>
		  </colgroup>
		  <thead>
		    <tr>
		      <th>姓名</th>
		      <th>学号</th>
		      <th>班级</th>
		      <th>住址</th>
		      <th>电话</th>
		    </tr> 
		  </thead>
		  <tbody>
		    <tr>
		      <td><%=u.getSname()%></td>
		      <td><%=u.getSno()%></td>
		      <td><%=u.getScno()%></td>
		      <td><%=u.getSaddr()%></td>
		      <td><%=u.getSphone()%></td>
		    </tr>
		  </tbody>
		</table>
  </div>

</div>

<script src="./layui/layui.js"></script>
</body>
</html>
