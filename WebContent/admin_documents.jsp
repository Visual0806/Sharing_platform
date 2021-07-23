<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:directive.page import="com.entity.Document" />

<%! String username;
	Document[] u = new Document[100];
%>
<%		Cookie[] cookies = request.getCookies();
		if(cookies != null)
			for(Cookie c : cookies){
				String name = c.getName();//获取Cookie名称
				if(name.equals("username")){
					username = c.getValue();
                }
			}
		u = (Document[])request.getAttribute("document");
%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>学习资料分享平台</title>
  <link rel="stylesheet" href="./layui/css/layui.css" media="all">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
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
	  </li>
	</ul>
   </div>
    

  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->  
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      	<li class="layui-nav-item layui-this">
          	<a href="javascript:;">文档审核</a>
        </li>
        <li class="layui-nav-item">
          	<a href="admin_comments.jsp">评论审核</a>
        </li>
	  	
      </ul>
    </div>
  </div>

  <div class="layui-body">
  <table class="layui-hide" id="test" lay-filter="test"></table>
 
	<script type="text/html" id="toolbarDemo">
  		<div class="layui-btn-container">
    		<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    		<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
   		 	<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
  		</div>
	</script>
	         
	<script src="./layui/layui.js" charset="utf-8"></script>
  	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  table.render({
		    elem: '#test'
		    ,url:'/test/table/demo1.json'
		    ,cols: [[
		      {field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
		      ,{field:'doctitle', title:'资料名', width:500}
		      ,{field:'username', title:'发布人', width:120}
		      ,{field:'publishtime', title:'发布时间', width:150}
		    ]]
		    ,page: true
		  });
		  
		  //监听行单击事件（双击事件为：rowDouble）
		  table.on('row(test)', function(obj){
		    var data = obj.data;
		    
		    layer.alert(JSON.stringify(data), {
		      title: '当前行数据：'
		    });
		    
		    //标注选中样式
		    obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		  });
		  
		});
	</script>
	
	
	
  </div>

</div>

<script src="./layui/layui.js"></script>
</body>
</html>
