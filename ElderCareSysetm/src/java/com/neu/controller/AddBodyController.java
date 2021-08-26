/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.BodyStatusDao;
import com.neu.dao.ElderDao;
import com.neu.pojo.BodyStatus;
import com.neu.pojo.Elder;
import com.neu.pojo.Movie;
import java.util.ArrayList;
import java.util.Random;
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
public class AddBodyController extends SimpleFormController {

    public AddBodyController() {
        setCommandClass(BodyStatus.class);
        setCommandName("bodystatus");
        setSuccessView("check_bodystatus");
        setFormView("check_bodystatus");
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
        
        HttpSession session=request.getSession();
        
        int i=(int) session.getAttribute("elderid");
        String id=String.valueOf(i);
        int ID=Integer.parseInt(id);
        //generate HR
        int hr=(int) (Math.random()*60+41);
        String HR=String.valueOf(hr);
        //generate SP
        int sp=(int) (Math.random()*10+140);
        String SP=String.valueOf(sp);
        //generate DP
        int dp=(int) (Math.random()*10+80);
        String DP=String.valueOf(dp);
        //generate SPO2
        int spo2=(int) (Math.random()*10+90);
        String SPO2=String.valueOf(spo2);
        //generate TE
        int te=(int) (Math.random()*4+36);
        String TE=String.valueOf(te);
        //generate RE
        int re=(int) (Math.random()*5+15);
        String RE=String.valueOf(re);
        try{
            BodyStatusDao bsdao = (BodyStatusDao)getApplicationContext().getBean("BodyStatusDao");
            ElderDao elderdao=new ElderDao();
            ArrayList<Elder> elders=(ArrayList<Elder>) elderdao.getElders(ID, "id");
            bsdao.addBodyStatus(HR, SP, DP, SPO2, TE, RE, elders.get(0));
            session.setAttribute("HR", HR);
            session.setAttribute("SP", SP);
            session.setAttribute("DP", DP);
            session.setAttribute("SPO2", SPO2);
            session.setAttribute("TE", TE);
            session.setAttribute("RE", RE);           
        }catch(Exception e){
            e.printStackTrace();
            mv.addObject("reminder", "Add movie info failed!");
            mv.setViewName(this.getSuccessView());
        }
        
        return mv;
    }
}
