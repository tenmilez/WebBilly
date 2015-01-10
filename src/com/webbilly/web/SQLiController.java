package com.webbilly.web;

import com.webbilly.service.SQLiServices;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by christopher on 11/22/14.
 */
public class SQLiController extends MultiActionController {
    private SQLiServices sqliServices;

    public ModelAndView onInitPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(new Date().toString() + " | SQLiController");
        return new ModelAndView("sqli");

    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return super.handleRequest(request, response);
    }

    public void inject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("SQLi?");
        String userInput = request.getParameter("user_input");
        sqliServices.sqlInject(userInput);

    }

    public SQLiServices getSqliServices() {
        return sqliServices;
    }

    public void setSqliServices(SQLiServices sqliServices) {
        this.sqliServices = sqliServices;
    }

}
