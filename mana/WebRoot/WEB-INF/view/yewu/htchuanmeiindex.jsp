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

<title>录入-品牌-广电传媒</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=basePath%>jeui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>jeui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>jeui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jeui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>data/shiduan.js"></script>
<script type="text/javascript" src="<%=basePath%>data/price.js"></script>

<script src="<%=basePath%>datepicker/kit.js"></script>
<script src="<%=basePath%>datepicker/array.js"></script>
<script src="<%=basePath%>datepicker/date.js"></script>
<script src="<%=basePath%>datepicker/dom.js"></script>
<script src="<%=basePath%>datepicker/selector.js"></script>
<script src="<%=basePath%>datepicker/datepicker.js"></script>
<script src="<%=basePath%>datepicker/datepicker-n-months.js"></script>
<link rel="stylesheet" href="<%=basePath%>datepicker/datepicker.css" />

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
<% Admins ad = (Admins)session.getAttribute("admin");%>
<body>
	<form id="ff" method="post" data-options="novalidate:true">
		<div id="p" class="easyui-panel" title="合同录入-广电传媒合同录入单" style="width:800px;padding:1px;text-align: center;" fit="true">
		<h1>吉林广电传媒有限责任公司</h1>
		<h2>广告发布合同 - 品牌(PP)</h2>
		<p align="right">合同编号：<font id="bianhao"></font></p>
			<table class="my-table">
				<tr>
					<td width="60">广告客户名称：</td>
					<td>
						<select class="easyui-combobox" id="kehuname" name="kehuname" style="width: 150px"></select>
						<select class="easyui-combobox" id="hangye" name="hangye" style="width: 100px">
							<option value="">-行业-</option>
							<option value="QCWF">汽车外阜</option>
	    					<option value="QCSN">汽车省内</option>
	    					<option value="DC">地产</option>
	    					<option value="SY">商业</option>
	    					<option value="YL">医疗</option>
	    					<option value="YD">移动</option>
	    					<option value="JZJC">家装建材</option>
						</select>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="shangye()">行业查询</a>
					</td>
					<td>广告承接单位：</td>
					<td>吉林广电传媒有限责任公司</td>
				</tr>
				<tr>
					<td>发布日期：</td>
					<td colspan="3">
						<input id="sdate" name="sdate" class="easyui-datebox"></input> 至 <input id="edate" name="edate" class="easyui-datebox"></input><hr>
						<font color="red">不播放日期（点击下方文本框加载控件，请按住Ctrl键点选，请勿修改文本框内内容！）：</font><br>
						<input type="text" id="J_input" value="" style="*zoom:1;width: 600px;border:solid 1px #FF0033;">
					</td>
				</tr>
				<tr>
					<td>播放媒体：</td>
					<td>
						<select class="easyui-combobox" id="meiti" name="meiti" style="width: 180px">
							<option value="">---请选择发布媒体---</option>
							<option value="FM103.8/吉林交通广播">FM103.8/吉林交通广播</option>
							<option value="FM100.1/吉林资讯广播">FM100.1/吉林资讯广播</option>
							<option value="FM91.6/吉林新闻综合广播">FM91.6/吉林新闻综合广播</option>
							<option value="FM103.3/吉林旅游广播">FM103.3/吉林旅游广播</option>
							<option value="FM96.3/吉林教育广播">FM96.3/吉林教育广播</option>
							<option value="FM101.9/吉林健康娱乐广播">FM101.9/吉林健康娱乐广播</option>
							<option value="FM97.6/吉林乡村广播">FM97.6/吉林乡村广播</option>
							<option value="FM95.3/吉林经济广播">FM95.3/吉林经济广播</option>
						</select>
					</td>
					<td>广告规格：</td>
					<td>
						<select class="easyui-combobox" id="guige" name="guige" style="width: 80px"></select>
					</td>
				</tr>
				<tr>
					<td>播出时段：</td>
					<td colspan="3" id="tdshiduan"></td>
				</tr>
				<tr>
					<td>执行折扣：</td>
					<td id="tdzhekou">
						<input type="radio" id="zhekou" name="zhekou" value="0.45">4.5折
						<input type="radio" id="zhekou" name="zhekou" value="0.4" checked="checked">4折
						<input type="radio" id="zhekou" name="zhekou" value="0.3">3折
						<input type="radio" id="zhekou" name="zhekou" value="0.2">2折
					</td>
					<td>播出总计：</td>
					<td><font id="bochutianshu">0</font>天<font id="bochucishu">0</font>次</td>
				</tr>
				<tr>
					<td>实收金额：</td>
					<td colspan="3">
						（小写）：<font id="price">0.00</font>
						（大写）：<font id="pricedaxie">零</font>
					</td>
				</tr>
				<tr>
					<td>付款时间约定：</td>
					<td><input id="fkyddate" class="easyui-datebox"></input></td>
					<td>付款方式：</td>
					<td id="tdfkfangshi">
						<input type="radio" id="fkfangshi" name="fkfangshi" value="现金">现金
						<input type="radio" id="fkfangshi" name="fkfangshi" value="转账" checked="checked">转账
						<input type="radio" id="fkfangshi" name="fkfangshi" value="支票">支票
					</td>
				</tr>
				
				<tr>
					<td rowspan="4">广告内容：</td>
					<td rowspan="4" colspan="3">
						<textarea id="beizhu" rows="10" cols="90">无</textarea>
					</td>
				</tr>
			</table>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">生成合同</a>
		</div>
	</form>
	<!-- 输出对话框 -->
	<div id="dlg" class="easyui-dialog" title="行业查询" style="width:600px;height:600px;padding:10px"
			data-options="buttons: [{text:'继续',iconCls:'icon-ok',handler:function(){$('#dlg').dialog('close');}}]">
			<p>
				<b>一、汽车品牌及销售、汽车消耗品</b><br>
				1、整车品牌及销售、新车及二手车交易市场。<br>
				2、4S店的销售及服务活动（包括4S店的宣传、维修、租赁等）。<br>
				3、汽车轮胎、防冻液。<hr>
				<b>二、汽车用品及相关服务</b><br>
				1、汽车美容装饰及改装相应产品。<br>
				2、汽车消耗品：机油、润滑油等保养及维修配件产品。（轮胎、防冻液除外）<br>
				3、汽车后服务：汽车维修、汽车清洁、汽车保养、汽车装饰、汽车检测、汽车租赁、驾校等店面或产品直营店等相关单位。<hr>
				<b>三、商城、服装服饰</b><br>
				1、常设性商城，包括商厦、百货商场、购物中心、（包括综合商场招商、铺位销售）<br>
				2、服装品牌、服装专卖店、服装展销会（包括文体用品、服饰综合商场）。<br>
				3、服饰类商品、商场、服饰展销会。如服饰配饰、箱包、伞具等。<br>
				4、鞋类品牌、鞋类综合市场、鞋城以及与其相关的展销会。<br>
				5、户外、运动：运动鞋、运动服、户外、健身用品、运动包配、运动品牌、户外品牌、健身品牌、及其直营店或综合店面，户外、运动相关展销会。<br>
				6、家电卖场、家电商城。<hr>
				<b>四、医疗</b><br>
				1、医疗机构，如各类医院、门诊部、医务所、疗养院、医学研究会、体检中心等。<br>
				2、医疗器械（“医器”、“药械”字号）产品、计生用品。<hr>
				<b>五、中国移动通信</b><hr>
				<b>六、房地产</b><br>
				1、房地产、房屋中介、房展会。<hr>
				<b>七、家居、建材</b><br>
				1、家具、家居、办公家具卖场及相关展会。<br>
				2、建材城、灯饰城、装饰布艺城、厨卫设施商店、五金商店。<br>
				3、装饰公司<br>
				4、家装品牌<br>
				A、建材品牌、灯饰品牌，如涂料、建筑胶粘剂、腻子粉、屏风、防盗门、地毯、窗帘布艺、床垫等。<br>
				B、整体厨房及设备，如固定安装炉具、橱柜等。<br>
				C、卫生洁具，如浴房、桑拿房。<br>
				D、家用五金器具，如锁具。<br>
				E、屋内供暖设备，如采暖炉、燃油炉等。<br>
				F、其他居室设备，如插座、开关、灯泡、电工产品、电线电缆、电表、煤气表、可视与不可视对讲门禁系统等。<br>
				G、建筑装饰材料及设备，如钢材、铝材、塑钢材料、石材、电梯、居室建筑玻璃等。<br>
			</p>
		<div id="msgbox"></div>
	</div>
