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
import model.Service;

/**
 *
 * @author ANTA_SOW
 */
public class ServiceDao {
    private final String SQL_SELECT_ALL = "SELECT * FROM `service`";
    private final String SQL_INSERT = "INSERT INTO `service` (`libelle`) VALUES (?)";
    private final String SQL_SELECT_ONE = "SELECT * FROM `service` WHERE libelle =?";
     private final String SQL_SELECT_ONE_WITH_ID = "SELECT * FROM `service` WHERE serviceId =?";
    private final Mysql mysql;
    
    public ServiceDao() {
        mysql = new Mysql();
    }

    @Override
    public Service add(Service service) {
        mysql.getConnection();

        mysql.initPS(SQL_INSERT);

        PreparedStatement psmt = mysql.getPstm();
        try {
            psmt.setString(1, service.getServiceLibelle());

            psmt.executeUpdate();
            ResultSet rs = psmt.getGeneratedKeys();
            if (rs.next()) {
                int categoryId = rs.getInt(1);
                service.setServiceId(categoryId);
            }

        } catch (SQLException ex) {
            
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
                service.setServiceId(rs.getInt("serviceId"));
                service.setServiceLibelle(rs.getString("serviceLibelle"));
                service.add(service);
            }

        } catch (SQLException ex) {
            
        } finally {
            mysql.closeConnection();
        }
        return services;
    }
}
