package com.mana.Yewu.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mana.pojo.Htdaili;
import com.mana.pojo.Htdaililog;
import com.mana.pojo.Htpinpai;
import com.mana.pojo.HtpinpaiDAO;
import com.mana.pojo.Htpinpailog;
import com.mana.pojo.HtpinpailogDAO;

@Controller
public class Hetong_Pinpai_Controller {
	
	@Resource(name="htpinpaiDAO")
	HtpinpaiDAO htpinpaiDAO;
	@Resource(name="htpinpailogDAO")
	HtpinpailogDAO htpinpailogDAO;
	
	@RequestMapping("/yewu_pinpai/index")
    public ModelAndView dailiindex() {
		//
        return new ModelAndView("/yewu_pinpai/index");
    }
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_pinpai/saveshiduan")
    public void saveshiduan(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String daili = request.getParameter("daili");//此参数为 代理名称，品牌合同中无用
		String kehuname = request.getParameter("kehuname");
		String bianhao = request.getParameter("bianhao");
		String ci = request.getParameter("ci");
		String hangye = request.getParameter("hangye");
		String meiti = request.getParameter("meiti");
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		String username = request.getParameter("nowusername");
		//单条 时段 设定后数据
		String shiduan = request.getParameter("shiduan");
		String guige = request.getParameter("guige");
		String kanlijia = request.getParameter("kanlijia");
		String zhekou = request.getParameter("zhekou");
		String jingjia = request.getParameter("jingjia");
		String tianshu = request.getParameter("tianshu");
		String zongjingjia = request.getParameter("zongjingjia");
		String zriqi = request.getParameter("zriqi");
		String nianfen = request.getParameter("nianfen");
		String yuefen = request.getParameter("yuefen");
		
		//临时 总金额
		float price = Float.valueOf(zongjingjia);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		
		//存储合同主体
		Htpinpai htpp = new Htpinpai();
		List<Htpinpai> listpp =  htpinpaiDAO.findByBianhao(bianhao);
		if(listpp.size() > 0) {//查找到了
			htpp = listpp.get(0);
			//计算总金额，遍历已经存储的+本次 总净价
			Htpinpailog htpplogtest = new Htpinpailog();
			List<Htpinpailog> listtest = htpinpailogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htpplogtest = listtest.get(i);
				price = price + htpplogtest.getZongjingjia();
			}
			
			htpp.setPrice(price);//#需要，计算，前端尚未计算处理?或者 每次存储的时候，从数据库中提取所有的详情，进行计算后存入，（那么需要在所有操作后，对此再次操作）
		} else {
			htpp = new Htpinpai();
			htpp.setBianhao(bianhao);
			htpp.setCdate(df.parse(sdate));
			htpp.setDaili(daili);//空的
			htpp.setKehuname(kehuname);
			//计算总金额，遍历已经存储的+本次 总净价
			Htpinpailog htpplogtest = new Htpinpailog();
			List<Htpinpailog> listtest = htpinpailogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htpplogtest = listtest.get(i);
				price = price + htpplogtest.getZongjingjia();
			}
			
