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
    <title>录入-品牌-时段</title>

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
	.riqi {
		width: 20px;
	}
	</style>
	<script type="text/javascript">
	
	//公共变量  用于其他函数 调用
	var year = 0;//当前年份
	var month = 0;//当前选择月份
	var dayc = 0;//当前月份总天数
	var trflag = 0;//数据航标
	var meiti = "";//播出媒体
	var hangye = "";//行业
	var shiduanflag = "";//当前选中时段
	var guigeflag = "";//当前选中规格
	var bianhao = "";
	var hetongsize = 0;//当日合同数量
	
  	//动态生成当月 日期 并设定是否是六日
  	$(document).ready(function() {
  		$('#dlg_add').dialog('close');
  		$('#dlg').dialog('close');
  		
  		$('#yue').combobox({
			onSelect: function (record) {
				//alert(record.value);
				//添加td,根据 当前月的最大天数
				//获得 当前月最大天数
				//获得 当前年份
				var dtest = new Date();//var str = dtest.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
				//构造一个日期对象：
				year = $("#year").val();
				if(year == "") {
					year = dtest.getFullYear();//赋值公共函数
					//如果年份为空，则自动填写当年
				}
				var  day = new Date(year,record.value,0); 
				//获取天数：
				var daycount = day.getDate();
				dayc = daycount;//赋值公共函数
				//根据天数 生成TD个数 //添加 是否是 六日
				$("#tr_ri").remove();
				$("#tr_zhoumo").remove();
				var ritrString = "<tr align='center' id='tr_ri' width='100%'>";//设置日行开头
				var zhoumotrString  = "<tr id='tr_zhoumo' width='100%'>";//设置是否周末行开头
				var jianju = 100/daycount;
				for(var j=0;j<daycount;j++) {
					ritrString += "<td class='riqi'>"+(j+1)+"</td>";
					//组合年月日，判断是否周末
					//组合日期开始，需要在 单月前+0
					var nowmonth = record.value;
					if(nowmonth < 10) {
						nowmonth = "0" + nowmonth;
					}
					month = nowmonth;//赋值公共变量
					var nowri = j + 1;
					if(nowri < 10) {
						nowri = "0" + nowri;
					}
					var s = year + "-" + nowmonth + "-" + nowri;
					if(new Date(s).getDay() == 0) {
						zhoumotrString += "<td>s7</td>";
					}else if(new Date(s).getDay() == 6) {
						zhoumotrString += "<td>s6</td>";
					} else {
						zhoumotrString += "<td> </td>";
					}
					
				}
				ritrString += "</tr>";//设置行结尾
				zhoumotrString += "</tr>";//设置行结尾
				$("#ri").append(zhoumotrString).show();
				$("#ri").append(ritrString).show();
				//添加 同步，日期 主要判断本月最大日期
				
			}
		});
		//媒体 时段联动
		$('#meiti').combobox({
			onSelect: function (record) {
				meiti = record.value;//设置 全局变量
				switch (record.value) {
					case "FM103.8/吉林交通广播":
						shiduan1038();
						break;
					case "FM100.1/吉林资讯广播":
						shiduan1001();
						break;
					case "FM91.6/吉林新闻综合广播":
						shiduan916();
						break;
					case "FM103.3/吉林旅游广播":
						shiduan1033();
						break;
					case "FM96.3/吉林教育广播":
						shiduan963();
						break;
					case "FM101.9/吉林健康娱乐广播":
						shiduan1019();
						break;
					case "FM97.6/吉林乡村广播":
						shiduan976();
						break;
					case "FM95.3/吉林经济广播":
						shiduan953();
						break;
					default:
						break;
				}
			}
		});
		//获得 合同编号组合,请求 当日合同数量
		function gethetongsize() {
			$.ajax( {   
			    type : "POST",
			    url : "<%=request.getContextPath()%>/yewu/ht_daili_getsize", 
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
  	});
  	function inserttr() {
  		if(meiti == "") {
			alert('请选择发布媒体！');
			return;
		}
		if(month == 0) {
			alert('请选择月份！');
			return;
		}
  		//航标 +1
  		trflag = trflag + 1;
  		//先添加整行
  		var trstr = "<tr id='tr"+trflag+"' align='center'>";
  		trstr += "<td><input id='shiduan"+trflag+"' onclick='add_open("+trflag+");' style='width: 40px' readonly></input></td>";
  		trstr += "<td><select class='easyui-combobox' id='guige"+trflag+"' name='guige"+trflag+"' style='width: 80px' onchange='guigechange(this,"+trflag+")'>" + 
					"<option value=''>-选择规格-</option>" + 
					"<option value='5'>5 秒</option>" + 
					"<option value='7'>7 秒</option>" + 
					"<option value='10'>10秒</option>" + 
					"<option value='15'>15秒</option>" + 
					"<option value='20'>20秒</option>" + 
					"<option value='30'>30秒</option>" + 
				"</select></td>";
  		trstr += "<td><input id='kanlijia"+trflag+"' style='width: 80px' readonly></input></td>";
  		trstr += "<td><select class='easyui-combobox' id='zhekou"+trflag+"' name='zhekou"+trflag+"' onchange='zhekouchange(this,"+trflag+")' style='width: 80px'>" + 
					"<option value=''>-选择折扣-</option>" + 
					"<option value='0.4'>4 折</option>" + 
					"<option value='0.3'>3 折</option>" + 
					"<option value='0.275'>2.75 折</option>" + 
					"<option value='0.25'>2.5 折</option>" + 
					"<option value='0.225'>2.25 折</option>" + 
					"<option value='0.2'>2 折</option>" + 
					"<option value='0.15'>1.5 折</option>" + 
					"<option value='0.13'>1.3 折</option>" + 
				"</select></td>";
  		trstr += "<td><input id='jingjia"+trflag+"' style='width: 80px' readonly value='0'></input></td>";
  		trstr += "<td><input id='tianshu"+trflag+"' style='width: 40px' readonly value='0'></input></td>";
  		trstr += "<td><input id='zongjingjia"+trflag+"' style='width: 80px' readonly value='0'></input></td>";
  		trstr += "<td><input id='yuefen"+trflag+"' style='width: 40px' readonly value='"+month+"'></input></td>";
  		trstr += "<input id='nianfen"+trflag+"' style='width: 40px' readonly type='hidden' value='"+year+"'></input>";//隐藏传输
  		trstr += "<td align='left'><table border='1'><tr>";
  		for(var j=0;j<dayc;j++) {
  			//先组合年月日，以便传递到后台
  			//月份已经补全过，这里只补全日
			var nowri = j + 1;
			if(nowri < 10) {
				nowri = "0" + nowri;
			}
			var s = year + "-" + month + "-" + nowri;
			trstr += "<td class='riqi'>"+
			"<input id='"+trflag+"sriqi"+(j+1)+"' name='"+trflag+"sriqi"+(j+1)+"' type='checkbox' value='"+s+"' onclick='sriqi(this,"+trflag+")'/>" + 
			"</td>";
		}
		trstr += "</tr></table></td>";
		trstr += "<td>";
		trstr += "<button onclick='savetr("+trflag+");'>保存</button>";
		//trstr += " | ";
		//trstr += "<button onclick='deletetr("+trflag+");'>删除</button>";
		trstr += "</td>";
		trstr += "<input id='zriqi"+trflag+"' style='width: 40px' type='hidden'></input>";//临时保存 要提交的 播出日期，方便修改和存储
  		trstr += "</tr>";//设置行结尾
  		$("#maintable").append(trstr).show();
  	}
  	function add_open(sd) {//sd 航标数字
  		shiduanflag = "shiduan"+sd;//给当前选中时段赋值
		$('#dlg_add').dialog('open');
	}
	function jisuan(tdflag){
		$("[name = sriqi"+tdflag+"]:checkbox").each(function () {
			if ($(this).is(":checked")) {//如果是选中则加入到数组中
				alert($(this).attr("value"));
			}
		});
	}
	//选中某一时段，关闭对话框，只选中一个
	function dayandprice(shiduan) {
		//将选中时段 赋值给 TD显示
		$("#"+shiduanflag+"").val(shiduan.value);
		$('#dlg_add').dialog('close');
		//shiduanflag = "";//清除当前选中时段
	}
	function savetr(trflag) {
		if(!subform()) {
			alert("数据填写不正确！");
		} else {
			//向服务器提交数据
			$.ajax( {   
			    type : "POST",
			    url : "<%=request.getContextPath()%>/yewu_pinpai/saveshiduan",
			    data : {
			      'shiduan' : $("#shiduan"+trflag).val(),
			      'guige' : $("#guige"+trflag).val(),
			      'kanlijia' : $("#kanlijia"+trflag).val(),
			      'zhekou' : $("#zhekou"+trflag).val(),
			      'jingjia' : $("#jingjia"+trflag).val(),
			      'tianshu' : $("#tianshu"+trflag).val(),
			      'zongjingjia' : $("#zongjingjia"+trflag).val(),
			      'zriqi' : $("#zriqi"+trflag).val(),
			      'sdate' : $('#sdate').datebox('getValue'),
			      'edate' : $('#edate').datebox('getValue'),
			      'bianhao' : bianhao,
			      'kehuname' : $("#kehuname").val(),
			      'daili' : $("#daili").val(),
			      'hangye' : hangye,
			      'meiti' : meiti,
			      'nowusername' : $("#nowusername").val(),
			      'ci' : $("#ci").val(),
			     },
			    dataType: "text",
			    success : function(data) {
					$("#tr"+trflag).css('background-color','green');//保存后 修改背景色
			    },   
			    error :function(){
			        $("#tr"+trflag).css('background-color','red');//保存后 修改背景色
			    }
			});
		}
	}
	function deletetr(trflag) {
		alert("数据删除会出现的问题：需要获得全行数据对比，这也有可能删除相同的其他数据，联系管理员删除是最好的解决办法");
	}
	function guigechange(guige,trflag) {
		$("#kanlijia"+trflag).val(getprice(meiti,$("#"+shiduanflag+"").val(),guige.value));
	}
	function zhekouchange(zhekou,trflag) {
		var x = $("#kanlijia"+trflag).val();
		var y = x * zhekou.value;//parseInt(x * zhekou.value);
		y = y.toFixed(2);
		$("#jingjia"+trflag).val(y);
	}
	function sriqi(sriqi,trflag) {//传入复选框对象， 行标
		alert(sriqi.value);
		var w = $("#zriqi"+trflag).val();//日期临时存储 文本框
		var x = $("#jingjia"+trflag).val();//获得净价
		var y = parseInt($("#tianshu"+trflag).val());//获得天数 
		var z = $("#zongjingjia"+trflag).val();//获得总净价
		//判断是选中还是取消，选中+(加的时候 直接加入即可) 取消-(取消的时候需要去 临时存储日期里面，找到并去除)
		if(sriqi.checked) {
			y = y + 1;//天数上+1
			if(w == "") {//判断是不是第一个变量，用来是否添加分隔符“；”
				w = sriqi.value;
			} else {
				w = w + ";" + sriqi.value;
			}
		} else {
			y = y - 1;//天数上-1
		}
		$("#zriqi"+trflag).val(w);//设置天数
		$("#tianshu"+trflag).val(y);//设置天数
		//总净价 = 天数*净价 z = y * x
		z = y * x;
		$("#zongjingjia"+trflag).val(z);//设置总净价
	}
	function subform() {
		var flag = true;
		if($("#kehuname").val() == "") {
			flag = false;
		}
		if($("#shiduan"+trflag).val() == "") {
			flag = false;
		}
		if($("#guige"+trflag).val() == "") {
			flag = false;
		}
		if($("#kanlijia"+trflag).val() == "") {
			flag = false;
		}
		if($("#zhekou"+trflag).val() == "") {
			flag = false;
		}
		if($("#jingjia"+trflag).val() == "") {
			flag = false;
		}
		if($("#zongjingjia"+trflag).val() == "") {
			flag = false;
		}
		if($("#zriqi"+trflag).val() == "") {
			flag = false;
		}
		if(bianhao == "") {
			flag = false;
		}
		if($("#nowusername").val() == "") {
			flag = false;
		}
		if(hangye == "") {
			flag = false;
		}
		if(meiti == "") {
			flag = false;
		}
		if($('#cdate').datebox('getValue') == "") {
			flag = false;
		}
		return flag;
	}
	</script>
  </head>
  
  <body>
   	<div id="p" class="easyui-panel" title="合同录入-广电传媒合同录入单" style="width:800px;height:800px;padding:1px;text-align: center;" fit="true">
		<h1>广告发布合同 - 品牌(PP)</h1>
		<!--品牌合同中，客户是前置中填写的，但是有个问题是：代输入怎么办   <h2><input id="daili" style="width: 400" type="hidden"></h2>-->
		<p align="right">合同编号：<font id="bianhao"></font></p>
		<table class="my-table" id="maintable">
			<tr>
				<td colspan="2">客户名称Brand Client：</td>
				<td colspan="5">
					<input id="kehuname" style="width: 200px">
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
				<td colspan="3">
					合同起始：<input id="cdate" name="sdate" class="easyui-datebox"></input>
					合同终止：<input id="cdate" name="edate" class="easyui-datebox"></input>
					经办人：<input id="nowusername" style="width: 80px">
				</td>
			</tr>
			<tr>
				<td>发布媒体：</td>
				<td colspan="8">
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
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="inserttr()" iconCls="icon-add">添加一条数据</a>
				</td>
			</tr>
			<tr align="center">
				<td rowspan="2" width="5%">时段</td>
				<td rowspan="2" width="5%">长度</td>
				<td rowspan="2" width="6%">刊例价</td>
				<td rowspan="2" width="5%">折扣</td>
				<td rowspan="2" width="6%">净价</td>
				<td rowspan="2" width="4%">天数</td>
				<td rowspan="2" width="6%">净价总计</td>
				<td rowspan="2" width="4%">月份</td>
				<td width="50%">
					年度：<input id="year" style="width: 80px">（如填写例如2016，则生成填写年的月份，如不填写，则生成当年月份）
					<select class="easyui-combobox" id="yue" name="yue" style="width: 100px">
						<option value="0">选择月份</option>
						<option value="1">1 月</option>
						<option value="2">2 月</option>
						<option value="3">3 月</option>
						<option value="4">4 月</option>
						<option value="5">5 月</option>
						<option value="6">6 月</option>
						<option value="7">7 月</option>
						<option value="8">8 月</option>
						<option value="9">9 月</option>
						<option value="10">10月</option>
						<option value="11">11月</option>
						<option value="12">12月</option>
					</select>
				</td>
				<td rowspan="2" width="9%">操作区</td>
			</tr>
			<tr height="60px">
				<td>
					<table id="ri"></table>
				</td>
			</tr>
		</table>
		<textarea id="ci" rows="10" cols="90"></textarea>
	</div>
	<div id="dlg_add" class="easyui-dialog" title="选择时段" style="width:700px;height:400px;padding:10px;font-size: 10px"
		data-options="buttons: [{text:'取消',iconCls:'icon-ok',handler:function(){$('#dlg_add').dialog('close');}}]">
		<table id="shiduantable" width="100%">
			<tr><td id="tdshiduan"></td></tr>
		</table>
	</div>
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
</html>
