package com.webbilly.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeController extends MultiActionController {

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        return new ModelAndView("welcome");

    }


    /*********************************************************
     ********** Accessors and private members ****************
     *********************************************************/


}
