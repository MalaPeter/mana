package com.mana.Yewu.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mana.pojo.Admins;
import com.mana.pojo.Qianzhiyewu;
import com.mana.pojo.QianzhiyewuDAO;

/**
 * 前置业务处理类
 * @author 安静波
 */
@Controller
public class QianzhiyewuController {
	
	@Resource(name="qianzhiyewuDAO")
	QianzhiyewuDAO qianzhiyewuDAO;
	
	/**
	 * 登陆到 前置业务 录入首页
	 * 不进入C 不能访问页面
	 * @return
	 */
	@RequestMapping("/yewu/qianzhiyewuindex")
    public ModelAndView qianzhiyewuindex() {
		//
        return new ModelAndView("/yewu/qianzhiyewuindex");
    }
	
	/**
	 * 前置业务 保存
	 */
	@RequestMapping("/yewu/qianzhiyewusave")
	public ModelAndView qianzhiyewusave(HttpServletRequest request, HttpServletResponse response) {
		boolean guaqi = Boolean.parseBoolean(request.getParameter("guaqi"));
		//String ctime = request.getParameter("ctime");
		String shixiao = request.getParameter("shixiao");
		String kehuname= request.getParameter("kehuname");
		String hangye= request.getParameter("hangye");
		String kehulianxiren= request.getParameter("kehulianxiren");
		String kehuzhiwu= request.getParameter("kehuzhiwu");
		String kehutel= request.getParameter("kehutel");
		String kehudizhi= request.getParameter("kehudizhi");
		//String type = request.getParameter("type");
		String kehuleixing = request.getParameter("type");
		//录入用户信息 通过session获得
		Qianzhiyewu qzyw = new Qianzhiyewu();
		qzyw.setIslock(guaqi?0:1);//如果返回 true就=0 锁定，否则=1 可用
		Date date = new Date();
		//Timestamp timeStamp = new Timestamp(date.getTime());
		qzyw.setCtime(new Timestamp(date.getTime()));
		qzyw.setShixiao(Integer.valueOf(shixiao));
		qzyw.setKehuname(kehuname);
		qzyw.setHangye(hangye);
		qzyw.setKehulianxiren(kehulianxiren);
		qzyw.setKehuzhiwu(kehuzhiwu);
		qzyw.setKehutel(kehutel);
		qzyw.setKehudizhi(kehudizhi);
		qzyw.setKehuleixing(kehuleixing);
		Admins ad = (Admins) request.getSession().getAttribute("admin");
		qzyw.setUsername(ad.getNickname());
		
		qianzhiyewuDAO.save(qzyw);
		//去往 用户自己的 前置业务列表
		return new ModelAndView("redirect:/yewu/qianzhiyewulist");
	}
	