			htpp.setPrice(price);//#需要，计算，前端尚未计算处理?或者 每次存储的时候，从数据库中提取所有的详情，进行计算后存入，（那么需要在所有操作后，对此再次操作）
			htpp.setHangye(hangye);
			htpp.setMeiti(meiti);
			htpp.setIsshenpi("false");
			htpp.setIsshenhe("false");
			htpp.setIszuofei("false");
			htpp.setCi(ci);
			htpp.setUsername(username);
			htpp.setShenpiuser("");
			htpp.setKfuser("");
			htpp.setSdate(df.parse(sdate));
			htpp.setEdate(df.parse(edate));
			htpp.setShenheremark("");
			htpp.setShenpiremark("");
			float f = 0;
			htpp.setJianmian(f);
		}
		//执行保存
		htpinpaiDAO.save(htpp);
		//不判断是否存在时段，因为需要跨越存储，来就存储就可以了
		Htpinpailog htpplog = new Htpinpailog();
		htpplog.setBianhao(bianhao);
		htpplog.setShiduan(shiduan);
		htpplog.setGuige(guige);
		htpplog.setKanlijia(Integer.valueOf(kanlijia));
		htpplog.setZhekou(zhekou);
		htpplog.setJingjia(Float.valueOf(jingjia));
		htpplog.setTianshu(Integer.valueOf(tianshu));
		htpplog.setZongjingjia(Float.valueOf(zongjingjia));
		htpplog.setZriqi(zriqi);
		htpplog.setNianfen(nianfen);
		htpplog.setYuefen(yuefen);
		
		htpinpailogDAO.save(htpplog);
		
		//将总金额写到页面中
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(String.valueOf(price));
		response.getWriter().flush();
	}
	/**
	 * 获得 所有合同数量
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/yewu_pinpai/pinpai_getsize")
    public void pinpai_getsize(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Admins ad = (Admins) request.getSession().getAttribute("admin");
		List<Htpinpai> list = htpinpaiDAO.findAll();
		String result = String.valueOf(list.size());
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
    }
	/**
	 * 删除单一时段（行）
	 * 需要修改1.金额 减掉并反馈
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_pinpai/delshiduan")
    public void delshiduan(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		
		String bianhao = request.getParameter("bianhao");
		//单条 时段 设定后数据
		String shiduan = request.getParameter("shiduan");
		String guige = request.getParameter("guige");
		String kanlijia = request.getParameter("kanlijia");
		String zhekou = request.getParameter("zhekou");
		String jingjia = request.getParameter("jingjia");
		String tianshu = request.getParameter("tianshu");
		String zongjingjia = request.getParameter("zongjingjia");
		String zriqi = request.getParameter("zriqi");
		String nianfen = request.getParameter("nianfen");
		String yuefen = request.getParameter("yuefen");
		
		Htpinpailog htpplog = new Htpinpailog();
		htpplog.setBianhao(bianhao);
		htpplog.setShiduan(shiduan);
		htpplog.setGuige(guige);
		htpplog.setKanlijia(Integer.valueOf(kanlijia));
		htpplog.setZhekou(zhekou);
		htpplog.setJingjia(Float.valueOf(jingjia));
		htpplog.setTianshu(Integer.valueOf(tianshu));
		htpplog.setZongjingjia(Float.valueOf(zongjingjia));
		htpplog.setZriqi(zriqi);
		htpplog.setNianfen(nianfen);
		htpplog.setYuefen(yuefen);
		//临时 总金额
		float price = 0;
		
		List<Htpinpailog> list =  htpinpailogDAO.findByExample(htpplog);
		if(list.size() > 0) {
			htpplog = list.get(0);
			//删除掉数据
			htpinpailogDAO.delete(htpplog);
			//计算总金额，遍历已经存储的+本次 总净价
			Htpinpailog htpplogtest = new Htpinpailog();
			List<Htpinpailog> listtest = htpinpailogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htpplogtest = listtest.get(i);
				price = htpplogtest.getZongjingjia();
			}
			//修改 合同主体 总金额
			Htpinpai htpp = new Htpinpai();
			List<Htpinpai> listpp =  htpinpaiDAO.findByBianhao(bianhao);
			if(listpp.size() > 0) {
				htpp = listpp.get(0);
				htpp.setPrice(price);
			}
			htpinpaiDAO.save(htpp);
		} else {
			
		}
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(String.valueOf(price));
		response.getWriter().flush();
	}
	
	@RequestMapping("/yewu_pinpai/list")
    public ModelAndView daililist() {
		//
        return new ModelAndView("/yewu_pinpai/list");
    }
	/**
	 * 获得所有列表
	 * ？需要 按照人员 查找？
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_pinpai/pinpai_listdata")
    public void pinpai_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Htpinpai> list = htpinpaiDAO.findAll();
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * 根据 客户名称（模糊匹配）
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_pinpai/pinpai_search")
    public void pinpai_search(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String kehuname = request.getParameter("kehuname");
		
		List<Htpinpai> list = htpinpaiDAO.vague_findByBianhao(kehuname);
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	@RequestMapping("/yewu_pinpai/pinpai_xiangqingdata")
    public void pinpai_xiangqingdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String bianhao = request.getParameter("bianhao");
		List<Htpinpailog> list = new ArrayList<Htpinpailog>();
		list = htpinpailogDAO.findByBianhao(bianhao);
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	/**
	 * 删除合同主体及所有相关详情
	 * @param 合同编号
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_pinpai/pinpai_del")
    public void pinpai_del(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String bianhao = request.getParameter("bianhao");
		String result = "";
		//需要 首先确认合同是否被审批或者审核
		Htpinpai htpp = new Htpinpai();
		List<Htpinpai> list = htpinpaiDAO.findByBianhao(bianhao);
		if(list.size() > 0) {
			htpp = list.get(0);
			if(htpp.getIsshenpi().equals("true")) {
				result = "合同已经被审批，不能删除！";
			} else if(htpp.getIsshenhe().equals("true")) {
				result = "合同已经被审核，不能删除！";
			} else if(htpp.getIszuofei().equals("true")) {
				result = "合同已经申请作废，不能删除！";
			} else {//未出现上述情况 将可以删除
				htpinpaiDAO.delete(htpp);//删除主合同
				//删除相关详情，需要先查再删
				Htpinpailog htpplog = new Htpinpailog();
				List<Htpinpailog> list2 = htpinpailogDAO.findByBianhao(bianhao);
				for(int i=0;i<list2.size();i++) {
					htpplog = list2.get(i);
					htpinpailogDAO.delete(htpplog);
				}
				result = "删除完成";
			}
		} else {
			result = "没有找到相关合同!";
		}
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
}
