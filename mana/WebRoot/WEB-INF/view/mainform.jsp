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
	href="<%=basePath%>jeui/themes/IconExtension.css">
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
		<script type="text/javascript">
			function jump(id,menu,ager,url) {//按钮ID、功能名称、权限、地址
				flag = false;
				switch(menu) {
					case "shenpi":
						switch(ager) {
							case 0: alert("访问权限受限!");break;
							case 1: flag = true;$('#'+id+'').attr("href",url);break;
						}
					break;
					case "yewu":
						switch(ager) {
							case 0: alert("访问权限受限!");break;
							case 1: flag = true;$('#'+id+'').attr("href",url);break;
						}
					break;
					case "liulan":
						switch(ager) {
							case 0: alert("访问权限受限!");break;
							case 1: alert("访问权限受限!");break;
							case 2: flag = true;$('#'+id+'').attr("href",url);break;
						}
					break;
					case "kefu":
						switch(ager) {
							case 0: alert("访问权限受限!");break;
							case 1: flag = true;$('#'+id+'').attr("href",url);break;
						}
					break;
					case "caiwu":
						switch(ager) {
							case 0: alert("访问权限受限!");break;
							case 1: flag = true;$('#'+id+'').attr("href",url);break;
						}
					break;
					case "shuju":
						switch(ager) {
							case 0: alert("访问权限受限!");break;
							case 1: flag = true;$('#'+id+'').attr("href",url);break;
						}
					break;
					case "sys":
						switch(ager) {
							case 0: alert("访问权限受限!");break;
							case 1: flag = true;$('#'+id+'').attr("href",url);break;
						}
					break;
				}
				return flag;
			}
		</script>
	</div>
	<div region="south" style="height: 20px; background: #D2E0F2;">
		<div style="text-align: center; font-weight: bold">吉林人民广播电台 经营中心 核算管理系统 V1.0.1 Bate 2016</div>
	</div>
	<div region="west" split="true" title="导航菜单"
		style="width: 180px;overflow:hidden;" icon="icon-redo">
		<div id="menu" class="easyui-accordion" fit="true" border="false">
			<div id="shenpi" title="合同审批" style="overflow:auto; padding: 10px;" icon="icon-edit">
				<div title="合同审批">
					<ul>
						<li>
							<div>
								<a id="m1" data-options="iconCls:'icon-key_add',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m1','shenpi',<%=ad.getRshenpi()%>,'shenpi/PP_index')">审批-品牌(PP)</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div id="yewu" title="业务部" style="overflow:auto; padding: 10px;"
				icon="icon-edit">
				<div title="业务部">
					<ul>
						<li>
							<div>
								<a id="m2" data-options="iconCls:'icon-add',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m2','yewu',<%=ad.getRluru()%>,'yewu/qianzhiyewuindex')">前置业务录入</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m3" data-options="iconCls:'icon-06',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m3','yewu',<%=ad.getRluru()%>,'yewu/qianzhiyewulist')">前置业务列表</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m4" data-options="iconCls:'icon-key_add',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m4','liulan',<%=ad.getRliulan()%>,'yewu/qianzhiyewushenpi')">前置业务审批</a>
							</div>
						</li>
						
						<li>
							<div>
								<a id="m13" data-options="iconCls:'icon-add',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m13','yewu',<%=ad.getRluru()%>,'yewu_daili/index')">录入-代理(DL)</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m15" data-options="iconCls:'icon-add',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m15','yewu',<%=ad.getRluru()%>,'yewu_pinpai/index')">录入-品牌(PP)</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m17" data-options="iconCls:'icon-add',toggle:true" class="easyui-linkbutton" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m17','yewu',<%=ad.getRluru()%>,'yewu_zanzhu/index')">录入-赞助(ZZ)</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m19" data-options="iconCls:'icon-add',toggle:true" class="easyui-linkbutton" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m19','yewu',<%=ad.getRluru()%>,'yewu_taobo/index')">录入-套播(TB)</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m14" data-options="iconCls:'icon-06',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m14','yewu',<%=ad.getRluru()%>,'yewu_daili/list')">管理-代理(DL)</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m16" data-options="iconCls:'icon-06',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m16','yewu',<%=ad.getRluru()%>,'yewu_pinpai/list')">管理-品牌(PP)</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m18" data-options="iconCls:'icon-06',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m18','yewu',<%=ad.getRluru()%>,'yewu_zanzhu/list')">管理-赞助(ZZ)</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m20" data-options="iconCls:'icon-06',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m20','yewu',<%=ad.getRluru()%>,'yewu_taobo/list')">管理-套播(TB)</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m5" data-options="iconCls:'icon-add',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m5','yewu',<%=ad.getRluru()%>,'yewu/htchuanmeiindex')">录入-样本</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m6" data-options="iconCls:'icon-06',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m6','yewu',<%=ad.getRluru()%>,'yewu/htchuanmeilist')">管理-样本</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div id="kefu" title="客服部" style="padding: 10px;" icon="icon-edit">
				<div title="客服部">
					<ul>
						<li>
							<div>
								<a id="m7" data-options="iconCls:'icon-key_add',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m7','kefu',<%=ad.getRshenhe()%>,'kefu/kfshenheindex')">审核-品牌(PP)</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m8" data-options="iconCls:'icon-2012081511202',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m8','kefu',<%=ad.getRshenhe()%>,'kefu/Print_list')">打印-品牌(PP)</a>
							</div>
						</li>
						<li>
							<div>
								<a id="m9" data-options="iconCls:'icon-01',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m9','kefu',<%=ad.getRtingbo()%>,'working.jsp')">停播</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div id="caiwu" title="财务部" style="padding: 10px;" icon="icon-edit">
				<div title="财务部">
					<ul>
						<li>
							<div>
								<a id="m10" data-options="iconCls:'icon-calculator',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m10','caiwu',<%=ad.getRhuakuan()%>,'working.jsp')">账务审核</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div id="shuju" title="数据部" style="padding: 10px;" icon="icon-edit">
				<div title="数据部">
					<ul>
						<li>
							<div>
								<a id="m11" data-options="iconCls:'icon-chart_curve_add',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m11','shuju',<%=ad.getRtongji()%>,'working.jsp')">数据统计</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div id="sys" title="系统管理" style="padding: 10px;" icon="icon-edit">
				<div title="系统管理">
					<ul>
						<li>
							<div>
								<a id="m12" data-options="iconCls:'icon-03',toggle:true" class="easyui-linkbutton" target="mainFrame" href="#" onclick="return jump('m12','sys',<%=ad.getRsys()%>,'admin/admin_list')">用户管理</a>
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