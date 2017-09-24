/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tworope.reactor.change.dto;

import java.util.Date;

/**
 *
 * @author tobah
 */
public class ChangeDTO {
    
    private Date oldDepartureDate;
    private Date newDepartureDate;
    private double penaltyFee;
    private Date changeDate;

    public Date getOldDepartureDate() {
        return oldDepartureDate;
    }

    public void setOldDepartureDate(Date oldDepartureDate) {
        this.oldDepartureDate = oldDepartureDate;
    }

    public Date getNewDepartureDate() {
        return newDepartureDate;
    }

    public void setNewDepartureDate(Date newDepartureDate) {
        this.newDepartureDate = newDepartureDate;
    }

    public double getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(double penaltyFee) {
        this.penaltyFee= penaltyFee;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
    
    
}
