/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.AdminDao;
import com.neu.dao.BodyStatusDao;
import com.neu.dao.ElderDao;
import com.neu.dao.NursingWorkerDao;
import com.neu.pojo.Administrator;
import com.neu.pojo.BodyStatus;
import com.neu.pojo.Elder;
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
public class AdminLoginController extends SimpleFormController {

    public AdminLoginController() {
        setCommandClass(Administrator.class);
        setCommandName("administrator");
        setSuccessView("index_admin");
        setFormView("login_admin");
        
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
        HttpSession session1=request.getSession();
        session1.invalidate();
        
        HttpSession session=request.getSession();        
        String s = request.getParameter("id");
        int id=Integer.parseInt(s);
        String password=request.getParameter("password");
        AdminDao admindao = (AdminDao) getApplicationContext().getBean("AdminDao");
        ArrayList<Administrator> n=new ArrayList<>();
        n=(ArrayList<Administrator>) admindao.getAdmin(id, "id");
        
        Date now=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
        String t=dateFormat.format(now);
        
        NursingWorkerDao nsdao=new NursingWorkerDao();
        ArrayList<NursingWorker> nss=new ArrayList<>();
        nss=(ArrayList<NursingWorker>) nsdao.getAllNursingWorkers();
        
        ElderDao elderdao=new ElderDao();
        ArrayList<Elder> elders=new ArrayList<>();
        elders=(ArrayList<Elder>) elderdao.getAllElders();
        
        ArrayList<Administrator> admins=new ArrayList<>();
        admins=(ArrayList<Administrator>) admindao.getAllAdmin();
        
        
        try{
            Administrator admin=n.get(0);
        if (admin.getPassword().equals(password)) {
            String name=admin.getName();
            session.setAttribute("elderName", name);
            session.setAttribute("date", t);
            session.setAttribute("nursingworkerInfo", nss);
            session.setAttribute("elderInfo", elders);
            session.setAttribute("adminInfo", admins);
            session.setAttribute("adminName", admin.getName());
            
            mv.setViewName(this.getSuccessView());
        } else { 
            mv.addObject("reminder", "Incorrect username or password");
            mv.addObject("backName", "login_admin.jsp");
            mv.setViewName("reminder");
        } 
        }catch(Exception e){
            e.printStackTrace();
            mv.addObject("reminder", "No such user!");
            mv.addObject("backName", "login_admin.jsp");
            mv.setViewName("reminder");
        }
        return mv;
    }
}
