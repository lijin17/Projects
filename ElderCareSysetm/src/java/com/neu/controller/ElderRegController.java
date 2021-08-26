/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ElderDao;
import com.neu.pojo.Elder;
import com.neu.pojo.Movie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author lijin
 */
public class ElderRegController extends SimpleFormController {

    public ElderRegController() {
        setCommandClass(Elder.class);
        setCommandName("elder");
        setSuccessView("index_nursingworker");
        setFormView("register_elder");
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
            String password = request.getParameter("password");
            //int id =Integer.parseInt(request.getParameter("bedid")) ;
            String gender = request.getParameter("gender");
            String birthday = request.getParameter("birthday");

            ElderDao elderdao = (ElderDao) getApplicationContext().getBean("ElderDao");
            if (name.equals("") || phoneNum.equals("") || address.equals("") || password.equals("") || gender.equals("") || birthday.equals("")) {
                mv.addObject("reminder", "You should fill all the blanks.");
                mv.addObject("backName", "register_elder.jsp");
                mv.setViewName("reminder");
            } else {
                if (elderdao.addElder(name, phoneNum, address, password, gender, birthday) == 1) {
                    mv.addObject("reminder", "You have added the movie info successfully!");
                    mv.setViewName(this.getSuccessView());
                } else {
                    mv.addObject("reminder", "Login failed. Please try again.");
                    mv.addObject("backName", "register_elder.jsp");
                    mv.setViewName("reminder");

                }
            }

        } catch (Exception e) {
            mv.addObject("reminder", "Operation failed. Please try again.");
            mv.addObject("backName", "register_elder.jsp");
            mv.setViewName("reminder");
        }

        return mv;
    }
}
