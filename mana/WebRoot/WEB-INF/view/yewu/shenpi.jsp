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

<title>查看 所有/自己 前置业务</title>

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

</head>

<body>
	<div id="p" class="easyui-panel" title="搜索" style="width:800px;height:80px;padding:10px;">
		<table cellpadding="5">
			<tr>
				<td>客户名称：</td>
				<td><input class="easyui-textbox" type="text" id="kehuname" name="kehuname"></input></td>
				<td>任务类别：</td>
				<td>
					<input type="radio" id="islock" name="islock" value="-1"><span>全部</span>
					<input type="radio" id="islock" name="islock" value="0" checked="checked"><span>挂起</span>
				</td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" onclick="oncheck()">搜索</a></td>
			</tr>
		</table>
	</div>
	<div id="p" class="easyui-panel" title="列表" style="width:800px;height:700px;">
		<table id="dg" title="当前数据列表" style="width:700px;height:250px" data-options="rownumbers:true,singleSelect:true,pagination:true">
			
		</table>
	</div>
	<form id="form1" method="post">
		<!-- 输出对话框 -->
		<div id="dlg" class="easyui-dialog" title="审批详情" style="width:400px;height:460px;padding:1px"
				data-options="
					buttons: [{
						text:'通过审批',
						iconCls:'icon-ok',
						handler:function(){
							submitForm2();
						}
					},{
						text:'放弃审批',
						iconCls:'icon-cancel',
						handler:function(){
							$('#dlg').dialog('close');
						}
					}]
				">
			<table>
				<tr>
					<td>业  务  员：</td><td><div id="dlg_username"></div></td>
				</tr>
				<tr>
					<td>客户名称：</td><td><div id="dlg_kehuname"></div></td>
				</tr>
				<tr>
					<td>客户行业：</td><td><div id="dlg_hangye"></div></td>
				</tr>
				<tr>
					<td>登记时间：</td><td><div id="dlg_ctime"></div></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="radio" id="shenpi" name="shenpi" value="true"  checked="checked"><span>通过</span>
					</td>
				</tr>
				<tr>
					<td colspan="2">审批批语：</td>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="10" cols="40" id="piyu"></textarea> </td>
				</tr>
			</table>
			<input type="text" id="id" name="id" style="display:none;"/>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function() { 
			//关闭对话
			$('#dlg').dialog('close');
		});
	//未知原因 造成 值只是默认第一个。在此处做处理后 正常
	var islock;
	function oncheck(){
		var temp = document.getElementsByName("islock");
		for(var i=0;i<temp.length;i++) {
			if(temp[i].checked)
	           islock = temp[i].value;
		}
		//执行查询
		submitForm();
	}
	function submitForm() {
		$.ajax({
			    type : "POST",
			    url : "<%=request.getContextPath()%>/yewu/qianzhiyewusearch1",
			    data : {
			      'kehuname' : $("#kehuname").val(),
			      'islock' : islock,
			     },
			    dataType: "json",
			    success : function(data) {
			    	//getdata(data);
			    	//alert($("#islock").val());
			    	$('#dg').datagrid('loadData', data); //将数据绑定到datagrid
			    },
			    error :function(){
			    	alert('数据格式错误');
			    }
			});
	}
	function submitForm2() {
		$.ajax({
			    type : "POST",
			    url : "<%=request.getContextPath()%>/yewu/qianzhiyewushenpiupdate",
			    data : {
			      'id' : $("#id").val(),
			      'piyu' : $("#piyu").val(),
			      'shenpi' : $("#shenpi").val()
			     },
			    dataType: "text",
			    success : function(data) {
			    	alert('审批完成！');
			    	$('#dlg').dialog('close');
			    	//$('#dg').datagrid('loadData', data); //将数据绑定到datagrid
			    },
			    error :function(){
			    	alert('数据格式错误');
			    }
			});
	}
	//return $(this).form('enableValidation').form('validate');
	getdata("yewu/qianzhiyewulistdata");
	
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
	        title:"数据列表 -> 只显示最近的20条数据，更多数据请根据条件查询！",  
	        columns:[[      //每个列具体内容  
		        {field:'id',title:'编号',width:30,align:'center'},     
		        {field:'username',title:'业务员',width:40,align:'center'},     
		        {field:'ctime',title:'登记时间',width:100,align:'center'},
		        {field:'kehuname',title:'客户名称',width:170,align:'center'},
		        {field:'hangye',title:'客户行业',width:100,align:'center'},
		        {field:'shixiao',title:'预定时效',width:60,align:'center'},
		        {field:'shengyutianshu',title:'剩余时效',width:60,align:'center'},
		        {field:'islock',title:'挂起',width:40,align:'center',formatter:function(value){
					if(value=='0')
					return '是';
					else
					return '否';
		        }}
	        ]],
	        onClickRow: function (index, row) {
	        	$("#dlg_kehuname").html(row.kehuname);
	        	$("#dlg_hangye").html(row.hangye);
	        	$("#dlg_username").html(row.username);
	        	$("#dlg_ctime").html(row.ctime);
	        	$("#id").val(row.id);
	        	$("#piyu").val(row.piyu);
	        	$('#dlg').dialog('open');
	        	//alert(index +":"+row.id);
	        }
	   });
	}
	
</script>
</html>
