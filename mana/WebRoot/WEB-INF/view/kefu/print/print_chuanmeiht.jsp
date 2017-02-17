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

<title>打印传媒合同</title>

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

<body>
	<div id='page1' style="position:absolute;width:794px;height:1123px;margin-left:auto;margin-right:auto;border:solid 0px #ccc;z-index:99;">
		<table border="0" width="794" height="110" >
			<tr align="center">
				<td><font face="FangSong" size="5px"><b>吉林广电传媒有限责任公司</b></font></td>
			</tr>
			<tr align="center">
				<td><font face="KaiTi" size="5px"><b>广告发布合同</b></font></td>
			</tr>
			<tr height="20" align="right" style="font-family:DFKai-SB;font-size: 16px">
				<td>合同编号：${model.bianhao}</td>
			</tr>
		</table>
		<table border="0" width="794" height="920" style="font-family:DFKai-SB;font-size: 16px;border-collapse:collapse;">
			<tr>
				<td class="td1" width="50%" height="36">广告客户名称：${model.kehuname}</td>
				<td class="td1">广告承接单位：吉林广电传媒有限责任公司</td>
			</tr>
			<tr>
				<td height="36" colspan="2" class="td1">发布日期：${model.sdate}  至   ${model.edate}</td>
			</tr>
			<tr>
				<td height="36" class="td1">发布媒体：${model.meiti}</td>
				<td class="td1">广告规格：${model.guige} 秒
				</td>
			</tr>
			<tr>
				<td class="td1" height="150" colspan="2" valign="top">播出时段： ${model.shiduan} <br>不播出日期：${model.nodate}</td>
			</tr>
			<tr>
				<td class="td1" height="36">播出总计：${model.bochutianshu} 天   ${model.bochucishu} 次</td>
				<td class="td1">执行折扣：${model.zhekou}</td>
			</tr>
			<tr>
				<td class="td1" height="36" colspan="2">实收金额：（小写） ${model.price} 元  （大写） <label id="daxie1"></label></td>
			</tr>
			<tr>
				<td class="td1" colspan="2" valign="top">广告内容： ${model.beizhu}</td>
			</tr>
			<tr>
				<td class="td1" height="180" colspan="2">
				合同条款：<br>
				1、依据广告相关法律、法规规定，甲、乙双方经平等协商自愿签订本合同。<br>
				2、甲方应向乙方提供的广告内容必须真实合法，如因广告内容引起的纠纷乙方概不负责。<br>
				3、乙方有权对甲方的证件及广告内容进行审查，如广告内容不真实、证件不全，乙方有权停止发布。<br>
				4、本合同内禁止涂改，如有涂改必须由双方经办人签字并加盖公章。<br>
				5、乙方应按合同规定按期发布广告，如因甲方原因导致延播或误播，乙方不承担责任。<br>
				6、如因国家政策、行政命令或自然灾害等不可抗拒因素以及重大活动、直播等原因，导致乙方则以顺延播出形式予以补播。<br>
				7、甲乙双方严格履行合同各项规定，如一方违约，由违约方承担责任。<br>
				8、本合同一式两份，具有同等法律效力，甲、乙双方签字盖章后生效。
				</td>
			</tr>
			<tr>
				<td height="223" colspan="2" class="td1">
					<table width="100%" height="100%" border="0" style="font-family:DFKai-SB;font-size: 16px">
						<tr><td width="50%">广告发布单位：（甲方）</td><td>广告承接单位：（乙方）</td></tr>
						<tr><td>单位名称：（章）</td><td>单位名称：（章）吉林广电传媒有限责任公司</td></tr>
						<tr><td>经办人：</td><td>经办人：</td></tr>
						<tr><td>法人代表：</td><td>法人代表：</td></tr>
						<tr><td>联系方式：</td><td>联系方式：</td></tr>
						<tr><td>签订日期：</td><td>签订日期：</td></tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="20" colspan="2" style="font-size: 14px">名称：吉林广电传媒有限责任公司 开户行：中国工商银行长春人民广场支行
					账号：4200 2203 0920 0100 720</td>
			</tr>
		</table>
	</div>
	
</body>
</html>
