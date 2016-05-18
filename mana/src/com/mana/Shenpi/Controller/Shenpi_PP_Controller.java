package com.mana.Shenpi.Controller;

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
 * 合同审批  广电传媒
 * 分管副主任、主任 使用控制类
 * 只有 折扣 < 4 的时候，才会提交 主任审批
 * @author 安静波
 */
@Controller
public class Shenpi_PP_Controller {
	@Resource(name="htchuanmeiDAO")
	HtchuanmeiDAO htchuanmeiDAO;
	
	/**
	 * 待审批 合同列表
	 * @return
	 */
	@RequestMapping("/shenpi/PP_index")
    public ModelAndView PP_index() {
        return new ModelAndView("/shenpi/PP_list");
    }
	
	/**
	 * 审批 品牌合同 获得所有的合同列表 （限20条）
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/shenpi/PP_listdata")
    public void PP_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Htchuanmei> list = new ArrayList<Htchuanmei>();
		list = htchuanmeiDAO.findByIslock("true");//寻找已经锁定的 合同
		
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
	@RequestMapping("/shenpi/PP_search")
    public void PP_search(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
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
	 * 审批 品牌合同 根据ID查询合同 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/shenpi/PP_shenpi")
    public ModelAndView PP_shenpi(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException, ParseException {
		String id = request.getParameter("id");
		Htchuanmei ht = new Htchuanmei();
		ht = htchuanmeiDAO.findById(Integer.valueOf(id));
		
		model.put("model", ht);
		
		return new ModelAndView("/shenpi/PP_shenpi",model);
	}
	
	/**
	 * 审批 品牌合同 审批
	 * flag = tongguo 不获取 客服备注(此类为 审批，如果到此处，获得的信息将覆盖 客服原有审核意见)
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/shenpi/PP_shenhe_save")
    public void PP_shenhe_save(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		Admins ad = (Admins)request.getSession().getAttribute("admin");
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		String kfbeizhu = request.getParameter("kfbeizhu");
		String result = "";
		//根据获取到的 合同ID 查询出合同
		Htchuanmei ht = htchuanmeiDAO.findById(Integer.valueOf(id));
		if(ht != null) {
			if(flag.equals("tongguo")) {
				ht.setIslock("false");//应为 分管主任审核
				result = "审批通过，数据处理完成！";
			}
			if(flag.equals("butongguo")) {
				ht.setIslock("true");
				result = "未通过审批，审批意见已提交！";
			}
			ht.setKfbeizhu(kfbeizhu);
			ht.setShenpiuser(ad.getNickname());
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
