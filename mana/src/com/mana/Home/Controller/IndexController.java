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
	 * ��ת����½ҳ��
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
	 * ��½��ϵͳ
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
			String uname = request.getParameter("uname");// �û���
			String upass = request.getParameter("upass");// ����
	         
			//�ж� �û��� �����Ƿ�Ϊ��
			Admins admin = adminsDAO.findByNameAndPass(uname, upass);
			if(admin != null) {
				request.getSession().setAttribute("admin", admin);
				returnurl = "/mainform";
			} else {
				//System.out.println(admin.getAdminname());
				request.setAttribute("msg", "��½ʧ�ܣ�40001,�û��������ڻ��������");
				//map.put("msg", "��½ʧ�ܣ�40001,�û��������ڻ��������");
				returnurl = "/index";
			}
		}
         return new ModelAndView(returnurl);
    }
}