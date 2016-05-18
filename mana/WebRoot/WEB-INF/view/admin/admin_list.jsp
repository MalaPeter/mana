<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jeui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jeui/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>jeui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jeui/jquery.easyui.min.js"></script>

  </head>
  
  <body>
    <div id="p" class="easyui-panel" title="搜索用户" style="width:800px;height:80px;padding:10px;">
		<table cellpadding="5">
			<tr>
				<td>用户名称：</td> 
				<td><input class="easyui-textbox" type="text" id="snickname" name="snickname"></input></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" onclick="search1();">搜索</a></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" onclick="add_open();">添加用户</a></td>
			</tr>
		</table>
	</div>
	<div id="p" class="easyui-panel" title="用户列表" style="width:800px;height:700px;">
		<table id="dg" title="用户列表" style="width:700px;height:250px" data-options="rownumbers:true,singleSelect:true,pagination:true">
			
		</table>
	</div>
	<!-- 输出对话框 新建用户 -->
	<div id="dlg_add" class="easyui-dialog" title="添加用户" style="width:500px;height:400px;padding:10px;font-size: 10px"
			data-options="buttons: [{text:'取消',iconCls:'icon-ok',handler:function(){$('#dlg_add').dialog('close');}}]">
		<table style="font-size: 10px" border="1">
			<tr>
				<td>登陆账号：</td>
				<td><input class="easyui-textbox" type="text" id="adminname" name="adminname"></input></td>
				<td>登陆密码：</td>
				<td><input class="easyui-textbox" type="text" id="adminpass" name="adminpass"></input></td>
			</tr>
			<tr>
				<td>用户部门：</td>
				<td>
					<select class="easyui-combobox" id="department" name="department" style="width: 150px">
    					<option value="业务部">1.业务部</option>
    					<option value="客服部">2.客服部</option>
    					<option value="财务部">3.财务部</option>
    					<option value="数据部">4.数据部</option>
    					<option value="办公室">5.办公室</option>
    					<option value="系统管理">6.系统管理</option>
    				</select>
				</td>
				<td>用户姓名：</td>
				<td><input class="easyui-textbox" type="text" id="nickname" name="nickname"></input></td>
			</tr>
			<tr>
				<td>浏览 权：</td>
				<td id="tdrliulan" colspan="3">
					<input type="radio" id="rliulan" name="rliulan" value="0">无权
					<input type="radio" id="rliulan" name="rliulan" value="1" checked="checked">本账户
					<input type="radio" id="rliulan" name="rliulan" value="2">全账户
				</td>
			</tr>
			<tr>
				<td>录入 权：</td>
				<td id="tdrluru" colspan="3">
					<input type="radio" id="rluru" name="rluru" value="0">无权
					<input type="radio" id="rluru" name="rluru" value="1" checked="checked">本账户
				</td>
			</tr>
			<tr>
				<td>审核 权：</td>
				<td id="tdrshenhe" colspan="3">
					<input type="radio" id="rshenhe" name="rshenhe" value="0" checked="checked">无权
					<input type="radio" id="rshenhe" name="rshenhe" value="1">全账户
				</td>
			</tr>
			<tr>
				<td>财务 权：</td>
				<td id="tdrhuakuan" colspan="3">
					<input type="radio" id="rhuakuan" name="rhuakuan" value="0" checked="checked">无权
					<input type="radio" id="rhuakuan" name="rhuakuan" value="1">全账户
				</td>
			</tr>
			<tr>
				<td>停播 权：</td>
				<td id="tdrtingbo" colspan="3">
					<input type="radio" id="rtingbo" name="rtingbo" value="0" checked="checked">无权
					<input type="radio" id="rtingbo" name="rtingbo" value="1">全账户
				</td>
			</tr>
			<tr>
				<td>统计 权：</td>
				<td id="tdrtongji" colspan="3">
					<input type="radio" id="rtongji" name="rtongji" value="0" checked="checked">无权
					<input type="radio" id="rtongji" name="rtongji" value="1">全账户
				</td>
			</tr>
			<tr>
				<td>审批 权：</td>
				<td id="tdrshenpi" colspan="3">
					<input type="radio" id="rshenpi" name="rshenpi" value="0" checked="checked">无权
					<input type="radio" id="rshenpi" name="rshenpi" value="1">全账户
				</td>
			</tr>
			<tr>
				<td>账户锁定：</td>
				<td id="tdislock" colspan="3">
					<input type="radio" id="islock" name="islock" value="true">是
					<input type="radio" id="islock" name="islock" value="false" checked="checked">否
				</td>
			</tr>
			<tr>
				<td colspan="4" align="right"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="add();">添加用户</a></td>
			</tr>
		</table>
	</div>
	<!-- 输出对话框 编辑用户 -->
	<div id="dlg_edit" class="easyui-dialog" title="编辑用户" style="width:500px;height:400px;padding:10px"
			data-options="buttons: [{text:'取消',iconCls:'icon-ok',handler:function(){$('#dlg_edit').dialog('close');}}]">
		<table style="font-size: 10px" border="1">
			<tr>
				<td>登陆账号：</td>
				<td><input class="easyui-textbox" type="text" id="eadminname" name="eadminname"></input></td>
				<td>登陆密码：</td>
				<td><input class="easyui-textbox" type="text" id="eadminpass" name="eadminpass"></input></td>
			</tr>
			<tr>
				<td>用户部门：</td>
				<td>
					<select class="easyui-combobox" id="edepartment" name="edepartment" style="width: 150px">
    					<option value="业务部">1.业务部</option>
    					<option value="客服部">2.客服部</option>
    					<option value="财务部">3.财务部</option>
    					<option value="数据部">4.数据部</option>
    					<option value="办公室">5.办公室</option>
    					<option value="系统管理">6.系统管理</option>
    				</select>
				</td>
				<td>用户姓名：</td>
				<td><input class="easyui-textbox" type="text" id="enickname" name="nickname"></input></td>
			</tr>
			<tr>
				<td>浏览 权：</td>
				<td id="tderliulan" colspan="3">
					<input type="radio" id="erliulan" name="erliulan" value="0">无权
					<input type="radio" id="erliulan" name="erliulan" value="1">本账户
					<input type="radio" id="erliulan" name="erliulan" value="2">全账户
				</td>
			</tr>
			<tr>
				<td>录入 权：</td>
				<td id="tderluru" colspan="3">
					<input type="radio" id="erluru" name="erluru" value="0">无权
					<input type="radio" id="erluru" name="erluru" value="1">本账户
				</td>
			</tr>
			<tr>
				<td>审核 权：</td>
				<td id="tdershenhe" colspan="3">
					<input type="radio" id="ershenhe" name="ershenhe" value="0">无权
					<input type="radio" id="ershenhe" name="ershenhe" value="1">全账户
				</td>
			</tr>
			<tr>
				<td>财务 权：</td>
				<td id="tderhuakuan" colspan="3">
					<input type="radio" id="erhuakuan" name="erhuakuan" value="0">无权
					<input type="radio" id="erhuakuan" name="erhuakuan" value="1">全账户
				</td>
			</tr>
			<tr>
				<td>停播 权：</td>
				<td id="tdertingbo" colspan="3">
					<input type="radio" id="ertingbo" name="ertingbo" value="0">无权
					<input type="radio" id="ertingbo" name="ertingbo" value="1">全账户
				</td>
			</tr>
			<tr>
				<td>统计 权：</td>
				<td id="tdertongji" colspan="3">
					<input type="radio" id="ertongji" name="ertongji" value="0">无权
					<input type="radio" id="ertongji" name="ertongji" value="1">全账户
				</td>
			</tr>
			<tr>
				<td>审批 权：</td>
				<td id="tdershenpi" colspan="3">
					<input type="radio" id="ershenpi" name="ershenpi" value="0">无权
					<input type="radio" id="ershenpi" name="ershenpi" value="1">全账户
				</td>
			</tr>
			<tr>
				<td>账户锁定：</td>
				<td id="tdeislock" colspan="3">
					<input type="radio" id="eislock" name="eislock" value="true">是
					<input type="radio" id="eislock" name="eislock" value="false">否
				</td>
			</tr>
			<tr>
				<td colspan="4" align="right"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="edit();">修改用户</a></td>
			</tr>
		</table>
	</div>
  </body>
