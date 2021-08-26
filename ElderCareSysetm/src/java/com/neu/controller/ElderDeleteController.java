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
public class ElderDeleteController extends SimpleFormController {

    public ElderDeleteController() {
        setCommandClass(Elder.class);
        setCommandName("elder");
        setSuccessView("reminder");
        setFormView("delete_elder");
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
          
        String s=request.getParameter("id");
        int id=Integer.parseInt(s);

        ElderDao elderdao = (ElderDao)getApplicationContext().getBean("ElderDao");
        int i=elderdao.deleteElders(id);
        if(i == 1){
            mv.addObject("reminder_s", "You have delete the elder info successfully!");
            mv.addObject("backName","index_nursingworker.jsp");
            mv.setViewName(this.getSuccessView());
        }else {
            mv.addObject("reminder", "Operation failed! Please try again.");
            mv.addObject("backName","index_nursingworker.jsp");
            mv.setViewName("reminder");
        }  
        }catch(Exception e){
            mv.addObject("reminder", "Operation failed! Please try again.");
            mv.addObject("backName","index_nursingworker.jsp");
            mv.setViewName("reminder");
        }
        
        return mv;
    }
}
