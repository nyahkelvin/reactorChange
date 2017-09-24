/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tworope.reactor.change.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;
import java.util.Date;

/**
 *
 * @author tobah
 */
public interface Change extends VertexFrame {
    
    @Property("old_departure_date")
    public Date getOldDepartureDate();
    
    @Property("old_departure_date")
    public void setOldDepartureDate(Date oldDepartureDate);
    
    @Property("new_departure_date")
    public Date getNewDepartureDate();
    
    @Property("new_departure_date")
    public void setNewDepartureDate(Date newDepartureDate);
    
    @Property("penalty_fee")
    public double getPenaltyFee();
    
    @Property("penalty_fee")
    public void setPenaltyFee(double penaltyFee);
    
    @Property("change_date")
    public Date getChangeDate();
    
    @Property("change_date")
    public void setChangeDate(Date changeDate);
}
