/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.BodyStatusDao;
import com.neu.pojo.BodyStatus;
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
public class CheckBodyController extends SimpleFormController {

    public CheckBodyController() {
        setCommandClass(BodyStatus.class);
        setCommandName("bodystatus");
        setSuccessView("table_bodyStatus");
        setFormView("check_nursing");
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
        String id = request.getParameter("id");
        int elderid=Integer.parseInt(id);
        HttpSession session=request.getSession();
        try{
            BodyStatusDao bsdao = (BodyStatusDao)getApplicationContext().getBean("BodyStatusDao");
            ArrayList<BodyStatus> bodys=new ArrayList<>();
            bodys=(ArrayList<BodyStatus>) bsdao.getAllBodyStatus(elderid);
            session.setAttribute("BodyStatus", bodys);
            session.setAttribute("Checkbodyid", id);
            mv.setViewName(this.getSuccessView());
        }catch(Exception e){
            e.printStackTrace();
            mv.addObject("reminder", "Operation failed!");
            mv.addObject("backName", "check_nursing.jsp");
            mv.setViewName(this.getSuccessView());
        }
        
        return mv;
    }
}
