/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author lijin
 */
public class SignInController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String identity=hsr.getParameter("identity");
        if(identity==null){
            return new ModelAndView("login_choose");
        }else if(identity.equals("nursingworker")){
            return new ModelAndView("index_nursingworker");
        }else if(identity.equals("administrator")){
            return new ModelAndView("index_admin");
        }
        return new ModelAndView("login_choose");
    }

    
}
