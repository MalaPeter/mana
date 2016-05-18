package com.mana.Yewu.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mana.pojo.Admins;
import com.mana.pojo.Qianzhiyewu;
import com.mana.pojo.QianzhiyewuDAO;

/**
 * ǰ��ҵ������
 * @author ������
 */
@Controller
public class QianzhiyewuController {
	
	@Resource(name="qianzhiyewuDAO")
	QianzhiyewuDAO qianzhiyewuDAO;
	
	/**
	 * ��½�� ǰ��ҵ�� ¼����ҳ
	 * ������C ���ܷ���ҳ��
	 * @return
	 */
	@RequestMapping("/yewu/qianzhiyewuindex")
    public ModelAndView qianzhiyewuindex() {
		//
        return new ModelAndView("/yewu/qianzhiyewuindex");
    }
	
	/**
	 * ǰ��ҵ�� ����
	 */
	@RequestMapping("/yewu/qianzhiyewusave")
	public ModelAndView qianzhiyewusave(HttpServletRequest request, HttpServletResponse response) {
		boolean guaqi = Boolean.parseBoolean(request.getParameter("guaqi"));
		//String ctime = request.getParameter("ctime");
		String shixiao = request.getParameter("shixiao");
		String kehuname= request.getParameter("kehuname");
		String hangye= request.getParameter("hangye");
		String kehulianxiren= request.getParameter("kehulianxiren");
		String kehuzhiwu= request.getParameter("kehuzhiwu");
		String kehutel= request.getParameter("kehutel");
		String kehudizhi= request.getParameter("kehudizhi");
		//String type = request.getParameter("type");
		String kehuleixing = request.getParameter("type");
		//¼���û���Ϣ ͨ��session���
		Qianzhiyewu qzyw = new Qianzhiyewu();
		qzyw.setIslock(guaqi?0:1);//������� true��=0 ����������=1 ����
		Date date = new Date();
		//Timestamp timeStamp = new Timestamp(date.getTime());
		qzyw.setCtime(new Timestamp(date.getTime()));
		qzyw.setShixiao(Integer.valueOf(shixiao));
		qzyw.setKehuname(kehuname);
		qzyw.setHangye(hangye);
		qzyw.setKehulianxiren(kehulianxiren);
		qzyw.setKehuzhiwu(kehuzhiwu);
		qzyw.setKehutel(kehutel);
		qzyw.setKehudizhi(kehudizhi);
		qzyw.setKehuleixing(kehuleixing);
		Admins ad = (Admins) request.getSession().getAttribute("admin");
		qzyw.setUsername(ad.getNickname());
		
		qianzhiyewuDAO.save(qzyw);
		//ȥ�� �û��Լ��� ǰ��ҵ���б�
		return new ModelAndView("redirect:/yewu/qianzhiyewulist");
	}
	
