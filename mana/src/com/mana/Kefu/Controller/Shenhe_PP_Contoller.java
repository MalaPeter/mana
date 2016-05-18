package com.mana.Kefu.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mana.pojo.Admins;
import com.mana.pojo.Htchuanmei;
import com.mana.pojo.HtchuanmeiDAO;

/**
 * 客服 合同审核  广电传媒
 * @author 安静波
 */
@Controller
public class Shenhe_PP_Contoller {
	@Resource(name="htchuanmeiDAO")
	HtchuanmeiDAO htchuanmeiDAO;
	
	/**
	 * 客服 合同列表
	 * @return
	 */
	@RequestMapping("/kefu/kfshenheindex")
    public ModelAndView kfshenheindex() {
		//
        return new ModelAndView("/kefu/htchuanmeilist");
    }
	
	/**
	 * 客服 品牌合同 获得所有的合同列表 （限20条）
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/kefu/htchuanmei_listdata")
    public void htchuanmei_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Htchuanmei> list = new ArrayList<Htchuanmei>();
		list = htchuanmeiDAO.findByIsedit("true");//寻找可以编辑的合同
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	/**
	 * 客服 品牌合同 根据客户名称查询合同 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/kefu/htchuanmei_search")
    public void htchuanmei_search(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String kehuname = request.getParameter("kehuname");
		
		List<Htchuanmei> list = new ArrayList<Htchuanmei>();
		Htchuanmei ht = new Htchuanmei();
		ht.setKehuname(kehuname);
		list = htchuanmeiDAO.findByExample(ht);
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	/**
	 * 客服 品牌合同 根据ID查询合同 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/kefu/htchuanmei_shenhe")
    public ModelAndView htchuanmei_shenhe(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException, ParseException {
		String id = request.getParameter("id");
		Htchuanmei ht = new Htchuanmei();
		ht = htchuanmeiDAO.findById(Integer.valueOf(id));
		
		model.put("model", ht);
		
		return new ModelAndView("/kefu/htchuameishenhe",model);
	}
	
	/**
	 * 客服 品牌合同 审核
	 * flag = tongguo 不获取 客服备注
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/kefu/ht_chuanmei_shenhe")
    public void ht_chuanmei_shenhe(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		Admins ad = (Admins)request.getSession().getAttribute("admin");
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		String kfbeizhu = request.getParameter("kfbeizhu");
		String result = "";
		//根据获取到的 合同ID 查询出合同
		Htchuanmei ht = htchuanmeiDAO.findById(Integer.valueOf(id));
		if(ht != null) {
			if(flag.equals("tongguo")) {
				//ht.setIslock("false");//应为 分管主任审核
				ht.setIsedit("false");
				result = "审核通过，数据处理完成！";
			}
			if(flag.equals("butongguo")) {
				//ht.setIslock("true");
				ht.setIsedit("true");
				result = "未通过审核，审批意见已提交！";
			}
			ht.setKfbeizhu(kfbeizhu);
			ht.setKfuser(ad.getNickname());
			htchuanmeiDAO.save(ht);
		} else {
			result = "没有找到指定的合同！";
		}
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
}
