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
  <title>学习资料分享平台</title>
  <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
 <!-- 头部区域（可配合layui已有的水平导航） -->
    <div class="layui-logo">学习资料分享平台(管理员)</div>
    <ul class="layui-nav layui-layout-right">
	  <li class="layui-nav-item">
	    <a href=""><i class="layui-icon layui-icon-username "></i><%=username%></a>
	    <dl class="layui-nav-child">
	      <dd><a href="javascript:;">修改信息</a></dd>
	      <dd><a href="javascript:;">安全管理</a></dd>
	      <dd><a href="javascript:;">退出</a></dd>
	    </dl>
   </div>
    

	

  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->  
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      	<li class="layui-nav-item">
          	<a href="admin_documents.jsp">文档审核</a>
        </li>
        <li class="layui-nav-item layui-this">
          	<a href="javascript:;">评论审核</a>
        </li>
	  	
      </ul>
    </div>
  </div>

  <div class="layui-body">
  </div>

</div>

<script src="./layui/layui.js"></script>
</body>
</html>
