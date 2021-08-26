/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.AdminDao;
import com.neu.dao.ElderDao;
import com.neu.dao.NursingWorkerDao;
import com.neu.pojo.Administrator;
import com.neu.pojo.Elder;
import com.neu.pojo.NursingWorker;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author lijin
 */
public class LogoutController extends AbstractController {

    

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView();       
        try{
            HttpSession session =hsr.getSession();
            session.invalidate();
            mv.setViewName("login_choose");
        }catch(Exception e){
            e.printStackTrace();
            mv.addObject("reminder", "logout failed");
            mv.setViewName("reminder");
        }
        return mv;
    }
}
