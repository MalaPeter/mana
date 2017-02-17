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
import com.mana.pojo.Htchuanmei;
import com.mana.pojo.HtchuanmeiDAO;
/**
 * 合同打印类
 * @author 安静波
 */
@Controller
public class Print_Controller {
	@Resource(name="htchuanmeiDAO")
	HtchuanmeiDAO htchuanmeiDAO;
	
	/**
	 * 获得 合同列表
	 * @return
	 */
	@RequestMapping("/kefu/Print_list")
    public ModelAndView Print_list() {
        return new ModelAndView("/kefu/print_list");
    }
	/**
	 * kefu/print_listdata
	 * @throws IOException 
	 */
	@RequestMapping("/kefu/Print_listdata")
    public void Print_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Htchuanmei> list = new ArrayList<Htchuanmei>();
		list = htchuanmeiDAO.findAll();//寻找可以编辑的合同
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
	@RequestMapping("/kefu/Print_search")
    public void Print_search(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String kehuname = request.getParameter("kehuname");
		//Admins ad = (Admins)request.getSession().getAttribute("admin");
		
		List<Htchuanmei> list = new ArrayList<Htchuanmei>();
		Htchuanmei ht = new Htchuanmei();
		ht.setKehuname(kehuname);
		//ht.setUsername(ad.getNickname());
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
	 * 跳转到 传媒合同打印,带合同ID
	 */
	@RequestMapping("/kefu/Print_chuanmeiht")
    public ModelAndView Print_chuanmeiht(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		String id = request.getParameter("id");
		Htchuanmei ht = new Htchuanmei();
		ht = htchuanmeiDAO.findById(Integer.valueOf(id));
		
		model.put("model", ht);
        return new ModelAndView("/kefu/print/print_chuanmeiht");
    }
	/**
	 * 跳转到 传媒合同打印,带合同ID
	 */
	@RequestMapping("/kefu/Print_chuanmeihtxp")
    public ModelAndView Print_chuanmeihtxp(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		String id = request.getParameter("id");
		Htchuanmei ht = new Htchuanmei();
		ht = htchuanmeiDAO.findById(Integer.valueOf(id));
		
		model.put("model", ht);
        return new ModelAndView("/kefu/print/print_chuanmeihtxp");
    }

}
