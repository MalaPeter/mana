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
import com.mana.pojo.HtdailiDAO;
import com.mana.pojo.Htdaililog;
import com.mana.pojo.HtdaililogDAO;

@Controller
public class Hetong_DaiLi_Controller {
	
	@Resource(name="htdailiDAO")
	HtdailiDAO htdailiDAO;
	@Resource(name="htdaililogDAO")
	HtdaililogDAO htdaililogDAO;
	
	@RequestMapping("/yewu_daili/index")
    public ModelAndView dailiindex() {
		//
        return new ModelAndView("/yewu_daili/index");
    }
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_daili/saveshiduan")
    public void saveshiduan(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String daili = request.getParameter("daili");
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
		Htdaili htdl = new Htdaili();
		List<Htdaili> listpp =  htdailiDAO.findByBianhao(bianhao);
		if(listpp.size() > 0) {//查找到了
			htdl = listpp.get(0);
			//计算总金额，遍历已经存储的+本次 总净价
			Htdaililog htdllogtest = new Htdaililog();
			List<Htdaililog> listtest = htdaililogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htdllogtest = listtest.get(i);
				price = price + htdllogtest.getZongjingjia();
			}
			
			htdl.setPrice(price);//#需要，计算，前端尚未计算处理?或者 每次存储的时候，从数据库中提取所有的详情，进行计算后存入，（那么需要在所有操作后，对此再次操作）
		} else {
			htdl = new Htdaili();
			htdl.setBianhao(bianhao);
			htdl.setCdate(df.parse(sdate));
			htdl.setDaili(daili);//空的
			htdl.setKehuname(kehuname);
			//计算总金额，遍历已经存储的+本次 总净价
			Htdaililog htdllogtest = new Htdaililog();
			List<Htdaililog> listtest = htdaililogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htdllogtest = listtest.get(i);
				price = price + htdllogtest.getZongjingjia();
			}
			
			htdl.setPrice(price);//#需要，计算，前端尚未计算处理?或者 每次存储的时候，从数据库中提取所有的详情，进行计算后存入，（那么需要在所有操作后，对此再次操作）
			htdl.setHangye(hangye);
			htdl.setMeiti(meiti);
			htdl.setIsshenpi("false");
			htdl.setIsshenhe("false");
			htdl.setIszuofei("false");
			htdl.setCi(ci);
			htdl.setUsername(username);
			htdl.setShenpiuser("");
			htdl.setKfuser("");
			htdl.setSdate(df.parse(sdate));
			htdl.setEdate(df.parse(edate));
			htdl.setShenheremark("");
			htdl.setShenpiremark("");
			float f = 0;
			htdl.setJianmian(f);
		}
		//执行保存
		htdailiDAO.save(htdl);
		//不判断是否存在时段，因为需要跨越存储，来就存储就可以了
		Htdaililog htdllog = new Htdaililog();
		htdllog.setBianhao(bianhao);
		htdllog.setShiduan(shiduan);
		htdllog.setGuige(guige);
		htdllog.setKanlijia(Integer.valueOf(kanlijia));
		htdllog.setZhekou(zhekou);
		htdllog.setJingjia(Float.valueOf(jingjia));
		htdllog.setTianshu(Integer.valueOf(tianshu));
		htdllog.setZongjingjia(Float.valueOf(zongjingjia));
		htdllog.setZriqi(zriqi);
		htdllog.setNianfen(nianfen);
		htdllog.setYuefen(yuefen);
		
		htdaililogDAO.save(htdllog);
		
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
	@RequestMapping("/yewu_daili/daili_getsize")
    public void daili_getsize(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Admins ad = (Admins) request.getSession().getAttribute("admin");
		List<Htdaili> list = htdailiDAO.findAll();
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
	@RequestMapping("/yewu_daili/delshiduan")
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
		
		Htdaililog htdllog = new Htdaililog();
		htdllog.setBianhao(bianhao);
		htdllog.setShiduan(shiduan);
		htdllog.setGuige(guige);
		htdllog.setKanlijia(Integer.valueOf(kanlijia));
		htdllog.setZhekou(zhekou);
		htdllog.setJingjia(Float.valueOf(jingjia));
		htdllog.setTianshu(Integer.valueOf(tianshu));
		htdllog.setZongjingjia(Float.valueOf(zongjingjia));
		htdllog.setZriqi(zriqi);
		htdllog.setNianfen(nianfen);
		htdllog.setYuefen(yuefen);
		//临时 总金额
		float price = 0;
		
		List<Htdaililog> list =  htdaililogDAO.findByExample(htdllog);
		if(list.size() > 0) {
			htdllog = list.get(0);
			//删除掉数据
			htdaililogDAO.delete(htdllog);
			//计算总金额，遍历已经存储的+本次 总净价
			Htdaililog htdllogtest = new Htdaililog();
			List<Htdaililog> listtest = htdaililogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htdllogtest = listtest.get(i);
				price = htdllogtest.getZongjingjia();
			}
			//修改 合同主体 总金额
			Htdaili htdl = new Htdaili();
			List<Htdaili> listpp =  htdailiDAO.findByBianhao(bianhao);
			if(listpp.size() > 0) {
				htdl = listpp.get(0);
				htdl.setPrice(price);
			}
			htdailiDAO.save(htdl);
		} else {
			
		}
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(String.valueOf(price));
		response.getWriter().flush();
	}
	
	@RequestMapping("/yewu_daili/list")
    public ModelAndView daililist() {
		//
        return new ModelAndView("/yewu_daili/list");
    }
	/**
	 * 获得所有列表
	 * ？需要 按照人员 查找？
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_daili/daili_listdata")
    public void daili_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Htdaili> list = htdailiDAO.findAll();
		
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
	@RequestMapping("/yewu_daili/daili_search")
    public void daili_search(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String kehuname = request.getParameter("kehuname");
		
		List<Htdaili> list = htdailiDAO.vague_findBykehuname(kehuname);
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	@RequestMapping("/yewu_daili/daili_xiangqingdata")
    public void daili_xiangqingdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String bianhao = request.getParameter("bianhao");
		List<Htdaililog> list = new ArrayList<Htdaililog>();
		list = htdaililogDAO.findByBianhao(bianhao);
		
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
	@RequestMapping("/yewu_daili/daili_del")
    public void daili_del(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String bianhao = request.getParameter("bianhao");
		String result = "";
		//需要 首先确认合同是否被审批或者审核
		Htdaili htpp = new Htdaili();
		List<Htdaili> list = htdailiDAO.findByBianhao(bianhao);
		if(list.size() > 0) {
			htpp = list.get(0);
			if(htpp.getIsshenpi().equals("true")) {
				result = "合同已经被审批，不能删除！";
			} else if(htpp.getIsshenhe().equals("true")) {
				result = "合同已经被审核，不能删除！";
			} else if(htpp.getIszuofei().equals("true")) {
				result = "合同已经申请作废，不能删除！";
			} else {//未出现上述情况 将可以删除
				htdailiDAO.delete(htpp);//删除主合同
				//删除相关详情，需要先查再删
				Htdaililog htdllog = new Htdaililog();
				List<Htdaililog> list2 = htdaililogDAO.findByBianhao(bianhao);
				for(int i=0;i<list2.size();i++) {
					htdllog = list2.get(i);
					htdaililogDAO.delete(htdllog);
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
