<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! String username;%>
<%		Cookie[] cookies = request.getCookies();
		if(cookies != null)
			for(Cookie c : cookies){
				String name = c.getName();//获取Cookie名称
				if(name.equals("username")){
					username = c.getValue();
                }
			}
%>
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
  	<h1>未查询到个人信息，请创建个人信息!</h1>
  	<form action="createInformation" method="post">
  		<div class="layui-form-item">
		    <label class="layui-form-label">姓名：</label>
		    <div class="layui-input-block">
		      <input type="text" name="sname" required  lay-verify="required" value=<%=username%> autocomplete="off" class="layui-input">
		    </div>
  		</div>
        <div class="layui-form-item">
		    <label class="layui-form-label">学号：</label>
		    <div class="layui-input-block">
		      <input type="text" name="sno" required  lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
		    </div>
  		</div>
        <div class="layui-form-item">
		    <label class="layui-form-label">班级：</label>
		    <div class="layui-input-block">
		      	<input type="text" name="scno" required  lay-verify="required" placeholder="请输入班级" autocomplete="off" class="layui-input">
		    </div>
  		</div>
  		<div class="layui-form-item">
		    <label class="layui-form-label">住址：</label>
		    <div class="layui-input-block">
		      <input type="text" name="saddr" required  lay-verify="required" placeholder="请输入住址" autocomplete="off" class="layui-input">
		    </div>
  		</div>
        <div class="layui-form-item">
		    <label class="layui-form-label">电话：</label>
		    <div class="layui-input-block">
		      	<input type="text" name="sphone" required  lay-verify="required" placeholder="请输入电话号码" autocomplete="off" class="layui-input">
		    </div>
  		</div>
        <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit lay-filter="formDemo">确认</button>
		    </div>
		</div>
    </form>
      
  </div>

</div>

<script src="./layui/layui.js"></script>
</body>
</html>