<script type="text/javascript">
$(document).ready(function() { 
	$('#dlg_add').dialog('close');
	$('#dlg_edit').dialog('close');
	
	getdata("admin/admin_listdata");
	function getdata(url) {
		var datagrid;  
		var rowEditor=undefined;
		datagrid=$("#dg").datagrid({  
	        url:url,//加载的URL  
	        isField:"id",  
	        pagination:false,//显示分页  
	        pageSize:20,//分页大小  
	        pageList:[20],//每页的个数  
	        fit:true,//自动补全  
	        fitColumns:true,  
	        iconCls:"icon-save",//图标  
	        title:"数据列表 -> 只显示50条数据，更多数据请根据“用户姓名”查询！双击行进编辑用户。",  
	        columns:[[      //每个列具体内容  
		        {field:'id',title:'编号',width:40,align:'center'},
		        {field:'nickname',title:'用户姓名',width:150,align:'center'},
		        {field:'department',title:'工作部门',width:150,align:'center'},  
		        {field:'adminname',title:'登陆账号',width:150,align:'center'},
		        {field:'adminpass',title:'登陆密码',width:150,align:'center'},     
		        {field:'ip',title:'登记地址',width:150,align:'center'},
		        {field:'islock',title:'停用',width:60,align:'center',formatter:function(value){
					if(value == "true")
					return '是';
					else
					return '否';
		        }},
	        ]],
	        onDblClickRow: function (index, row) {
	        	$("#eadminname").textbox('setValue',row.adminname);
	        	$("#eadminpass").textbox('setValue',row.adminpass);
	        	$("#enickname").textbox('setValue',row.nickname);
	        	$('#edepartment').combobox('select',row.department);
			    $(":radio[name='erliulan'][value='"+row.rliulan+"']").attr("checked",'checked');
			    $(":radio[name='erluru'][value='"+row.rluru+"']").attr("checked",'checked');
			    $(":radio[name='ershenhe'][value='"+row.rshenhe+"']").attr("checked",'checked');
			    $(":radio[name='erhuakuan'][value='"+row.rhuakuan+"']").attr("checked",'checked');
			    $(":radio[name='ertingbo'][value='"+row.rtingbo+"']").attr("checked",'checked');
			    $(":radio[name='ertongji'][value='"+row.rtongji+"']").attr("checked",'checked');
			    $(":radio[name='ershenpi'][value='"+row.rshenpi+"']").attr("checked",'checked');
			    $(":radio[name='eislock'][value='"+row.islock+"']").attr("checked",'checked');
			    id = row.id;
	        	$('#dlg_edit').dialog('open');
	        },
	   });
	}
});
function search1() {
	$.ajax({
	    type : "POST",
	    url : "<%=request.getContextPath()%>/admin/admin_search",
	    data : {
	      'nickname' : $("#snickname").val(),
	     },
	    dataType: "json",
	    success : function(data) {
	    	$('#dg').datagrid('loadData', data); //将数据绑定到datagrid
	    },
	    error :function(){
	    	alert('数据格式错误');
	    }
	});
}
var id = 0;
function add_open() {
	$('#dlg_add').dialog('open');
}
function add() {
	$.ajax({
	    type : "POST",
	    url : "<%=request.getContextPath()%>/admin/admin_add",
	    data : {
	      'adminname' : $("#adminname").val(),
	      'adminpass' : $("#adminpass").val(),
	      'nickname' : $("#nickname").val(),
	      'department' : $('#department').combobox('getValue'),
	      'rliulan' : $('#tdrliulan input[name="rliulan"]:checked ').val(),
	      'rluru' : $('#tdrluru input[name="rluru"]:checked ').val(),
	      'rshenhe' : $('#tdrshenhe input[name="rshenhe"]:checked ').val(),
	      'rhuakuan' : $('#tdrhuakuan input[name="rhuakuan"]:checked ').val(),
	      'rtingbo' : $('#tdrtingbo input[name="rtingbo"]:checked ').val(),
	      'rtongji' : $('#tdrtongji input[name="rtongji"]:checked ').val(),
	      'rshenpi' : $('#tdrshenpi input[name="rshenpi"]:checked ').val(),
	      'islock' : $('#tdislock input[name="islock"]:checked ').val()
	     },
	    dataType: "json",
	    success : function(data) {
	    	alert('添加成功');
	    	$('#dlg_add').dialog('close');
	    	$('#dg').datagrid('loadData', data); //将数据绑定到datagrid
	    },
	    error :function(){
	    	alert('数据格式错误');
	    }
	});
	$('#dlg_add').dialog('close');
}
function edit() {
	$.ajax({
	    type : "POST",
	    url : "<%=request.getContextPath()%>/admin/admin_edit",
	    data : {
	      'id' : id,
	      'adminname' : $("#eadminname").val(),
	      'adminpass' : $("#eadminpass").val(),
	      'nickname' : $("#enickname").val(),
	      'department' : $('#edepartment').combobox('getValue'),
	      'rliulan' : $('#tderliulan input[name="erliulan"]:checked ').val(),
	      'rluru' : $('#tderluru input[name="erluru"]:checked ').val(),
	      'rshenhe' : $('#tdershenhe input[name="ershenhe"]:checked ').val(),
	      'rhuakuan' : $('#tderhuakuan input[name="erhuakuan"]:checked ').val(),
	      'rtingbo' : $('#tdertingbo input[name="ertingbo"]:checked ').val(),
	      'rtongji' : $('#tdertongji input[name="ertongji"]:checked ').val(),
	      'rshenpi' : $('#tdershenpi input[name="ershenpi"]:checked ').val(),
	      'islock' : $('#tdeislock input[name="eislock"]:checked ').val()
	     },
	    dataType: "json",
	    success : function(data) {
	    	alert('修改成功');
	    	$('#dlg_edit').dialog('close');
	    	$('#dg').datagrid('loadData', data); //将数据绑定到datagrid
	    },
	    error :function(){
	    	alert('数据格式错误');
	    }
	});
	$('#dlg_edit').dialog('close');
}
</script>
</html>
