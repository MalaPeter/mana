<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="weui.css"/>


  </head>
  
  <body>
    <a href="#" class="weui_btn weui_btn_primary">按钮</a>
<a href="#" class="weui_btn weui_btn_disabled weui_btn_primary">按钮</a>
<a href="#" class="weui_btn weui_btn_warn">确认</a>
<a href="#" class="weui_btn weui_btn_disabled weui_btn_warn">确认</a>
  </body>
</html>
