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
 * �ͷ� ��ͬ���  ��紫ý
 * @author ������
 */
@Controller
public class Shenhe_PP_Contoller {
	@Resource(name="htchuanmeiDAO")
	HtchuanmeiDAO htchuanmeiDAO;
	
	/**
	 * �ͷ� ��ͬ�б�
	 * @return
	 */
	@RequestMapping("/kefu/kfshenheindex")
    public ModelAndView kfshenheindex() {
		//
        return new ModelAndView("/kefu/htchuanmeilist");
    }
	
	/**
	 * �ͷ� Ʒ�ƺ�ͬ ������еĺ�ͬ�б� ����20����
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/kefu/htchuanmei_listdata")
    public void htchuanmei_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Htchuanmei> list = new ArrayList<Htchuanmei>();
		list = htchuanmeiDAO.findByIsedit("true");//Ѱ�ҿ��Ա༭�ĺ�ͬ
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(list);
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	/**
	 * �ͷ� Ʒ�ƺ�ͬ ���ݿͻ����Ʋ�ѯ��ͬ 
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
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	/**
	 * �ͷ� Ʒ�ƺ�ͬ ����ID��ѯ��ͬ 
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
	 * �ͷ� Ʒ�ƺ�ͬ ���
	 * flag = tongguo ����ȡ �ͷ���ע
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
		//���ݻ�ȡ���� ��ͬID ��ѯ����ͬ
		Htchuanmei ht = htchuanmeiDAO.findById(Integer.valueOf(id));
		if(ht != null) {
			if(flag.equals("tongguo")) {
				//ht.setIslock("false");//ӦΪ �ֹ��������
				ht.setIsedit("false");
				result = "���ͨ�������ݴ�����ɣ�";
			}
			if(flag.equals("butongguo")) {
				//ht.setIslock("true");
				ht.setIsedit("true");
				result = "δͨ����ˣ�����������ύ��";
			}
			ht.setKfbeizhu(kfbeizhu);
			ht.setKfuser(ad.getNickname());
			htchuanmeiDAO.save(ht);
		} else {
			result = "û���ҵ�ָ���ĺ�ͬ��";
		}
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
}
