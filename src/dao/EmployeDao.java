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
import models.Employes;
import models.Service;

/**
 *
 * @author ASUS
 */
public class EmployeDao implements IDao<Employes> {

    private final String SQL_SELECT_ALL = "SELECT * FROM `employe`";
    private final String SQL_INSERT = "INSERT INTO `employe` (`nomComplet`, `dateEmbauche`, `idService`) VALUES (?, ?, ?)";

    private final Mysql mysql;

    public EmployeDao() {
        mysql = new Mysql();
    }

    @Override
    public Employes add(Employes employe) {
        mysql.getConnection();

        mysql.initPS(SQL_INSERT);

        PreparedStatement psmt = mysql.getPstm();
        try {
            psmt.setString(1, employe.getNomComplet());
            psmt.setDate(2, java.sql.Date.valueOf(employe.getDateEmbeauche()));
            psmt.setInt(3, employe.getEmpSer().getId());

            psmt.executeUpdate();
            ResultSet rs = psmt.getGeneratedKeys();
            if (rs.next()) {
                int empId = rs.getInt(1);
                employe.setId(empId);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection();
        }

        return employe;
    }

    @Override
    public List<Employes> selectAll() {
        List<Employes> employes = new ArrayList();
        mysql.getConnection();

        mysql.initPS(SQL_SELECT_ALL);

        PreparedStatement ps = mysql.getPstm();
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employes employe = new Employes();
                employe.setId(rs.getInt("id"));
                employe.setNomComplet(rs.getString("nomComplet"));
                employe.setDateEmbeauche(rs.getDate("dateEmbauche").toLocalDate());
                employes.add(employe);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection();
        }
        return employes;
    }
}
