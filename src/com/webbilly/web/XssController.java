package com.webbilly.web;

import com.webbilly.domain.XssData;
import com.webbilly.service.SQLiServices;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Created by christopher on 12/12/14.
 */
public class XssController extends MultiActionController {

    private SQLiServices sqliServices;

    public ModelAndView onInitPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Collection<XssData> posts = sqliServices.getAllPosts();
        return new ModelAndView("xss", "messages", posts);

    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return super.handleRequest(request, response);
    }

    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        XssData data = new XssData();

        data.setMessage(request.getParameter("message"));
        data.setUserName(request.getParameter("userName"));

        sqliServices.xssSave(data);
        return onInitPage(request, response);
    }

    public SQLiServices getSqliServices() {
        return sqliServices;
    }

    public void setSqliServices(SQLiServices sqliServices) {
        this.sqliServices = sqliServices;
    }
}
