package com.hiynn.test.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hiynn.test.dao.PoiTestDao;

/**
 * <p>Title: UserController </p>
 * <p>Description: TODO </p>
 * Date: 2017年9月15日 上午11:35:04
 *
 * @author hydata@hiynn.com
 * @version 1.0 </p>
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年9月15日         jiangzhegnxiong         创建文件,实现基本功能
 * <p>
 * ==========================================================
 */
@Controller
@RequestMapping("/user")
public class UserController {

    static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private PoiTestDao poiTestDao;


    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, Model model) {
        ModelAndView mo = new ModelAndView("index");
        List<Object> list = poiTestDao.selectApartInfo();
        mo.addObject("list", list);
        return mo;
    }


}  
