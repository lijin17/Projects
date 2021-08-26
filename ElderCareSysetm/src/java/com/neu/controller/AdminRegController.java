/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ElderDao;
import com.neu.dao.AdminDao;
import com.neu.pojo.Administrator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author lijin
 */
public class AdminRegController extends SimpleFormController {

    public AdminRegController() {
        setCommandClass(Administrator.class);
        setCommandName("administrator");
        setSuccessView("reminder_s");
        setFormView("register_admin");
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
        

        String name = request.getParameter("name");
        String phoneNum = request.getParameter("phoneNum");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        AdminDao admindao = (AdminDao) getApplicationContext().getBean("AdminDao");
        try{
          if ((!name.equals("")&&!phoneNum.equals("")&&!address.equals("")&&!email.equals("")&&!password.equals("")&&!gender.equals(""))&&(admindao.addAdmin(name, phoneNum, address, email, password, gender) == 1)) {
            mv.addObject("reminder", "You have registered as an administrator successfully!");
            mv.addObject("backName", "register_choose.jsp");
            mv.setViewName(this.getSuccessView());
        } else {
            mv.addObject("reminder", "Registration failed!");
            mv.addObject("backName", "register_admin.jsp");
            mv.setViewName("reminder");
        }  
        }catch(Exception e){
            mv.addObject("reminder", "Registration failed!");
            mv.addObject("backName", "register_admin.jsp");
            mv.setViewName("reminder");
        }
        

        return mv;
    }
}
