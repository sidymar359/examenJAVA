/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ANTA_SOW
 */
public class Service {
    private int serviceId;
    private String serviceLibelle;

    @Override
    public String toString() {
        return "Service{" + "serviceId=" + serviceId + ", serviceLibelle=" + serviceLibelle + '}';
    }
    
     public Service() {
    }

    public Service(int serviceId, String serviceLibelle) {
        this.serviceId = serviceId;
        this.serviceLibelle = serviceLibelle;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceLibelle() {
        return serviceLibelle;
    }

    public void setServiceLibelle(String serviceLibelle) {
        this.serviceLibelle = serviceLibelle;
    }
}
