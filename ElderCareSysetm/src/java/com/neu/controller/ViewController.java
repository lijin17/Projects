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
public class ViewController extends SimpleFormController {

    public ViewController() {
        setCommandClass(Elder.class);
        setCommandName("elder");
        setSuccessView("reminder");
        setFormView("elder_register");
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
        String password = request.getParameter("password");
        //int id =Integer.parseInt(request.getParameter("bedid")) ;
        String gender=request.getParameter("gender");
        String birthday=request.getParameter("birthday");

        ElderDao elderdao = (ElderDao)getApplicationContext().getBean("ElderDao");
        if(elderdao.addElder(name, phoneNum, address, password, gender, birthday) == 1){
            mv.addObject("reminder", "You have added the movie info successfully!");
            mv.setViewName(this.getSuccessView());
        }else {
            mv.addObject("reminder", "Add movie info failed!");
            mv.setViewName(this.getSuccessView());
        }
        return mv;
    }
}
