/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.validator;

import com.neu.pojo.Elder;
import com.neu.pojo.Movie;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author lijin
 */
public class addElderValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
       return Elder.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Elder elder=(Elder) o;
        ValidationUtils.rejectIfEmpty(errors, "name", "titleReminder");
        ValidationUtils.rejectIfEmpty(errors, "phoneNum", "actorReminder");
        ValidationUtils.rejectIfEmpty(errors, "address", "actressReminder");
        ValidationUtils.rejectIfEmpty(errors, "birthday", "genreReminder");
        ValidationUtils.rejectIfEmpty(errors, "password", "yearReminder");
        ValidationUtils.rejectIfEmpty(errors, "gender", "yearReminder");
        ValidationUtils.rejectIfEmpty(errors, "id", "yearReminder");
    }
    
}
