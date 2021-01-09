/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Employes {
    
    private int id;
    private LocalDate dateEmbeauche;
    private String nomComplet;
    
    private Service empSer;

    public Employes() {
    }
    
    

    public Service getEmpSer() {
        return empSer;
    }

    public void setEmpSer(Service empSer) {
        this.empSer = empSer;
    }
    
    

    public Employes(int id, LocalDate dateEmbeauche, String nomComplet) {
        this.id = id;
        this.dateEmbeauche = dateEmbeauche;
        this.nomComplet = nomComplet;
    }

    public Employes( String nomComplet) {
        this.dateEmbeauche = LocalDate.now();
        this.nomComplet = nomComplet;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateEmbeauche() {
        return dateEmbeauche;
    }

    public void setDateEmbeauche(LocalDate dateEmbeauche) {
        this.dateEmbeauche = dateEmbeauche;
    }


    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    
    
    
    
    
}
