/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Service;

/**
 *
 * @author ASUS
 */
public class DaoService implements   IDao<Service> {
    
    
    private final String SQL_SELECT_ALL = "SELECT * FROM `service`";
    private final String SQL_INSERT = "INSERT INTO `service` (`libelle`) VALUES (?)";
    
     private final Mysql mysql;

    
    public DaoService() {
        mysql = new Mysql();
    }

    @Override
    public Service add(Service service) {
        mysql.getConnection();

        mysql.initPS(SQL_INSERT);

        PreparedStatement psmt = mysql.getPstm();
        try {
            psmt.setString(1, service.getLibelle());

            psmt.executeUpdate();
            ResultSet rs = psmt.getGeneratedKeys();
            if (rs.next()) {
                int serviceId = rs.getInt(1);
                service.setId(serviceId);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection();
        }

        return service;
    }

    @Override
    public List<Service> selectAll() {
        List<Service> services = new ArrayList();
        mysql.getConnection();

        mysql.initPS(SQL_SELECT_ALL);

        PreparedStatement ps = mysql.getPstm();
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("idService"));
                service.setLibelle(rs.getString("libelle"));
                services.add(service);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection();
        }
        return services;
    }
    
}
