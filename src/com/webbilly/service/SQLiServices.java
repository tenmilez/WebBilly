package com.webbilly.service;

import com.webbilly.dao.IGenericDAO;
import com.webbilly.domain.SQLiData;
import com.webbilly.domain.XssData;

import java.util.Collection;

/**
 * Created by christopher on 12/3/14.
 */
public class SQLiServices {


    private IGenericDAO<SQLiData> sqliDataDAO;
    private IGenericDAO<XssData> xssDataDAO;

    public void sqlInject(String str) {
        SQLiData sqliData = new SQLiData();
        sqliData.setValue(str);
        getSqliDataDAO().save(sqliData);
    }

    public void xssSave(XssData data) {
        xssDataDAO.save(data);
    }

    public Collection<XssData> getAllPosts() {
        return xssDataDAO.getAll();
    }

    public IGenericDAO<SQLiData> getSqliDataDAO() {
        return sqliDataDAO;
    }

    public void setSqliDataDAO(IGenericDAO<SQLiData> sqliDataDAO) {
        this.sqliDataDAO = sqliDataDAO;
    }

    public IGenericDAO<XssData> getXssDataDAO() {
        return xssDataDAO;
    }

    public void setXssDataDAO(IGenericDAO<XssData> xssDataDAO) {
        this.xssDataDAO = xssDataDAO;
    }
}
