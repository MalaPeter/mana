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

<title>打印传媒小票</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=basePath%>jeui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>jeui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>jeui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jeui/jquery.easyui.min.js"></script>
<script type="text/javascript">

function pricechange(num) {
  var strOutput = "";
  var strUnit = '仟佰拾亿仟佰拾万仟佰拾元角分';
  num += "00";
  var intPos = num.indexOf('.');
  if (intPos >= 0)
    num = num.substring(0, intPos) + num.substr(intPos + 1, 2);
  strUnit = strUnit.substr(strUnit.length - num.length);
  for (var i=0; i < num.length; i++)
    strOutput += '零壹贰叁肆伍陆柒捌玖'.substr(num.substr(i,1),1) + strUnit.substr(i,1);
    return strOutput.replace(/零角零分$/, '整').replace(/零[仟佰拾]/g, '零').replace(/零{2,}/g, '零').replace(/零([亿|万])/g, '$1').replace(/零+元/, '元').replace(/亿零{0,3}万/, '亿').replace(/^元/, "零元");
};
//$("#daxie1").html("tt");
$(document).ready(function(){
	$("#daxie1").html(pricechange(${model.price}));
});
</script>
<style type="text/css">
.td1{border:1px solid #000}
</style>
</head>
<% 
	Calendar cal = Calendar.getInstance(); 
    int year = cal.get(Calendar.YEAR); 
    int month = cal.get(Calendar.MONTH) + 1; 
    int day = cal.get(Calendar.DAY_OF_MONTH);
    String nowdate = String.valueOf(year) + "年" +String.valueOf(month) + "月" +String.valueOf(day) + "日";
	%>
<body>
	<div id='page1' style="position:absolute;width:600px;height:300px;margin-left:auto;margin-right:auto;border:solid 0px #ccc;z-index:99;">
		<table border="0" width="600" height="60" >
			<tr align="center">
				<td colspan="2"><font face="FangSong" size="5px"><b>吉林广电传媒有限责任公司交款通知单</b></font></td>
			</tr>
			<tr height="20" style="font-family:DFKai-SB;font-size: 16px">
				<td>播出频率：${model.meiti}</td><td align="right">合同编号：${model.bianhao}</td>
			</tr>
		</table>
		<table border="0" width="600" height="240" style="font-family:DFKai-SB;font-size: 16px;border-collapse:collapse;">
			<tr height="30">
				<td class="td1" width="50">客户名称</td>
				<td class="td1" colspan="3">${model.kehuname}</td>
				<td class="td1" width="50">经 办 人</td>
				<td class="td1" width="50">${model.username}</td>
			</tr>
			<tr height="30">
				<td class="td1">合同编号</td>
				<td class="td1">${model.bianhao}</td>
				<td class="td1">合同金额</td>
				<td class="td1">${model.price}</td>
				<td class="td1">合同日期</td>
				<td class="td1">${model.sdate}</td>
			</tr>
			<tr height="30">
				<td class="td1">播出形式</td><!-- 调整 -->
				<td class="td1"></td>
				<td class="td1">本次交款</td><!-- 调整 -->
				<td class="td1"></td>
				<td class="td1">播出日期</td><!-- 调整 -->
				<td class="td1"></td>
			</tr>
			<tr>
				<td class="td1" colspan="6" valign="top">广告内容:${model.beizhu}</td>
			</tr>
			<tr height="30">
				<td colspan="3">制表人：${model.username}</td>
				<td colspan="3" align="right">制表日期：<%=nowdate %></td>
			</tr>
		</table>
	</div>
</body>
</html>
