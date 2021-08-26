/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.NotificationDao;
import com.neu.pojo.Administrator;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author lijin
 */
public class SendNotiController extends SimpleFormController {

    public SendNotiController() {
        setCommandClass(Administrator.class);
        setCommandName("notification");
        setSuccessView("index_nursingworker");
        setFormView("notify_nursingworker");
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(this.getSuccessView());

        try {
            String content = request.getParameter("content");
            String sender = request.getParameter("from");
            String receiver = request.getParameter("to");

            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String t = dateFormat.format(now);

            NotificationDao ndao = (NotificationDao) getApplicationContext().getBean("NotificationDao");
            if (content.equals("") || sender.equals("") || receiver.equals("")) {
                mv.addObject("reminder", "Operation failed! All blanks should be filled.");
                mv.addObject("backName", "index_nursingworker.jsp");
                mv.setViewName("reminder");
            } else {
                if (ndao.addNotification(content, sender, receiver, t) == 1) {
                    mv.addObject("reminder", "Operation successful!");
                    mv.addObject("backName", "index_nursingworker.jsp");
                    mv.setViewName("reminder_s");

                } else {
                    mv.addObject("reminder", "Operation failed! Please try again.");
                    mv.addObject("backName", "index_nursingworker.jsp");
                    mv.setViewName("reminder");
                }
            }

        } catch (Exception e) {
            mv.addObject("reminder", "Operation failed! Please try again.");
            mv.addObject("backName", "index_nursingworker.jsp");
            mv.setViewName("reminder");
        }

        return mv;
    }
}
