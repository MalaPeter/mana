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
 * ��ͬ����  ��紫ý
 * �ֹܸ����Ρ����� ʹ�ÿ�����
 * ֻ�� �ۿ� < 4 ��ʱ�򣬲Ż��ύ ��������
 * @author ������
 */
@Controller
public class Shenpi_PP_Controller {
	@Resource(name="htchuanmeiDAO")
	HtchuanmeiDAO htchuanmeiDAO;
	
	/**
	 * ������ ��ͬ�б�
	 * @return
	 */
	@RequestMapping("/shenpi/PP_index")
    public ModelAndView PP_index() {
        return new ModelAndView("/shenpi/PP_list");
    }
	
	/**
	 * ���� Ʒ�ƺ�ͬ ������еĺ�ͬ�б� ����20����
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/shenpi/PP_listdata")
    public void PP_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Htchuanmei> list = new ArrayList<Htchuanmei>();
		list = htchuanmeiDAO.findByIslock("true");//Ѱ���Ѿ������� ��ͬ
		
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
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	/**
	 * ���� Ʒ�ƺ�ͬ ����ID��ѯ��ͬ 
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
	 * ���� Ʒ�ƺ�ͬ ����
	 * flag = tongguo ����ȡ �ͷ���ע(����Ϊ ������������˴�����õ���Ϣ������ �ͷ�ԭ��������)
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
		//���ݻ�ȡ���� ��ͬID ��ѯ����ͬ
		Htchuanmei ht = htchuanmeiDAO.findById(Integer.valueOf(id));
		if(ht != null) {
			if(flag.equals("tongguo")) {
				ht.setIslock("false");//ӦΪ �ֹ��������
				result = "����ͨ�������ݴ�����ɣ�";
			}
			if(flag.equals("butongguo")) {
				ht.setIslock("true");
				result = "δͨ������������������ύ��";
			}
			ht.setKfbeizhu(kfbeizhu);
			ht.setShenpiuser(ad.getNickname());
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