</body>
<script type="text/javascript">
//全局变量，动态生成的元素值，不能获取到，当元素被使用的时候 会被赋值
var kehuname = "";
var bianhao = "";
var hangye = "";
var guige = 0;//规格
var price = 0;//总金额
var shiduanstr = "";//播出时段
var meiti = "";//播出媒体
var bochutianshu = 0;//播出天数
var bochucishu = 0;//播出次数
var zhekou = 1;//折扣
var iszengsong = true;//是否赠送
var zsshiduan = "";//赠送时段
var nodate = "";//不播放日期
//全局方法 表单提交
function submitForm(){
	//校验是否为空
	if(kehuname == "") {
		alert('发布客户必须选择！');
		return false;
	}
	if(hangye == "") {
		alert('行业必须选择！');
		return false;
	}
	if($('#sdate').datebox('getValue') == "") {
		alert('合同起始日期必须填写！');
		return false;
	}
	if($('#edate').datebox('getValue') == "") {
		alert('合同终止日期必须填写！');
		return false;
	}
	//需要校验 起始和终止 打大小关系
	if(meiti == "") {
		alert('请选择发布媒体！');
		return false;
	}
	if(guige == 0) {
		alert('请选择广告规格！');
		return false;
	}
	if(price == 0) {
		alert('合同金额为 0元，不能录入合同，请重新填写！');
		return false;
	}
	sub();
}
function sub() {
	//执行 ajax提交
	$.ajax( {   
	    type : "POST",
	    url : "<%=request.getContextPath()%>/yewu/ht_chuanmei_yingxing_save", 
	    data : {
	      'bianhao' : bianhao,
	      'kehuname' : kehuname,
	      'hangye' : hangye,
	      'sdate' : $('#sdate').datebox('getValue'),
	      'edate' : $('#edate').datebox('getValue'),
	      'nodate' : nodate,
	      'meiti' : meiti,
	      'guige' : guige,
	      'shiduan' : shiduanstr,
	      'iszengsong' : iszengsong,
	      'zsshiduan' : zsshiduan,
	      'zhekou' : zhekou,
	      'bochutianshu' : bochutianshu,
	      'bochucishu' : bochucishu,
	      'price' : price,
	      'fkyddate' : $('#fkyddate').datebox('getValue'),
	      'fkfangshi' : $('#tdfkfangshi input[name="fkfangshi"]:checked ').val(),
	      'beizhu' : $("#beizhu").val(),
	     },  
	    dataType: "text",
	    success : function(data) {
			alert("保存合同成功！");
	    },   
	    error :function(){
	        alert("网络连接出错！请联系网络管理员或服务器管理员！");
	    }
	});
}
//页面内容初始化
$(document).ready(function() {
	$('#dlg').dialog('close');
	//不播放日期 多选日期控件 初始化
	$kit.ev({
		el : '#J_input',
		ev : 'focus',
		fn : function(e) {
			var d, ipt = e.target;
			d = e.target[$kit.ui.DatePicker.defaultConfig.kitWidgetName];
			if(d) {
				d.show();
			} else {
				d = new $kit.ui.DatePicker.NMonths();
				d.init();
				d.adhere($kit.el('#J_input'));
				d.show();
			}
		}
	});
	$kit.ev({
		el : document,
		ev : 'click',
		fn : function(e) {
			var input = $kit.el('#J_input');
			d = input[$kit.ui.DatePicker.defaultConfig.kitWidgetName];
			if(d && !$kit.contains(d.picker, e.target) && input != e.target) {
				d.hide();
			}
		}
	});
	//获得已经登记的 客户名称（仅限当前用户,用户信息 session获得）
	$.ajax( {   
	    type : "POST",
	    url : "<%=request.getContextPath()%>/yewu/ht_chuanmei_yingxing_getindexdata", 
	    data : {
	      'kehuname' : $("#kehuname").val(),
	     },  
	    dataType: "json",   
	    success : function(data) {
	    	data.push({ "text": "---请选择发布客户---", "value": "" });
			$("#kehuname").combobox("loadData", data);
			//$('#kehuname').combobox('reload');
	    },   
	    error :function(){
	        $("#msgbox").html("网络连接出错！请联系网络管理员或服务器管理员！");
	    }
	});
	//设置 选中的客户名称如果不选 应该是null
	$('#kehuname').combobox({
		onSelect: function (record) {
			kehuname = record.value;
		}
	});
	//获得 合同编号组合,请求 当日合同数量
	var hetongsize = 0;//当日合同数量
	function gethetongsize() {
		$.ajax( {   
		    type : "POST",
		    url : "<%=request.getContextPath()%>/yewu/ht_chuanmei_yingxing_gethetongsize", 
		    dataType: "text",   
		    success : function(data) {
				hetongsize = parseInt(data) + 1;//从1号开始，如果没有则返回的是0
		    },   
		    error :function(){
		        $("#msgbox").html("网络连接出错！请联系网络管理员或服务器管理员！");
		    }
		});
	}
	//获得当日合同数量（全部用户）
	gethetongsize();
	//编辑 合同编号，根据 用户选择的行业进行变动监听
	//设置当前的合同编号
    //此页面 为 时段广告（品牌）
   	var hetongcode = "PP-";//设置为 品牌开头
   	$('#hangye').combobox({
		onSelect: function (record) {
			hetongcode = "PP-";//还原数据
			//添加 行业 分类（从 用户选择区获得）
			hetongcode = hetongcode + record.value + "-";
			//获得当前日期
			var mydate = new Date();
			var mon = mydate.getMonth()+1;//如果 月份小于10，则添加0在月份前
			if(mon < 10)
				mon = "0" + mon;
			var day = mydate.getDate();//如果 天数小于10，则添加0
			if(day < 10)
				day = "0" + day;
			hetongcode = hetongcode + mydate.getFullYear() + mon + day + "-";
			//添加当日合同数量
			hetongcode = hetongcode + hetongsize + "-" + <%= ad.getId()%>;
			hangye = record.value;//全局变量赋值
			bianhao = hetongcode;//全局变量赋值
			$("#bianhao").html(hetongcode);
			//alert(hetongcode);
		}
		
	});
   	
	//媒体 规格联动
	//媒体 时段联动
	var guigelist = new Array();
	$('#meiti').combobox({
		onSelect: function (record) {
			guigelist = new Array();
			guigelist.push({ "text": "-规格-", "value": "" });
			switch (record.value) {
			case "FM103.8/吉林交通广播":
				guigelist.push({ "text": "5秒", "value": "5" });
				guigelist.push({ "text": "10秒", "value": "10" });
				guigelist.push({ "text": "15秒", "value": "15" });
				shiduan1038();
				break;
			case "FM100.1/吉林资讯广播":
				guigelist.push({ "text": "5秒", "value": "5" });
				guigelist.push({ "text": "10秒", "value": "10" });
				guigelist.push({ "text": "15秒", "value": "15" });
				shiduan1001();
				break;
			case "FM91.6/吉林新闻综合广播":
				guigelist.push({ "text": "5秒", "value": "5" });
				guigelist.push({ "text": "10秒", "value": "10" });
				guigelist.push({ "text": "15秒", "value": "15" });
				shiduan916();
				break;
			case "FM103.3/吉林旅游广播":
				guigelist.push({ "text": "7秒", "value": "7" });
				guigelist.push({ "text": "15秒", "value": "15" });
				shiduan1033();
				break;
			case "FM96.3/吉林教育广播":
				guigelist.push({ "text": "7秒", "value": "7" });
				guigelist.push({ "text": "15秒", "value": "15" });
				shiduan963();
				break;
			case "FM101.9/吉林健康娱乐广播":
				guigelist.push({ "text": "10秒", "value": "10" });
				shiduan1019();
				break;
			case "FM97.6/吉林乡村广播":
				guigelist.push({ "text": "10秒", "value": "10" });
				shiduan976();
				break;
			case "FM95.3/吉林经济广播":
				guigelist.push({ "text": "10秒", "value": "10" });
				guigelist.push({ "text": "15秒", "value": "15" });
				shiduan953();
				break;
			default:
				break;
			}
			guigelist.push({ "text": "20秒", "value": "20" });
			guigelist.push({ "text": "30秒", "value": "30" });
			meiti = record.value;//设置 全局变量
			$("#guige").combobox("loadData", guigelist);
		}
	});
	//将 规格 动态生成的 值 保存到 JS变量中
	$('#guige').combobox({
		onSelect: function (record) {
			guige = record.value;
		}
		
	});
	//
});

