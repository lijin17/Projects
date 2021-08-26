/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.validator;

import com.neu.pojo.SearchInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author lijin
 */
public class searchMovieValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return SearchInfo.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SearchInfo searchInfo=(SearchInfo) o;
        ValidationUtils.rejectIfEmpty(errors, "type", "typeReminder");
        ValidationUtils.rejectIfEmpty(errors, "keyword", "keywordReminder");
    }
    
}
