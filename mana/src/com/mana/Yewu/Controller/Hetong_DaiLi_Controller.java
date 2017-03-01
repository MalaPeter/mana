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
		//���� ʱ�� �趨������
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
		
		//��ʱ �ܽ��
		float price = Float.valueOf(zongjingjia);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		
		//�洢��ͬ����
		Htdaili htdl = new Htdaili();
		List<Htdaili> listpp =  htdailiDAO.findByBianhao(bianhao);
		if(listpp.size() > 0) {//���ҵ���
			htdl = listpp.get(0);
			//�����ܽ������Ѿ��洢��+���� �ܾ���
			Htdaililog htdllogtest = new Htdaililog();
			List<Htdaililog> listtest = htdaililogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htdllogtest = listtest.get(i);
				price = price + htdllogtest.getZongjingjia();
			}
			
			htdl.setPrice(price);//#��Ҫ�����㣬ǰ����δ���㴦��?���� ÿ�δ洢��ʱ�򣬴����ݿ�����ȡ���е����飬���м������룬����ô��Ҫ�����в����󣬶Դ��ٴβ�����
		} else {
			htdl = new Htdaili();
			htdl.setBianhao(bianhao);
			htdl.setCdate(df.parse(sdate));
			htdl.setDaili(daili);//�յ�
			htdl.setKehuname(kehuname);
			//�����ܽ������Ѿ��洢��+���� �ܾ���
			Htdaililog htdllogtest = new Htdaililog();
			List<Htdaililog> listtest = htdaililogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htdllogtest = listtest.get(i);
				price = price + htdllogtest.getZongjingjia();
			}
			
			htdl.setPrice(price);//#��Ҫ�����㣬ǰ����δ���㴦��?���� ÿ�δ洢��ʱ�򣬴����ݿ�����ȡ���е����飬���м������룬����ô��Ҫ�����в����󣬶Դ��ٴβ�����
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
		//ִ�б���
		htdailiDAO.save(htdl);
		//���ж��Ƿ����ʱ�Σ���Ϊ��Ҫ��Խ�洢�����ʹ洢�Ϳ�����
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
		
		//���ܽ��д��ҳ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(String.valueOf(price));
		response.getWriter().flush();
	}
	/**
	 * ��� ���к�ͬ����
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
	 * ɾ����һʱ�Σ��У�
	 * ��Ҫ�޸�1.��� ����������
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_daili/delshiduan")
    public void delshiduan(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		
		String bianhao = request.getParameter("bianhao");
		//���� ʱ�� �趨������
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
		//��ʱ �ܽ��
		float price = 0;
		
		List<Htdaililog> list =  htdaililogDAO.findByExample(htdllog);
		if(list.size() > 0) {
			htdllog = list.get(0);
			//ɾ��������
			htdaililogDAO.delete(htdllog);
			//�����ܽ������Ѿ��洢��+���� �ܾ���
			Htdaililog htdllogtest = new Htdaililog();
			List<Htdaililog> listtest = htdaililogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htdllogtest = listtest.get(i);
				price = htdllogtest.getZongjingjia();
			}
			//�޸� ��ͬ���� �ܽ��
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
	 * ��������б�
	 * ����Ҫ ������Ա ���ң�
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
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * ���� �ͻ����ƣ�ģ��ƥ�䣩
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
		//������Ӧ����
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
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	/**
	 * ɾ����ͬ���弰�����������
	 * @param ��ͬ���
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_daili/daili_del")
    public void daili_del(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String bianhao = request.getParameter("bianhao");
		String result = "";
		//��Ҫ ����ȷ�Ϻ�ͬ�Ƿ������������
		Htdaili htpp = new Htdaili();
		List<Htdaili> list = htdailiDAO.findByBianhao(bianhao);
		if(list.size() > 0) {
			htpp = list.get(0);
			if(htpp.getIsshenpi().equals("true")) {
				result = "��ͬ�Ѿ�������������ɾ����";
			} else if(htpp.getIsshenhe().equals("true")) {
				result = "��ͬ�Ѿ�����ˣ�����ɾ����";
			} else if(htpp.getIszuofei().equals("true")) {
				result = "��ͬ�Ѿ��������ϣ�����ɾ����";
			} else {//δ����������� ������ɾ��
				htdailiDAO.delete(htpp);//ɾ������ͬ
				//ɾ��������飬��Ҫ�Ȳ���ɾ
				Htdaililog htdllog = new Htdaililog();
				List<Htdaililog> list2 = htdaililogDAO.findByBianhao(bianhao);
				for(int i=0;i<list2.size();i++) {
					htdllog = list2.get(i);
					htdaililogDAO.delete(htdllog);
				}
				result = "ɾ�����";
			}
		} else {
			result = "û���ҵ���غ�ͬ!";
		}
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
}
