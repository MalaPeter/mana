<%@page import="com.mana.pojo.Admins"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% Admins ad = (Admins)session.getAttribute("admin");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>录入-赞助</title>
    
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
	<style type="text/css">
	.my-table {
	    border: 1px solid #ccc;
	    border-collapse: collapse;
	    font-size: 10px;
	    width: 600px;
	}
	.my-table td {
	    border: 1px solid blue;
	    height: 36px;
	}
	</style>
	<script type="text/javascript">
	//公共变量  用于其他函数 调用
	var meiti = "";//播出媒体
	var hangye = "";//行业
	var shiduanflag = "";//当前选中时段
	var guigeflag = "";//当前选中规格
	var bianhao = "";
	var hetongsize = 0;//当日合同数量
	var kehuname = "";//客户名称
	var zhekou = "";
	var price = "";//总价
	
  	//动态生成当月 日期 并设定是否是六日
  	$(document).ready(function() {
  		//获得 合同编号组合,请求 当日合同数量
		function gethetongsize() {
			$.ajax( {   
			    type : "POST",
			    url : "<%=request.getContextPath()%>/yewu_zanzhu/zanzhu_getsize", 
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
	   	var hetongcode = "ZZ-";//设置为 品牌开头
	   	$('#hangye').combobox({
			onSelect: function (record) {
				hetongcode = "ZZ-";//还原数据
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
		//初始化 客户名
		$.ajax({
		    type : "POST",
		    url : "<%=request.getContextPath()%>/publicf/getKehuname_zanzhu",
		    dataType: "json",
		    success : function(data) {
				$("#kehuname").combobox("loadData", data);
		    },   
		    error :function(){
		        alert("网络连接出错！请联系网络管理员或服务器管理员！");
		    }
		});
		//初始化  业务员
		$.ajax({
		    type : "POST",
		    url : "<%=request.getContextPath()%>/publicf/getYewuyuan_zanzhu",
		    dataType: "json",
		    success : function(data) {
				$("#nowusername").combobox("loadData", data);
		    },   
		    error :function(){
		        alert("网络连接出错！请联系网络管理员或服务器管理员！");
		    }
		});
		
		//折扣变动
		$('#zhekou').combobox({
			onSelect: function (record) {
				zhekou = record.value;
				var x = $("#zhuprice").val();
				//var y = $("#ziprice").val();
				var z = $("#zhekoudaili").combobox('getValue');
				//price = (parseInt(x) + parseInt(y)) * zhekou * z;
				price = parseInt(x) * zhekou * z;
				$("#price").val(price.toFixed(2));
			}
		});
		//代理折扣变动
		$('#zhekoudaili').combobox({
			onSelect: function (record) {
				zhekoudaili = record.value;
				var x = $("#zhuprice").val();
				//var y = $("#ziprice").val();
				var z = $("#zhekou").combobox('getValue');
				price = parseInt(x) * zhekoudaili * z;
				$("#price").val(price.toFixed(2));
			}
		});
  	});
  	function savedata() {
  		var tt = subform();
		if(!tt == "") {
			alert(tt);
		} else {
			//提交
			$.ajax( {   
			    type : "POST",
			    url : "<%=request.getContextPath()%>/yewu_zanzhu/save",
			    data : {
			      'sdate' : $("#sdate").datebox('getValue'),
			      'edate' : $("#edate").datebox('getValue'),
			      'bianhao' : bianhao,
			      'kehuname' : $('#kehuname').combobox('getValue'),
			      'hangye' : hangye,
			      'meiti' : $('#meiti').combobox('getValue'),
			      'nowusername' : $('#nowusername').combobox('getValue'),
			      'zhekou' :$('#zhekou').combobox('getValue'),
			      'zhekoudaili' :$("#zhekoudaili").combobox('getValue'),
			      'zhuprice' :$("#zhuprice").val(),
			      'ziprice' : $("#ziprice").val(),
			      'price' : $("#price").val(),
			      'jiemu0' : $('#jiemu0').combobox('getValue'),
			      'jiemu6' : $('#jiemu6').combobox('getValue'),
			      'jiemu7' : $('#jiemu7').combobox('getValue'),
			      'shour' : $('#shour').combobox('getValue'),
			      'sminute' : $('#sminute').combobox('getValue'),
			      'ehour' : $('#ehour').combobox('getValue'),
			      'eminute' : $('#eminute').combobox('getValue'),
			      'ci' : $("#ci").val(),
			     },
			    dataType: "text",
			    success : function(data) {
			    	alert('合同保存完成');
					//$("#savehetong").attr({"disabled":"disabled"});
					$('#savehetong').removeAttr('onclick');
			    },   
			    error :function(){
			    	
			    }
			});
		}
  	}
  	function subform() {
		var flag = "";
		if(bianhao == "") {
			flag = "合同编号未生成";
		}
		if($('#nowusername').combobox('getValue') == "") {
			flag = "请填写业务员";
		}
		if(hangye == "") {
			flag = "请选择行业";
		}
		if($('#meiti').combobox('getValue') == "") {
			flag = "请选择播出媒体";
		}
		if($('#sdate').datebox('getValue') == "") {
			flag = "请输入起始日期";
		}
		if($("#ci").val() == "请填写广告主题。") {
			flag = "请填写广告主题。";
		}
		return flag;
	}
  	</script>
  </head>
  
  <body>
  	<div id="p" class="easyui-panel" title="录入-赞助" style="width:400px;height:800px;padding:1px;text-align: center;" fit="true">
    	<h1>广告发布合同 - 赞助(ZZ)</h1>
		<p align="left">合同编号：<font id="bianhao"></font></p>
		<table class="my-table" id="maintable">
			<tr>
				<td width="40%">
					合同类型：赞助
				</td>
			</tr>
			<tr>
				<td>
					客户名称：
					<select class="easyui-combobox" id="kehuname" name="kehuname" style="width: 200px"></select>
					<select class="easyui-combobox" id="hangye" name="hangye" style="width: 100px">
							<option value="">-行业-</option>
							<option value="QCWF">汽车外阜</option>
	    					<option value="QCSN">汽车省内</option>
	    					<option value="QCXHP">汽车消耗品</option>
	    					<option value="DC">地产</option>
	    					<option value="SY">商业</option>
	    					<option value="YL">医疗</option>
	    					<option value="ZGYD">中国移动</option>
	    					<option value="JJJC">家居、建材</option>
	    					<option value="WHYL">文化娱乐、餐饮</option>
	    					<option value="PC">皮草</option>
	    					<option value="BJ">白酒</option>
	    					<option value="JL">酒类（不含白酒）</option>
	    					<option value="YLSP">饮料、食品</option>
	    					<option value="LY">旅游</option>
	    					<option value="YP">药品/保健品</option>
	    					<option value="TX">通讯(移动除外)</option>
	    					<option value="SJSM">手机数码</option>
	    					<option value="JDBG">家电办公</option>
	    					<option value="JR">金融</option>
	    					<option value="ZBSS">珠宝首饰</option>
	    					<option value="RH">日化</option>
	    					<option value="QT">其他</option>
					</select>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('open')">行业查询</a>
				</td>
			</tr>
			<tr>
				<td>
					发布日期：
					起始：<input id="sdate" name="sdate" class="easyui-datebox"></input>
					终止：<input id="edate" name="edate" class="easyui-datebox"></input>
					经办人：<select class="easyui-combobox" id="nowusername" style="width: 80px"></select>
				</td>
			</tr>
			<tr>
				<td>
					发布媒体：
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
			</tr>
			<tr>
				<td>
					主节目刊例价格：<input type="text" class="easyui-numberbox" value="0" data-options="min:0,precision:2" id="zhuprice" name="zhuprice" style="width: 100px">
					总价格：<input type="text" value="0" id="price" name="price" style="width: 120px"><br>
					冠名价格：<input type="text" class="easyui-numberbox" value="0" data-options="min:0,precision:2" id="ziprice" name="ziprice" style="width: 100px"><font color="red">如果填写冠名价格，此单将自动升级为赞助+冠名</font>
				</td>
			</tr>
			<tr>
				<td>
					折扣：
					<select class='easyui-combobox' id='zhekou' name='zhekou' style='width: 80px'>
						<option value=''>折扣</option>
						<option value='1'>不打折</option>
						<option value='0.4'>4 折</option>
						<option value='0.35'>3.5 折</option>
						<option value='0.3'>3 折</option>
						<option value='0.275'>2.75 折</option>
						<option value='0.25'>2.5 折</option>
						<option value='0.225'>2.25 折</option>
						<option value='0.2'>2 折</option>
						<option value='0.17'>1.7 折</option>
						<option value='0.15'>1.5 折</option>
						<option value='0.13'>1.3 折</option>
					</select>
					代理折扣：
					<select class='easyui-combobox' id='zhekoudaili' name='zhekoudaili' style='width: 100px'>
						<option value='1'>非代理单</option>
						<option value='0.84'>8.4折</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<b>节目：</b><br>
					星期一至星期五
						<select class="easyui-combobox" id="jiemu0" name="jiemu0" style="width: 160px"></select><br>
					星期六
						<select class="easyui-combobox" id="jiemu6" name="jiemu6" style="width: 160px"></select><br>
					星期日
						<select class="easyui-combobox" id="jiemu7" name="jiemu7" style="width: 160px"></select>
				</td>
			</tr>
			<tr>
				<td>
					播出时段：
					<select class='easyui-combobox' id='shour' name='shour' style='width: 50px'>
						<option value="1">1</option><option value="2">2</option><option value="3">3</option>
						<option value="4">4</option><option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option><option value="9">9</option>
						<option value="10">10</option><option value="11">11</option><option value="12">12</option>
						<option value="13">13</option><option value="14">14</option><option value="3">15</option>
						<option value="16">16</option><option value="17">17</option><option value="6">18</option>
						<option value="19">19</option><option value="20">20</option><option value="21">21</option>
						<option value="22">22</option><option value="23">23</option><option value="24">24</option>
					</select>
					：
					<select class='easyui-combobox' id='sminute' name='sminute' style='width: 50px'>
						<option value="0">00</option><option value="5">05</option><option value="10">10</option>
						<option value="15">15</option><option value="20">20</option><option value="25">25</option>
						<option value="30">30</option><option value="35">35</option><option value="40">40</option>
						<option value="45">45</option><option value="50">50</option><option value="55">55</option>
					</select>
					-
					<select class='easyui-combobox' id='ehour' name='ehour' style='width: 50px'>
						<option value="1">1</option><option value="2">2</option><option value="3">3</option>
						<option value="4">4</option><option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option><option value="9">9</option>
						<option value="10">10</option><option value="11">11</option><option value="12">12</option>
						<option value="13">13</option><option value="14">14</option><option value="3">15</option>
						<option value="16">16</option><option value="17">17</option><option value="6">18</option>
						<option value="19">19</option><option value="20">20</option><option value="21">21</option>
						<option value="22">22</option><option value="23">23</option><option value="24">24</option>
					</select>
					：
					<select class='easyui-combobox' id='eminute' name='eminute' style='width: 50px'>
						<option value="0">00</option><option value="5">05</option><option value="10">10</option>
						<option value="15">15</option><option value="20">20</option><option value="25">25</option>
						<option value="30">30</option><option value="35">35</option><option value="40">40</option>
						<option value="45">45</option><option value="50">50</option><option value="55">55</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<textarea id="ci" rows="4" cols="90"  onfocus="cleartext()">请填写广告词。</textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<a id="savehetong" href="javascript:void(0)" class="easyui-linkbutton" onclick="savedata()">生成合同</a>
				</td>
			</tr>
		</table>
    </div>
  </body>
</html>
