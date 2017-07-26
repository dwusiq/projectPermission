package com.wusiq.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于切换页面的控制器
 */
@Controller
@RequestMapping(value = "pageChange")
public class PageChangeController {
    /*首页*/
    @RequestMapping(value = "login.do",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/firstPage");
        return mv;
    }

    /*用户管理页面*/
    @RequestMapping(value = "userManagePage.do",method = RequestMethod.GET)
    public ModelAndView userManagePage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/userManagePage");
        return mv;
    }


}
