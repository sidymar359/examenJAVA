/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DaoService;
import dao.EmployeDao;
import models.Service;

/**
 *
 * @author ASUS
 */
public class services {
     private final DaoService serviceDao;
    private final EmployeDao empDao;

    public services() {
        serviceDao = new DaoService();
        empDao = new  EmployeDao();
    }
    
    
    
    
    public Service saveSerice(String s) {
        Service ser = new Service(s);
       return  serviceDao.add(ser);
    }
    
    
}
