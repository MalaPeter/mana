<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客服-合同审核-传媒-品牌</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jeui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jeui/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>jeui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jeui/jquery.easyui.min.js"></script>
	
	<style type="text/css">
	.my-table {
	    border: 1px solid #ccc;
	    border-collapse: collapse;
	    font-size: 10px;
	    width: 100%;
	}
	.my-table td {
	    border: 1px solid blue;
	    height: 26px;
	}
	</style>
  </head>
  
  <body>
    <div id="p" class="easyui-panel" title="审核-广电传媒合同" style="width:800px;height:800px;padding:1px;text-align: center;">
    	<h1>吉林广电传媒有限责任公司</h1>
		<h2>广告发布合同</h2>
		<p align="right">合同编号：<font id="bianhao">${model.bianhao}</font></p>
			<table class="my-table">
				<tr>
					<td width="60">广告客户名称：</td>
					<td>${model.kehuname }</td>
					<td>广告承接单位：</td>
					<td>吉林广电传媒有限责任公司</td>
				</tr>
				<tr>
					<td>发布日期：</td>
					<td colspan="3">${model.sdate } 至 ${model.edate }</td>
				</tr>
				<tr>
					<td>不播放日期：</td>
					<td colspan="3">${model.nodate }</td>
				</tr>
				<tr>
					<td>播放媒体：</td>
					<td>${model.meiti }</td>
					<td>广告规格：</td>
					<td>${model.guige }秒</td>
				</tr>
				<tr>
					<td>播出时段：</td>
					<td colspan="3">${model.shiduan }</td>
				</tr>
				<tr>
					<td>赠送时段：</td>
					<td colspan="3">${model.iszengsong=="true" ? '是':'否'}:${model.zsshiduan }</td>
				</tr>
				<tr>
					<td>执行折扣：</td>
					<td id="tdzhekou">${model.zhekou }</td>
					<td>播出总计：</td>
					<td><font>${model.bochutianshu }</font>天<font>${model.bochucishu }</font>次</td>
				</tr>
				<tr>
					<td>实收金额：</td>
					<td colspan="3">
						（小写）：<font id="price">${model.price }元</font>
						（大写）：<font id="pricedaxie">零</font>
					</td>
				</tr>
				<tr>
					<td>付款时间约定：</td>
					<td>${model.fkyddate }</td>
					<td>付款方式：</td>
					<td id="tdfkfangshi">${model.fkfangshi }</td>
				</tr>
				<tr>
					<td rowspan="4">广告内容：</td>
					<td rowspan="4" colspan="3">${model.beizhu }</td>
				</tr>
			</table>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm1()">审核通过</a>
		<textarea rows="10" cols="60" id="kfbeizhu" onfocus="cleartext()" onblur="">如合同审核未过，请在此处填写处理意见。</textarea>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm2()">审核未过 提交意见</a>
    </div>
  </body>
 <script type="text/javascript">
 function submitForm1() {
 	sub("tongguo","无");
 }
 function submitForm2() {
 	sub("butongguo",$("#kfbeizhu").val());
 }
 function sub(flag,kfbeizhu) {
 	$.ajax( {   
	    type : "POST",
	    url : "<%=request.getContextPath()%>/kefu/ht_chuanmei_shenhe", 
	    data : {
	      'id' : ${model.id},
	      'flag' : flag,
	      'kfbeizhu' : kfbeizhu,
	     },  
	    dataType: "text",   
	    success : function(data) {
	    	alert(data);
	    	//跳转到 列表
	    	self.location='kefu/kfshenheindex';
	    },   
	    error :function(){
	        $("#msgbox").html("网络连接出错！请联系网络管理员或服务器管理员！");
	    }
	});
 }
 //清空对话框
 function cleartext() {
 	if($("#kfbeizhu").val() == "如合同审核未过，请在此处填写处理意见。") {
 		$("#kfbeizhu").val("");
 	}
 }
 </script>
</html>
