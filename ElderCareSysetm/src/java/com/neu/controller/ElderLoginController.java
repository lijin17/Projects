/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ElderDao;
import com.neu.dao.NotificationDao;
import com.neu.dao.NursingWorkerDao;
import com.neu.pojo.Elder;
import com.neu.pojo.Notification;
import com.neu.pojo.NursingWorker;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ElderLoginController extends SimpleFormController {

    public ElderLoginController() {
        setCommandClass(Elder.class);
        setCommandName("elder");
        setSuccessView("index_elder");
        setFormView("login_elder");
        
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
        HttpSession sessionTemp=request.getSession();
        sessionTemp.invalidate();//refresh session
        HttpSession session=request.getSession();
               
        String s = request.getParameter("id");
        int id=Integer.parseInt(s);
        String password=request.getParameter("password");

        ElderDao elderdao = (ElderDao) getApplicationContext().getBean("ElderDao");
        ArrayList<Elder> n=new ArrayList<>();
        n=(ArrayList<Elder>) elderdao.getElders(id, "id");
        
        Date now=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
        String t=dateFormat.format(now);
        
        NotificationDao ndao=new NotificationDao();
        ArrayList<Notification> noti=new ArrayList<>();
        noti=(ArrayList<Notification>) ndao.getNotificationsBy(n.get(0).getName(), "receiver");
        ArrayList<Notification> no=(ArrayList<Notification>) ndao.getNotificationsBy("annElder", "receiver");
        String anno=no.get(no.size()-1).getContent();
                
        
        ArrayList<NursingWorker> ns=new ArrayList<>();
        NursingWorkerDao nursingdao=new NursingWorkerDao();
        ns=(ArrayList<NursingWorker>) nursingdao.getAllNursingWorkers();
        
            Elder elder=n.get(0);           
        if (elder.getPassword().equals(password)) {
            session.setAttribute("elderid", elder.getId());
            session.setAttribute("elderName", n.get(0).getName());
            session.setAttribute("date", t);
            session.setAttribute("bedid", n.get(0).getBed().getId());
            session.setAttribute("number", elderdao.getAllElders().size());
            session.setAttribute("notificationInfo", noti);
            session.setAttribute("nursingworkerInfo", ns);
            session.setAttribute("anno_elder", anno);
            
            mv.setViewName(this.getSuccessView());
        } else { 
            mv.addObject("reminder", "Login Failed!");
            mv.addObject("backName","login_elder.jsp");
            mv.setViewName("reminder");
        } 
        }catch(Exception e){
            e.printStackTrace();
            mv.addObject("reminder", "No such user");
            mv.addObject("backName","login_elder.jsp");
            mv.setViewName("reminder");
        }
        return mv;
    }
}
