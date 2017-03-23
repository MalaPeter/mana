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
import com.mana.pojo.Htpinpai;
import com.mana.pojo.Htpinpailog;
import com.mana.pojo.Htzanzhu;
import com.mana.pojo.HtzanzhuDAO;
/**
 * 节目赞助和节目冠名，只有价格不同，其他数据类型相同
 * @author 安静波
 *
 */
@Controller
public class Hetong_Zanzhu_Controller {
	@Resource(name="htzanzhuDAO")
	HtzanzhuDAO htzanzhuDAO;
	/**
	 * 跳转 赞助冠名登记页面
	 */
	@RequestMapping("/yewu_zanzhu/index")
    public ModelAndView index() {
        return new ModelAndView("/yewu_zanzhu/index");
    }
	/**
	 * 跳转 赞助冠名列表页面
	 */
	@RequestMapping("/yewu_zanzhu/list")
    public ModelAndView list() {
        return new ModelAndView("/yewu_zanzhu/list");
    }
	/**
	 * 获得 所有合同数量
	 */
	@RequestMapping("/yewu_zanzhu/zanzhu_getsize")
    public void zanzhu_getsize(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Admins ad = (Admins) request.getSession().getAttribute("admin");
		List<Htpinpai> list = htzanzhuDAO.findAll();
		String result = String.valueOf(list.size());
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
    }
	/**
	 * 保存
	 * @throws ParseException 
	 */
	@RequestMapping("/yewu_zanzhu/save")
    public void zanzhu_save(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		
	     String sdate = request.getParameter("sdate");
		 String edate = request.getParameter("edate");
		 String bianhao = request.getParameter("bianhao");
		 String kehuname = request.getParameter("kehuname");
		 String hangye = request.getParameter("hangye");
		 String meiti = request.getParameter("meiti");
		 String nowusername = request.getParameter("nowusername");
		 String zhekou = request.getParameter("zhekou");
		 String zhekoudaili = request.getParameter("zhekoudaili");
		 String zhuprice = request.getParameter("zhuprice");
		 String ziprice = request.getParameter("ziprice");
		 String price = request.getParameter("price");
		 String jiemu0 = request.getParameter("jiemu0");
		 String jiemu6 = request.getParameter("jiemu6");
		 String jiemu7 = request.getParameter("jiemu7");
		 String shour = request.getParameter("shour");
		 String sminute = request.getParameter("sminute");
		 String ehour = request.getParameter("ehour");
		 String eminute = request.getParameter("eminute");
		 String ci = request.getParameter("ci");
		 
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		 
		 Htzanzhu zanzhu = new Htzanzhu();
		 zanzhu.setBianhao(bianhao);
		 //zanzhu.setCadate(cadate);
		 zanzhu.setCi(ci);
		 zanzhu.setEdate(df.parse(edate));
		 zanzhu.setEhour(ehour);
		 zanzhu.setEminute(eminute);
		 zanzhu.setHangye(hangye);
		 zanzhu.setIsshenhe("false");
		 zanzhu.setIsshenpi("false");
		 zanzhu.setIszuofei("false");
		 zanzhu.setJiemu0(jiemu0);
		 zanzhu.setJiemu6(jiemu6);
		 zanzhu.setJiemu7(jiemu7);
		 zanzhu.setKehuname(kehuname);
		 zanzhu.setKfuser("");
		 zanzhu.setMeiti(meiti);
		 zanzhu.setSdate(df.parse(sdate));
		 zanzhu.setShour(shour);
		 zanzhu.setSminute(sminute);
		 zanzhu.setUsername(nowusername);
		 zanzhu.setZhekou(zhekou);
		 zanzhu.setZhekoudaili(zhekoudaili);
		 zanzhu.setZhuprice(zhuprice);
		 zanzhu.setZiprice(ziprice);
		 zanzhu.setPrice(price);
		 
		 htzanzhuDAO.save(zanzhu);
    }
	
	/**
	 * 获得所有列表
	 * ？需要 按照人员 查找？
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_zanzhu/zanzhu_listdata")
    public void zanzhu_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Htzanzhu> list = htzanzhuDAO.findAll();
		
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
	@RequestMapping("/yewu_zanzhu/zanzhu_search")
    public void zanzhu_search(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String kehuname = request.getParameter("kehuname");
		
		List<Htzanzhu> list = htzanzhuDAO.vague_findBykehuname(kehuname);
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
//	@RequestMapping("/yewu_zanzhu/pinpai_xiangqingdata")
//    public void pinpai_xiangqingdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
//		String bianhao = request.getParameter("bianhao");
//		List<Htpinpailog> list = new ArrayList<Htpinpailog>();
//		list = htpinpailogDAO.findByBianhao(bianhao);
//		
//		String result = "";
//		Gson gson = new Gson();
//		result = gson.toJson(list);
//		//设置相应编码
//		response.setCharacterEncoding("utf-8");
//		response.getWriter().write(result);
//		response.getWriter().flush();
//	}
	
	/**
	 * 删除合同主体及所有相关详情
	 * @param 合同编号
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_zanzhu/zanzhu_del")
    public void zanzhu_del(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String bianhao = request.getParameter("bianhao");
		String result = "";
		//需要 首先确认合同是否被审批或者审核
		Htzanzhu htzz = new Htzanzhu();
		List<Htzanzhu> list = htzanzhuDAO.findByBianhao(bianhao);
		if(list.size() > 0) {
			htzz = list.get(0);
			if(htzz.getIsshenpi().equals("true")) {
				result = "合同已经被审批，不能删除！";
			} else if(htzz.getIsshenhe().equals("true")) {
				result = "合同已经被审核，不能删除！";
			} else if(htzz.getIszuofei().equals("true")) {
				result = "合同已经申请作废，不能删除！";
			} else {//未出现上述情况 将可以删除
				htzanzhuDAO.delete(htzz);//删除主合同
				//删除相关详情，需要先查再删
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
