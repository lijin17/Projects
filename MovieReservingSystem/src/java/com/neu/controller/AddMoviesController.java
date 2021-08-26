/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.movieDao;
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
public class AddMoviesController extends SimpleFormController {

    public AddMoviesController() {
        setCommandClass(Movie.class);
        setCommandName("movie");
        setSuccessView("reminder");
        setFormView("addMovie");
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
        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String actress = request.getParameter("actress");
        String genre = request.getParameter("genre");
        String year = request.getParameter("year");

        movieDao movieDao = (movieDao)getApplicationContext().getBean("movieDao");
        if(movieDao.addMovie(title,actor,actress,genre,year) == 1){
            mv.addObject("reminder", "You have added the movie info successfully!");
            mv.setViewName(this.getSuccessView());
        }else {
            mv.addObject("reminder", "Add movie info failed!");
            mv.setViewName(this.getSuccessView());
        }
        return mv;
    }
}
