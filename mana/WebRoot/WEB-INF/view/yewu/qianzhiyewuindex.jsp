<%@page import="java.sql.Timestamp"%>
<%@page import="com.mana.pojo.Admins"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>前置业务录入</title>
    
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
  	<form id="ff" action="yewu/qianzhiyewusave" method="post" data-options="novalidate:true">
    <div id="p" class="easyui-panel" title="业务信息" style="width:800px;height:150px;padding:10px;">
		<table cellpadding="5">
			<% 
				//用户信息
				Admins ad = (Admins) session.getAttribute("admin");
				//获得当前时间
				Date date = new Date();
				Timestamp timeStamp = new Timestamp(date.getTime());
			%>
			<tr>
			<td>业务员:(不可更改)</td>
    			<td><input class="easyui-textbox" type="text" name="uname" data-options="required:true" disabled="disabled" value="<%=ad.getNickname() %>"></input></td>
    		<td>登记时间：(不可更改)</td>
    			<td><input class="easyui-textbox" type="text" name="ctime" data-options="required:true" disabled="disabled" value="<%=timeStamp %>"></input></td>
    		</tr>
    		<tr>
    		<td>登记时效：</td>
    			<td>
    				<select class="easyui-combobox" name="shixiao" style="width: 150px">
    					<option value="7">7 天</option>
    					<option value="15">15天</option>
    					<option value="30">30天</option>
    					<option value="45">45天</option>
    					<option value="60">60天</option>
    				</select>
    			</td>
    		</tr>
		</table>
	</div>
	<div id="p2" class="easyui-panel" title="客户信息" style="width:800px;height:200px;padding:10px;">
		<table cellpadding="5">
			<tr>
			<td>客户类型</td>
				<td>
    			<select class="easyui-combobox" name="type" style="width: 150px">
   					<option value="潜在客户">1.潜在客户</option>
   					<option value="准客户">2.准客户</option>
   					<option value="意向客户">3.意向客户</option>
   				</select>
    		</tr>
    		<tr>
    			<td>客户公司名称：</td>
    			<td><input class="easyui-textbox" type="text" id="kehuname" name="kehuname" data-options="required:true"></input></td>
    			<td>行业：</td>
    			<td>
    				<select class="easyui-combobox" name="hangye" style="width: 150px">
    					<option value="QCWF">汽车外阜</option>
    					<option value="QCSN">汽车省内</option>
    					<option value="DC">地产</option>
    					<option value="SY">商业</option>
    					<option value="YL">医疗</option>
    					<option value="YD">移动</option>
    					<option value="JZJC">家装建材</option>
    				</select>
    			</td>
    			<td><a href="javascript:void(0)" class="easyui-linkbutton" onclick="check()">校验客户是否在任务中</a></td>
    		</tr>
    		<tr>
    		<td>客户联系人：</td>
    			<td><input class="easyui-textbox" type="text" id="kehulianxiren" name="kehulianxiren" data-options="required:true"></input></td>
    		<td>联系人职务：</td>
    			<td><input class="easyui-textbox" type="text" id="kehuzhiwu" name="kehuzhiwu" data-options="required:true"></input></td>
    		</tr>
    		<tr>
    		<td>联系人电话：</td>
    			<td><input class="easyui-textbox" type="text" id="kehutel" name="kehutel" data-options="required:true"></input></td>
    		<td>公司地址：</td>
    			<td><input class="easyui-textbox" type="text" id="kehudizhi" name="kehudizhi" data-options="required:true"></input></td>
    		</tr>
    		<input type="text" name="guaqi" id="guaqi"  style="display:none;"></input>
		</table>
	</div>
	<div id="p" class="easyui-panel" title="操作区" style="width:800px;height:150px;padding:10px;">
	<p style="font-size:14px;color: red">警告：如果客户公司已经存在于其他业务员任务中，您的提交将被挂起，您的任务将不会被执行，如特殊审批未被及时通过，请联系审批领导做特殊审批。</p>
		<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交任务</a>
	    </div>
	</div>
	<!-- 输出对话框 -->
	<div id="dlg" class="easyui-dialog" title="消息反馈" style="width:400px;height:200px;padding:10px"
			data-options="
				buttons: [{
					text:'继续',
					iconCls:'icon-ok',
					handler:function(){
						$('#dlg').dialog('close');
					}
				}]
			">
		<div id="msgbox"></div>
	</div>
	</form>
	<script type="text/javascript">
		$(document).ready(function() { 
			//关闭对话
			$('#dlg').dialog('close');
		});
		//是否二次验证
		var ischeck = false;
		//是否可以提交
		var flag = false;
		function submitForm(){
			//校验是否为空
			if($('#kehuname').val() == "") {
				alert('客户公司必须填写！');
				return false;
			}
			if($('#kehulianxiren').val() == "") {
				alert('联系人必须填写！');
				return false;
			}
			if($('#kehuzhiwu').val() == "") {
				alert('职务必须填写！');
				return false;
			}
			if($('#kehutel').val() == "") {
				alert('联系电话必须填写！');
				return false;
			}
			if($('#kehudizhi').val() == "") {
				alert('客户地址必须填写！');
				return false;
			}
			if(!ischeck)
				check();
			if(flag) {
				$('#ff').submit();
			} else {
				$('#dlg').dialog('close');
			}
			//return fs;
		}
		function check() {
			if($('#kehuname').val() == "") {
				alert('客户公司必须填写！');
				return false;
			}
			$.ajax( {   
			    type : "POST",
			    url : "<%=request.getContextPath()%>/yewu/qianzhiyewucheck", 
			    data : {
			      'kehuname' : $("#kehuname").val(),
			      'hangye' : $("#hangye").val()
			     },  
			    dataType: "json",   
			    success : function(data) {   
			        if(data.success){
			        	var msg1 = "目标公司任务执行中...<br>业务员：" + data.username + "<br>任务剩余时效：" + data.tianshu + "天<br>如果继续提交，您的任务将被挂起，请联系您的主管!";
			            $("#msgbox").html(msg1);
			            $('#dlg').dialog('open');
			            $('#guaqi').val('true');
			        } else {   
			            $("#msgbox").html(data.msg);
			            $('#dlg').dialog('open');
			            $('#guaqi').val('false');
			        }
			        flag = true;
			        ischeck = true;
			    },   
			    error :function(){
			        $("#msgbox").html("网络连接出错！请联系网络管理员或服务器管理员！");
			        $('#dlg').dialog('open');
			    }
			});
		}
	</script>
  </body>
</html>
