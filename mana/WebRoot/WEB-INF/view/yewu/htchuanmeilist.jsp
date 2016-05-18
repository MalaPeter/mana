<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>品牌广告列表-录入管理</title>
    
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
  </body>
<script type="text/javascript">
$(document).ready(function() { 
	getdata("yewu/htchuanmei_listdata");
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
	        	//alert(index +":"+row.id);
	        	self.location='yewu/htchuanmei_edit?id=' + row.id;
	        },
	   });
	}
});
function search1() {
	$.ajax({
	    type : "POST",
	    url : "<%=request.getContextPath()%>/yewu/htchuanmei_search",
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
</script>
</html>
