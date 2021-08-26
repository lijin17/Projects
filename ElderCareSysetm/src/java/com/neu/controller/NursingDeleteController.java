/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ElderDao;
import com.neu.dao.NursingWorkerDao;
import com.neu.pojo.Elder;
import com.neu.pojo.Movie;
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
public class NursingDeleteController extends SimpleFormController {

    public NursingDeleteController() {
        setCommandClass(NursingWorker.class);
        setCommandName("nursingworker");
        setSuccessView("index_admin");
        setFormView("delete_nursing");
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

            NursingWorkerDao nsdao = (NursingWorkerDao) getApplicationContext().getBean("NursingWorkerDao");
            int i = nsdao.deleteNurse(id);
            if (i == 1) {
                mv.addObject("reminder", "You have delete the worker successfully!");
                mv.addObject("backName","index_admin.jsp");
                mv.setViewName("reminder_s");
            } else {
                mv.addObject("reminder", "Deletion failed! Please try again.");
                mv.addObject("backName","index_admin.jsp");
                mv.setViewName("reminder");
            }
        }catch(Exception e){
            mv.addObject("reminder", "Operation failed! Please try again.");
                mv.addObject("backName","index_admin.jsp");
                mv.setViewName("reminder");
        }

        return mv;
    }
}
