<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>合同打印列表</title>
    
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
 	
    <div id="p" class="easyui-panel" title="搜索" style="width:800px;height:80px;padding:10px;">
		<table cellpadding="5">
			<tr>
				<td>客户名称：</td> 
				<td><input class="easyui-textbox" type="text" id="kehuname" name="kehuname"></input></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" onclick="search1();">搜索</a></td>
		</table>
	</div>
	<div id="p" class="easyui-panel" title="列表" style="width:800px;height:700px;">
		<table id="dg" title="当前数据列表" style="width:700px;height:250px" data-options="rownumbers:true,singleSelect:true,pagination:true">
			
		</table>
	</div>
	<div id="dlg" class="easyui-dialog" title="打印选择" style="width:230px;height:250px;padding:1px;"
			data-options="buttons: [{text:'关闭',iconCls:'icon-ok',handler:function(){$('#dlg').dialog('close');}}]">
		<table style="font-size: 10px" border="2" id="printcontent" style="border-style:none">
			<tr>
				<td colspan="2" align="center">传媒打印</td>
			</tr>
			<tr>
				<td>
					<button onclick="print_chuameiht()">打印传媒合同</button>
					<button onclick="print_chuameixp()">打印传媒小票</button>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">电台打印</td>
			</tr>
			<tr>
				<td>
					<button onclick="">打印电台合同</button>
					<button onclick="">打印电台小票</button>
				</td>
			</tr>
		</table>
	</div>
  </body>
<script type="text/javascript">
//跳转用：合同ID
var id = "-1";

$(document).ready(function() { 
	$('#dlg').dialog('close');
	
	getdata("kefu/Print_listdata");
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
	        title:"数据列表 -> 只显示最近的20条数据，更多数据请根据条件查询！双击行进行合同编辑。",  
	        columns:[[      //每个列具体内容  
		        {field:'id',title:'编号',width:30,align:'center'},     
		        {field:'username',title:'业务员',width:50,align:'center'},     
		        {field:'cdate',title:'登记时间',width:100,align:'center'},
		        {field:'kehuname',title:'客户名称',width:170,align:'center'},
		        {field:'bianhao',title:'合同编号',width:170,align:'center'},
		        {field:'price',title:'合同总额',width:170,align:'center'},
		        {field:'zhekou',title:'折扣',width:40,align:'center',formatter:function(value){
		        	if(value == "0.45") return '4.5折';
		        	if(value == "0.4") return '4折';
		        	if(value == "0.3") return '3折';
		        	if(value == "0.2") return '2折';
		        }},
		        {field:'isedit',title:'审核',width:40,align:'center',formatter:function(value){
					if(value == "true")
					return '未审';
					else
					return '通过';
		        }},
		        {field:'islock',title:'审批',width:40,align:'center',formatter:function(value){
					if(value == "true")
					return '未审';
					else
					return '通过';
		        }},
		        {field:'ispay',title:'付款',width:40,align:'center',formatter:function(value){
					if(value == "true")
					return '是';
					else
					return '否';
		        }},
		        {field:'istingbo',title:'停播',width:40,align:'center',formatter:function(value){
					if(value == "true")
					return '是';
					else
					return '否';
		        }},
	        ]],
	        onDblClickRow: function (index, row) {
	        	//A4 19MM width:649px;height:978px
	        	//弹出对话框，显示合同内容，选择打印内容
	        	id = row.id;
	        	$('#dlg').dialog('open');
	        },
	   });
	}
});
function search1() {
	$.ajax({
	    type : "POST",
	    url : "<%=request.getContextPath()%>/kefu/Print_search",
	    data : {
	      'kehuname' : $("#kehuname").val(),
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

//跳转打印 传媒合同
function print_chuameiht(){
	window.open("<%=basePath%>kefu/Print_chuanmeiht?id=" + id);
}
//跳转打印 传媒小票
function print_chuameixp(){
	window.open("<%=basePath%>kefu/Print_chuanmeihtxp?id=" + id);
}

</script>
</html>
