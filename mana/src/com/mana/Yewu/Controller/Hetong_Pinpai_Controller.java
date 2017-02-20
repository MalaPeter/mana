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
import com.mana.pojo.Htdaililog;
import com.mana.pojo.Htpinpai;
import com.mana.pojo.HtpinpaiDAO;
import com.mana.pojo.Htpinpailog;
import com.mana.pojo.HtpinpailogDAO;

@Controller
public class Hetong_Pinpai_Controller {
	
	@Resource(name="htpinpaiDAO")
	HtpinpaiDAO htpinpaiDAO;
	@Resource(name="htpinpailogDAO")
	HtpinpailogDAO htpinpailogDAO;
	
	@RequestMapping("/yewu_pinpai/index")
    public ModelAndView dailiindex() {
		//
        return new ModelAndView("/yewu_pinpai/index");
    }
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_pinpai/saveshiduan")
    public void saveshiduan(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String daili = request.getParameter("daili");//�˲���Ϊ �������ƣ�Ʒ�ƺ�ͬ������
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
		Htpinpai htpp = new Htpinpai();
		List<Htpinpai> listpp =  htpinpaiDAO.findByBianhao(bianhao);
		if(listpp.size() > 0) {//���ҵ���
			htpp = listpp.get(0);
			//�����ܽ������Ѿ��洢��+���� �ܾ���
			Htpinpailog htpplogtest = new Htpinpailog();
			List<Htpinpailog> listtest = htpinpailogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htpplogtest = listtest.get(i);
				price = price + htpplogtest.getZongjingjia();
			}
			
			htpp.setPrice(price);//#��Ҫ�����㣬ǰ����δ���㴦��?���� ÿ�δ洢��ʱ�򣬴����ݿ�����ȡ���е����飬���м������룬����ô��Ҫ�����в����󣬶Դ��ٴβ�����
		} else {
			htpp = new Htpinpai();
			htpp.setBianhao(bianhao);
			htpp.setCdate(df.parse(sdate));
			htpp.setDaili(daili);//�յ�
			htpp.setKehuname(kehuname);
			//�����ܽ������Ѿ��洢��+���� �ܾ���
			Htpinpailog htpplogtest = new Htpinpailog();
			List<Htpinpailog> listtest = htpinpailogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htpplogtest = listtest.get(i);
				price = price + htpplogtest.getZongjingjia();
			}
			
