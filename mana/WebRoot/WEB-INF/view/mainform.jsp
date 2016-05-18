<%@page import="com.mana.pojo.Admins"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jeui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jeui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>jeui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jeui/jquery.easyui.min.js"></script>
<style type="text/css">
.easyui-accordion ul {
	list-style-type: none;
	margin: 0px;
	padding: 10px;
}

.easyui-accordion ul li {
	padding: 0px;
}

.easyui-accordion ul li a {
	line-height: 24px;
}

.easyui-accordion ul li div {
	margin: 2px 0px;
	padding-left: 10px;
	padding-top: 2px;
}

.easyui-accordion ul li div.hover {
	border: 1px dashed #99BBE8;
	background: #E0ECFF;
	cursor: pointer;
}

.easyui-accordion ul li div.hover a {
	color: #416AA3;
}

.easyui-accordion ul li div.selected {
	border: 1px solid #99BBE8;
	background: #E0ECFF;
	cursor: default;
}

.easyui-accordion ul li div.selected a {
	color: #416AA3;
	font-weight: bold;
}
</style>
<script type="text/javascript">
$(function () {
    InitLeftMenu();
    $('body').layout();
})

function InitLeftMenu() {
    $('.easyui-accordion li a').click(function () {
        var tabTitle = $(this).text();
        var url = $(this).attr("href");
        addTab(tabTitle, url);
        $('.easyui-accordion li div').removeClass("selected");
        $(this).parent().addClass("selected");
    }).hover(function () {
        $(this).parent().addClass("hover");
    }, function () {
        $(this).parent().removeClass("hover");
    });
}

function addTab(subtitle, url) {
    if (!$('#tabs').tabs('exists', subtitle)) {
        $('#tabs').tabs('add', {
            title: subtitle,
            content: createFrame(url),
            closable: true,
            width: $('#mainPanle').width() - 10,
            height: $('#mainPanle').height() - 26
        });
    } else {
        $('#tabs').tabs('select', subtitle);
    }
}

function createFrame(url) {
    var s = '<iframe name="mainFrame" scrolling="no" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
    return s;
}
</script>
</head>

<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px;
            width: 100%; background: white; text-align: center;">
			<img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<div region="north" split="true"
		style="overflow: hidden; height: 30px; background: #D2E0F2 repeat-x center 50%;
        line-height: 20px; color: #ff0000;">
        <!-- 用户信息 提醒 -->
        <% Admins ad = (Admins) session.getAttribute("admin");%>
		欢迎您：<%=ad.getDepartment() %> <%=ad.getNickname() %> 
		您的权限：
		<% 
			switch(ad.getRliulan()) {
				case 0: out.print("浏览权：无权限 |"); break;
				case 1: out.print("<font color=yellow>浏览权：本账号</font> |"); break;
				case 2: out.print("<font color=green>浏览权：全部</font> |"); break;
			}
			switch(ad.getRluru()) {
				case 0: out.print("录入权：无权限  |"); break;
				case 1: out.print("<font color=green>录入权：本账户</font> |"); break;
			}
			switch(ad.getRshenhe()) {
				case 0: out.print("审核权：无权限 |"); break;
				case 1: out.print("<font color=green>审核权：全部</font> |"); break;
			}
			switch(ad.getRhuakuan()) {
				case 0: out.print("划款权：无权限 |"); break;
				case 1: out.print("<font color=green>划款权：全部</font> |"); break;
			}
			switch(ad.getRtingbo()) {
				case 0: out.print("停播权：无权限 |"); break;
				case 1: out.print("<font color=green>停播权：全部</font> |"); break;
			}
			switch(ad.getRtongji()) {
				case 0: out.print("统计权：无权限 |"); break;
				case 1: out.print("<font color=green>统计权：全部</font> |"); break;
			}
		%>
	</div>
	<div region="south" style="height: 20px; background: #D2E0F2;">
		<div style="text-align: center; font-weight: bold">吉林人民广播电台 经营中心 核算管理系统 V1.0.1 Bate 2016</div>
	</div>
	<div region="west" split="true" title="导航菜单"
		style="width: 180px;overflow:hidden;" icon="icon-redo">
		<div id="menu" class="easyui-accordion" fit="true" border="false">
			<div title="合同审批" style="overflow:auto; padding: 10px;" icon="icon-edit">
				<div title="合同审批">
					<ul>
						<li>
							<div>
								<a target="mainFrame" href="shenpi/PP_index">审批-传媒-品牌(PP)</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div title="业务部" style="overflow:auto; padding: 10px;"
				icon="icon-edit">
				<div title="业务部">
					<ul>
						<li>
							<div>
								<a target="mainFrame" href="yewu/qianzhiyewuindex">前置业务录入</a>
							</div>
						</li>
						<li>
							<div>
								<a target="mainFrame" href="yewu/qianzhiyewulist">前置业务列表</a>
							</div>
						</li>
						<li>
							<div>
								<a target="mainFrame" href="yewu/qianzhiyewushenpi">前置业务审批</a>
							</div>
						</li>
						<li>
							<div>
								<a target="mainFrame" href="yewu/htchuanmeiindex">录入-传媒-品牌(PP)</a>
							</div>
						</li>
						<li>
							<div>
								<a target="mainFrame" href="yewu/htchuanmeilist">管理-传媒-品牌(PP)</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div title="客服部" style="padding: 10px;" icon="icon-edit">
				<div title="客服部">
					<ul>
						<li>
							<div>
								<a target="mainFrame" href="kefu/kfshenheindex">审核-传媒-品牌(PP)</a>
							</div>
						</li>
						<li>
							<div>
								<a target="mainFrame" href="#">停播</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div title="财务部" style="padding: 10px;" icon="icon-edit">
				<div title="财务部">
					<ul>
						<li>
							<div>
								<a target="mainFrame" href="Product/Default.htm">账务审核</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div title="数据部" style="padding: 10px;" icon="icon-edit">
				<div title="数据部">
					<ul>
						<li>
							<div>
								<a target="mainFrame" href="Product/Default.htm">数据统计</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div title="系统管理" style="padding: 10px;" icon="icon-edit">
				<div title="系统管理">
					<ul>
						<li>
							<div>
								<a target="mainFrame" href="admin/admin_list">用户管理</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div region="center" id="mainPanle"
		style="background: #eee;overflow:hidden;">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="主页" style="padding: 20px;" id="home">
				<h1>Welcome...</h1>
				<h2>欢迎使用 吉林人民广播电台 经营中心 核算管理系统！</h2>
			</div>
		</div>
	</div>
</body>
</html>