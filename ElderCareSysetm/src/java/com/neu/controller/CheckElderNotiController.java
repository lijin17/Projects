/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.NotificationDao;
import com.neu.pojo.Notification;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author lijin
 */
public class CheckElderNotiController extends AbstractController {

    

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView();
        try{
        
        HttpSession session = hsr.getSession();
        String name = (String) session.getAttribute("elderName");
        NotificationDao ndao = (NotificationDao) getApplicationContext().getBean("NotificationDao");
        ArrayList<Notification> notification = new ArrayList<>();
        notification = (ArrayList<Notification>) ndao.getNotificationsBy(name, "receiver");
        session.setAttribute("Notifications", notification);
        mv.setViewName("table_ElderNoti");    
        }catch(Exception e){
            mv.addObject("reminder","There is an error here, please try again.");
            mv.addObject("backName","index_elder.jsp");
            mv.setViewName("reminder");
        }
        return mv;
    }
}
