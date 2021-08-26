/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.validator;

import com.neu.pojo.Movie;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author lijin
 */
public class addMovieValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
       return Movie.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Movie movie=(Movie) o;
        ValidationUtils.rejectIfEmpty(errors, "title", "titleReminder");
        ValidationUtils.rejectIfEmpty(errors, "actor", "actorReminder");
        ValidationUtils.rejectIfEmpty(errors, "actress", "actressReminder");
        ValidationUtils.rejectIfEmpty(errors, "genre", "genreReminder");
        ValidationUtils.rejectIfEmpty(errors, "year", "yearReminder");
    }
    
}
