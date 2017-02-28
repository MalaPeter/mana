package com.mana.Yewu.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.mana.pojo.Qianzhiyewu;
import com.mana.pojo.QianzhiyewuDAO;

/**
 * ��ԭʼ�� ��ͬ�����࣬Ŀǰ�Ѿ�����ʹ��
 * ��ͬ����  ��紫ý
 * @author ������
 */
@Controller
public class Hetong_PP_Controller {
	
	@Resource(name="htchuanmeiDAO")
	HtchuanmeiDAO htchuanmeiDAO;
	@Resource(name="qianzhiyewuDAO")
	QianzhiyewuDAO qianzhiyewuDAO;
	
	/**
	 * ���� ��ý��ͬ�Ǽ���ҳ
	 * �ж�Ȩ�� 
	 * ��ȡҳ����������
	 */
	@RequestMapping("/yewu/htchuanmeiindex")
    public ModelAndView qianzhiyewuindex() {
		//
        return new ModelAndView("/yewu/htchuanmeiindex");
    }
	
	/**
	 * Ӳ�Թ�� ¼��
	 * ��õǼ�ҳ����������
	 * 1.�ѵǼǵĿͻ����� �����޵�ǰ�û���
	 * @throws IOException 
	 */
	@RequestMapping("/yewu/ht_chuanmei_yingxing_getindexdata")
    public void ht_chuanmei_yingxing_getindexdata(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Admins ad = (Admins) request.getSession().getAttribute("admin");
		List<Qianzhiyewu> list = qianzhiyewuDAO.getKeHuname(ad.getNickname());//��ѯ δ�����ͻ�����
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
	 * Ӳ�Թ�� ¼��
	 * ��� ���պ�ͬ����
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/yewu/ht_chuanmei_yingxing_gethetongsize")
    public void ht_chuanmei_yingxing_gethetongsize(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Admins ad = (Admins) request.getSession().getAttribute("admin");
		List<Htchuanmei> list = htchuanmeiDAO.getByCdate();
		String result = String.valueOf(list.size());
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
    }
	/**
	 * ��ͬ¼�뵽���ݿ���
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException 
	 */
	@RequestMapping("/yewu/ht_chuanmei_yingxing_save")
	public void ht_chuanmei_yingxing_save(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		System.out.println("save in");
		Admins ad = (Admins) request.getSession().getAttribute("admin");
		String nowusername = request.getParameter("nowusername");
		String bianhao = request.getParameter("bianhao");
		String kehuname = request.getParameter("kehuname");
	    String hangye = request.getParameter("hangye");
	    String sdate = request.getParameter("sdate");
	    String edate = request.getParameter("edate");
	    String nodate = request.getParameter("nodate");
	    String meiti = request.getParameter("meiti");
	    String guige = request.getParameter("guige");
	    String shiduan = request.getParameter("shiduan");
	    String iszengsong = request.getParameter("iszengsong");
	    String zsshiduan = request.getParameter("zsshiduan");
	    String zhekou = request.getParameter("zhekou");
	    String bochutianshu = request.getParameter("bochutianshu");
	    String bochucishu = request.getParameter("bochucishu");
	    String price = request.getParameter("price");
	    String fkyddate = request.getParameter("fkyddate");
	    String fkfangshi = request.getParameter("fkfangshi");
	    String beizhu = request.getParameter("beizhu");
	    String pinming = request.getParameter("pinming");
		
	    Htchuanmei ht = new Htchuanmei();
	    ht.setBianhao(bianhao);
	    ht.setKehuname(kehuname);
	    ht.setHangye(hangye);
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
	    ht.setCdate(new Date());
	    ht.setSdate(df.parse(sdate));
	    ht.setEdate(df.parse(edate));
	    ht.setNodate(nodate);
	    ht.setMeiti(meiti);
	    ht.setGuige(guige);
	    ht.setShiduan(shiduan);
	    ht.setZhekou(zhekou);
	    ht.setBochutianshu(Integer.valueOf(bochutianshu));
	    ht.setBochucishu(Integer.valueOf(bochucishu));
	    ht.setPrice(Integer.valueOf(price));
	    ht.setFkyddate(df.parse(fkyddate));
	    ht.setFkfangshi(fkfangshi);
	    ht.setBeizhu(beizhu);
	    ht.setIslock("true");
	    ht.setIspay("false");
	    ht.setIstingbo("true");
	    ht.setUsername(nowusername);
	    ht.setIsedit("true");
	    ht.setZuofei("false");
	    ht.setIszengsong(iszengsong);
	    ht.setZsshiduan(zsshiduan);
	    ht.setPinming(pinming);
	    
	    htchuanmeiDAO.save(ht);
	    
		String result = "����ɹ���";
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	/**
	 * Ʒ�� ��ͬ �б�
	 */
	@RequestMapping("/yewu/htchuanmeilist")
    public ModelAndView htchuanmeilist() {
		//
        return new ModelAndView("/yewu/htchuanmeilist");
    }
	/**
	 * Ʒ�ƺ�ͬ ����Լ��ĺ�ͬ�б� ����20����
	 * ����������Ȩ���ж� ����Լ�����ȫ��
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu/htchuanmei_listdata")
    public void htchuanmei_listdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		Admins ad = (Admins)request.getSession().getAttribute("admin");
		List<Htchuanmei> list = new ArrayList<Htchuanmei>();
		list = htchuanmeiDAO.findByUsername(ad.getNickname());
		
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
	@RequestMapping("/yewu/htchuanmei_search")
    public void htchuanmei_search(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String kehuname = request.getParameter("kehuname");
		Admins ad = (Admins)request.getSession().getAttribute("admin");
		
		List<Htchuanmei> list = new ArrayList<Htchuanmei>();
		Htchuanmei ht = new Htchuanmei();
		ht.setKehuname(kehuname);
		ht.setUsername(ad.getNickname());
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
	 * Ʒ�ƺ�ͬ �޸ģ�
	 * ����һ�� ��ͬ��ŵĲ������ڴ˴���ѯ��ֱ�ӷ���һ����ͬ���� ��ǰ��
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/yewu/htchuanmei_edit")
    public ModelAndView htchuanmei_edit(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException, ParseException {
		String id = request.getParameter("id");
		Admins ad = (Admins)request.getSession().getAttribute("admin");
		Htchuanmei ht = new Htchuanmei();
		List<Htchuanmei> list = htchuanmeiDAO.getByIDAndUname(id,ad.getNickname());
		ht = list.get(0);
		
		model.put("model", ht);
		
		return new ModelAndView("/yewu/htchuameiedit",model);
	}
	/**
	 * ��ͬ �޸� �����ݿ���
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException 
	 */
	@RequestMapping("/yewu/ht_chuanmei_yingxing_edit")
	public void ht_chuanmei_yingxing_edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		Admins ad = (Admins) request.getSession().getAttribute("admin");
		String id = request.getParameter("id");
		String bianhao = request.getParameter("bianhao");
		String kehuname = request.getParameter("kehuname");
	    String hangye = request.getParameter("hangye");
	    String sdate = request.getParameter("sdate");
	    String edate = request.getParameter("edate");
	    String nodate = request.getParameter("nodate");
	    String meiti = request.getParameter("meiti");
	    String guige = request.getParameter("guige");
	    String shiduan = request.getParameter("shiduan");
	    String iszengsong = request.getParameter("iszengsong");
	    String zsshiduan = request.getParameter("zsshiduan");
	    String zhekou = request.getParameter("zhekou");
	    String bochutianshu = request.getParameter("bochutianshu");
	    String bochucishu = request.getParameter("bochucishu");
	    String price = request.getParameter("price");
	    String fkyddate = request.getParameter("fkyddate");
	    String fkfangshi = request.getParameter("fkfangshi");
	    String beizhu = request.getParameter("beizhu");
		
	    List<Htchuanmei> list = htchuanmeiDAO.getByIDAndUname(id,ad.getNickname());
	    
	    Htchuanmei ht = list.get(0);
	    ht.setBianhao(bianhao);
	    ht.setKehuname(kehuname);
	    ht.setHangye(hangye);
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
	    ht.setCdate(new Date());
	    ht.setSdate(df.parse(sdate));
	    ht.setEdate(df.parse(edate));
	    ht.setNodate(nodate);
	    ht.setMeiti(meiti);
	    ht.setGuige(guige);
	    ht.setShiduan(shiduan);
	    ht.setZhekou(zhekou);
	    ht.setBochutianshu(Integer.valueOf(bochutianshu));
	    ht.setBochucishu(Integer.valueOf(bochucishu));
	    ht.setPrice(Integer.valueOf(price));
	    ht.setFkyddate(df.parse(fkyddate));
	    ht.setFkfangshi(fkfangshi);
	    ht.setBeizhu(beizhu);
	    ht.setIslock("true");
	    ht.setIspay("false");
	    ht.setIstingbo("true");
	    ht.setUsername(ad.getNickname());
	    ht.setIsedit("true");
	    ht.setZuofei("false");
	    ht.setIszengsong(iszengsong);
	    ht.setZsshiduan(zsshiduan);
	    
	    htchuanmeiDAO.save(ht);
	    
		String result = "�޸ĳɹ���";
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
}
