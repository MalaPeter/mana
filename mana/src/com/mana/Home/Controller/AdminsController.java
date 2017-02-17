package com.mana.Home.Controller;

import java.io.IOException;
import java.text.ParseException;
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
import com.mana.pojo.AdminsDAO;
import com.mana.pojo.Htchuanmei;

/**
 * 用户创建、修改、删除、查询
 * 权限管理
 * @author 安静波
 */
@Controller
public class AdminsController {
	@Resource(name="adminsDAO")
	AdminsDAO adminsDAO;
	/**
	 * 用户列表页面
	 * @return
	 */
	@RequestMapping("/admin/admin_list")
    public ModelAndView Admin_list() {
        return new ModelAndView("/admin/admin_list");
    }
	/**
	 * 用户列表页面
	 * @return
	 */
	@RequestMapping("/admin/admin_listdata")
    public void admin_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Htchuanmei> list = new ArrayList<Htchuanmei>();
		list = adminsDAO.findAll();
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * 用户搜索
	 * nickname= 姓名搜索
	 * @return
	 */
	@RequestMapping("/admin/admin_search")
    public void admin_search(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Admins> list = adminsDAO.findByNickname(request.getParameter("nickname"));
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * 添加用户
	 * 前端 没做空验证
	 * @return
	 */
	@RequestMapping("/admin/admin_add")
    public void admin_add(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String adminname = request.getParameter("adminname");
		String adminpass = request.getParameter("adminpass");
		String nickname = request.getParameter("nickname");
		String department = request.getParameter("department");
		String rliulan = request.getParameter("rliulan");
		String rluru = request.getParameter("rluru");
		String rshenhe = request.getParameter("rshenhe");
		String rhuakuan = request.getParameter("rhuakuan");
		String rtingbo = request.getParameter("rtingbo");
		String rtongji = request.getParameter("rtongji");
		String rshenpi = request.getParameter("rshenpi");
		String islock = request.getParameter("islock");
		Admins newad = new Admins();
		newad.setAdminname(adminname);
		newad.setAdminpass(adminpass);
		newad.setNickname(nickname);
		newad.setDepartment(department);
		newad.setRliulan(Integer.valueOf(rliulan));
		newad.setRluru(Integer.valueOf(rluru));
		newad.setRshenhe(Integer.valueOf(rshenhe));
		newad.setRhuakuan(Integer.valueOf(rhuakuan));
		newad.setRtingbo(Integer.valueOf(rtingbo));
		newad.setRtongji(Integer.valueOf(rtongji));
		newad.setRshenpi(Integer.valueOf(rshenpi));
		newad.setIslock(islock);
		newad.setRsys(0);
		
		adminsDAO.save(newad);
		
		//返回 所有
		List<Admins> list = adminsDAO.findAll();
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * 修改用户
	 * 前端 没做空验证
	 * @return
	 */
	@RequestMapping("/admin/admin_edit")
    public void admin_edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String id = request.getParameter("id");
		String adminname = request.getParameter("adminname");
		String adminpass = request.getParameter("adminpass");
		String nickname = request.getParameter("nickname");
		String department = request.getParameter("department");
		String rliulan = request.getParameter("rliulan");
		String rluru = request.getParameter("rluru");
		String rshenhe = request.getParameter("rshenhe");
		String rhuakuan = request.getParameter("rhuakuan");
		String rtingbo = request.getParameter("rtingbo");
		String rtongji = request.getParameter("rtongji");
		String rshenpi = request.getParameter("rshenpi");
		String islock = request.getParameter("islock");
		Admins newad = adminsDAO.findById(Integer.valueOf(id));
		//newad.setId(Integer.valueOf(id));
		newad.setAdminname(adminname);
		newad.setAdminpass(adminpass);
		newad.setNickname(nickname);
		newad.setDepartment(department);
		newad.setRliulan(Integer.valueOf(rliulan));
		newad.setRluru(Integer.valueOf(rluru));
		newad.setRshenhe(Integer.valueOf(rshenhe));
		newad.setRhuakuan(Integer.valueOf(rhuakuan));
		newad.setRtingbo(Integer.valueOf(rtingbo));
		newad.setRtongji(Integer.valueOf(rtongji));
		newad.setRshenpi(Integer.valueOf(rshenpi));
		newad.setIslock(islock);
		
		adminsDAO.save(newad);
		
		//返回 所有
		List<Admins> list = adminsDAO.findAll();
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//设置相应编码
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
}
