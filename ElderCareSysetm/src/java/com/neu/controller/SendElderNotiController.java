/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.NotificationDao;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author lijin
 */
public class SendElderNotiController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = hsr.getSession();
        try {

            String content = hsr.getParameter("content");
            String sender = (String) session.getAttribute("elderName");
            String receiver = hsr.getParameter("to");

            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String t = dateFormat.format(now);

            NotificationDao ndao = (NotificationDao) getApplicationContext().getBean("NotificationDao");
            if (content.equals("") || sender.equals("") || receiver.equals("")) {
                mv.addObject("reminder", "Operation failed! All blanks should be filled.");
                mv.addObject("backName", "index_admin.jsp");
                mv.setViewName("reminder");
            } else {
                if (ndao.addNotification(content, sender, receiver, t) == 1) {
                    if (receiver.equals("annElder") || receiver.equals("annNurse")) {
                        mv.setViewName("index_admin");
                    } else {
                        mv.setViewName("index_elder");
                    }
                } else {
                    if (session.getAttribute("elderName").equals("")) {
                        mv.addObject("reminder", "Operation failed! Please try again.");
                        mv.addObject("backName", "index_admin.jsp");
                        mv.setViewName("reminder");
                    } else {
                        mv.addObject("reminder", "Operation failed! Please try again.");
                        mv.addObject("backName", "index_elder.jsp");
                        mv.setViewName("reminder");

                    }

                }
            }

        } catch (Exception e) {
            if (session.getAttribute("elderName").equals("")) {
                mv.addObject("reminder", "Operation failed! Please try again.");
                mv.addObject("backName", "index_admin.jsp");
                mv.setViewName("reminder");
            } else {
                mv.addObject("reminder", "Operation failed! Please try again.");
                mv.addObject("backName", "index_elder.jsp");
                mv.setViewName("reminder");
            }

        }
        return mv;
    }
}
