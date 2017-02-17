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
import com.mana.pojo.Admins;
import com.mana.pojo.Htchuanmei;
import com.mana.pojo.Htdaili;
import com.mana.pojo.HtdailiDAO;
import com.mana.pojo.Htdaililog;
import com.mana.pojo.HtdaililogDAO;

@Controller
public class Hetong_PP_shiduan_Controller {
	
	@Resource(name="htdailiDAO")
	HtdailiDAO htdailiDAO;
	@Resource(name="htdaililogDAO")
	HtdaililogDAO htdaililogDAO;
	
	@RequestMapping("/yewu_shiduan/index")
    public ModelAndView dailiindex() {
		//
        return new ModelAndView("/yewu_shiduan/index");
    }
	@RequestMapping("/yewu_shiduan/saveshiduan")
    public void saveshiduan(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		//此合同数据 合同编号，客户名称，总次数，投放公司(业务员？)
		String daili = request.getParameter("daili");
		String kehuname = request.getParameter("kehuname");
		String bianhao = request.getParameter("bianhao");
		String ci = request.getParameter("ci");
		String hangye = request.getParameter("hangye");
		String meiti = request.getParameter("meiti");
		String cdate = request.getParameter("cdate");
		//单条 时段 设定后数据
		String shiduan = request.getParameter("shiduan");
		String guige = request.getParameter("guige");
		String kanlijia = request.getParameter("kanlijia");
		String zhekou = request.getParameter("zhekou");
		String jingjia = request.getParameter("jingjia");
		String tianshu = request.getParameter("tianshu");
		String zongjingjia = request.getParameter("zongjingjia");
		String zriqi = request.getParameter("zriqi");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		
		//需要先查询 是否存在合同
		Htdaili htdl = new Htdaili();
		List<Htdaili> list = htdailiDAO.findByBianhao(bianhao);
		if(list.size() > 0) {
			htdl = list.get(0);
			//#如果存在 暂未做任何处理
		} else {
			Admins ad = (Admins)request.getSession().getAttribute("admin");
			htdl.setUsername(ad.getNickname());
			htdl.setBianhao(bianhao);
			htdl.setCi(ci);
			htdl.setDaili(daili);
			htdl.setHangye(hangye);
			htdl.setKehuname(kehuname);
			htdl.setMeiti(meiti);
			htdl.setPrice(0);//#总价暂未计算，考虑用其他方式
			htdl.setIsshenhe("false");
			htdl.setIsshenpi("false");
			htdl.setCdate(df.parse(cdate));
			htdl.setCi(ci);
		}
		htdailiDAO.save(htdl);
		//判断合同里的详细时段是否存在，存在就修改，不存在就添加
		Htdaililog htdllog = new Htdaililog();
		htdllog.setBianhao(bianhao);
		htdllog.setShiduan(shiduan);
		List<Htdaililog> list2 = htdaililogDAO.findByExample(htdllog);
		if(list2.size() > 0) {
			htdllog = list2.get(0);
		} else {
			
		}
		htdllog.setGuige(guige);
		htdllog.setJingjia(Float.valueOf(jingjia));
		htdllog.setKanlijia(Integer.valueOf(kanlijia));
		htdllog.setTianshu(Integer.valueOf(tianshu));
		htdllog.setZhekou(zhekou);
		htdllog.setZongjingjia(Float.valueOf(zongjingjia));
		htdllog.setZriqi(zriqi);
		htdaililogDAO.save(htdllog);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("in");
		response.getWriter().flush();
    }
	/**
	 * 获得 所有合同数量
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/yewu/ht_daili_getsize")
    public void ht_daili_getsize(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Admins ad = (Admins) request.getSession().getAttribute("admin");
		List<Htdaili> list = htdailiDAO.findAll();
		String result = String.valueOf(list.size());
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
    }
	
	@RequestMapping("/yewu_shiduan/delshiduan")
    public void delshiduan(HttpServletRequest request, HttpServletResponse response) {
		
	}
	/**
	 * 代理 合同 列表
	 */
	@RequestMapping("/yewu_shiduan/list")
    public ModelAndView daililist() {
		//
		return new ModelAndView("/yewu_shiduan/list");
    }
	/**
	 * 代理合同 获得自己的合同列表 （限20条）
	 * 新增：根据权限判断 获得自己或获得全部
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu/daili_listdata")
    public void daili_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		Admins ad = (Admins)request.getSession().getAttribute("admin");
		List<Htdaili> list = new ArrayList<Htdaili>();
		list = htdailiDAO.findByUsername(ad.getNickname());
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * 品牌合同 查询，根据 客户名称+用户名称查询
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu/daili_search")
    public void daili_search(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String kehuname = request.getParameter("kehuname");
		Admins ad = (Admins)request.getSession().getAttribute("admin");
		
		List<Htdaili> list = new ArrayList<Htdaili>();
		Htdaili ht = new Htdaili();
		ht.setKehuname(kehuname);
		ht.setUsername(ad.getNickname());
		list = htdailiDAO.findByExample(ht);
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * 详情  返回list datagrid
	 * 根据 合同编号查询
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu/daili_xiangqingdata")
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
	 * 删除
	 * 根据 合同编号
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu/daili_deletedata")
    public void daili_deletedata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String bianhao = request.getParameter("bianhao");
		
		//删除主合同
		htdailiDAO.deleteByBianhao(bianhao);
		//删除合同详情
		htdaililogDAO.deleteByBianhao(bianhao);
		
		//再返回数据
		Admins ad = (Admins)request.getSession().getAttribute("admin");
		List<Htdaili> list = new ArrayList<Htdaili>();
		list = htdailiDAO.findByUsername(ad.getNickname());
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
}
