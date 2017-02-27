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
import com.mana.pojo.Htpinpai;
import com.mana.pojo.HtpinpaiDAO;

/**
 * Ʒ�ƺ�ͬ
 * ��� Ʒ�ƺ�ͬ���Ѿ����ڵ� ҵ��Ա����
 * @author ������
 */
@Controller
public class PublicFunction {
	@Resource(name="htpinpaiDAO")
	HtpinpaiDAO htpinpaiDAO;
	
	@RequestMapping("/publicf/getYewuyuan_pinpai")
    public void saveshiduan(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
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
}
