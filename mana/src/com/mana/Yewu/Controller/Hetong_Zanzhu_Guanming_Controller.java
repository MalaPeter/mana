package com.mana.Yewu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * ��Ŀ�����ͽ�Ŀ������ֻ�м۸�ͬ����������������ͬ
 * @author ������
 *
 */
@Controller
public class Hetong_Zanzhu_Guanming_Controller {
	
	/**
	 * ��ת ���������Ǽ�ҳ��
	 */
	@RequestMapping("/yewu_zanzhu_guanming/index")
    public ModelAndView index() {
        return new ModelAndView("/yewu_zanzhu_guanming/index");
    }
	/**
	 * ��ת ���������б�ҳ��
	 */
	@RequestMapping("/yewu_zanzhu_guanming/list")
    public ModelAndView list() {
        return new ModelAndView("/yewu_zanzhu_guanming/list");
    }
}
