package com.mana.Home.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mana.pojo.Admins;
import com.mana.pojo.AdminsDAO;

@Controller
public class IndexController {
	/**
	 * 跳转到登陆页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/index")  
    public ModelAndView adminindex() {  
         return new ModelAndView("/index");  
    }
	
	@Resource(name="adminsDAO")
	AdminsDAO adminsDAO;
	
	/**
	 * 登陆到系统
	 * @return
	 */
	@RequestMapping("/login")  
    public ModelAndView adminlogin(HttpServletRequest request, HttpServletResponse response) {
		
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		
		//Map<String, Object> map = new HashMap<String, Object>();
		
		String returnurl = "";
		if(isGet) {
			returnurl = "/admin/index";
		} else {
			String uname = request.getParameter("uname");// 用户名
			String upass = request.getParameter("upass");// 密码
	         
			//判断 用户名 密码是否为空
			Admins admin = adminsDAO.findByNameAndPass(uname, upass);
			if(admin != null) {
				request.getSession().setAttribute("admin", admin);
				returnurl = "/mainform";
			} else {
				//System.out.println(admin.getAdminname());
				request.setAttribute("msg", "登陆失败！40001,用户名不存在或密码错误！");
				//map.put("msg", "登陆失败！40001,用户名不存在或密码错误！");
				returnurl = "/index";
			}
		}
         return new ModelAndView(returnurl);
    }
}