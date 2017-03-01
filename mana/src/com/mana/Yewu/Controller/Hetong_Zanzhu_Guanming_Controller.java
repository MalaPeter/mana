package com.mana.Yewu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 节目赞助和节目冠名，只有价格不同，其他数据类型相同
 * @author 安静波
 *
 */
@Controller
public class Hetong_Zanzhu_Guanming_Controller {
	
	/**
	 * 跳转 赞助冠名登记页面
	 */
	@RequestMapping("/yewu_zanzhu_guanming/index")
    public ModelAndView index() {
        return new ModelAndView("/yewu_zanzhu_guanming/index");
    }
	/**
	 * 跳转 赞助冠名列表页面
	 */
	@RequestMapping("/yewu_zanzhu_guanming/list")
    public ModelAndView list() {
        return new ModelAndView("/yewu_zanzhu_guanming/list");
    }
}