	/**
	 * ǰ��ҵ�� ��˾У��
	 * ����һ�� ajax����
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/yewu/qianzhiyewucheck")
	public void qianzhiyewucheck(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		//��ѯ
		List<Qianzhiyewu> list = qianzhiyewuDAO.findByKehuname(request.getParameter("kehuname"));
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		//Ҫ���Ƚϵ�����
		long tianshu = -1;
		//Ҫ�����������
		Qianzhiyewu qz = null;
		if(list.size() > 0) {
			//����м�¼��Ҫ�鿴 �Ƿ��Ѿ�����
			//��Ҫ �����д��ڵļ�¼ ����ѭ�� ��ѯ,��ѯ��  �Ѿ���ռ�ò���ʱЧ���
			Qianzhiyewu qzyw = null;
			Iterator<Qianzhiyewu> it = list.iterator();
			while(it.hasNext()) {
				qzyw = it.next();
				//�鿴�Ƿ� ��δִ���������
				//��Ҫ������װ ʱ�䣬�ȱȽ����ڣ����Ƚ�ʱ��
				int year =qzyw.getCtime().getYear()+1900;
				int month =qzyw.getCtime().getMonth() +1;
				int day =qzyw.getCtime().getDate();
//				int hour =qzyw.getCtime().getHours();
//				int minite =qzyw.getCtime().getMinutes();
//				int Second =qzyw.getCtime().getSeconds();
				
				//��ǰʱ��Timestamp
				//Timestamp d = new Timestamp(System.currentTimeMillis());
				
				//��ʽ�� �� ��¼������+ʱЧ ���������
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        String str= year+"-"+month+"-"+day;
		        //���Ŀ������
		        Date dt=sdf.parse(str);
		        Calendar renwudate = Calendar.getInstance();
		        renwudate.setTime(dt);
		        //rightNow.add(Calendar.YEAR,-1);//���ڼ�1��
		        //rightNow.add(Calendar.MONTH,3);//���ڼ�3����
		        renwudate.add(Calendar.DAY_OF_YEAR,qzyw.getShixiao());//���ڼ� ʱЧ����
		        Date dt1 = renwudate.getTime();
		        //String reStr = sdf.format(dt1);
		        //��õ�ǰ����
		        Date nowdate = new Date() ;
		        //�жϣ����  ¼������+ʱЧ �� ��ǰ����֮����ô��Ҫ��ʾ
		        if(dt1.after(nowdate)) {
		        	//��� ����ִ�� ���� ��ǰ���ڣ��� ���мӼ���������������Ȼ�� ��¼���������ֱ�����м�¼����һ�飬�����������Ǹ���
		        	//��õ�ǰ ������
		        	Calendar nowDate=Calendar.getInstance();
		        	nowDate.setTime(new Date());//����Ϊ��ǰϵͳʱ�� 
		        	long timeNow=nowDate.getTimeInMillis();
		        	//������� ������
		        	long timerenwu=renwudate.getTimeInMillis();
		        	//������˴ε��������� �Ѿ��洢����������ô��¼�µ�����
		        	if(tianshu <= (timerenwu-timeNow)/(1000*60*60*24)) {
		        		//Ҫ��������ݣ�������
		        		qz = qzyw;
		        		tianshu = (timerenwu-timeNow)/(1000*60*60*24);//��Ϊ��
		        	}
		        	//response.getWriter().write("{\"success\":true ,\"size\": 22}");
		        }
			}
			//�˳�ѭ�����¼�����Ƚ� ʱЧ��ģ����������ݷ��ظ�ǰ��
	        if(tianshu >= 0){//��������ִ��
	        	response.getWriter().write("{\"success\":true ,\"username\":\""+qz.getUsername()+"\",\"tianshu\":"+tianshu+" }");
	        } else {//��������ִ��
	        	//response.getWriter().write("{\"success\":false ,\"msg\":\""+request.getParameter("kehuname")+"Ŀ�깫˾����ע��\" }");
	        	response.getWriter().write("{\"success\":false ,\"msg\":\"ԭ��������ִ����ϣ�����ִ���µ�����.���Ҫ�ύ���룬���� �������ٴ��ύ��\" }");
	        }
		} else {//���û����ҹ�˾��ֱ����ʾ����ע��
			response.getWriter().write("{\"success\":false ,\"msg\":\""+request.getParameter("kehuname")+"!Ŀ�깫˾����ע��!���Ҫ�ύ���룬���� �������ٴ��ύ��\" }");
		}
		response.getWriter().flush();
		//return new ModelAndView("/yewu/qianzhiyewusave");
	}
	
	/**
	 * ��½�� ǰ��ҵ�� ��ѯ�б�
	 * @return
	 */
	@RequestMapping("/yewu/qianzhiyewulist")
    public ModelAndView qianzhiyewulist() {
		//����û��Լ���
        return new ModelAndView("/yewu/mylist");
    }
	/**
	 * ����Ȩ�ޣ��жϲ�ѯѡ�� �Ƿ񼤻�
	 * ����� �����Լ���ֻ���� ʱ�䡢��˾���ơ���ϵ�ˡ���ϵ�˵绰����˾��ַ ��
	 * ����� ����Ȩ�ޣ��򼤻����й��ܣ����� ���������
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@RequestMapping("/yewu/qianzhiyewulistdata")
    public void qianzhiyewulistdata(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		List<Qianzhiyewu> list = new ArrayList<Qianzhiyewu>();
		List<YwJsonData> listdata = new ArrayList<YwJsonData>();
		//����Ȩ�޲�ѯ
		Admins ad = (Admins) request.getSession().getAttribute("admin");
		if(ad.getRliulan() == 1) {//������Լ�
			list = qianzhiyewuDAO.findByUsername(ad.getNickname());
		}
		if(ad.getRliulan() == 2) {//�����ȫ��
			list = qianzhiyewuDAO.findAll();
		}
		//������װ���� �����ҳ������ʾ
		if(list.size() > 0) {
			YwJsonData data = new YwJsonData();
			long tianshu = -1;//�����⣬ԭ������ ��¼�����Ǹ���������ÿ������Ҫ��¼
			Qianzhiyewu qzyw = null;
			Qianzhiyewu qz = null;
			Iterator<Qianzhiyewu> it = list.iterator();
			while(it.hasNext()) {
				qzyw = it.next();
				//�鿴�Ƿ� ��δִ���������
				//��Ҫ������װ ʱ�䣬�ȱȽ����ڣ����Ƚ�ʱ��
				int year =qzyw.getCtime().getYear()+1900;
				int month =qzyw.getCtime().getMonth() +1;
				int day =qzyw.getCtime().getDate();
				int hour =qzyw.getCtime().getHours();
				int minite =qzyw.getCtime().getMinutes();
				int Second =qzyw.getCtime().getSeconds();
				//��ʽ�� �� ��¼������+ʱЧ ���������
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        String str= year+"-"+month+"-"+day;
		        //���Ŀ������
		        Date dt=sdf.parse(str);
		        Calendar renwudate = Calendar.getInstance();
		        renwudate.setTime(dt);
		        renwudate.add(Calendar.DAY_OF_YEAR,qzyw.getShixiao());//���ڼ� ʱЧ����
		        Date dt1 = renwudate.getTime();
		        //��õ�ǰ����
		        Date nowdate = new Date() ;
		        //�жϣ����  ¼������+ʱЧ �� ��ǰ����֮����ô��Ҫ��ʾ
		        if(dt1.after(nowdate)) {
		        	//��� ����ִ�� ���� ��ǰ���ڣ��� ���мӼ���������������Ȼ�� ��¼���������ֱ�����м�¼����һ�飬�����������Ǹ���
		        	//��õ�ǰ ������
		        	Calendar nowDate=Calendar.getInstance();
		        	nowDate.setTime(new Date());//����Ϊ��ǰϵͳʱ�� 
		        	long timeNow=nowDate.getTimeInMillis();
		        	//������� ������
		        	long timerenwu=renwudate.getTimeInMillis();
		        	//������˴ε��������� �Ѿ��洢����������ô��¼�µ�����
		        	tianshu = (timerenwu-timeNow)/(1000*60*60*24);//��Ϊ��
		        }
		        //�����ݼ��뵽Ҫ����� jsondata��
		        data = new YwJsonData();
		        data.setId(qzyw.getId().toString());
		        data.setCtime(year+"-"+month+"-"+day+" "+hour+":"+minite+":"+Second);
		        data.setIslock(qzyw.getIslock().toString());
		        data.setKehuname(qzyw.getKehuname());
		        data.setKehutel(qzyw.getKehutel());
		        if(tianshu >= 0){
		        	data.setShengyutianshu(String.valueOf(tianshu)+"��");
		        	tianshu = -1;
		        } else {
		        	data.setShengyutianshu("����");
		        }
		        data.setShixiao(qzyw.getShixiao().toString()+"��");
		        data.setUsername(qzyw.getUsername());
		        data.setHangye(qzyw.getHangye());
		        data.setPiyu(qzyw.getPiyu());
		        listdata.add(data);
			}
		}
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(listdata);
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
    }
	
	/**
	 * ǰ��ҵ��  ҵ���ѯ
	 */
	@RequestMapping("/yewu/qianzhiyewusearch1")
    public void qianzhiyewusearch1(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String kehuname = request.getParameter("kehuname");
		int islock = Integer.valueOf(request.getParameter("islock"));
		List<Qianzhiyewu> list = new ArrayList<Qianzhiyewu>();
		List<YwJsonData> listdata = new ArrayList<YwJsonData>();
		Qianzhiyewu q = new Qianzhiyewu();
		//����Ȩ�޲�ѯ
		Admins ad = (Admins) request.getSession().getAttribute("admin");
		if(ad.getRliulan() == 1) {//������Լ�
			//�жϴ���� �ͻ����Ʋ�����Ϊ��
			if(kehuname != null) {
				if(!kehuname.trim().equals("")) {
					q.setUsername(ad.getNickname());
					q.setKehuname(kehuname);
					if(islock == 0)
						q.setIslock(0);
				} else {//���ַ��� �������Լ������м�¼
					q.setUsername(ad.getNickname());
					if(islock == 0)
						q.setIslock(0);
				}
			} else {//�� null �������Լ����м�¼
				q.setUsername(ad.getNickname());
				if(islock == 0)
					q.setIslock(0);
			}
		}
		if(ad.getRliulan() == 2) {//�����ȫ��
			if(kehuname != null) {
				if(!kehuname.trim().equals("")) {
					q.setKehuname(kehuname);
					if(islock == 0){
						q.setIslock(0);
					}

				} else {//���ַ��� �������м�¼
					if(islock == 0){
						q.setIslock(0);
					}
				}
			} else {//�� null �������м�¼
				if(islock == 0){
					q.setIslock(0);
				}
			}
		}
		list = qianzhiyewuDAO.findByExample(q);
		//������װ���� �����ҳ������ʾ
		if(list.size() > 0) {
			YwJsonData data = new YwJsonData();
			long tianshu = -1;//�����⣬ԭ������ ��¼�����Ǹ���������ÿ������Ҫ��¼
			Qianzhiyewu qzyw = null;
			//Qianzhiyewu qz = null;
			Iterator<Qianzhiyewu> it = list.iterator();
			while(it.hasNext()) {
				qzyw = it.next();
				//�鿴�Ƿ� ��δִ���������
				//��Ҫ������װ ʱ�䣬�ȱȽ����ڣ����Ƚ�ʱ��
				int year =qzyw.getCtime().getYear()+1900;
				int month =qzyw.getCtime().getMonth() +1;
				int day =qzyw.getCtime().getDate();
				int hour =qzyw.getCtime().getHours();
				int minite =qzyw.getCtime().getMinutes();
				int Second =qzyw.getCtime().getSeconds();
				//��ʽ�� �� ��¼������+ʱЧ ���������
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        String str= year+"-"+month+"-"+day;
		        //���Ŀ������
		        Date dt=sdf.parse(str);
		        Calendar renwudate = Calendar.getInstance();
		        renwudate.setTime(dt);
		        renwudate.add(Calendar.DAY_OF_YEAR,qzyw.getShixiao());//���ڼ� ʱЧ����
		        Date dt1 = renwudate.getTime();
		        //��õ�ǰ����
		        Date nowdate = new Date() ;
		        //�жϣ����  ¼������+ʱЧ �� ��ǰ����֮����ô��Ҫ��ʾ
		        if(dt1.after(nowdate)) {
		        	//��� ����ִ�� ���� ��ǰ���ڣ��� ���мӼ���������������Ȼ�� ��¼���������ֱ�����м�¼����һ�飬�����������Ǹ���
		        	//��õ�ǰ ������
		        	Calendar nowDate=Calendar.getInstance();
		        	nowDate.setTime(new Date());//����Ϊ��ǰϵͳʱ�� 
		        	long timeNow=nowDate.getTimeInMillis();
		        	//������� ������
		        	long timerenwu=renwudate.getTimeInMillis();
		        	//������˴ε��������� �Ѿ��洢����������ô��¼�µ�����
		        	tianshu = (timerenwu-timeNow)/(1000*60*60*24);//��Ϊ��
		        }
		        //�����ݼ��뵽Ҫ����� jsondata��
		        data = new YwJsonData();
		        data.setId(qzyw.getId().toString());
		        data.setCtime(year+"-"+month+"-"+day+" "+hour+":"+minite+":"+Second);
		        data.setIslock(qzyw.getIslock().toString());
		        data.setKehuname(qzyw.getKehuname());
		        data.setKehutel(qzyw.getKehutel());
		        if(tianshu >= 0){
		        	data.setShengyutianshu(String.valueOf(tianshu)+"��");
		        	tianshu = -1;
		        } else {
		        	data.setShengyutianshu("����");
		        }
		        data.setShixiao(qzyw.getShixiao().toString()+"��");
		        data.setUsername(qzyw.getUsername());
		        data.setHangye(qzyw.getHangye());
		        data.setPiyu(qzyw.getPiyu());
		        listdata.add(data);
			}
		}
		
		String result = "";
		Gson gson = new Gson();
		result = gson.toJson(listdata);
		//������Ӧ����
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
	
	/**
	 * ǰ��ҵ��  ����ҳ�� ��ת
	 */
	@RequestMapping("/yewu/qianzhiyewushenpi")
    public ModelAndView qianzhiyewushenpi(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		return new ModelAndView("/yewu/shenpi");
	}
	
	/**
	 * ǰ��ҵ��  ���� �༭��������
	 * ����д�����ݣ����������ݿ⼴��
	 */
	@RequestMapping("/yewu/qianzhiyewushenpiupdate")
    public void qianzhiyewushenpiupdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String id = request.getParameter("id");
		String piyu = request.getParameter("piyu");
		String shenpi = request.getParameter("shenpi");//��ʱû�õ�
		
		Qianzhiyewu qzyw = qianzhiyewuDAO.findById(Integer.valueOf(id));
		qzyw.setPiyu(piyu);
		qianzhiyewuDAO.save(qzyw);
		
	}
}