//计算，实际播出天数和价格 因为时段元素是动态添加，所以只能做全局函数
function dayandprice() {
	//判断 规格是否选中，如果规格未选，则无法计算金额
	if(guige == 0) {
		alert('请选择广告规格！');
		return false;
	}
	var result = new Array();
	var resultzs = new Array();
	var priceday = 0;
	var flag = false;//需要判断是不是 常规时段（赠送时段）
	iszengsong = $('#tdshiduan input[name="shiduanzengsong"]:checked ').val();//每次需要重新获取 是否赠送
	price = 0;//每次进入 需要重新计算
	$("[name = shiduan]:checkbox").each(function () {
	    if ($(this).is(":checked")) {//如果是选中则加入到数组中
	        //首先判断是否为 赠送时段内(拆分了从checkbox内获得的时间，通过 : 进行分割，判断第一个小时的大小 即可知道在哪个时段内)
	        var hourtest = new Array();
	        hourtest = $(this).attr("value").split(":");
	        if(parseInt(hourtest[0]) >= 22) flag = true;
	        if(parseInt(hourtest[0]) < 7) flag = true;
	        //计算金额
	        if(flag) {
	        	//判断 是否开启赠送，如果不赠送 则进行累加计算，否则不算
		        if($('#tdshiduan input[name="shiduanzengsong"]:checked ').val() == "false") {//如果 为否(此处选否)
		        	priceday = priceday + getprice(meiti,$(this).attr("value"),guige);//金额正常取
		        	iszengsong = false;//设置 赠送为 不赠送
		        }
		        resultzs.push($(this).attr("value"));//时段 被独立存储 收不收费 都需要存储
	        } else {//正常时段，加入
	        	result.push($(this).attr("value"));//添加到数组中
	        	priceday = priceday + getprice(meiti,$(this).attr("value"),guige);//当天金额
	        }
	        
	        //计算不播出天数
	        var arr1= new Array(); //定义一数组 
	        if($.trim($("#J_input").val()) != "")//如果未填写，则不能分割，否则数组长度也会为1
				arr1 = $("#J_input").val().split(","); //字符分割 
			nodate = $("#J_input").val();//设置全局变量，不播放日期
	        //计算播出天数 合同总天数-不播出天数
	        bochutianshu = getAlldays() - arr1.length;
	        //计算总金额 = 一天时段金额 X 播出天数 X 折扣
	        zhekou = $('#tdzhekou input[name="zhekou"]:checked ').val();//全局变量赋值 折扣
	        price = bochutianshu * priceday * zhekou;
	        //计算 播出次数 = (时段数+赠送时段) x 天数
	        bochucishu = (result.length + resultzs.length) * bochutianshu;
	    }
	});
	$("#bochutianshu").html(bochutianshu);//输出到页面
	$("#bochucishu").html(bochucishu);//输出到页面
	$("#price").html(price);//输出到页面
	$("#pricedaxie").html(pricechange(price));//输出到页面
	zsshiduan = resultzs.join(",")
	shiduanstr = result.join(",")//设置全局变量 转换成字符串 进行时段存储用
}
//获得 合同签订 起止和结束日期的 天数	
function getAlldays(){
	var begin=$(":input[name=sdate]").val();
	var end=$(":input[name=edate]").val();
	var ab = begin.split("-");
	var ae = end.split("-");
	var db = new Date();
	db.setUTCFullYear(ab[0], ab[1]-1, ab[2]);
	var de = new Date();
	de.setUTCFullYear(ae[0], ae[1]-1, ae[2]);
	var unixDb=db.getTime();
	var unixDe=de.getTime();
	var n = 0;
	for(var k=unixDb;k<unixDe;){
	    n=n+1;
	    k=k+24*60*60*1000;
	}
	return n;
}
//金额 大写转换
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
//行业查询内容
function shangye() {
	$("#msgbox").html('');
	$('#dlg').dialog('open');
}
</script>
</html>