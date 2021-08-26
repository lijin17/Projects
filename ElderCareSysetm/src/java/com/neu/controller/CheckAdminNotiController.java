/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.NotificationDao;
import com.neu.pojo.Administrator;
import com.neu.pojo.Notification;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author lijin
 */
public class CheckAdminNotiController extends SimpleFormController {

    public CheckAdminNotiController() {
        setCommandClass(Administrator.class);
        setCommandName("notification");
        setSuccessView("index_nursingworker");
        setFormView("table_NurseNoti");
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
        try{
            
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("workerName");
        NotificationDao ndao = (NotificationDao) getApplicationContext().getBean("NotificationDao");
        ArrayList<Notification> notification = new ArrayList<>();
        notification = (ArrayList<Notification>) ndao.getNotificationsBy(name, "receiver");
        session.setAttribute("Notifications", notification);
        mv.setViewName(this.getSuccessView());
        }catch(Exception e){
             mv.addObject("reminder", "There's an error here. Please try again.");
            mv.addObject("backName", "index_nursingworker.jsp");
            mv.setViewName("reminder");
        }
        
        return mv;
    }
}
