/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author ANTA_SOW
 */
public class Employe {
    private int empId;
    private String nomComplet;
    private LocalDate dateEmb;
    private Service employeService;

    public Employe(int empId, String nomComplet, LocalDate dateEmb, Service employeService) {
        this.empId = empId;
        this.nomComplet = nomComplet;
        this.dateEmb = dateEmb;
        this.employeService = employeService;
    }

    public Service getEmployeService() {
        return employeService;
    }

    public void setEmployeService(Service employeService) {
        this.employeService = employeService;
    }

    public Employe(int empId, String nomComplet, LocalDate dateEmb) {
        this.empId = empId;
        this.nomComplet = nomComplet;
        this.dateEmb = dateEmb;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public LocalDate getDateEmb() {
        return dateEmb;
    }

    public void setDateEmb(LocalDate dateEmb) {
        this.dateEmb = dateEmb;
    }
}
