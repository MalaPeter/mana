package com.mana.Public;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.mana.Yewu.Controller.KehunameJsonData;
import com.mana.pojo.Htdaili;
import com.mana.pojo.HtdailiDAO;
import com.mana.pojo.Htpinpai;
import com.mana.pojo.HtpinpaiDAO;
import com.mana.pojo.Htzanzhu;
import com.mana.pojo.HtzanzhuDAO;

/**
 * ��� �����ͬ���Ѿ����ڵ� ҵ��Ա����
 * @author ������
 */
@Controller
public class PublicFunction {
	@Resource(name="htpinpaiDAO")
	HtpinpaiDAO htpinpaiDAO;
	@Resource(name="htdailiDAO")
	HtdailiDAO htdailiDAO;
	@Resource(name="htzanzhuDAO")
	HtzanzhuDAO htzanzhuDAO;
	/**
	 * ��� Ʒ�ƺ�ͬ �Ѿ�¼��� ҵ��Ա
	 */
	@RequestMapping("/publicf/getYewuyuan_pinpai")
    public void getYewuyuan_pinpai(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String content = request.getParameter("content");//���������
		
		List<Htpinpai> list = htpinpaiDAO.vague_findByyewuyuan();
		List<KehunameJsonData> listdata = new ArrayList<KehunameJsonData>();
		KehunameJsonData kehunamejd;
		for(int i=0;i<list.size();i++) {
			kehunamejd = new KehunameJsonData();
			kehunamejd.setText(String.valueOf(list.get(i)));
			kehunamejd.setValue(String.valueOf(list.get(i)));
			listdata.add(kehunamejd);
		}
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(listdata);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * ��� �����ͬ �Ѿ�¼���ҵ��Ա
	 */
	@RequestMapping("/publicf/getYewuyuan_daili")
    public void getYewuyuan_daili(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String content = request.getParameter("content");//���������
		
		List<Htdaili> list = htdailiDAO.vague_findByyewuyuan();
		List<KehunameJsonData> listdata = new ArrayList<KehunameJsonData>();
		KehunameJsonData kehunamejd;
		for(int i=0;i<list.size();i++) {
			kehunamejd = new KehunameJsonData();
			kehunamejd.setText(String.valueOf(list.get(i)));
			kehunamejd.setValue(String.valueOf(list.get(i)));
			listdata.add(kehunamejd);
		}
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(listdata);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * ��� ������ͬ �Ѿ�¼��� ҵ��Ա
	 */
	@RequestMapping("/publicf/getYewuyuan_zanzhu")
    public void getYewuyuan_zanzhu(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String content = request.getParameter("content");//���������
		
		List<Htzanzhu> list = htzanzhuDAO.vague_findByyewuyuan();
		List<KehunameJsonData> listdata = new ArrayList<KehunameJsonData>();
		KehunameJsonData kehunamejd;
		for(int i=0;i<list.size();i++) {
			kehunamejd = new KehunameJsonData();
			kehunamejd.setText(String.valueOf(list.get(i)));
			kehunamejd.setValue(String.valueOf(list.get(i)));
			listdata.add(kehunamejd);
		}
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(listdata);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * ��� �����ͬ �Ѿ�¼��Ĵ���˾����
	 */
	@RequestMapping("/publicf/getDaili_daili")
    public void getDaili_daili(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String content = request.getParameter("content");//���������
		
		List<Htdaili> list = htdailiDAO.vague_findDailinames();
		List<KehunameJsonData> listdata = new ArrayList<KehunameJsonData>();
		KehunameJsonData kehunamejd;
		for(int i=0;i<list.size();i++) {
			kehunamejd = new KehunameJsonData();
			kehunamejd.setText(String.valueOf(list.get(i)));
			kehunamejd.setValue(String.valueOf(list.get(i)));
			listdata.add(kehunamejd);
		}
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(listdata);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * ��� �����ͬ �Ѿ�¼��Ŀͻ�����
	 */
	@RequestMapping("/publicf/getKehuname_daili")
    public void getKehuname_daili(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String content = request.getParameter("content");//���������
		
		List<Htdaili> list = htdailiDAO.vague_findKehunames();
		List<KehunameJsonData> listdata = new ArrayList<KehunameJsonData>();
		KehunameJsonData kehunamejd;
		for(int i=0;i<list.size();i++) {
			kehunamejd = new KehunameJsonData();
			kehunamejd.setText(String.valueOf(list.get(i)));
			kehunamejd.setValue(String.valueOf(list.get(i)));
			listdata.add(kehunamejd);
		}
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(listdata);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * ��� ������ͬ �Ѿ�¼��Ŀͻ�����
	 */
	@RequestMapping("/publicf/getKehuname_zanzhu")
    public void getKehuname_zanzhu(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String content = request.getParameter("content");//���������
		
		List<Htzanzhu> list = htzanzhuDAO.vague_findKehunames();
		List<KehunameJsonData> listdata = new ArrayList<KehunameJsonData>();
		KehunameJsonData kehunamejd;
		for(int i=0;i<list.size();i++) {
			kehunamejd = new KehunameJsonData();
			kehunamejd.setText(String.valueOf(list.get(i)));
			kehunamejd.setValue(String.valueOf(list.get(i)));
			listdata.add(kehunamejd);
		}
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(listdata);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
}