			htpp.setPrice(price);//#��Ҫ�����㣬ǰ����δ���㴦��?���� ÿ�δ洢��ʱ�򣬴����ݿ�����ȡ���е����飬���м������룬����ô��Ҫ�����в����󣬶Դ��ٴβ�����
			htpp.setHangye(hangye);
			htpp.setMeiti(meiti);
			htpp.setIsshenpi("false");
			htpp.setIsshenhe("false");
			htpp.setIszuofei("false");
			htpp.setCi(ci);
			htpp.setUsername(username);
			htpp.setShenpiuser("");
			htpp.setKfuser("");
			htpp.setSdate(df.parse(sdate));
			htpp.setEdate(df.parse(edate));
			htpp.setShenheremark("");
			htpp.setShenpiremark("");
			float f = 0;
			htpp.setJianmian(f);
		}
		//ִ�б���
		htpinpaiDAO.save(htpp);
		//���ж��Ƿ����ʱ�Σ���Ϊ��Ҫ��Խ�洢�����ʹ洢�Ϳ�����
		Htpinpailog htpplog = new Htpinpailog();
		htpplog.setBianhao(bianhao);
		htpplog.setShiduan(shiduan);
		htpplog.setGuige(guige);
		htpplog.setKanlijia(Integer.valueOf(kanlijia));
		htpplog.setZhekou(zhekou);
		htpplog.setJingjia(Float.valueOf(jingjia));
		htpplog.setTianshu(Integer.valueOf(tianshu));
		htpplog.setZongjingjia(Float.valueOf(zongjingjia));
		htpplog.setZriqi(zriqi);
		htpplog.setNianfen(nianfen);
		htpplog.setYuefen(yuefen);
		
		htpinpailogDAO.save(htpplog);
		
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
	@RequestMapping("/yewu_pinpai/pinpai_getsize")
    public void pinpai_getsize(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Admins ad = (Admins) request.getSession().getAttribute("admin");
		List<Htpinpai> list = htpinpaiDAO.findAll();
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
	@RequestMapping("/yewu_pinpai/delshiduan")
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
		
		Htpinpailog htpplog = new Htpinpailog();
		htpplog.setBianhao(bianhao);
		htpplog.setShiduan(shiduan);
		htpplog.setGuige(guige);
		htpplog.setKanlijia(Integer.valueOf(kanlijia));
		htpplog.setZhekou(zhekou);
		htpplog.setJingjia(Float.valueOf(jingjia));
		htpplog.setTianshu(Integer.valueOf(tianshu));
		htpplog.setZongjingjia(Float.valueOf(zongjingjia));
		htpplog.setZriqi(zriqi);
		htpplog.setNianfen(nianfen);
		htpplog.setYuefen(yuefen);
		//��ʱ �ܽ��
		float price = 0;
		
		List<Htpinpailog> list =  htpinpailogDAO.findByExample(htpplog);
		if(list.size() > 0) {
			htpplog = list.get(0);
			//ɾ��������
			htpinpailogDAO.delete(htpplog);
			//�����ܽ������Ѿ��洢��+���� �ܾ���
			Htpinpailog htpplogtest = new Htpinpailog();
			List<Htpinpailog> listtest = htpinpailogDAO.findByBianhao(bianhao);
			for(int i=0;i < listtest.size() ; i++) {
				htpplogtest = listtest.get(i);
				price = htpplogtest.getZongjingjia();
			}
			//�޸� ��ͬ���� �ܽ��
			Htpinpai htpp = new Htpinpai();
			List<Htpinpai> listpp =  htpinpaiDAO.findByBianhao(bianhao);
			if(listpp.size() > 0) {
				htpp = listpp.get(0);
				htpp.setPrice(price);
			}
			htpinpaiDAO.save(htpp);
		} else {
			
		}
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(String.valueOf(price));
		response.getWriter().flush();
	}
	
	@RequestMapping("/yewu_pinpai/list")
    public ModelAndView daililist() {
		//
        return new ModelAndView("/yewu_pinpai/list");
    }
	/**
	 * ��������б�
	 * ����Ҫ ������Ա ���ң�
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu_pinpai/pinpai_listdata")
    public void pinpai_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Htpinpai> list = htpinpaiDAO.findAll();
		
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
	@RequestMapping("/yewu_pinpai/pinpai_search")
    public void pinpai_search(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String kehuname = request.getParameter("kehuname");
		
		List<Htpinpai> list = htpinpaiDAO.vague_findByBianhao(kehuname);
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	@RequestMapping("/yewu_pinpai/pinpai_xiangqingdata")
    public void pinpai_xiangqingdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String bianhao = request.getParameter("bianhao");
		List<Htpinpailog> list = new ArrayList<Htpinpailog>();
		list = htpinpailogDAO.findByBianhao(bianhao);
		
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
	@RequestMapping("/yewu_pinpai/pinpai_del")
    public void pinpai_del(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String bianhao = request.getParameter("bianhao");
		String result = "";
		//��Ҫ ����ȷ�Ϻ�ͬ�Ƿ������������
		Htpinpai htpp = new Htpinpai();
		List<Htpinpai> list = htpinpaiDAO.findByBianhao(bianhao);
		if(list.size() > 0) {
			htpp = list.get(0);
			if(htpp.getIsshenpi().equals("true")) {
				result = "��ͬ�Ѿ�������������ɾ����";
			} else if(htpp.getIsshenhe().equals("true")) {
				result = "��ͬ�Ѿ�����ˣ�����ɾ����";
			} else if(htpp.getIszuofei().equals("true")) {
				result = "��ͬ�Ѿ��������ϣ�����ɾ����";
			} else {//δ����������� ������ɾ��
				htpinpaiDAO.delete(htpp);//ɾ������ͬ
				//ɾ��������飬��Ҫ�Ȳ���ɾ
				Htpinpailog htpplog = new Htpinpailog();
				List<Htpinpailog> list2 = htpinpailogDAO.findByBianhao(bianhao);
				for(int i=0;i<list2.size();i++) {
					htpplog = list2.get(i);
					htpinpailogDAO.delete(htpplog);
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