	/**
	 * 前置业务 公司校验
	 * 这是一个 ajax请求
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/yewu/qianzhiyewucheck")
	public void qianzhiyewucheck(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		//查询
		List<Qianzhiyewu> list = qianzhiyewuDAO.findByKehuname(request.getParameter("kehuname"));
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		//要被比较的天数
		long tianshu = -1;
		//要被输出的数据
		Qianzhiyewu qz = null;
		if(list.size() > 0) {
			//如果有记录，要查看 是否已经过期
			//需要 对所有存在的记录 进行循环 查询,查询出  已经被占用并且时效最长的
			Qianzhiyewu qzyw = null;
			Iterator<Qianzhiyewu> it = list.iterator();
			while(it.hasNext()) {
				qzyw = it.next();
				//查看是否 有未执行完的任务
				//需要重新组装 时间，先比较日期，最后比较时间
				int year =qzyw.getCtime().getYear()+1900;
				int month =qzyw.getCtime().getMonth() +1;
				int day =qzyw.getCtime().getDate();
//				int hour =qzyw.getCtime().getHours();
//				int minite =qzyw.getCtime().getMinutes();
//				int Second =qzyw.getCtime().getSeconds();
				
				//当前时间Timestamp
				//Timestamp d = new Timestamp(System.currentTimeMillis());
				
				//格式化 并 把录入日期+时效 计算出日期
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        String str= year+"-"+month+"-"+day;
		        //获得目标日期
		        Date dt=sdf.parse(str);
		        Calendar renwudate = Calendar.getInstance();
		        renwudate.setTime(dt);
		        //rightNow.add(Calendar.YEAR,-1);//日期减1年
		        //rightNow.add(Calendar.MONTH,3);//日期加3个月
		        renwudate.add(Calendar.DAY_OF_YEAR,qzyw.getShixiao());//日期加 时效天数
		        Date dt1 = renwudate.getTime();
		        //String reStr = sdf.format(dt1);
		        //获得当前日期
		        Date nowdate = new Date() ;
		        //判断，如果  录入日期+时效 在 当前日期之后，那么需要提示
		        if(dt1.after(nowdate)) {
		        	//如果 任务执行 大于 当前日期，则 进行加减，算出相隔天数，然后 记录相隔天数，直到所有记录都走一遍，输出天数最长的那个。
		        	//获得当前 毫秒数
		        	Calendar nowDate=Calendar.getInstance();
		        	nowDate.setTime(new Date());//设置为当前系统时间 
		        	long timeNow=nowDate.getTimeInMillis();
		        	//获得任务 毫秒数
		        	long timerenwu=renwudate.getTimeInMillis();
		        	//如果，此次的天数大于 已经存储的天数，那么记录新的天数
		        	if(tianshu <= (timerenwu-timeNow)/(1000*60*60*24)) {
		        		//要输出的数据，被更新
		        		qz = qzyw;
		        		tianshu = (timerenwu-timeNow)/(1000*60*60*24);//化为天
		        	}
		        	//response.getWriter().write("{\"success\":true ,\"size\": 22}");
		        }
			}
			//退出循环后记录，并比较 时效最长的，保留此数据返回给前端
	        if(tianshu >= 0){//有任务在执行
	        	response.getWriter().write("{\"success\":true ,\"username\":\""+qz.getUsername()+"\",\"tianshu\":"+tianshu+" }");
	        } else {//无任务在执行
	        	//response.getWriter().write("{\"success\":false ,\"msg\":\""+request.getParameter("kehuname")+"目标公司可以注册\" }");
	        	response.getWriter().write("{\"success\":false ,\"msg\":\"原有任务已执行完毕！可以执行新的任务.如果要提交申请，请点击 继续并再次提交。\" }");
	        }
		} else {//如果没有这家公司，直接提示可以注册
			response.getWriter().write("{\"success\":false ,\"msg\":\""+request.getParameter("kehuname")+"!目标公司可以注册!如果要提交申请，请点击 继续并再次提交。\" }");
		}
		response.getWriter().flush();
		//return new ModelAndView("/yewu/qianzhiyewusave");
	}
	
	/**
	 * 登陆到 前置业务 查询列表
	 * @return
	 */
	@RequestMapping("/yewu/qianzhiyewulist")
    public ModelAndView qianzhiyewulist() {
		//获得用户自己的
        return new ModelAndView("/yewu/mylist");
    }
	/**
	 * 根据权限，判断查询选项 是否激活
	 * 如果是 仅限自己，只激活 时间、公司名称、联系人、联系人电话、公司地址 等
	 * 如果是 审批权限，则激活所有功能，包括 挂起的任务
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@RequestMapping("/yewu/qianzhiyewulistdata")
    public void qianzhiyewulistdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Qianzhiyewu> list = new ArrayList<Qianzhiyewu>();
		List<YwJsonData> listdata = new ArrayList<YwJsonData>();
		//根据权限查询
		Admins ad = (Admins) request.getSession().getAttribute("admin");
		if(ad.getRliulan() == 1) {//可浏览自己
			list = qianzhiyewuDAO.findByUsername(ad.getNickname());
		}
		if(ad.getRliulan() == 2) {//可浏览全部
			list = qianzhiyewuDAO.findAll();
		}
		//重新组装数据 输出到页面中显示
		if(list.size() > 0) {
			YwJsonData data = new YwJsonData();
			long tianshu = -1;//很特殊，原来用于 记录最大的那个，现在是每个都需要记录
			Qianzhiyewu qzyw = null;
			Qianzhiyewu qz = null;
			Iterator<Qianzhiyewu> it = list.iterator();
			while(it.hasNext()) {
				qzyw = it.next();
				//查看是否 有未执行完的任务
				//需要重新组装 时间，先比较日期，最后比较时间
				int year =qzyw.getCtime().getYear()+1900;
				int month =qzyw.getCtime().getMonth() +1;
				int day =qzyw.getCtime().getDate();
				int hour =qzyw.getCtime().getHours();
				int minite =qzyw.getCtime().getMinutes();
				int Second =qzyw.getCtime().getSeconds();
				//格式化 并 把录入日期+时效 计算出日期
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        String str= year+"-"+month+"-"+day;
		        //获得目标日期
		        Date dt=sdf.parse(str);
		        Calendar renwudate = Calendar.getInstance();
		        renwudate.setTime(dt);
		        renwudate.add(Calendar.DAY_OF_YEAR,qzyw.getShixiao());//日期加 时效天数
		        Date dt1 = renwudate.getTime();
		        //获得当前日期
		        Date nowdate = new Date() ;
		        //判断，如果  录入日期+时效 在 当前日期之后，那么需要提示
		        if(dt1.after(nowdate)) {
		        	//如果 任务执行 大于 当前日期，则 进行加减，算出相隔天数，然后 记录相隔天数，直到所有记录都走一遍，输出天数最长的那个。
		        	//获得当前 毫秒数
		        	Calendar nowDate=Calendar.getInstance();
		        	nowDate.setTime(new Date());//设置为当前系统时间 
		        	long timeNow=nowDate.getTimeInMillis();
		        	//获得任务 毫秒数
		        	long timerenwu=renwudate.getTimeInMillis();
		        	//如果，此次的天数大于 已经存储的天数，那么记录新的天数
		        	tianshu = (timerenwu-timeNow)/(1000*60*60*24);//化为天
		        }
		        //将数据加入到要输出的 jsondata里
		        data = new YwJsonData();
		        data.setId(qzyw.getId().toString());
		        data.setCtime(year+"-"+month+"-"+day+" "+hour+":"+minite+":"+Second);
		        data.setIslock(qzyw.getIslock().toString());
		        data.setKehuname(qzyw.getKehuname());
		        data.setKehutel(qzyw.getKehutel());
		        if(tianshu >= 0){
		        	data.setShengyutianshu(String.valueOf(tianshu)+"天");
		        	tianshu = -1;
		        } else {
		        	data.setShengyutianshu("过期");
		        }
		        data.setShixiao(qzyw.getShixiao().toString()+"天");
		        data.setUsername(qzyw.getUsername());
		        data.setHangye(qzyw.getHangye());
		        data.setPiyu(qzyw.getPiyu());
		        listdata.add(data);
			}
		}
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(listdata);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
    }
	
	/**
	 * 前置业务  业务查询
	 */
	@RequestMapping("/yewu/qianzhiyewusearch1")
    public void qianzhiyewusearch1(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String kehuname = request.getParameter("kehuname");
		int islock = Integer.valueOf(request.getParameter("islock"));
		List<Qianzhiyewu> list = new ArrayList<Qianzhiyewu>();
		List<YwJsonData> listdata = new ArrayList<YwJsonData>();
		Qianzhiyewu q = new Qianzhiyewu();
		//根据权限查询
		Admins ad = (Admins) request.getSession().getAttribute("admin");
		if(ad.getRliulan() == 1) {//可浏览自己
			//判断传入的 客户名称参数不为空
			if(kehuname != null) {
				if(!kehuname.trim().equals("")) {
					q.setUsername(ad.getNickname());
					q.setKehuname(kehuname);
					if(islock == 0)
						q.setIslock(0);
				} else {//空字符串 返回他自己的所有记录
					q.setUsername(ad.getNickname());
					if(islock == 0)
						q.setIslock(0);
				}
			} else {//空 null 返回他自己所有记录
				q.setUsername(ad.getNickname());
				if(islock == 0)
					q.setIslock(0);
			}
		}
		if(ad.getRliulan() == 2) {//可浏览全部
			if(kehuname != null) {
				if(!kehuname.trim().equals("")) {
					q.setKehuname(kehuname);
					if(islock == 0){
						q.setIslock(0);
					}

				} else {//空字符串 返回所有记录
					if(islock == 0){
						q.setIslock(0);
					}
				}
			} else {//空 null 返回所有记录
				if(islock == 0){
					q.setIslock(0);
				}
			}
		}
		list = qianzhiyewuDAO.findByExample(q);
		//重新组装数据 输出到页面中显示
		if(list.size() > 0) {
			YwJsonData data = new YwJsonData();
			long tianshu = -1;//很特殊，原来用于 记录最大的那个，现在是每个都需要记录
			Qianzhiyewu qzyw = null;
			//Qianzhiyewu qz = null;
			Iterator<Qianzhiyewu> it = list.iterator();
			while(it.hasNext()) {
				qzyw = it.next();
				//查看是否 有未执行完的任务
				//需要重新组装 时间，先比较日期，最后比较时间
				int year =qzyw.getCtime().getYear()+1900;
				int month =qzyw.getCtime().getMonth() +1;
				int day =qzyw.getCtime().getDate();
				int hour =qzyw.getCtime().getHours();
				int minite =qzyw.getCtime().getMinutes();
				int Second =qzyw.getCtime().getSeconds();
				//格式化 并 把录入日期+时效 计算出日期
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        String str= year+"-"+month+"-"+day;
		        //获得目标日期
		        Date dt=sdf.parse(str);
		        Calendar renwudate = Calendar.getInstance();
		        renwudate.setTime(dt);
		        renwudate.add(Calendar.DAY_OF_YEAR,qzyw.getShixiao());//日期加 时效天数
		        Date dt1 = renwudate.getTime();
		        //获得当前日期
		        Date nowdate = new Date() ;
		        //判断，如果  录入日期+时效 在 当前日期之后，那么需要提示
		        if(dt1.after(nowdate)) {
		        	//如果 任务执行 大于 当前日期，则 进行加减，算出相隔天数，然后 记录相隔天数，直到所有记录都走一遍，输出天数最长的那个。
		        	//获得当前 毫秒数
		        	Calendar nowDate=Calendar.getInstance();
		        	nowDate.setTime(new Date());//设置为当前系统时间 
		        	long timeNow=nowDate.getTimeInMillis();
		        	//获得任务 毫秒数
		        	long timerenwu=renwudate.getTimeInMillis();
		        	//如果，此次的天数大于 已经存储的天数，那么记录新的天数
		        	tianshu = (timerenwu-timeNow)/(1000*60*60*24);//化为天
		        }
		        //将数据加入到要输出的 jsondata里
		        data = new YwJsonData();
		        data.setId(qzyw.getId().toString());
		        data.setCtime(year+"-"+month+"-"+day+" "+hour+":"+minite+":"+Second);
		        data.setIslock(qzyw.getIslock().toString());
		        data.setKehuname(qzyw.getKehuname());
		        data.setKehutel(qzyw.getKehutel());
		        if(tianshu >= 0){
		        	data.setShengyutianshu(String.valueOf(tianshu)+"天");
		        	tianshu = -1;
		        } else {
		        	data.setShengyutianshu("过期");
		        }
		        data.setShixiao(qzyw.getShixiao().toString()+"天");
		        data.setUsername(qzyw.getUsername());
		        data.setHangye(qzyw.getHangye());
		        data.setPiyu(qzyw.getPiyu());
		        listdata.add(data);
			}
		}
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(listdata);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	/**
	 * 前置业务  审批页面 跳转
	 */
	@RequestMapping("/yewu/qianzhiyewushenpi")
    public ModelAndView qianzhiyewushenpi(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		return new ModelAndView("/yewu/shenpi");
	}
	
	/**
	 * 前置业务  审批 编辑申请任务
	 * 无需写回数据，更新完数据库即可
	 */
	@RequestMapping("/yewu/qianzhiyewushenpiupdate")
    public void qianzhiyewushenpiupdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String id = request.getParameter("id");
		String piyu = request.getParameter("piyu");
		String shenpi = request.getParameter("shenpi");//暂时没用到
		
		Qianzhiyewu qzyw = qianzhiyewuDAO.findById(Integer.valueOf(id));
		qzyw.setPiyu(piyu);
		qianzhiyewuDAO.save(qzyw);
		
	}
}
