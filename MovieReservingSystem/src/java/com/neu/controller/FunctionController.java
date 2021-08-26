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
public class FunctionController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String function=hsr.getParameter("option");
        if(function==null){
            return new ModelAndView("main");
        }else if(function.equals("addMovie")){
            return new ModelAndView("redirect:/addMovie.htm");
        }else if(function.equals("searchMovie")){
            return new ModelAndView("redirect:/searchMovie.htm");
        }
        return new ModelAndView("main");
    }

    
}
