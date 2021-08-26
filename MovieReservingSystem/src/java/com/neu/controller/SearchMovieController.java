/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.movieDao;
import com.neu.pojo.Movie;
import com.neu.pojo.SearchInfo;
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
public class SearchMovieController extends SimpleFormController {

    public SearchMovieController() {
        setCommandClass(SearchInfo.class);
        setCommandName("SearchInfo");
        setSuccessView("searchData");
        setFormView("searchMovie");

    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView();
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");

        movieDao movieDao = (movieDao) getApplicationContext().getBean("movieDao");
        ArrayList<Movie> movies = new ArrayList<>();
        movies = (ArrayList<Movie>) movieDao.getMovies(keyword, type);
        if (movies.size() == 0) {
            mv.addObject("keyword", "There is no results about "+keyword);
            mv.setViewName(this.getSuccessView());
        } else {
            mv.addObject("keyword", "Your searching keyword is: "+keyword);
            mv.addObject("movies", movies);
            mv.setViewName(this.getSuccessView());
        }
        return mv;
    }
}
