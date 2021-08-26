/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ElderDao;
import com.neu.dao.NursingWorkerDao;
import com.neu.pojo.Elder;
import com.neu.pojo.NursingWorker;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author lijin
 */
public class ElderModifyController extends SimpleFormController {

    public ElderModifyController() {
        setCommandClass(Elder.class);
        setCommandName("elder");
        setSuccessView("index_nursingworker");
        setFormView("modify_elder");

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
            String s = request.getParameter("id");
            int id = Integer.parseInt(s);
            String name = request.getParameter("name");
            String phoneNum = request.getParameter("phoneNum");
            String address = request.getParameter("address");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String birthday = request.getParameter("birthday");
            if (name.equals("") || phoneNum.equals("") || address.equals("") || password.equals("") || gender.equals("") || birthday.equals("")) {
                mv.addObject("reminder", "Every attribute should be filled in!");
                mv.addObject("backName", "modify_elder.jsp");
                mv.setViewName("reminder");
            } else {
                ElderDao elderdao = (ElderDao) getApplicationContext().getBean("ElderDao");
                int i = elderdao.ModifyElder(id, name, phoneNum, address, password, gender, birthday);
                if (i == 1) {
                    mv.addObject("reminder", "Modify Successful!");
                    mv.addObject("backName", "index_nursingworker.jsp");
                    mv.setViewName("reminder_s");
                    
                } else {
                    mv.addObject("reminder", "Modify Failed!");
                    mv.addObject("backName", "index_nursingworker.jsp");
                    mv.setViewName("reminder");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("reminder", "Operation Failed!");
            mv.setViewName("reminder");
        }
        return mv;
    }
}
