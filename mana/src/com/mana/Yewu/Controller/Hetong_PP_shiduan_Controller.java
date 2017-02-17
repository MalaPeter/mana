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
		//�˺�ͬ���� ��ͬ��ţ��ͻ����ƣ��ܴ�����Ͷ�Ź�˾(ҵ��Ա��)
		String daili = request.getParameter("daili");
		String kehuname = request.getParameter("kehuname");
		String bianhao = request.getParameter("bianhao");
		String ci = request.getParameter("ci");
		String hangye = request.getParameter("hangye");
		String meiti = request.getParameter("meiti");
		String cdate = request.getParameter("cdate");
		//���� ʱ�� �趨������
		String shiduan = request.getParameter("shiduan");
		String guige = request.getParameter("guige");
		String kanlijia = request.getParameter("kanlijia");
		String zhekou = request.getParameter("zhekou");
		String jingjia = request.getParameter("jingjia");
		String tianshu = request.getParameter("tianshu");
		String zongjingjia = request.getParameter("zongjingjia");
		String zriqi = request.getParameter("zriqi");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		
		//��Ҫ�Ȳ�ѯ �Ƿ���ں�ͬ
		Htdaili htdl = new Htdaili();
		List<Htdaili> list = htdailiDAO.findByBianhao(bianhao);
		if(list.size() > 0) {
			htdl = list.get(0);
			//#������� ��δ���κδ���
		} else {
			Admins ad = (Admins)request.getSession().getAttribute("admin");
			htdl.setUsername(ad.getNickname());
			htdl.setBianhao(bianhao);
			htdl.setCi(ci);
			htdl.setDaili(daili);
			htdl.setHangye(hangye);
			htdl.setKehuname(kehuname);
			htdl.setMeiti(meiti);
			htdl.setPrice(0);//#�ܼ���δ���㣬������������ʽ
			htdl.setIsshenhe("false");
			htdl.setIsshenpi("false");
			htdl.setCdate(df.parse(cdate));
			htdl.setCi(ci);
		}
		htdailiDAO.save(htdl);
		//�жϺ�ͬ�����ϸʱ���Ƿ���ڣ����ھ��޸ģ������ھ����
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
	 * ��� ���к�ͬ����
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
	 * ���� ��ͬ �б�
	 */
	@RequestMapping("/yewu_shiduan/list")
    public ModelAndView daililist() {
		//
		return new ModelAndView("/yewu_shiduan/list");
    }
	/**
	 * �����ͬ ����Լ��ĺ�ͬ�б� ����20����
	 * ����������Ȩ���ж� ����Լ�����ȫ��
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
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * Ʒ�ƺ�ͬ ��ѯ������ �ͻ�����+�û����Ʋ�ѯ
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
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * ����  ����list datagrid
	 * ���� ��ͬ��Ų�ѯ
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
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * ɾ��
	 * ���� ��ͬ���
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu/daili_deletedata")
    public void daili_deletedata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String bianhao = request.getParameter("bianhao");
		
		//ɾ������ͬ
		htdailiDAO.deleteByBianhao(bianhao);
		//ɾ����ͬ����
		htdaililogDAO.deleteByBianhao(bianhao);
		
		//�ٷ�������
		Admins ad = (Admins)request.getSession().getAttribute("admin");
		List<Htdaili> list = new ArrayList<Htdaili>();
		list = htdailiDAO.findByUsername(ad.getNickname());
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
}
