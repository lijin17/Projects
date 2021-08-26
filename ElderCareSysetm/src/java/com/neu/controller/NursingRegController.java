/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ElderDao;
import com.neu.dao.AdminDao;
import com.neu.dao.NursingWorkerDao;
import com.neu.pojo.Administrator;
import com.neu.pojo.NursingWorker;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author lijin
 */
public class NursingRegController extends SimpleFormController {

    public NursingRegController() {
        setCommandClass(NursingWorker.class);
        setCommandName("nursingworker");
        setSuccessView("reminder");
        setFormView("register_nursingworker");
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

            String name = request.getParameter("name");
            String phoneNum = request.getParameter("phoneNum");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String type = request.getParameter("type");

            if (name.equals("") || phoneNum.equals("") || address.equals("") || email.equals("") || password.equals("") || gender.equals("") || type.equals("")) {
                mv.addObject("reminder", "You should fill all the blank. Please try again.");
                mv.addObject("backName", "register_choose.jsp");
                mv.setViewName("reminder");
            } else {
                NursingWorkerDao nsdao = (NursingWorkerDao) getApplicationContext().getBean("NursingWorkerDao");
                if (nsdao.addWoker(name, phoneNum, address, password, gender, email, type) == 1) {
                    mv.addObject("reminder", "You have registered as a nursing worker successfully!");
                    mv.addObject("backName", "login_choose.jsp");
                    mv.setViewName("reminder_s");
                } else {
                    mv.addObject("reminder", "Registration failed!!!");
                    mv.addObject("backName", "register_choose.jsp");
                    mv.setViewName("reminder");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("reminder", "Registration failed!!");
            mv.addObject("backName", "register_choose.jsp");
            mv.setViewName("reminder");
        }

        return mv;
    }
}
